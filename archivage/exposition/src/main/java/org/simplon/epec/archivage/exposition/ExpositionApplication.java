package org.simplon.epec.archivage.exposition;

import org.apache.commons.lang3.RandomUtils;
import org.simplon.epec.archivage.application.account.AccountService;
import org.simplon.epec.archivage.application.client.ClientService;
import org.simplon.epec.archivage.application.contract.ContractService;
import org.simplon.epec.archivage.domain.account.entity.Account;
import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.simplon.epec.archivage.domain.classificationNature.repository.ClassificationNatureRepository;
import org.simplon.epec.archivage.domain.client.entity.Client;
import org.simplon.epec.archivage.domain.contract.entity.Contract;
import org.simplon.epec.archivage.domain.document.entity.Context;
import org.simplon.epec.archivage.domain.document.entity.DigitalDocument;
import org.simplon.epec.archivage.domain.user.entity.Role;
import org.simplon.epec.archivage.domain.user.entity.User;
import org.simplon.epec.archivage.domain.user.repository.RoleRepository;
import org.simplon.epec.archivage.domain.user.repository.UserRepository;
import org.simplon.epec.archivage.infrastructure.account.repository.AccountJpaRepository;
import org.simplon.epec.archivage.infrastructure.client.repository.ClientJpaRepository;
import org.simplon.epec.archivage.infrastructure.context.repository.ContextJpaRepository;
import org.simplon.epec.archivage.infrastructure.contract.repository.ContractJpaRepository;
import org.simplon.epec.archivage.infrastructure.document.CrypterDocument;
import org.simplon.epec.archivage.infrastructure.document.repository.DigitalDocumentJpaRepository;
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

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;



@SpringBootApplication
@EntityScan(basePackages = {"org.simplon.epec.archivage.*"})
@ComponentScan(basePackages = {"org.simplon.epec.archivage.*"})
@EnableJpaRepositories(basePackages = {"org.simplon.epec.archivage.*"})
public class ExpositionApplication  extends SpringBootServletInitializer implements CommandLineRunner {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContextJpaRepository contextJpaRepository;
    @Autowired
    private ClientService clientService;
     @Autowired
    private DigitalDocumentJpaRepository digitalDocumentJpaRepository;
    @Autowired
    public ClientJpaRepository clientJpaRepository;
    @Autowired
    ClassificationNatureRepository classificationNatureRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private ContractService contractService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountJpaRepository accountJpaRepository;
    @Autowired
    private ContractJpaRepository contactJpaRepository;


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
      //  BufferedReader br = new BufferedReader(new FileReader("/media/fadeil/60cf352d-c946-4eb0-ab01-76d3f1bc3a57/fadeil/Documents/docs_perso/tire_sejour.pdf"));
        // Reading each line of file using BufferedReader class
       // String str;
      //  while ( (str = br.readLine()) != null) {
       //     System.out.println("str reder : "+str);
       // }


