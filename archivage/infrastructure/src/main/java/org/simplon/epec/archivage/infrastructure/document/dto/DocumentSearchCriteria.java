package org.simplon.epec.archivage.infrastructure.document.dto;

import org.hibernate.transform.Transformers;
import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.simplon.epec.archivage.domain.document.entity.Context;
import org.simplon.epec.archivage.domain.event.entity.Event;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class DocumentSearchCriteria {
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
    private Context context;
// document_id, conserv_unit_id, final_stage_date, archiving_reference_date, classification_nature, final_business_processing_date, frozen_label, hold_status, frozen, event
// frozen_label, hold_status, frozen, event
    public DocumentSearchCriteria(){}


    public void setDocument_id(String document_id) {
        this.document_id = document_id;
    }


    public void setConserv_unit_id(long conserv_unit_id) {
        this.conserv_unit_id = conserv_unit_id;
    }

    public void setFinal_stage_date(LocalDate final_stage_date) {
        this.final_stage_date = final_stage_date;
    }

    public void setArchiving_reference_date(LocalDateTime archiving_reference_date) {
        this.archiving_reference_date = archiving_reference_date;
    }

    public void setClassification_nature(ClassificationNature classification_nature) {
        this.classification_nature = classification_nature;
    }

    public void setFinal_business_processing_date(LocalDate final_business_processing_date) {
        this.final_business_processing_date = final_business_processing_date;
    }

    public void setFrozen_label(String frozen_label) {
        this.frozen_label = frozen_label;
    }

    public void setHold_status(boolean hold_status) {
        this.hold_status = hold_status;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public void setEvent(Event event) {
        this.event = event;
    }


    public String getDocument_id() {
        return document_id;
    }


    public long getConserv_unit_id() {
        return conserv_unit_id;
    }

    public LocalDate getFinal_stage_date() {
        return final_stage_date;
    }

    public LocalDateTime getArchiving_reference_date() {
        return archiving_reference_date;
    }

    public ClassificationNature getClassification_nature() {
        return classification_nature;
    }

    public LocalDate getFinal_business_processing_date() {
        return final_business_processing_date;
    }

    public String getFrozen_label() {
        return frozen_label;
    }

    public boolean isHold_status() {
        return hold_status;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public Event getEvent() {
        return event;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @PersistenceContext
    private  EntityManager entityManager;

    public  List<DocumentSearchCriteria> documentSearchCriteria(){
        List<DocumentSearchCriteria> documentDTOs = entityManager.
                createNativeQuery(" select d.document_id as document_id, d.final_stage_date as final_stage_date" +
                        "   " +
                        " from digital_document d")
                .unwrap(org.hibernate.query.NativeQuery.class)
                .setResultTransformer(Transformers.aliasToBean(DocumentSearchCriteria.class))
                .getResultList();
        return documentDTOs;
    }



}
