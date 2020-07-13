package org.simplon.epec.archivage.infrastructure.document.dto;

import org.simplon.epec.archivage.domain.document.entity.Context;
import org.simplon.epec.archivage.domain.document.entity.DigitalDocument;

import java.util.ArrayList;
import java.util.List;

public class DocumentSearchCriteria extends DigitalDocument {

    String [] document_id;
    String [] archive_format;
    String [] file_name;
    Context[] context;

    List<DigitalDocument> listeDocs = new ArrayList<>();
    // document.

}
