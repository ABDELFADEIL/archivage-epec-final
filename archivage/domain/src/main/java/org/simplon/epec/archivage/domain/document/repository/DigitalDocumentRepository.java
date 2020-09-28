package org.simplon.epec.archivage.domain.document.repository;

import org.simplon.epec.archivage.domain.document.dto.DocumentDTO;
import org.simplon.epec.archivage.domain.document.entity.Context;
import org.simplon.epec.archivage.domain.document.entity.DigitalDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;

public interface DigitalDocumentRepository {

    DigitalDocument createDocument(DigitalDocument document) throws IOException, NoSuchAlgorithmException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException;
    DigitalDocument getDocById(String docID);
    DigitalDocument updateContext(String docID, Context context);
    DigitalDocument saveDocFileWhithId(String docID, MultipartFile multipartFile) throws IOException, NoSuchAlgorithmException, BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException;
    Page<DigitalDocument> getAllDocs(Pageable pageable);
    DigitalDocument saveDoc(DigitalDocument doc);
    List<DigitalDocument> getAllDocsByContractId(String contract_id);
    List<DigitalDocument> getDocsAccountById(String account_id);
    List<DocumentDTO> getDocumentDfbmIsNullArchivingDateBefore(LocalDateTime dateBefore) throws ParseException;
}
