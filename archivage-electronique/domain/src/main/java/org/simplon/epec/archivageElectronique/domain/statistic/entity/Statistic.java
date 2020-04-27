package org.simplon.epec.archivageElectronique.domain.statistic.entity;

import java.time.LocalDate;

/**
 * Class Statistic
 */
public class Statistic {

  //
  // Fields
  //

  private String statistic_id;
  private String event_type;
  private String document_id;
  private String user_id;
  private LocalDate event_date;
  
  //
  // Constructors
  //
  public Statistic () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of statistic_id
   * @param newVar the new value of statistic_id
   */
  public void setStatistic_id (String newVar) {
    statistic_id = newVar;
  }

  /**
   * Get the value of statistic_id
   * @return the value of statistic_id
   */
  public String getStatistic_id () {
    return statistic_id;
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
   * Set the value of document_id
   * @param newVar the new value of document_id
   */
  public void setDocument_id (String newVar) {
    document_id = newVar;
  }

  /**
   * Get the value of document_id
   * @return the value of document_id
   */
  public String getDocument_id () {
    return document_id;
  }

  /**
   * Set the value of user_id
   * @param newVar the new value of user_id
   */
  public void setUser_id (String newVar) {
    user_id = newVar;
  }

  /**
   * Get the value of user_id
   * @return the value of user_id
   */
  public String getUser_id () {
    return user_id;
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
