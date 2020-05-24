package org.simplon.epec.archivage.domain.statistic.entity;

import org.apache.commons.lang3.RandomUtils;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Class Statistic
 */
public class Statistic implements Serializable {

  //
  // Fields
  //

  private Long statistic_id;
  private String event_type;
  private String document_id;
  private String user_id;
  private LocalDate event_date;
  
  //
  // Constructors
  //
  public Statistic () { };

  public Statistic(String event_type, String document_id, String user_id) {
    this.event_type = event_type;
    this.document_id = document_id;
    this.user_id = user_id;
    this.statistic_id = RandomUtils.nextLong();
    this.event_date = LocalDate.now();
  }
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
  public void setStatistic_id (Long newVar) {
    statistic_id = newVar;
  }

  /**
   * Get the value of statistic_id
   * @return the value of statistic_id
   */
  public Long getStatistic_id () {
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
