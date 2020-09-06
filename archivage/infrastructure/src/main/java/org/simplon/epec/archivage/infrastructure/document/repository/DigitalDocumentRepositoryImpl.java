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
import java.util.List;

@Repository
public class DigitalDocumentRepositoryImpl implements DigitalDocumentRepository {

    private final transient DigitalDocumentJpaRepository digitalDocumentJpaRepository;
    private final transient ContextJpaRepository contextJpaRepository;

    public DigitalDocumentRepositoryImpl(DigitalDocumentJpaRepository digitalDocumentJpaRepository, ContextJpaRepository contextJpaRepository) {
        this.digitalDocumentJpaRepository = digitalDocumentJpaRepository;
        this.contextJpaRepository = contextJpaRepository;
    }

    @Override
    public DigitalDocument createDocument(DigitalDocument document) throws IOException, NoSuchAlgorithmException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException {
        return digitalDocumentJpaRepository.save(document);
    }

    @Override
    public DigitalDocument getDocById(String docID) {
        return digitalDocumentJpaRepository.findById(docID).get();
    }

    @Override
    public DigitalDocument updateContext(String docID, Context context) {
       DigitalDocument document = digitalDocumentJpaRepository.findById(docID).get();
       document.setContext(context);
        return null; //digitalDocumentJpaRepository.save(document);
    }

    @Override
    public DigitalDocument saveDocFileWhithId(String docID, MultipartFile multipartFile) throws IOException, NoSuchAlgorithmException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException {
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

    @Override
    public DigitalDocument saveDoc(DigitalDocument doc) {
        return digitalDocumentJpaRepository.save(doc);
    }

    @Override
    public List<DigitalDocument> getAllDocsByContractId(String contract_id) {

        return digitalDocumentJpaRepository.getDocsContractById(contract_id);
    }

    @Override
    public List<DigitalDocument> getDocsAccountById(String account_id) {
        return digitalDocumentJpaRepository.getDocsAccountById(account_id);
    }


}
