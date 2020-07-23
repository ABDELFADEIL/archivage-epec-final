package org.simplon.epec.archivage.application.document;

import org.simplon.epec.archivage.application.classificationNature.ClassificationNatureService;
import org.simplon.epec.archivage.application.user.UserService;
import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
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

@Service
@Transactional
public class DigitalDocumentServiceImpl implements DigitalDocumentService{

    private final transient DigitalDocumentRepository digitalDocumentRepository;
    private final transient ClassificationNatureService classificationNatureService;
    private final transient ContextService contextRepository;
    private final transient UserService userService;
    @Autowired
    public DigitalDocumentServiceImpl(DigitalDocumentRepository digitalDocumentRepository, ClassificationNatureService classificationNatureService, ContextService contextRepository, UserService userService) {
        this.digitalDocumentRepository = digitalDocumentRepository;
        this.classificationNatureService = classificationNatureService;
        this.contextRepository = contextRepository;
        this.userService = userService;
    }



    @Override
    public DigitalDocument createDocument(DigitalDocument document, ClassificationNature classificationNature, MultipartFile multipartFile) throws BadPaddingException, NoSuchAlgorithmException, IOException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException {

        // encrypter le doc avec un code secret avant l'archivage pour séruriser l'accès //////
        CrypterDocument crypterDocument = new CrypterDocument();
        byte[] data = multipartFile.getBytes();
        byte[] enryptedFile = crypterDocument.encrypt(data);
        // gestion le pérode d'archivage de doc
        ClassificationNature nature = classificationNatureService.findByClassificationNatureCode(classificationNature.getClassification_nature_code());

        java.time.LocalDate final_stage_date = null;
        if (document.getContext().getFinal_business_processing_date()!=null){
             final_stage_date = document.getContext().getFinal_business_processing_date().plusYears(nature.getDuration());
        }

        // paramètres le context de doc à archiver
        Long user_id = userService.getAuthentificatedUser().getUser_id();
        Context context = document.getContext();
        context.setFinal_stage_date(final_stage_date);
        context.setClassification_nature(nature);
        context.setUser_id(user_id);
         context = contextRepository.createContext(context);
        // création de l'objet digitalDocument pour archiver le doc avec toutes les infos obligatoires
        document.setEncoding_doc(enryptedFile);
        document.setContext(context);
        // archiver le doc dans la base de données et retourner le avec l'id
        return digitalDocumentRepository.createDocument(document);
    }

    @Override
    public DigitalDocument getDocById(Long docID) {
        return digitalDocumentRepository.getDocById(docID);
    }

    @Override
    public DigitalDocument updateContext(Long docID, Context context) {
        return digitalDocumentRepository.updateContext(docID, context);
    }

    @Override
    public DigitalDocument saveDocFileWhithId(Long docID, MultipartFile multipartFile) throws IOException, NoSuchAlgorithmException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException {
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
}
