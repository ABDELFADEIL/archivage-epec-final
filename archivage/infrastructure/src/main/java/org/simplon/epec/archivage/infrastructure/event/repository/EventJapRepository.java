package org.simplon.epec.archivage.infrastructure.event.repository;

import org.simplon.epec.archivage.domain.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface EventJapRepository extends JpaRepository<Event, String> {


    @Query("select event from Event event where event.event_type=:eventType")
    Set<Event> findByEvent_type(@Param("eventType") String eventType);
    //@Query("select event from Event event where event.classificationNature in (select cn from ClassificationNature cn where cn.classification_nature_code=:classificationNatureCode)")
   // Set<Event> getEventByClassificationNatureCode(@Param("classificationNatureCode") String classificationNatureCode);
}
