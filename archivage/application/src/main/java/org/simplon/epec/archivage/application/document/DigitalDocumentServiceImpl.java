package org.simplon.epec.archivage.application.document;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RandomUtils;
import org.simplon.epec.archivage.application.classificationNature.ClassificationNatureService;
import org.simplon.epec.archivage.application.contract.ContractService;
import org.simplon.epec.archivage.application.user.UserService;
import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.simplon.epec.archivage.domain.contract.entity.Contract;
import org.simplon.epec.archivage.domain.document.entity.Context;
import org.simplon.epec.archivage.domain.document.entity.DigitalDocument;
import org.simplon.epec.archivage.domain.document.repository.DigitalDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DigitalDocumentServiceImpl implements DigitalDocumentService{

    private final transient DigitalDocumentRepository digitalDocumentRepository;
    private final transient ClassificationNatureService classificationNatureService;
    private final transient ContextService contextRepository;
    private final transient UserService userService;
    private final transient ContractService contractService;
    @Autowired
    public DigitalDocumentServiceImpl(DigitalDocumentRepository digitalDocumentRepository, ClassificationNatureService classificationNatureService, ContextService contextRepository, UserService userService, ContractService contractService) {
        this.digitalDocumentRepository = digitalDocumentRepository;
        this.classificationNatureService = classificationNatureService;
        this.contextRepository = contextRepository;
        this.userService = userService;
        this.contractService = contractService;
    }



    @Override
    public DigitalDocument createDocument(DigitalDocument document, ClassificationNature classificationNature, MultipartFile multipartFile) throws BadPaddingException, NoSuchAlgorithmException, IOException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException {

        // encrypter le doc avec un code secret avant l'archivage pour séruriser l'accès //////
        CrypterDocument crypterDocument = new CrypterDocument();
        byte[] data = multipartFile.getBytes();
        byte[] enryptedFile = crypterDocument.encrypt(data);
        // gestion le pérode d'archivage de doc

        java.time.LocalDate final_stage_date = null;
        if (document.getContext().getFinal_business_processing_date()!=null){
             final_stage_date = document.getContext().getFinal_business_processing_date().plusYears(classificationNature.getDuration());
        }

        // paramètres le context de doc à archiver
        String user_id = userService.getAuthentificatedUser().getUser_id();
        Context context = document.getContext();
        context.setFinal_stage_date(final_stage_date);
        context.setClassification_nature(classificationNature);
        context.setUser_id(user_id);
         context = contextRepository.createContext(context);
        // création de l'objet digitalDocument pour archiver le doc avec toutes les infos obligatoires
        document.setEncoding_doc(enryptedFile);
        document.setContext(context);
        // archiver le doc dans la base de données et retourner le avec l'id
        return digitalDocumentRepository.createDocument(document);
    }

    @Override
    public DigitalDocument getDocById(String docID) {
        return digitalDocumentRepository.getDocById(docID);
    }

    @Override
    public DigitalDocument updateContext(String docID, Context context) {
        return digitalDocumentRepository.updateContext(docID, context);
    }

    @Override
    public DigitalDocument saveDocFileWhithId(String docID, MultipartFile multipartFile) throws IOException, NoSuchAlgorithmException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException {
        return digitalDocumentRepository.saveDocFileWhithId(docID, multipartFile);
    }



    @Override
    public Page<DigitalDocument> getAllDocs(Pageable pageable) {
        /*
         Set<DigitalDocument> digitalDocuments = null;
        Set<DigitalDocument> stream =digitalDocumentRepository.getAllDocs();
               stream.forEach(document -> {
                   digitalDocuments.add(document);
               });
         */
        return digitalDocumentRepository.getAllDocs(pageable);
    }

    @Override
    public DigitalDocument savedoc(DigitalDocument doc) {
        return digitalDocumentRepository.saveDoc(doc);
    }

    @Override
    public Contract addDocsToContract(String contract_id, MultipartFile[] files) throws IOException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException {
        List<DigitalDocument> docs = digitalDocumentRepository.getAllDocsByContractId(contract_id);
        List<DigitalDocument> documentList = new ArrayList<DigitalDocument>();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        String contractId = objectMapper.readValue(contract_id, String.class);

        //Client c = contract1.getClient();
        // Client c = contract1.getClient();

        Contract contract = contractService.findById(contractId);
        DigitalDocument document = null;

        if (files.length > 0) {
            for (MultipartFile file: files) {
                Context ctx = new Context(RandomUtils.nextLong(), null, docs.get(0).getContext().getClassification_nature(), docs.get(0).getContext().getFinal_business_processing_date(), null, contract.getClient());
                ctx.setContract(contract);
                ctx.setMine_type(file.getContentType());
                document = new DigitalDocument(file.getOriginalFilename(), file.getContentType().split("/")[1], null, ctx);
                DigitalDocument doc = createDocument(document, docs.get(0).getContext().getClassification_nature(), file);
                // documentService.savedoc(doc);
                documentList.add(doc);
            }
        }
        return documentList.get(0).getContext().getContract();
    }
}
