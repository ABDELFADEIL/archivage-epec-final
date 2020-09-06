package org.simplon.epec.archivage.infrastructure.document.repository;

import org.simplon.epec.archivage.domain.document.entity.DigitalDocument;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import javax.persistence.QueryHint;
import java.util.List;
import java.util.stream.Stream;

import static org.hibernate.jpa.QueryHints.HINT_FETCH_SIZE;
import static org.hibernate.jpa.QueryHints.HINT_PASS_DISTINCT_THROUGH;

public interface DigitalDocumentJpaRepository extends JpaRepository<DigitalDocument, String> {


    @Query(value="select doc from DigitalDocument doc")
    @QueryHints(value={ @QueryHint(name= HINT_FETCH_SIZE, value=""+Integer.MIN_VALUE), @QueryHint(name = HINT_PASS_DISTINCT_THROUGH, value = "false")})
    public Page<DigitalDocument> getAllDocs(Pageable pageable);

    @Query(value="select * from digital_document limit 1000",  nativeQuery=true)
    @QueryHints(value= {@QueryHint(name= HINT_FETCH_SIZE, value=""+Integer.MIN_VALUE), @QueryHint(name = HINT_PASS_DISTINCT_THROUGH, value = "false")})
    public List<DigitalDocument> getAllDocs();

    @Query(value="select document_id, archive_format,  file_name, context FROM digital_document where document_id > 0 order by document_id limit 2000" ,  nativeQuery=true)
    @QueryHints(value= {@QueryHint(name= HINT_FETCH_SIZE, value=""+Integer.MIN_VALUE), @QueryHint(name = HINT_PASS_DISTINCT_THROUGH, value = "false")})
    public List<Object[]> getAllMetadata();

    @Query(value="select doc from DigitalDocument doc")
    @QueryHints(value= {@QueryHint(name= HINT_FETCH_SIZE, value=""+Integer.MIN_VALUE), @QueryHint(name = HINT_PASS_DISTINCT_THROUGH, value = "false")})
    public Stream<DigitalDocument> getAllDocsStream();
    @Query(value = "SELECT * FROM `digital_document` WHERE `digital_document`.`context` IN (SELECT `context`.`context_id` FROM `context` WHERE `context`.`contract` = :contract_id)", nativeQuery = true)
    List<DigitalDocument> getDocsContractById(@Param("contract_id") String contract_id);
    @Query(value = "SELECT * FROM `digital_document` WHERE `digital_document`.`context` IN (SELECT `context`.`context_id` FROM `context` WHERE `context`.`account` = :account_id)", nativeQuery = true)
    List<DigitalDocument> getDocsAccountById(@Param("account_id") String account_id);
}
