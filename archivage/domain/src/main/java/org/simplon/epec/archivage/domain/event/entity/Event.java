package org.simplon.epec.archivage.domain.event.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.RandomUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Class Event
 */
public class Event implements Serializable {

  //
  // Fields
  //

  private Long id_event;
  private String event_type;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.S")
  private LocalDateTime event_date;

  public Event(String event_type) {
    this.event_type = event_type;
  }

  //
  // Constructors
  //
  public Event () { };

  public Event(String event_type, LocalDateTime event_date) {
    this.id_event = RandomUtils.nextLong();
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
  public void setId_event (Long newVar) {
    id_event = newVar;
  }

  /**
   * Get the value of id_event
   * @return the value of id_event
   */
  public Long getId_event () {
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
  public void setEvent_date (LocalDateTime newVar) {
    event_date = newVar;
  }

  /**
   * Get the value of event_date
   * @return the value of event_date
   */
  public LocalDateTime getEvent_date () {
    return event_date;
  }

//
  // Other methods
  //

}
