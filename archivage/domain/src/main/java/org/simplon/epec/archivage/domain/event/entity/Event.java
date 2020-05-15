package org.simplon.epec.archivage.domain.event.entity;

import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Class Event
 */
public class Event implements Serializable {

  //
  // Fields
  //

  private String id_event;
  private String event_type;
  private LocalDate event_date;

  public Event(String event_type) {
    this.event_type = event_type;
  }

  //
  // Constructors
  //
  public Event () { };

  public Event(String event_type, LocalDate event_date) {
    this.id_event = UUID.randomUUID().toString();
    this.event_type = event_type;
    this.event_date = event_date;
  }
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of id_event
   * @param newVar the new value of id_event
   */
  public void setId_event (String newVar) {
    id_event = newVar;
  }

  /**
   * Get the value of id_event
   * @return the value of id_event
   */
  public String getId_event () {
    return id_event;
  }

  /**
   * Set the value of event_type
   * @param newVar the new value of event_type
   */
  public void setEvent_type (String newVar) {
    event_type = newVar;
  }

  /**
   * Get the value of event_type
   * @return the value of event_type
   */
  public String getEvent_type () {
    return event_type;
  }

  /**
   * Set the value of event_date
   * @param newVar the new value of event_date
   */
  public void setEvent_date (LocalDate newVar) {
    event_date = newVar;
  }

  /**
   * Get the value of event_date
   * @return the value of event_date
   */
  public LocalDate getEvent_date () {
    return event_date;
  }

//
  // Other methods
  //

}