        for (int i = 0; i > 0; i --){
            Role role = new Role("ADMIN");
            role= roleRepository.findByName(role.getName());
            User u = new User(RandomUtils.nextBytes(10).toString(), RandomUtils.nextBytes(6).toString()+"@gmail.com", "abcd", role);
             u = userRepository.saveUser(u);
            //User user = userRepository.findByEmail(u.getEmail());
            Client c = new Client(RandomUtils.nextBytes(10).toString(), null, RandomUtils.nextBytes(8).toString(), RandomUtils.nextBytes(8).toString(),"M", null, null, "SIREN"+RandomUtils.nextInt(), "SIRET"+RandomUtils.nextInt(), u.getUser_id());
           c = clientService.createClient(c);
           //Client c = clientService.findOneByCientId(2304336606350193664L);
           // Client client = clientService.findOnByClientNumber(c.getClient_number());
          //  ClassificationNature nature = new ClassificationNature(RandomUtils.nextInt()+"", 2);
           ClassificationNature  nature = classificationNatureRepository.addClassificationNature(new ClassificationNature(""+RandomUtils.nextInt(), RandomUtils.nextInt(0, 9)));

            int nb = new Random().nextInt(1 + 1);
            Account account = new Account("CC", "Compte corant", c, u);
            Contract contract= new Contract(RandomUtils.nextBytes(9).toString(), RandomUtils.nextBytes(9).toString(), c);
            if(nb==1){
                  String con= accountService.createNewAccountNumber();
                  account.setAccount_number(con);
                  account = accountJpaRepository.save(account);
                  System.out.println(" account 1 nb = "+nb);
            } else {
                contract.setUser(u);
                contract.setClient(c);
                String connb= contractService.createNewContractNumber();
                contract.setContract_number(connb);
                contactJpaRepository.save(contract);
                System.out.println("contract 2 nb = "+nb);
            }

              for (int x = 0; x < 2; x++){
                  Context context = null;//new Context("conseve id", "null", "pdf", null, nature.getClassification_nature_code(), null, null, false, false, null, null);


                  if(nb==1){
                      context.setAccount(account);
                      Context context1 = contextJpaRepository.save(context);
                      //accountJpaRepository.save(account);
                     // contextJpaRepository.save(context1);
                      System.out.println(" contextJpaRepository.save(context1); account 1 nb = "+nb);

                  } else {
                      context.setContract(contract);
                      Context context1 = contextJpaRepository.save(context);
                     // contactJpaRepository.save(contract);
                     // contextJpaRepository.save(context1);
                      System.out.println(" contextJpaRepository.save(context1); contract 2 nb = "+nb);

                  }

                  byte[] file = Files.readAllBytes(Paths.get("/media/fadeil/60cf352d-c946-4eb0-ab01-76d3f1bc3a57/fadeil/Documents/docs_perso/tire_sejour.pdf"));
                  System.out.println("file length "+file);
                  CrypterDocument crypterDocument = new CrypterDocument();
                  byte[] fileEnc = crypterDocument.encrypt(file);
                  DigitalDocument document = new DigitalDocument("tire_sejour", "pdf", fileEnc, context);
                  digitalDocumentJpaRepository.save(document);
              }

            // Files.write(Paths.get("Diagramme.pdf"), fileEnc);

            // byte[] file2 = Files.readAllBytes(Paths.get("Diagramme.pdf"));

            // System.out.println("myNew.getFileSystem() : "+ myNew.getFileSystem());
          //  document =  digitalDocumentJpaRepository.save(document);

           // byte [] docEn = document.getEncoding_doc();
          //  byte [] docDec = crypterDocument.decrypt(file2);
           // Files.write(Paths.get("Diagramme1.pdf"), docDec);


        }

      //  ArrayList<DigitalDocument> arrayList = digitalDocumentJpaRepository.getAllDocs().stream().collect(Collectors.toCollection(ArrayList<DigitalDocument>::new));

      //  List<DigitalDocument> arrayList =  digitalDocumentJpaRepository.getAllDocs();
       //  AtomicInteger i= new AtomicInteger();
       // digitalDocumentJpaRepository.getAllDocs().forEach(document -> {
         //  i.getAndIncrement();
        //    document.setDocument_id(RandomUtils.nextLong());
           //// digitalDocumentJpaRepository.save(document);
       // System.out.println("Random ///////// : "+" : "+i+RandomUtils.nextLong());

           // System.out.println("id doc n° "+i+" : ");
            /*
            byte[] file = new byte[0];
            try {
                file = Files.readAllBytes(Paths.get("/media/fadeil/60cf352d-c946-4eb0-ab01-76d3f1bc3a57/fadeil/Documents/docs_perso/tire_sejour.pdf"));
                //System.out.println("file length "+file);
                CrypterDocument crypterDocument = new CrypterDocument();
                byte[] fileEnc = crypterDocument.encrypt(file);
                document.setEncoding_doc(fileEnc);
                digitalDocumentJpaRepository.save(document);
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
            }

             */
       //});





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
/*
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
        String client_number = clientJpaRepository.findMaxClientNumber();
      //  System.out.println(client_number);

         //   System.out.println("Client n° "+ client_number);




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

AtomicInteger i= new AtomicInteger();
        digitalDocumentJpaRepository.getAllDocs().forEach(document -> {
            i.set(i.get() + 1);
            System.out.println("Document n° "+i+" : "+document);
        });


         */



    }




}
