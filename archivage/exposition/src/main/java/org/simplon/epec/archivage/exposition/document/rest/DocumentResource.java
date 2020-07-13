package org.simplon.epec.archivage.exposition.document.rest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.simplon.epec.archivage.application.document.DigitalDocumentService;
import org.simplon.epec.archivage.domain.document.entity.Context;
import org.simplon.epec.archivage.domain.document.entity.DigitalDocument;
import org.simplon.epec.archivage.infrastructure.context.repository.ContextJpaRepository;
import org.simplon.epec.archivage.infrastructure.document.repository.DigitalDocumentJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
    @RequestMapping("/api/documents")
public class DocumentResource {

    private  final DigitalDocumentService digitalDocumentService;
    private final DigitalDocumentJpaRepository digitalDocumentJpaRepository;
    private final ContextJpaRepository contextJpaRepository;

    public DocumentResource(DigitalDocumentService digitalDocumentService, DigitalDocumentJpaRepository digitalDocumentJpaRepository,  ContextJpaRepository contextJpaRepository) {
        this.digitalDocumentService = digitalDocumentService;
        this.digitalDocumentJpaRepository = digitalDocumentJpaRepository;
        this.contextJpaRepository = contextJpaRepository;
    }


    @PostMapping( value = "/create-doc-file", headers = {"content-type=multipart/mixed", "content-type=multipart/form-data"},
            consumes = {"multipart/form-data"})
    public List<DigitalDocument> createDocuments(@RequestPart(value = "files") List<MultipartFile>  files,
                                                @RequestPart(value = "documents") DigitalDocument document) throws IOException, NoSuchAlgorithmException,
            BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException
    {
                 List<DigitalDocument> digitalDocumentList = null;
                 if (files.size() > 0){
                   for (int i = 0; i < files.size(); i++){
                       DigitalDocument doc = digitalDocumentService.createDocument(document, files.get(i));
                       digitalDocumentList.add(doc);
                   }
                 }
                 return digitalDocumentList;
    }

    @GetMapping( value= {"/get-doc-by-id"}, produces = { "application/json;charset=UTF-8" }, consumes = {"application/json;charset=UTF-8" })
      public  DigitalDocument getDocById(@RequestParam("docId") Long docID){
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
    DigitalDocument updateContext(@RequestParam("docId") Long docID, @RequestBody(required = true) Context context) {
        return digitalDocumentService.updateContext(docID, context);
    }



    @PostMapping( value = "/save-digital-doc-by-id", produces = { "application/json;charset=UTF-8" }, consumes = {"application/json;charset=UTF-8" })
    DigitalDocument saveDocFileWhithId(Long docID, MultipartFile multipartFile) throws IOException, NoSuchAlgorithmException,
            BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException
    {
        return digitalDocumentService.saveDocFileWhithId(docID, multipartFile);
    }

    @GetMapping(value = "/all-docs-list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DigitalDocument> getAllDocs(){
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
        List<DigitalDocument> documents = new ArrayList<>();
        List<Optional<Context>> contexts = new ArrayList<>();
        digitalDocumentJpaRepository.getAllMetadata().forEach(doc -> {
            Long id = 0L;
            BigInteger object = (BigInteger) doc[3];
            id = object.longValue();

            System.out.println("BigInteger "+id);
            Context c = contextJpaRepository.findById(id).get();
            DigitalDocument document = new DigitalDocument();
            document.setContext(c);
            BigInteger idDoc = (BigInteger) doc[0];
            document.setDocument_id(idDoc.longValue());
            document.setArchive_format((String) doc[1]);
            document.setFile_name((String) doc[2]);
            documents.add(document);
            System.out.println("============= cannot cast "+ object.getClass());
        });

        return documents;
    }

}
