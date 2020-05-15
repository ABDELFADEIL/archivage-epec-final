package org.simplon.epec.archivage.application.document;

import org.simplon.epec.archivage.domain.document.entity.Context;
import org.simplon.epec.archivage.domain.document.entity.DigitalDocument;
import org.simplon.epec.archivage.domain.document.repository.DigitalDocumentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
@Transactional
public class DigitalDocumentServiceImpl implements DigitalDocumentService{

    private final transient DigitalDocumentRepository digitalDocumentRepository;

    public DigitalDocumentServiceImpl(DigitalDocumentRepository digitalDocumentRepository) {
        this.digitalDocumentRepository = digitalDocumentRepository;
    }


    @Override
    public DigitalDocument createDocument(DigitalDocument document, MultipartFile multipartFile) throws BadPaddingException, NoSuchAlgorithmException, IOException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException {
        return digitalDocumentRepository.createDocument(document, multipartFile);
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
    public List<DigitalDocument> getAllDocs() {
        return digitalDocumentRepository.getAllDocs();
    }
}
