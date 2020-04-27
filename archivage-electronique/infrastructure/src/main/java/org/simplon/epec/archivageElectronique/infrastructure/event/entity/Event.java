package org.simplon.epec.archivageElectronique.infrastructure.event.entity;

import java.time.LocalDate;

/**
 * Class Event
 */
public class Event {

  //
  // Fields
  //

  private String id_event;
  private String event_type;
  private LocalDate event_date;
  
  //
  // Constructors
  //
  public Event () { };
  
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
