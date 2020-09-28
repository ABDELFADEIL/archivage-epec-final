package org.simplon.epec.archivage.infrastructure.document.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.simplon.epec.archivage.domain.document.dto.DocumentDTO;
import org.simplon.epec.archivage.domain.document.entity.Context;
import org.simplon.epec.archivage.domain.document.entity.DigitalDocument;
import org.simplon.epec.archivage.domain.event.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.criteria.*;
import java.text.ParseException;
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



    public List<DocumentDTO> getDocumentDfbmIsNullArchivingDateBefore(LocalDateTime eventDate) throws ParseException {
        Session session = hibernateFactory.getSessionFactory().openSession();
        List<DocumentDTO> documentDTOList = new ArrayList<>();
        List<DocumentDTO> tuples = session.createNativeQuery(
                "SELECT d.document_id, c.context_id, c.conserv_unit_id, c.archiving_reference_date, " +
                        "c.frozen_label, c.hold_status, c.frozen, cl.*, e.* FROM digital_document d INNER JOIN " +
                        "context c ON d.context=c.context_id and c.frozen=false INNER JOIN event e ON e.id_event=c.event " +
                        "and e.event_date < :eventDate INNER JOIN classification_nature cl ON cl.classification_nature_id=c.classification_nature" +
                        " WHERE c.final_business_processing_date=null and e.event_type='FIN_RELATION_CLIENT' OR e.event_type='COMPTE_CLOSE' OR e.event_type='CONTRAT_CLOS'"
         )
                .setParameter( "eventDate", eventDate)
                .setResultTransformer( Transformers.aliasToBean( DocumentDTO.class ) )
                .list();

        return tuples;
    }



   // @Transactional
    public List<Tuple[]> getDocumentDfbmIsNullArchivingDateBefore(){
        List<DigitalDocument> documents = new ArrayList<>();
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Tuple[]> queryObject = criteriaBuilder.createQuery(Tuple[].class );
                       Root<Context> contextRoot = queryObject.from(Context.class);
                        Root<DigitalDocument> root = queryObject.from(DigitalDocument.class);
                        //Root<ClassificationNature> classficationRoot = queryObject.from(ClassificationNature.class);
                        //Root<Event> eventtRoot = queryObject.from(Event.class);
                      //queryObject.select(root);
                      //  Predicate contextPredicate = criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo(contextRoot.get("archiving_reference_date"), LocalDateTime.now()),
                       // criteriaBuilder.isNull(contextRoot.get("final_business_processing_date")));
                        //Predicate evenPredicate = criteriaBuilder.and(criteriaBuilder.isNotNull(eventtRoot));
                       // queryObject.where(contextPredicate, evenPredicate);
            Path<String> document_id = root.get("document_id");
            Path<String> context_id = root.get("context").get("context_id");
            Path<Long> conserv_unit_id = root.get("context").get("conserv_unit_id");
            Path<LocalDateTime> final_stage_date = root.get("context").get("final_stage_date");
            Path<LocalDateTime> archiving_reference_date = root.get("context").get("archiving_reference_date");
            Path<LocalDate> final_business_processing_date = root.get("context").get("final_business_processing_date");
            Path<String> frozen_label = root.get("context").get("frozen_label");
            Path<Boolean> hold_status = root.get("context").get("hold_status");
            Path<Boolean> frozen = root.get("context").get("frozen");
            Path<ClassificationNature> classification_nature = root.get("context").get("classification_nature");
            Path<Event> event = contextRoot.get("event");
            Join<DigitalDocument, Context> contextJoin = root.join("context", JoinType.INNER);

            queryObject.multiselect(document_id, context_id, conserv_unit_id, archiving_reference_date, final_stage_date,
                    final_business_processing_date, frozen_label, hold_status, frozen,classification_nature, event);

            List<Tuple[]> liste = entityManager.createQuery(queryObject).getResultList();
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
