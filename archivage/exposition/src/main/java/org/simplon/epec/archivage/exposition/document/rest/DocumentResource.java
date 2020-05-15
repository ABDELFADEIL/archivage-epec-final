package org.simplon.epec.archivage.exposition.document.rest;

import org.simplon.epec.archivage.application.document.DigitalDocumentService;
import org.simplon.epec.archivage.domain.document.entity.Context;
import org.simplon.epec.archivage.domain.document.entity.DigitalDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class DocumentResource {

    private  final DigitalDocumentService digitalDocumentService;


    public DocumentResource(DigitalDocumentService digitalDocumentService) {
        this.digitalDocumentService = digitalDocumentService;
    }


    @PostMapping("/create-doc-file")
    public List<DigitalDocument> createDocument(List<DigitalDocument> documents, MultipartFile [] multipartFiles) throws IOException, NoSuchAlgorithmException,
            BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException
    {
        List<DigitalDocument> digitalDocumentList = new ArrayList<>();
            for (int i = 0; i < multipartFiles.length; i++){
                digitalDocumentList.add(i, digitalDocumentService.createDocument(documents.get(i), multipartFiles [i]));
            }
            return digitalDocumentList;
    }

    @GetMapping("/get-doc-by-id")
    public DigitalDocument getDocById(@RequestParam("docId") String docID){
        return digitalDocumentService.getDocById(docID);
    }

    @GetMapping("/get-all-docs")
    public List<DigitalDocument> getAllDocs(){
        return digitalDocumentService.getAllDocs();
    }

    @PutMapping("/update-doc-context-by-doc-id")
    DigitalDocument updateContext(String docID, Context context) {
        return digitalDocumentService.updateContext(docID, context);
    }

    @PostMapping("/save-digital-doc-by-id")
    DigitalDocument saveDocFileWhithId(String docID, MultipartFile multipartFile) throws IOException, NoSuchAlgorithmException,
            BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException
    {
        return digitalDocumentService.saveDocFileWhithId(docID, multipartFile);
    }

}
