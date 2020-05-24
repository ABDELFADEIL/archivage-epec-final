package org.simplon.epec.archivage.application.document;

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

    @Autowired
    public DigitalDocumentServiceImpl(DigitalDocumentRepository digitalDocumentRepository) {
        this.digitalDocumentRepository = digitalDocumentRepository;
    }


    @Override
    public DigitalDocument createDocument(DigitalDocument document, MultipartFile multipartFile) throws BadPaddingException, NoSuchAlgorithmException, IOException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException {
        return digitalDocumentRepository.createDocument(document, multipartFile);
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
