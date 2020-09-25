package org.simplon.epec.archivage.infrastructure.document.dto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class DocumentSearchCriteria {
    DocumentDTO documentDTO;

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private DigitalDocumentJpaRepository digitalDocumentJpaRepository;
    private SessionFactory hibernateFactory;

    @Autowired
    public DocumentSearchCriteria(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.hibernateFactory = factory.unwrap(SessionFactory.class);
    }

    public List<DigitalDocument> documentSearchCriteria(){
        Session session = hibernateFactory.getSessionFactory().openSession();
        List<DigitalDocument> tuples = session.createNativeQuery(
                "SELECT * " +
                        "FROM digital_document", DigitalDocument.class)
              // .addEntity( DigitalDocument.class )
                .getResultList();
        return tuples;
    }



   // @Transactional
    public List<DigitalDocument> getDocumentDfbmIsNullArchivingDateBefore(){
        List<DigitalDocument> documents = new ArrayList<>();
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            //CriteriaQuery<Tuple> query = criteriaBuilder.createQuery( Tuple.class );
            CriteriaQuery<DigitalDocument> queryObject = criteriaBuilder.createQuery(DigitalDocument.class );
                        Root<Context> contextRoot = queryObject.from(Context.class);
                        Root<DigitalDocument> root = queryObject.from(DigitalDocument.class);
                       Root<ClassificationNature> classficationRoot = queryObject.from(ClassificationNature.class);
                        Root<Event> eventtRoot = queryObject.from(Event.class);
            queryObject.multiselect(root, contextRoot, classficationRoot, eventtRoot);
                      //  Predicate contextPredicate = criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo(contextRoot.get("archiving_reference_date"), LocalDateTime.now()),
                       // criteriaBuilder.isNull(contextRoot.get("final_business_processing_date")));
                        //Predicate evenPredicate = criteriaBuilder.and(criteriaBuilder.isNotNull(eventtRoot));
                       // queryObject.where(contextPredicate, evenPredicate);
            Path<String> document_id = root.get("document_id");
            Path<String> context_id = contextRoot.get("context_id");
            Path<Long> conserv_unit_id = contextRoot.get("conserv_unit_id");
            Path<LocalDateTime> final_stage_date = contextRoot.get("final_stage_date");
            Path<LocalDateTime> archiving_reference_date = contextRoot.get("archiving_reference_date");
            Path<LocalDate> final_business_processing_date = contextRoot.get("final_business_processing_date");
            Path<String> frozen_label = contextRoot.get("frozen_label");
            Path<Boolean> hold_status = contextRoot.get("hold_status");
            Path<Boolean> frozen = contextRoot.get("frozen");
            Path<ClassificationNature> classification_nature = contextRoot.get("classification_nature");
            Path<Event> event = contextRoot.get("event");
           // queryObject.select(criteriaBuilder.array(document_id, context_id, conserv_unit_id, final_stage_date, archiving_reference_date,
           // final_business_processing_date, frozen_label, frozen, hold_status, classification_nature, event));
           /// Fetch<DigitalDocument, Context> personFetch = root.fetch( DigitalDocument_.context );
            System.out.println("dddddddddddd////queryObject.select(criteriaBuilder.array/////*************///////////////////////////////////////////////////////////////////////////////////////////////////::ùùùùùùùùùù************");
            Join<DigitalDocument, Context> contextJoin = root.join("context");
            Join<Context, ClassificationNature> classificationNatureJoin = root.join("classification_nature");
            Join<Context, Event> contextEventJoin = root.join("event");
            queryObject.multiselect(contextJoin);

            List<DigitalDocument> liste = entityManager.createQuery(queryObject).getResultList();
            System.out.println("mmmmmmmQuery<Object[]> objects = session.createQuery(queryObject) ùùùùùùùùùùùù************");
            //session.close();
            return liste;
        }catch (Exception e){
            e.getStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }


}
