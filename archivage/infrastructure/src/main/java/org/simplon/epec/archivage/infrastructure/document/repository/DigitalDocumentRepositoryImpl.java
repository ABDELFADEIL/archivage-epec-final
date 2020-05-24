package org.simplon.epec.archivage.infrastructure.document.repository;


import org.simplon.epec.archivage.domain.document.entity.Context;
import org.simplon.epec.archivage.domain.document.entity.DigitalDocument;
import org.simplon.epec.archivage.domain.document.repository.DigitalDocumentRepository;
import org.simplon.epec.archivage.infrastructure.context.repository.ContextJpaRepository;
import org.simplon.epec.archivage.infrastructure.document.CrypterDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Repository
public class DigitalDocumentRepositoryImpl implements DigitalDocumentRepository {

    private final transient DigitalDocumentJpaRepository digitalDocumentJpaRepository;
    private final transient ContextJpaRepository contextJpaRepository;

    public DigitalDocumentRepositoryImpl(DigitalDocumentJpaRepository digitalDocumentJpaRepository, ContextJpaRepository contextJpaRepository) {
        this.digitalDocumentJpaRepository = digitalDocumentJpaRepository;
        this.contextJpaRepository = contextJpaRepository;
    }

    @Override
    public DigitalDocument createDocument(DigitalDocument document, MultipartFile multipartFile) throws IOException, NoSuchAlgorithmException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException {
        CrypterDocument crypterDocument = new CrypterDocument();
        byte[] data = multipartFile.getBytes();
        byte[] enryptedFile = crypterDocument.encrypt(data);
        DigitalDocument document1 = new DigitalDocument(multipartFile.getOriginalFilename(), document.getArchive_format(), enryptedFile, document.getContext());
        return digitalDocumentJpaRepository.save(document1);
    }

    @Override
    public DigitalDocument getDocById(Long docID) {
        return digitalDocumentJpaRepository.findById(docID).get();
    }

    @Override
    public DigitalDocument updateContext(Long docID, Context context) {
       DigitalDocument document = digitalDocumentJpaRepository.findById(docID).get();
      document.setContext(context);
        return null; //digitalDocumentJpaRepository.save(document);
    }

    @Override
    public DigitalDocument saveDocFileWhithId(Long docID, MultipartFile multipartFile) throws IOException, NoSuchAlgorithmException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException {
        CrypterDocument crypterDocument = new CrypterDocument();
        byte[] data = multipartFile.getBytes();
        byte[] enryptedFile = crypterDocument.encrypt(data);
        DigitalDocument document = digitalDocumentJpaRepository.findById(docID).get();
        document.setEncoding_doc(enryptedFile);
        return digitalDocumentJpaRepository.save(document);
    }

    @Override
    public Page<DigitalDocument> getAllDocs(Pageable pageable) {
        return  digitalDocumentJpaRepository.getAllDocs(pageable);
    }
}
