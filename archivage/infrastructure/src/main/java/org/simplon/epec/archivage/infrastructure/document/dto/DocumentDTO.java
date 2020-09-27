package org.simplon.epec.archivage.infrastructure.document.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DocumentDTO {
    private String document_id;
    private String conserv_unit_id;
    private String final_stage_date;
    private String archiving_reference_date;
    private String final_business_processing_date;
    private String deletion_date;
    private String frozen_label;
    private String hold_status;
    private String frozen;
    private String context_id;
    private String classification_nature_id;
    private String classification_nature_label;
    private String classification_nature_code;
    private String duration;
    private String id_event;
    private String event_type;
    private String event_date;

   }
