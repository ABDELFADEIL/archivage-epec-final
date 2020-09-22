package org.simplon.epec.archivage.infrastructure.document.dto;

import org.simplon.epec.archivage.domain.document.entity.DigitalDocument;

import java.util.List;
import java.util.stream.Collectors;

public class DocumentConverter {


    // document_id, conserv_unit_id, final_stage_date, archiving_reference_date, classification_nature, final_business_processing_date, frozen_label, hold_status, frozen, event

    public static List<DocumentDTO> convertToStudentDTO(List<DigitalDocument> documents) {
        return documents.stream().map(d ->
                DocumentDTO.builder()
                        .document_id(d.getDocument_id())
                        .context_id(d.getContext().getContext_id())
                        .conserv_unit_id(d.getContext().getConserv_unit_id())
                        .final_stage_date(d.getContext().getFinal_stage_date())
                        .archiving_reference_date(d.getContext().getArchiving_reference_date())
                        .classification_nature(d.getContext().getClassification_nature())
                        .final_business_processing_date(d.getContext().getFinal_business_processing_date())
                        .frozen_label(d.getContext().getFrozen_label())
                        .hold_status(d.getContext().getHold_status())
                        .frozen(d.getContext().getFrozen())
                        .event(d.getContext().getEvent())
                        .build()
        ).collect(Collectors.toList());
    }


}
