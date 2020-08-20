package org.simplon.epec.archivage.domain.contract.entity;

import org.apache.commons.lang3.RandomUtils;
import org.simplon.epec.archivage.domain.client.entity.Client;
import org.simplon.epec.archivage.domain.event.entity.Event;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Class Contract
 */
public class Contract implements Serializable {

  //
  // Fields
  //

  private String contract_id;
  private String contract_id_type_code;
  private String contract_id_type_label;
  private Client client;
  private String contract_number;
  private Event event;
  private LocalDate creating_date;
    private String user_id;
    private String status;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    // private Set<DigitalDocument> digitalDocuments;



    //
  // Constructors
  //
  public Contract () { };
  
  //
  // Methods
  //

  public Contract(String contract_id_type_code, String contract_id_type_label, Client client) {
    this.contract_id = RandomUtils.nextLong()+"";
    this.contract_id_type_code = contract_id_type_code;
    this.contract_id_type_label = contract_id_type_label;
    this.client = client;
    this.creating_date = LocalDate.now();
  }


  //
  // Accessor methods
  //

  public String getContract_id() {
    return contract_id;
  }

  public String getContract_id_type_code() {
    return contract_id_type_code;
  }

  public String getContract_id_type_label() {
    return contract_id_type_label;
  }

  public Client getClient() {
    return client;
  }

  public String getContract_number() {
    return contract_number;
  }

  public Event getEvent() {
    return event;
  }

  public LocalDate getCreating_date() {
    return creating_date;
  }



  public void setContract_id(String contract_id) {
    this.contract_id = contract_id;
  }

  public void setContract_id_type_code(String contract_id_type_code) {
    this.contract_id_type_code = contract_id_type_code;
  }

  public void setContract_id_type_label(String contract_id_type_label) {
    this.contract_id_type_label = contract_id_type_label;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public void setContract_number(String contract_number) {
    this.contract_number = contract_number;
  }

  public void setEvent(Event event) {
    this.event = event;
  }

  public void setCreating_date(LocalDate creating_date) {
    this.creating_date = creating_date;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
//
  // Other methods
  //

}
