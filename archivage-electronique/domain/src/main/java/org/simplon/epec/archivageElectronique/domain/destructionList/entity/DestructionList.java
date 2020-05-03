package org.simplon.epec.archivageElectronique.domain.destructionList.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.simplon.epec.archivageElectronique.domain.document.entity.DigitalDocument;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Class DestructionList
 */
public class DestructionList implements Serializable {

  //
  // Fields
  //

  private String destruction_id;
  private DigitalDocument document;
  private boolean validation = false;
  private String description;
  @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
  private LocalDate validation_date;
  private String user_validate_id;

  
  //
  // Constructors
  //
  public DestructionList () { };
  
  //

  public DestructionList(String destruction_id, DigitalDocument document, boolean validation, String description, LocalDateTime validation_date, String user_validate_id) {
    this.destruction_id = destruction_id;
    this.document = document;
    this.validation = validation;
    this.description = description;
    this.validation_date = LocalDate.now();
    this.user_validate_id = user_validate_id;
  }
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of document_id
   * @param
   */
  public DigitalDocument getDocument() {
    return document;
  }

  /**
   * Get the value of document_id
   * @return the value of document
   */
  public void setDocument(DigitalDocument document) {
    this.document = document;
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
  public boolean isValidation() {
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

  public String getDestruction_id() {
    return destruction_id;
  }



  public void setDestruction_id(String destruction_id) {
    this.destruction_id = destruction_id;
  }

  //
  // Other methods
  //

}
