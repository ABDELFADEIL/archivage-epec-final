package org.simplon.epec.archivageElectronique.infrastructure.document.entity;

import org.simplon.epec.archivageElectronique.infrastructure.account.entity.Account;
import org.simplon.epec.archivageElectronique.infrastructure.client.entity.Client;
import org.simplon.epec.archivageElectronique.infrastructure.contract.entity.Contract;

import java.time.LocalDate;

/**
 * Class Context
 */
public class Context {

  //
  // Fields
  //

  private String context_id;
  private String conserv_unit_id;
  private String media_type;
  private String mine_type;
  private String original_value_id;
  private LocalDate archiving_reference_date;
  private Contract contract;
  private Account account;
  private String classification_nature_id;
  private LocalDate final_business_processing_date;
  private Client client;
  private String frozen_label;
  private boolean hold_status;
  private boolean frozen;
  private LocalDate final_hold_date;
  private LocalDate deletion_date;
  
  //
  // Constructors
  //
  public Context () { };
  
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
  public void setContext_id (String newVar) {
    context_id = newVar;
  }

  /**
   * Get the value of context_id
   * @return the value of context_id
   */
  public String getContext_id () {
    return context_id;
  }

  /**
   * Set the value of conserv_unit_id
   * @param newVar the new value of conserv_unit_id
   */
  public void setConserv_unit_id (String newVar) {
    conserv_unit_id = newVar;
  }

  /**
   * Get the value of conserv_unit_id
   * @return the value of conserv_unit_id
   */
  public String getConserv_unit_id () {
    return conserv_unit_id;
  }

  /**
   * Set the value of media_type
   * @param newVar the new value of media_type
   */
  public void setMedia_type (String newVar) {
    media_type = newVar;
  }

  /**
   * Get the value of media_type
   * @return the value of media_type
   */
  public String getMedia_type () {
    return media_type;
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
   * Set the value of original_value_id
   * @param newVar the new value of original_value_id
   */
  public void setOriginal_value_id (String newVar) {
    original_value_id = newVar;
  }

  /**
   * Get the value of original_value_id
   * @return the value of original_value_id
   */
  public String getOriginal_value_id () {
    return original_value_id;
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
   * @param newVar the new value of classification_nature_id
   */
  public void setClassification_nature_id (String newVar) {
    classification_nature_id = newVar;
  }

  /**
   * Get the value of classification_nature_id
   * @return the value of classification_nature_id
   */
  public String getClassification_nature_id () {
    return classification_nature_id;
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

  //
  // Other methods
  //

}
