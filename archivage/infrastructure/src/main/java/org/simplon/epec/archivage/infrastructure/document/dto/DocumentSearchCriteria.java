package org.simplon.epec.archivage.infrastructure.document.dto;

import org.hibernate.transform.Transformers;
import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.simplon.epec.archivage.domain.document.entity.Context;
import org.simplon.epec.archivage.domain.document.entity.DigitalDocument;
import org.simplon.epec.archivage.domain.event.entity.Event;
import org.simplon.epec.archivage.infrastructure.document.repository.DigitalDocumentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class DocumentSearchCriteria {
    DocumentDTO documentDTO;

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private DigitalDocumentJpaRepository digitalDocumentJpaRepository;


    public List<DocumentDTO> documentSearchCriteria(){
        List<DocumentDTO> documentDTOs = entityManager.
                createNativeQuery(" select d.document_id as document_id, d.context as context" +
                        "   " +
                        " from digital_document d")
                .unwrap(org.hibernate.query.NativeQuery.class)
                .setResultTransformer(Transformers.aliasToBean(DocumentDTO.class))
                .getResultList();
        return documentDTOs;
    }

    public List<DigitalDocument> getDocumentDfbmIsNullArchivingDateBefore(LocalDateTime since){
            List<DigitalDocument> documentList = digitalDocumentJpaRepository.findAll(
                    new Specification<DigitalDocument>() {
                @Override
                public Predicate toPredicate(Root<DigitalDocument> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                   Root<Context> contextRoot = query.from(Context.class);
                    Root<ClassificationNature> classficationRoot = query.from(ClassificationNature.class);
                    Root<Event> eventtRoot = query.from(Event.class);
                    Predicate p = criteriaBuilder.conjunction();
                    if (Objects.nonNull(since)) {
                        p = criteriaBuilder.and(p, criteriaBuilder.greaterThanOrEqualTo(contextRoot.get("archiving_reference_date"),   LocalDateTime.of(2020, 9, 19, 00, 00)));
                        p = criteriaBuilder.and(p, criteriaBuilder.isNotNull(contextRoot.get("final_business_processing_date")));
                        query.where(p);
                        // document_id, conserv_unit_id, final_stage_date, archiving_reference_date, classification_nature, final_business_processing_date, frozen_label, hold_status, frozen, event

                        Path<Object> document_id = root.get("document_id");
                        Path<Object> context_id = contextRoot.get("context_id");
                        Path<Object> conserv_unit_id = contextRoot.get("conserv_unit_id");
                        Path<Object> final_stage_date = contextRoot.get("final_stage_date");
                        Path<Object> archiving_reference_date = contextRoot.get("archiving_reference_date");
                        Path<Object> final_business_processing_date = contextRoot.get("final_business_processing_date");
                        Path<Object> frozen_label = contextRoot.get("frozen_label");
                        Path<Object> hold_status = contextRoot.get("hold_status");
                        Path<Object> frozen = contextRoot.get("frozen");
                        Path<Object> classification_nature = classficationRoot.get("classification_nature");
                        Path<Object> event = eventtRoot.get("event");
                      // p = criteriaBuilder.and(p, )
                        query.select(criteriaBuilder.construct(DocumentDTO.class, document_id, context_id, conserv_unit_id,
                                final_stage_date, archiving_reference_date, final_business_processing_date, frozen_label, frozen, classification_nature, event));
                        // query.where(criteriaBuilder.lessThanOrEqualTo(contextRoot.get("archiving_reference_date"), since));
                       //  query.where(criteriaBuilder.isNotNull(contextRoot.get("final_business_processing_date")));

                    }
                    return p;
                }
            });

          //  List<DocumentDTO> list = DocumentConverter.convertToStudentDTO(documentList);
          //  Page<DocumentDTO> documentDTOS = new PageImpl<DocumentDTO>(list, PageRequest.of(0, 10), list.size());
            return documentList;
    }


}
