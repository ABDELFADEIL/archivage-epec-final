package org.simplon.epec.archivage.infrastructure.document.repository;

import org.simplon.epec.archivage.domain.document.entity.DigitalDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import javax.persistence.QueryHint;
import java.util.List;
import java.util.stream.Stream;

import static org.hibernate.jpa.QueryHints.HINT_FETCH_SIZE;
import static org.hibernate.jpa.QueryHints.HINT_PASS_DISTINCT_THROUGH;

public interface DigitalDocumentJpaRepository extends JpaRepository<DigitalDocument, String>, JpaSpecificationExecutor<DigitalDocument> {


    @Query(value="select doc from DigitalDocument doc")
    @QueryHints(value={ @QueryHint(name= HINT_FETCH_SIZE, value=""+Integer.MIN_VALUE), @QueryHint(name = HINT_PASS_DISTINCT_THROUGH, value = "false")})
    public Page<DigitalDocument> getAllDocs(Pageable pageable);

    @Query(value="select * from digital_document limit 1000",  nativeQuery=true)
    @QueryHints(value= {@QueryHint(name= HINT_FETCH_SIZE, value=""+Integer.MIN_VALUE), @QueryHint(name = HINT_PASS_DISTINCT_THROUGH, value = "false")})
    public List<DigitalDocument> getAllDocs();
    // where digital_document.context.event not null order by digital_document.context.event.event_date
    //@Query(value="select document_id, context.context_id, context.conserv_unit_id, context.final_stage_date, context.archiving_reference_date, context.final_business_processing_date, context.frozen_label, context.hold_status, context.frozen, classification_nature, event FROM digital_document")
    //@CriteriaQuery
    //@QueryHints(value= {@QueryHint(name= HINT_FETCH_SIZE, value=""+Integer.MIN_VALUE), @QueryHint(name = HINT_PASS_DISTINCT_THROUGH, value = "false")})
    //public List<DigitalDocument> getAllMetadata();

    @Query(value="select doc from DigitalDocument doc")
    @QueryHints(value= {@QueryHint(name= HINT_FETCH_SIZE, value=""+Integer.MIN_VALUE), @QueryHint(name = HINT_PASS_DISTINCT_THROUGH, value = "false")})
    public Stream<DigitalDocument> getAllDocsStream();
    @Query(value = "SELECT * FROM digital_document WHERE digital_document.context in(SELECT c.context_id FROM context c WHERE c.contract=:contract_id)", nativeQuery = true)
    List<DigitalDocument> getDocsContractById(@Param("contract_id") String contract_id);
    @Query(value = "SELECT * FROM digital_document WHERE digital_document.context in(SELECT c.context_id FROM context c WHERE c.account=:account_id)", nativeQuery = true)
    List<DigitalDocument> getDocsAccountById(@Param("account_id") String account_id);
    @Query(value = "SELECT * FROM digital_document WHERE digital_document.context in(SELECT c.context_id FROM context c WHERE c.client=:client_id)", nativeQuery = true)
    List<DigitalDocument> getDocsClientById(@Param("client_id") String client_id);

    @Query(value = "select * from digital_document doc INNER JOIN context c ON doc.context=c.context_id INNER JOIN event e ON e.id_event=c.event AND e.event_type=:eventType AND e.id_event in (select c.event from context c where c.client=:client_id)", nativeQuery = true)
    List<DigitalDocument> findByEventTypeAndClientId(@Param("eventType") String eventType, @Param("client_id") String client_id);
}
