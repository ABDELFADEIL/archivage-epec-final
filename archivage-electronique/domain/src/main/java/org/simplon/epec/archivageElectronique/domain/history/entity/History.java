package org.simplon.epec.archivageElectronique.domain.history.entity;

import org.simplon.epec.archivageElectronique.domain.user.entity.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Class History
 */
public class History implements Serializable {

  //
  // Fields
  //

  private String history_id;
  private LocalDate history_date;
  private String event_type;
  private User calling_user;
  private String calling_application;
  
  //
  // Constructors
  //
  public History () { };

  public History(String event_type, User calling_user, String calling_application) {
    this.history_date = LocalDate.now();
    this.event_type = event_type;
    this.calling_user = calling_user;
    this.calling_application = calling_application;
    this.history_id = UUID.randomUUID().toString();
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
  public void setHistory_id (String newVar) {
    history_id = newVar;
  }

  /**
   * Get the value of history_id
   * @return the value of history_id
   */
  public String getHistory_id () {
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
   * Set the value of calling_user
   * @param newVar the new value of calling_user
   */
  public void setCalling_user (User newVar) {
    calling_user = newVar;
  }

  /**
   * Get the value of calling_user
   * @return the value of calling_user
   */
  public User getCalling_user () {
    return calling_user;
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
