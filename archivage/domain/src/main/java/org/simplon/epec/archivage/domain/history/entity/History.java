package org.simplon.epec.archivage.domain.history.entity;

import org.apache.commons.lang3.RandomUtils;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Class History
 */
public class History implements Serializable {

  //
  // Fields
  //

  private Long history_id;
  private LocalDate history_date;
  private String event_type;
  private String calling_application;
    private String user_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    //
  // Constructors
  //


  public History () { };

  public History(String event_type, String calling_application) {
    this.history_date = LocalDate.now();
    this.event_type = event_type;
    this.calling_application = calling_application;
    this.history_id = RandomUtils.nextLong();
  }
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of history_id
   * @param newVar the new value of history_id
   */
  public void setHistory_id (Long newVar) {
    history_id = newVar;
  }

  /**
   * Get the value of history_id
   * @return the value of history_id
   */
  public Long getHistory_id () {
    return history_id;
  }

  /**
   * Set the value of history_date
   * @param newVar the new value of history_date
   */
  public void setHistory_date (LocalDate newVar) {
    history_date = newVar;
  }

  /**
   * Get the value of history_date
   * @return the value of history_date
   */
  public LocalDate getHistory_date () {
    return history_date;
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
   * Set the value of calling_application
   * @param newVar the new value of calling_application
   */
  public void setCalling_application (String newVar) {
    calling_application = newVar;
  }

  /**
   * Get the value of calling_application
   * @return the value of calling_application
   */
  public String getCalling_application () {
    return calling_application;
  }

  //
  // Other methods
  //

}
