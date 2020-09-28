package org.simplon.epec.archivage.infrastructure.context.repository;

import org.simplon.epec.archivage.domain.document.entity.Context;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ContextJpaRepository extends JpaRepository<Context, String> {
    //update Person p set p.image = null where p.image = :image
    @Modifying
    @Transactional
    @Query(value = "update context c set c.event= null where c.context_id=:context_id", nativeQuery = true)
     void deleteEven(@Param("context_id") String context_id);
    
}
