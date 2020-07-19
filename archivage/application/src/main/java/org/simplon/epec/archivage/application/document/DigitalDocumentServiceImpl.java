package org.simplon.epec.archivage.application.document;

import org.simplon.epec.archivage.application.classificationNature.ClassificationNatureService;
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
    @Autowired
    public DigitalDocumentServiceImpl(DigitalDocumentRepository digitalDocumentRepository, ClassificationNatureService classificationNatureService) {
        this.digitalDocumentRepository = digitalDocumentRepository;
        this.classificationNatureService = classificationNatureService;
    }


    @Override
    public DigitalDocument createDocument(DigitalDocument document, MultipartFile multipartFile) throws BadPaddingException, NoSuchAlgorithmException, IOException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException {

        CrypterDocument crypterDocument = new CrypterDocument();
        byte[] data = multipartFile.getBytes();
        byte[] enryptedFile = crypterDocument.encrypt(data);
        ClassificationNature classificationNature = classificationNatureService.findByClassificationNatureCode(document.getContext().getClassification_nature().getClassification_nature_code());
        java.time.LocalDate deletion_date = null;
        if (document.getContext().getFinal_business_processing_date()!=null){
             deletion_date = document.getContext().getFinal_business_processing_date().plusYears(classificationNature.getDuration());
        }

        Context context = new Context("conserv_unit_id", multipartFile.getContentType(),
                document.getContext().getClassification_nature(), document.getContext().getFinal_business_processing_date(),
                null,  false,  false, null, deletion_date);
        DigitalDocument document1 = new DigitalDocument(multipartFile.getOriginalFilename(), document.getArchive_format(), enryptedFile, document.getContext());

        return digitalDocumentRepository.createDocument(document1);
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
