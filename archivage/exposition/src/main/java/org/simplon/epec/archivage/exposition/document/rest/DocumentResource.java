package org.simplon.epec.archivage.exposition.document.rest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.simplon.epec.archivage.application.document.DigitalDocumentService;
import org.simplon.epec.archivage.domain.document.entity.Context;
import org.simplon.epec.archivage.domain.document.entity.DigitalDocument;
import org.simplon.epec.archivage.infrastructure.document.repository.DigitalDocumentJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/documents")
public class DocumentResource {

    private  final DigitalDocumentService digitalDocumentService;
    private final DigitalDocumentJpaRepository digitalDocumentJpaRepository;

    public DocumentResource(DigitalDocumentService digitalDocumentService, DigitalDocumentJpaRepository digitalDocumentJpaRepository) {
        this.digitalDocumentService = digitalDocumentService;
        this.digitalDocumentJpaRepository = digitalDocumentJpaRepository;
    }


    @PostMapping( value = "/create-doc-file", produces = { "application/json;charset=UTF-8" }, consumes = {"application/json;charset=UTF-8" })
    public List<DigitalDocument> createDocument(List<DigitalDocument> documents, MultipartFile [] multipartFiles) throws IOException, NoSuchAlgorithmException,
            BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException
    {
        List<DigitalDocument> digitalDocumentList = new ArrayList<>();
            for (int i = 0; i < multipartFiles.length; i++){
                digitalDocumentList.add(i, digitalDocumentService.createDocument(documents.get(i), multipartFiles [i]));
            }
            return digitalDocumentList;
    }

    @GetMapping( value= {"/get-doc-by-id"}, produces = { "application/json;charset=UTF-8" }, consumes = {"application/json;charset=UTF-8" })
      public  DigitalDocument getDocById(@RequestParam("docId") Long docID){
        return digitalDocumentService.getDocById(docID);
    }

    @ApiOperation(value = "/get-all-docs")
    @GetMapping( value = "/get-all-docs", produces = { "application/json;charset=UTF-8" })
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

    @PutMapping( value = {"/update-doc-context-by-doc-id"} , produces = { "application/json;charset=UTF-8" }, consumes = {"application/json;charset=UTF-8" })
    DigitalDocument updateContext(Long docID, Context context) {
        return digitalDocumentService.updateContext(docID, context);
    }

    @PostMapping( value = "/save-digital-doc-by-id", produces = { "application/json;charset=UTF-8" }, consumes = {"application/json;charset=UTF-8" })
    DigitalDocument saveDocFileWhithId(Long docID, MultipartFile multipartFile) throws IOException, NoSuchAlgorithmException,
            BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException
    {
        return digitalDocumentService.saveDocFileWhithId(docID, multipartFile);
    }

    @GetMapping("/all-docs-list")
    public List<DigitalDocument> getAllDocs(){
        return digitalDocumentJpaRepository.getAllDocs()
                .stream()
                .collect(Collectors.toList());
    }

}
