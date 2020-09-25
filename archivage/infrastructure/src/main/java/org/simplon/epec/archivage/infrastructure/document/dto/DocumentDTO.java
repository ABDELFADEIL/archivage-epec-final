package org.simplon.epec.archivage.infrastructure.document.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.simplon.epec.archivage.domain.event.entity.Event;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDTO {
    private String  document_id;
    private long conserv_unit_id;
    private LocalDate final_stage_date;
    private LocalDateTime archiving_reference_date;
    private ClassificationNature classification_nature;
    private LocalDate final_business_processing_date;
    private String frozen_label;
    private boolean hold_status;
    private boolean frozen;
    private Event event;
    private String context_id;
   // private Context context;
   // document_id, conserv_unit_id, final_stage_date, archiving_reference_date, classification_nature, final_business_processing_date, frozen_label, hold_status, frozen, event
   // frozen_label, hold_status, frozen, event






}
