package org.simplon.epec.archivageElectronique.domain.client.entity;

import java.util.Date;

/**
 * Class Client
 */
public class Client {

  //
  // Fields
  //

  private String client_id;
  private String client_nature_id;
  private String client_name;
  private String client_first_name;
  private String civility_id;
  private Date birth_date;
  private String birth_dept;
  private String siren_number;
  private String siret_number;
  
  //
  // Constructors
  //
  public Client () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

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
   * Set the value of client_nature_id
   * @param newVar the new value of client_nature_id
   */
  public void setClient_nature_id (String newVar) {
    client_nature_id = newVar;
  }

  /**
   * Get the value of client_nature_id
   * @return the value of client_nature_id
   */
  public String getClient_nature_id () {
    return client_nature_id;
  }

  /**
   * Set the value of client_name
   * @param newVar the new value of client_name
   */
  public void setClient_name (String newVar) {
    client_name = newVar;
  }

  /**
   * Get the value of client_name
   * @return the value of client_name
   */
  public String getClient_name () {
    return client_name;
  }

  /**
   * Set the value of client_first_name
   * @param newVar the new value of client_first_name
   */
  public void setClient_first_name (String newVar) {
    client_first_name = newVar;
  }

  /**
   * Get the value of client_first_name
   * @return the value of client_first_name
   */
  public String getClient_first_name () {
    return client_first_name;
  }

  /**
   * Set the value of civility_id
   * @param newVar the new value of civility_id
   */
  public void setCivility_id (String newVar) {
    civility_id = newVar;
  }

  /**
   * Get the value of civility_id
   * @return the value of civility_id
   */
  public String getCivility_id () {
    return civility_id;
  }

  /**
   * Set the value of birth_date
   * @param newVar the new value of birth_date
   */
  public void setBirth_date (Date newVar) {
    birth_date = newVar;
  }

  /**
   * Get the value of birth_date
   * @return the value of birth_date
   */
  public Date getBirth_date () {
    return birth_date;
  }

  /**
   * Set the value of birth_dept
   * @param newVar the new value of birth_dept
   */
  public void setBirth_dept (String newVar) {
    birth_dept = newVar;
  }

  /**
   * Get the value of birth_dept
   * @return the value of birth_dept
   */
  public String getBirth_dept () {
    return birth_dept;
  }

  /**
   * Set the value of siren_number
   * @param newVar the new value of siren_number
   */
  public void setSiren_number (String newVar) {
    siren_number = newVar;
  }

  /**
   * Get the value of siren_number
   * @return the value of siren_number
   */
  public String getSiren_number () {
    return siren_number;
  }

  /**
   * Set the value of siret_number
   * @param newVar the new value of siret_number
   */
  public void setSiret_number (String newVar) {
    siret_number = newVar;
  }

  /**
   * Get the value of siret_number
   * @return the value of siret_number
   */
  public String getSiret_number () {
    return siret_number;
  }

  //
  // Other methods
  //

}
