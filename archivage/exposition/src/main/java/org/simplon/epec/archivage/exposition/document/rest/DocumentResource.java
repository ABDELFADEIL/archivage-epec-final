package org.simplon.epec.archivage.exposition.document.rest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.simplon.epec.archivage.application.document.DigitalDocumentService;
import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.simplon.epec.archivage.domain.document.entity.Context;
import org.simplon.epec.archivage.domain.document.entity.DigitalDocument;
import org.simplon.epec.archivage.infrastructure.context.repository.ContextJpaRepository;
import org.simplon.epec.archivage.infrastructure.document.dto.DocumentSearchCriteria;
import org.simplon.epec.archivage.infrastructure.document.repository.DigitalDocumentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
    @RequestMapping("/api/documents")
public class DocumentResource {

    private  final DigitalDocumentService digitalDocumentService;
    private final DigitalDocumentJpaRepository digitalDocumentJpaRepository;
    private final ContextJpaRepository contextJpaRepository;
    @Autowired
    DocumentSearchCriteria documentSearchCriteria;

    public DocumentResource(DigitalDocumentService digitalDocumentService, DigitalDocumentJpaRepository digitalDocumentJpaRepository,  ContextJpaRepository contextJpaRepository) {
        this.digitalDocumentService = digitalDocumentService;
        this.digitalDocumentJpaRepository = digitalDocumentJpaRepository;
        this.contextJpaRepository = contextJpaRepository;
    }


    @PostMapping( value = "/create-doc-file", headers = {"content-type=multipart/mixed", "content-type=multipart/form-data"},
            consumes = {"multipart/form-data"})
    public List<DigitalDocument> createDocuments(@RequestPart(value = "files") List<MultipartFile>  files,
                                                @RequestPart(value = "documents") DigitalDocument document,
                                                 ClassificationNature classificationNature) throws IOException, NoSuchAlgorithmException,
            BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException
    {
                 List<DigitalDocument> digitalDocumentList = null;
                 if (files.size() > 0){
                   for (int i = 0; i < files.size(); i++){
                       DigitalDocument doc = digitalDocumentService.createDocument(document, classificationNature, files.get(i));
                       digitalDocumentList.add(doc);
                   }
                 }
                 return digitalDocumentList;
    }

    @GetMapping( value= {"/get-doc-by-id"}, produces = { "application/json;charset=UTF-8" }, consumes = {"application/json;charset=UTF-8" })
      public  DigitalDocument getDocById(@RequestParam("docId") String docID){
        return digitalDocumentService.getDocById(docID);
    }

    @ApiOperation(value = "/get-all-docs")
    @GetMapping( value = "/get-all-docs", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<DigitalDocument> getAllDocs(
            @ApiParam(value = "page", required = true) @RequestParam("page") int page,
            @ApiParam(value = "size", required = true) @RequestParam("size") int size
                                           ) throws InterruptedException, IOException {
      // Set<DigitalDocument> digitalDocuments = digitalDocumentService.getAllDocs();
       // Page<DigitalDocument> pages = new PageImpl<DigitalDocument>(((List<DigitalDocument>)digitalDocuments), PageRequest.of(page, size), digitalDocuments.size());
        System.out.println("digital start ......//// ");
     //   Map<String, String> map = null;
            System.out.println("digital start for ......//// ");
            System.out.println("digital fin for ......//// ");

     //   System.out.println("digital avant return ......//// "+digitalDocuments);
        // digitalDocuments.close();
        return digitalDocumentService.getAllDocs(PageRequest.of(page, size));
    }

    @PutMapping( value = {"/update-doc-context-by-doc-id"} , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    DigitalDocument updateContext(@RequestParam("docId") String docID, @RequestBody(required = true) Context context) {
        return digitalDocumentService.updateContext(docID, context);
    }



    @PostMapping( value = "/save-digital-doc-by-id", produces = { "application/json;charset=UTF-8" }, consumes = {"application/json;charset=UTF-8" })
    DigitalDocument saveDocFileWhithId(String docID, MultipartFile multipartFile) throws IOException, NoSuchAlgorithmException,
            BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException
    {
        return digitalDocumentService.saveDocFileWhithId(docID, multipartFile);
    }

    @GetMapping(value = "/all-docs-list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DocumentSearchCriteria> getAllDocs(){
        /*
        digitalDocumentJpaRepository.getAllDocs().forEach(digitalDocument -> {
            DigitalDocument d = new DigitalDocument();
            d.setDocument_id(digitalDocument.getDocument_id());
            d.setArchive_format(digitalDocument.getArchive_format());
            d.setFile_name(digitalDocument.getFile_name());
            d.setContext(digitalDocument.getContext());
            documents.add(d);
        });

         */

        return documentSearchCriteria.documentSearchCriteria();
    }

}
