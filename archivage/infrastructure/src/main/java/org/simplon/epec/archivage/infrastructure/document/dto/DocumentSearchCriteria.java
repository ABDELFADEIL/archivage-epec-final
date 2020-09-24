package org.simplon.epec.archivage.infrastructure.document.dto;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.simplon.epec.archivage.domain.document.entity.Context;
import org.simplon.epec.archivage.domain.document.entity.DigitalDocument;
import org.simplon.epec.archivage.domain.event.entity.Event;
import org.simplon.epec.archivage.infrastructure.document.repository.DigitalDocumentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Configuration
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

    private SessionFactory hibernateFactory;

    @Autowired
    public DocumentSearchCriteria(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.hibernateFactory = factory.unwrap(SessionFactory.class);
    }

   // @Transactional
    public List<DocumentDTO> getDocumentDfbmIsNullArchivingDateBefore(){
        List<DigitalDocument> documents = new ArrayList<>();
        Session session = hibernateFactory.unwrap(SessionFactory.class).openSession();

        try {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
           // CriteriaQuery<Tuple> query = criteriaBuilder.createQuery( Tuple.class );
            CriteriaQuery<DocumentDTO> queryObject = criteriaBuilder.createQuery(DocumentDTO.class );
                        Root<Context> contextRoot = queryObject.from(Context.class);
                        Root<DigitalDocument> root = queryObject.from(DigitalDocument.class);
                       Root<ClassificationNature> classficationRoot = queryObject.from(ClassificationNature.class);
                        Root<Event> eventtRoot = queryObject.from(Event.class);
                      //  Predicate contextPredicate = criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo(contextRoot.get("archiving_reference_date"), LocalDateTime.now()),
                       // criteriaBuilder.isNull(contextRoot.get("final_business_processing_date")));
                        //Predicate evenPredicate = criteriaBuilder.and(criteriaBuilder.isNotNull(eventtRoot));
                       // queryObject.where(contextPredicate, evenPredicate);
            Path<Object> document_id = root.get("document_id");
            Path<Object> context_id = contextRoot.get("context_id");
            Path<Object> conserv_unit_id = contextRoot.get("conserv_unit_id");
            Path<Object> final_stage_date = contextRoot.get("final_stage_date");
            Path<Object> archiving_reference_date = contextRoot.get("archiving_reference_date");
            Path<Object> final_business_processing_date = contextRoot.get("final_business_processing_date");
            Path<Object> frozen_label = contextRoot.get("frozen_label");
            Path<Object> hold_status = contextRoot.get("hold_status");
            Path<Object> frozen = contextRoot.get("frozen");
            Path<Object> classification_nature = contextRoot.get("classification_nature");
            Path<Object> event = contextRoot.get("event");
            queryObject.select(criteriaBuilder.construct(DocumentDTO.class ,document_id, context_id, conserv_unit_id, final_stage_date, archiving_reference_date,
            final_business_processing_date, frozen_label, frozen, hold_status, classification_nature, event));
            System.out.println("dddddddddddd////queryObject.select(criteriaBuilder.array/////*************///////////////////////////////////////////////////////////////////////////////////////////////////::ùùùùùùùùùù************");
            Query<DocumentDTO> documentDTOQuery = session.createQuery(queryObject);
            List<DocumentDTO> liste = documentDTOQuery.getResultList();
            System.out.println("mmmmmmmQuery<Object[]> objects = session.createQuery(queryObject) ùùùùùùùùùùùù************");
            session.close();
            return liste;
        }catch (Exception e){
            e.getStackTrace();
        }finally {
            if (!Objects.isNull(session)){
                session.close();
            }
        }
        return null;
    }


}
