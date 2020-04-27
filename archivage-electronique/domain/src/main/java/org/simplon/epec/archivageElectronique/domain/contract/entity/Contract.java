package org.simplon.epec.archivageElectronique.domain.contract.entity;

import org.simplon.epec.archivageElectronique.domain.client.entity.Client;
import org.simplon.epec.archivageElectronique.domain.event.entity.Event;

import java.time.LocalDate;

/**
 * Class Contract
 */
public class Contract {

  //
  // Fields
  //

  private String contact_id;
  private String contract_id_type_code;
  private String contract_id_type_label;
  private Client client;
  private String status;
  private String contract_number;
  private Event event;
  private LocalDate creating_date;
  
  //
  // Constructors
  //
  public Contract () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of contact_id
   * @param newVar the new value of contact_id
   */
  public void setContact_id (String newVar) {
    contact_id = newVar;
  }

  /**
   * Get the value of contact_id
   * @return the value of contact_id
   */
  public String getContact_id () {
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

  //
  // Other methods
  //

}
