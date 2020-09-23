package org.simplon.epec.archivage.infrastructure.document.dto;

import org.hibernate.transform.Transformers;
import org.simplon.epec.archivage.domain.document.entity.Context;
import org.simplon.epec.archivage.domain.document.entity.DigitalDocument;
import org.simplon.epec.archivage.infrastructure.document.repository.DigitalDocumentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
                    Predicate p = criteriaBuilder.conjunction();
                    if (Objects.nonNull(since)) {
                        p = criteriaBuilder.and(p, criteriaBuilder.greaterThanOrEqualTo(contextRoot.get("archiving_reference_date"),   LocalDateTime.of(2020, 9, 19, 00, 00)));
                        p = criteriaBuilder.and(p, criteriaBuilder.isNotNull(contextRoot.get("final_business_processing_date")));
                        query.where(p);
                      //  p = criteriaBuilder.and(p, )
                        //query.select(root.get("document_id"));
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
