package org.simplon.epec.archivage.exposition;

import org.simplon.epec.archivage.application.client.ClientService;
import org.simplon.epec.archivage.application.document.DigitalDocumentService;
import org.simplon.epec.archivage.application.user.RoleService;
import org.simplon.epec.archivage.application.user.UserService;
import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.simplon.epec.archivage.domain.classificationNature.repository.ClassificationNatureRepository;
import org.simplon.epec.archivage.domain.client.entity.Client;
import org.simplon.epec.archivage.domain.document.entity.Context;
import org.simplon.epec.archivage.domain.document.entity.DigitalDocument;
import org.simplon.epec.archivage.domain.document.repository.DigitalDocumentRepository;
import org.simplon.epec.archivage.domain.user.entity.Role;
import org.simplon.epec.archivage.domain.user.entity.User;
import org.simplon.epec.archivage.domain.user.repository.UserRepository;
import org.simplon.epec.archivage.infrastructure.client.repository.ClientJpaRepository;
import org.simplon.epec.archivage.infrastructure.context.repository.ContextJpaRepository;
import org.simplon.epec.archivage.infrastructure.document.CrypterDocument;
import org.simplon.epec.archivage.infrastructure.document.repository.DigitalDocumentJpaRepository;
import org.simplon.epec.archivage.infrastructure.user.repository.RoleJpaRepository;
import org.simplon.epec.archivage.infrastructure.user.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@EntityScan(basePackages = {"org.simplon.epec.archivage.*"})
@ComponentScan(basePackages = {"org.simplon.epec.archivage.*"})
@EnableJpaRepositories(basePackages = {"org.simplon.epec.archivage.*"})
public class ExpositionApplication  extends SpringBootServletInitializer implements CommandLineRunner {

    @Autowired
    private UserJpaRepository userJpaRepository;
    @Autowired
    private RoleJpaRepository roleJpaRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private  DigitalDocumentService digitalDocumentService;
    @Autowired
    private ContextJpaRepository contextJpaRepository;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClassificationNatureRepository classificationNatureRepository;
    @Autowired
    private DigitalDocumentRepository digitalDocumentRepository;
    @Autowired
    private DigitalDocumentJpaRepository digitalDocumentJpaRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ClientJpaRepository clientJpaRepository;
    public static void main(String[] args) {
        SpringApplication.run(ExpositionApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ExpositionApplication.class);
    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
       // Role role = roleJpaRepository.save(new Role("ADMIN"));
       // Role  role = roleJpaRepository.findByName("ADMIN");
      //  System.out.print(role.getRole_id() +" "+role.getName());
      //  String password = bCryptPasswordEncoder.encode("abcd");
       // User user = new User("bbb", "bbb@gmail.com", password, role);

        long timeStrat=0;
        long timeEnd=0;
        for (int i = 10000; i > 0; i --){
             timeStrat = Instant.now().getEpochSecond() /1000000000;

            System.out.println(" time : "+timeStrat);

            User user = userRepository.findByEmail("bbb@gmail.com");
            Client client = clientService.findOnByClientNumber("0000000002");
            ClassificationNature nature = new ClassificationNature("23333", 2);
            nature = classificationNatureRepository.addClassificationNature(nature);
            Context context = new Context(null, null, null, null, nature.getClassification_nature_id(),
                    null, client,
                    "forzen label", false, false, null, null);
            context = contextJpaRepository.save(context);
            // MultipartFile multipartFile = null;
            byte[] file = Files.readAllBytes(Paths.get("/media/fadeil/60cf352d-c946-4eb0-ab01-76d3f1bc3a57/fadeil/Documents/docs_perso/tire_sejour.pdf"));
            System.out.println("file length "+file);
            CrypterDocument crypterDocument = new CrypterDocument();
            byte[] fileEnc = crypterDocument.encrypt(file);
            // File file1 = new File("");
            // Path myNew = Files.write(Paths.get("Diagramme.png"), fileEnc);

            // System.out.println("myNew.getFileSystem() : "+ myNew.getFileSystem());
            DigitalDocument document = new DigitalDocument("tire_sejour.pdf", null, fileEnc, context);
            document =  digitalDocumentJpaRepository.save(document);
            timeEnd = Instant.now().getEpochSecond() /1000000000;
            System.out.println(" time : "+(timeEnd - timeStrat));

            byte [] docEn = document.getEncoding_doc();
            byte [] docDec = crypterDocument.decrypt(docEn);
            Files.write(Paths.get("tire_sejour.pdf"), docDec);
        }




        // user = userRepository.findByEmail("abcd@gmail.com");
        // user.setRole(role);
       // System.out.println(user.getEmail()+ ""+ user.getUser_id()+ " "+ user.getPassword() +"\n role name: " +user.getRole().getName()+" id role: "+user.getRole().getRole_id());
        // user = userJpaRepository.save(user);

        //user = userRepository.findByEmail("aaa@gmail.com");
       // System.out.print(user.getEmail()+ ""+ user.getUser_id()+ ""+ user.getPassword() +"\n role name: " +user.getRole().getName()+" id role: "+user.getRole().getRole_id());
      //   user = new User("ddd", "ddd@gmail.com", password, null);
        //userService.CreateUser(user, "ADMIN");
       // user.setRole(role);
       // userRepository.saveUser(user);

        String number_st = "0000000000";
        long number_account = Long.parseLong(number_st);
        long new_number_account = number_account + 1;
        number_st = "00000000000".substring(String.valueOf(new_number_account).length()+1)+new_number_account;

        // String st2 = st.substring(0, st.length());
        System.out.println("number st : "+number_st);


        System.out.println("number number_account  : "+number_account);
        System.out.println("number number_account 2: "+new_number_account);
        number_st = "00000000000".substring(String.valueOf(new_number_account).length()+1)+new_number_account;
        System.out.print("number_st : "+number_st);
        AtomicInteger i = new AtomicInteger();
        String client_number = clientJpaRepository.findMaxClientNumber();
      //  System.out.println(client_number);

         //   System.out.println("Client n° "+ client_number);



    }

      /*
        @Bean
        public ServletWebServerFactory servletContainer() {
            // Enable SSL Trafic
            TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
                @Override
                protected void postProcessContext(Context context) {
                    SecurityConstraint securityConstraint = new SecurityConstraint();
                    securityConstraint.setUserConstraint("CONFIDENTIAL");
                    SecurityCollection collection = new SecurityCollection();
                    collection.addPattern("/*");
                    securityConstraint.addCollection(collection);
                    context.addConstraint(securityConstraint);
                }
            };
            // Add HTTP to HTTPS redirect
            tomcat.addAdditionalTomcatConnectors(httpToHttpsRedirectConnector());
            return tomcat;
        }

        private Connector httpToHttpsRedirectConnector() {
            Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
            connector.setScheme("http");
            connector.setPort(8080);
            connector.setSecure(false);
            connector.setRedirectPort(8443);
            return connector;
        }
    */



}
