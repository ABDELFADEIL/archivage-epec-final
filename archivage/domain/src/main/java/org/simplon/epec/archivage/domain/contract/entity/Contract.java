package org.simplon.epec.archivage.domain.contract.entity;

import org.apache.commons.lang3.RandomUtils;
import org.simplon.epec.archivage.domain.client.entity.Client;
import org.simplon.epec.archivage.domain.event.entity.Event;
import org.simplon.epec.archivage.domain.user.entity.User;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Class Contract
 */
public class Contract implements Serializable {

  //
  // Fields
  //

  private Long contact_id;
  private String contract_id_type_code;
  private String contract_id_type_label;
  private Client client;
  private String contract_number;
  private Event event;
  private LocalDate creating_date;
  private User user;
 // private Set<DigitalDocument> digitalDocuments;



    //
  // Constructors
  //
  public Contract () { };
  
  //
  // Methods
  //

  public Contract(String contract_id_type_code, String contract_id_type_label, Client client) {
    this.contact_id = RandomUtils.nextLong();
    this.contract_id_type_code = contract_id_type_code;
    this.contract_id_type_label = contract_id_type_label;
    this.client = client;
    this.creating_date = LocalDate.now();
  }


  //
  // Accessor methods
  //

  /**
   * Set the value of contact_id
   * @param newVar the new value of contact_id
   */
  public void setContact_id (Long newVar) {
    contact_id = newVar;
  }

  /**
   * Get the value of contact_id
   * @return the value of contact_id
   */
  public Long getContact_id () {
    return contact_id;
  }

  /**
   * Set the value of contract_id_type_code
   * @param newVar the new value of contract_id_type_code
   */
  public void setContract_id_type_code (String newVar) {
    contract_id_type_code = newVar;
  }

  /**
   * Get the value of contract_id_type_code
   * @return the value of contract_id_type_code
   */
  public String getContract_id_type_code () {
    return contract_id_type_code;
  }

  /**
   * Set the value of contract_id_type_label
   * @param newVar the new value of contract_id_type_label
   */
  public void setContract_id_type_label (String newVar) {
    contract_id_type_label = newVar;
  }

  /**
   * Get the value of contract_id_type_label
   * @return the value of contract_id_type_label
   */
  public String getContract_id_type_label () {
    return contract_id_type_label;
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
   * Set the value of contract_number
   * @param newVar the new value of contract_number
   */
  public void setContract_number (String newVar) {
    contract_number = newVar;
  }

  /**
   * Get the value of contract_number
   * @return the value of contract_number
   */
  public String getContract_number () {
    return contract_number;
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
