package org.simplon.epec.archivageElectronique.domain.destructionList.entity;

import java.time.LocalDate;

/**
 * Class DestructionList
 */
public class DestructionList {

  //
  // Fields
  //

  private String document_id;
  private String client_id;
  private String contract_id;
  private boolean validation;
  private String description;
  private LocalDate validation_date;
  private String user_validate_id;
  private String account_id;
  
  //
  // Constructors
  //
  public DestructionList () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

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
   * Set the value of client_id
   * @param newVar the new value of client_id
   */
  public void setClient_id (String newVar) {
    client_id = newVar;
  }

  /**
   * Get the value of client_id
   * @return the value of client_id
   */
  public String getClient_id () {
    return client_id;
  }

  /**
   * Set the value of contract_id
   * @param newVar the new value of contract_id
   */
  public void setContract_id (String newVar) {
    contract_id = newVar;
  }

  /**
   * Get the value of contract_id
   * @return the value of contract_id
   */
  public String getContract_id () {
    return contract_id;
  }

  /**
   * Set the value of validation
   * @param newVar the new value of validation
   */
  public void setValidation (boolean newVar) {
    validation = newVar;
  }

  /**
   * Get the value of validation
   * @return the value of validation
   */
  public boolean getValidation () {
    return validation;
  }

  /**
   * Set the value of description
   * @param newVar the new value of description
   */
  public void setDescription (String newVar) {
    description = newVar;
  }

  /**
   * Get the value of description
   * @return the value of description
   */
  public String getDescription () {
    return description;
  }

  /**
   * Set the value of validation_date
   * @param newVar the new value of validation_date
   */
  public void setValidation_date (LocalDate newVar) {
    validation_date = newVar;
  }

  /**
   * Get the value of validation_date
   * @return the value of validation_date
   */
  public LocalDate getValidation_date () {
    return validation_date;
  }

  /**
   * Set the value of user_validate_id
   * @param newVar the new value of user_validate_id
   */
  public void setUser_validate_id (String newVar) {
    user_validate_id = newVar;
  }

  /**
   * Get the value of user_validate_id
   * @return the value of user_validate_id
   */
  public String getUser_validate_id () {
    return user_validate_id;
  }

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

  //
  // Other methods
  //

}
