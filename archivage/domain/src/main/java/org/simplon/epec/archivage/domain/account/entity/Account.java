package org.simplon.epec.archivage.domain.account.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.simplon.epec.archivage.domain.client.entity.Client;
import org.simplon.epec.archivage.domain.event.entity.Event;
import org.simplon.epec.archivage.domain.user.entity.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Class Account
 */
public class Account implements Serializable {

  //
  // Fields
  //

  private String account_id;
  private String account_id_type_code;
  private String account_id_label;
  private String status;
  private String account_number;
  private Client client;
  private Event event;
  private LocalDate creating_date;
  private User user;

  //
  // Constructors
  //
  public Account () { };

  public Account(String account_id_type_code, String account_id_label, String account_number, Client client) {
    this.account_id_type_code = account_id_type_code;
    this.account_id_label = account_id_label;
    this.account_number = account_number;
    this.client = client;
    this.account_id = UUID.randomUUID().toString();
    this.creating_date = LocalDate.now();
    this.status = "CREATED";
  }
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of account_id
   * @param newVar the new value of account_id
   */
  public void setAccount_id (String newVar) {
    account_id = newVar;
  }

  /**
   * Get the value of account_id
   * @return the value of account_id
   */
  public String getAccount_id () {
    return account_id;
  }

  /**
   * Set the value of account_id_type_code
   * @param newVar the new value of account_id_type_code
   */
  public void setAccount_id_type_code (String newVar) {
    account_id_type_code = newVar;
  }

  /**
   * Get the value of account_id_type_code
   * @return the value of account_id_type_code
   */
  public String getAccount_id_type_code () {
    return account_id_type_code;
  }

  /**
   * Set the value of account_id_label
   * @param newVar the new value of account_id_label
   */
  public void setAccount_id_label (String newVar) {
    account_id_label = newVar;
  }

  /**
   * Get the value of account_id_label
   * @return the value of account_id_label
   */
  public String getAccount_id_label () {
    return account_id_label;
  }

  /**
   * Set the value of status
   * @param newVar the new value of status
   */
  public void setStatus (String newVar) {
    status = newVar;
  }

  /**
   * Get the value of status
   * @return the value of status
   */
  public String getStatus () {
    return status;
  }

  /**
   * Set the value of account_number
   * @param newVar the new value of account_number
   */
  public void setAccount_number (String newVar) {
    account_number = newVar;
  }

  /**
   * Get the value of account_number
   * @return the value of account_number
   */
  public String getAccount_number () {
    return account_number;
  }

  /**
   * Set the value of client
   * @param newVar the new value of client
   */
  public void setClient (Client newVar) {
    client = newVar;
  }

  /**
   * Get the value of client
   * @return the value of client
   */
  public Client getClient () {
    return client;
  }

  /**
   * Set the value of event
   * @param newVar the new value of event
   */
  public void setEvent (Event newVar) {
    event = newVar;
  }

  /**
   * Get the value of event
   * @return the value of event
   */
  public Event getEvent () {
    return event;
  }

  /**
   * Set the value of creating_date
   * @param newVar the new value of creating_date
   */
  public void setCreating_date (LocalDate newVar) {
    creating_date = newVar;
  }

  /**
   * Get the value of creating_date
   * @return the value of creating_date
   */
  public LocalDate getCreating_date () {
    return creating_date;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
  //
  // Other methods
  //

}
