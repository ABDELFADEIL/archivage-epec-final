package org.simplon.epec.archivage.infrastructure.document.dto;

import org.hibernate.transform.Transformers;
import org.simplon.epec.archivage.domain.document.entity.Context;
import org.simplon.epec.archivage.domain.document.entity.DigitalDocument;
import org.simplon.epec.archivage.infrastructure.document.repository.DigitalDocumentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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

    public List<DocumentDTO> getDocumentDfbmIsNullArchivingDateBefore(LocalDateTime since, Pageable pageable){
            List<DigitalDocument> documentList = digitalDocumentJpaRepository.findAll(new Specification<DigitalDocument>() {
                @Override
                public Predicate toPredicate(Root<DigitalDocument> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                    Predicate p = criteriaBuilder.conjunction();
                    if (Objects.nonNull(since)) {
                        Join<DigitalDocument, Context> ard = root.join("context");
                        p = criteriaBuilder.and(p, criteriaBuilder.greaterThanOrEqualTo(root.get("ard.archiving_reference_date"), since));
                        p = criteriaBuilder.and(p, criteriaBuilder.isNull(root.get("ard.final_business_processing_date")));
                    }
                    return p;
                }
            });

            return DocumentConverter.convertToStudentDTO(documentList);
    }


}
