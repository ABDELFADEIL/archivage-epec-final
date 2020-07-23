package org.simplon.epec.archivage.domain.document.entity;

import org.apache.commons.lang3.RandomUtils;
import org.simplon.epec.archivage.domain.account.entity.Account;
import org.simplon.epec.archivage.domain.classificationNature.entity.ClassificationNature;
import org.simplon.epec.archivage.domain.client.entity.Client;
import org.simplon.epec.archivage.domain.contract.entity.Contract;
import org.simplon.epec.archivage.domain.event.entity.Event;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Class Context
 */
public class Context implements Serializable {

  //
  // Fields
  //

  private Long context_id;
  private long conserv_unit_id;
  private String mine_type;
  private LocalDate final_stage_date;
  private LocalDate archiving_reference_date;
  private Contract contract;
  private Account account;
  private ClassificationNature classification_nature;
  private LocalDate final_business_processing_date;
  private String frozen_label;
  private boolean hold_status;
  private boolean frozen;
  //@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
  private LocalDate final_hold_date;
  // @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
  private LocalDate deletion_date;
    private Event event;
  private Long user_id;
  private Client client;


    //
  // Constructors
  //
  public Context () { };

  public Context(
                 long conserv_unit_id,
                 String mine_type,
                 ClassificationNature classification_nature,
                 LocalDate final_business_processing_date,
                 LocalDate final_stage_date,
                 Client client
                )
  {
    this.conserv_unit_id = conserv_unit_id;
    this.mine_type = mine_type;
    this.archiving_reference_date = LocalDate.now();
    this.classification_nature = classification_nature;
    this.final_business_processing_date = final_business_processing_date;
    this.final_stage_date = final_stage_date;
    this.client = client;
    this.context_id = RandomUtils.nextLong();
  }
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of context_id
   * @param newVar the new value of context_id
   */
  public void setContext_id (Long newVar) {
    context_id = newVar;
  }


  /**
   * Get the value of context_id
   * @return the value of context_id
   */
  public Long getContext_id () {
    return context_id;
  }

  /**
   * Set the value of conserv_unit_id
   * @param newVar the new value of conserv_unit_id
   */
  public void setConserv_unit_id (long newVar) {
    conserv_unit_id = newVar;
  }

  /**
   * Get the value of conserv_unit_id
   * @return the value of conserv_unit_id
   */
  public long getConserv_unit_id () {
    return conserv_unit_id;
  }



  /**
   * Set the value of mine_type
   * @param newVar the new value of mine_type
   */
  public void setMine_type (String newVar) {
    mine_type = newVar;
  }

  /**
   * Get the value of mine_type
   * @return the value of mine_type
   */
  public String getMine_type () {
    return mine_type;
  }


  /**
   * Set the value of archiving_reference_date
   * @param newVar the new value of archiving_reference_date
   */
  public void setArchiving_reference_date (LocalDate newVar) {
    archiving_reference_date = newVar;
  }

  /**
   * Get the value of archiving_reference_date
   * @return the value of archiving_reference_date
   */
  public LocalDate getArchiving_reference_date () {
    return archiving_reference_date;
  }

  /**
   * Set the value of contract
   * @param newVar the new value of contract
   */
  public void setContract (Contract newVar) {
    contract = newVar;
  }

  /**
   * Get the value of contract
   * @return the value of contract
   */
  public Contract getContract () {
    return contract;
  }

  /**
   * Set the value of account
   * @param newVar the new value of account
   */
  public void setAccount (Account newVar) {
    account = newVar;
  }

  /**
   * Get the value of account
   * @return the value of account
   */
  public Account getAccount () {
    return account;
  }

  /**
   * Set the value of classification_nature_id
   * @param classification_nature the new value of classification_nature_id
   */
  public void setClassification_nature (ClassificationNature classification_nature) {
    classification_nature = classification_nature;
  }

  /**
   * Get the value of classification_nature
   * @return the value of classification_nature
   */
  public ClassificationNature getClassification_nature () {
    return classification_nature;
  }

  /**
   * Set the value of final_business_processing_date
   * @param newVar the new value of final_business_processing_date
   */
  public void setFinal_business_processing_date (LocalDate newVar) {
    final_business_processing_date = newVar;
  }

  /**
   * Get the value of final_business_processing_date
   * @return the value of final_business_processing_date
   */
  public LocalDate getFinal_business_processing_date () {
    return final_business_processing_date;
  }

  /**
   * Set the value of frozen_label
   * @param newVar the new value of frozen_label
   */
  public void setFrozen_label (String newVar) {
    frozen_label = newVar;
  }

  /**
   * Get the value of frozen_label
   * @return the value of frozen_label
   */
  public String getFrozen_label () {
    return frozen_label;
  }

  /**
   * Set the value of hold_status
   * @param newVar the new value of hold_status
   */
  public void setHold_status (boolean newVar) {
    hold_status = newVar;
  }

  /**
   * Get the value of hold_status
   * @return the value of hold_status
   */
  public boolean getHold_status () {
    return hold_status;
  }

  /**
   * Set the value of frozen
   * @param newVar the new value of frozen
   */
  public void setFrozen (boolean newVar) {
    frozen = newVar;
  }

  /**
   * Get the value of frozen
   * @return the value of frozen
   */
  public boolean getFrozen () {
    return frozen;
  }

  /**
   * Set the value of final_hold_date
   * @param newVar the new value of final_hold_date
   */
  public void setFinal_hold_date (LocalDate newVar) {
    final_hold_date = newVar;
  }

  /**
   * Get the value of final_hold_date
   * @return the value of final_hold_date
   */
  public LocalDate getFinal_hold_date () {
    return final_hold_date;
  }

  /**
   * Set the value of deletion_date
   * @param newVar the new value of deletion_date
   */
  public void setDeletion_date (LocalDate newVar) {
    deletion_date = newVar;
  }

  /**
   * Get the value of deletion_date
   * @return the value of deletion_date
   */
  public LocalDate getDeletion_date () {
    return deletion_date;
  }

  public Long getUser_id() {
    return user_id;
  }

  public void setUser_id(Long user_id) {
    this.user_id = user_id;
  }

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }

  public boolean isHold_status() {
    return hold_status;
  }

  public boolean isFrozen() {
    return frozen;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public LocalDate getFinal_stage_date() {
    return final_stage_date;
  }

  public void setFinal_stage_date(LocalDate final_stage_date) {
    this.final_stage_date = final_stage_date;
  }
//
  // Other methods
  //

}
