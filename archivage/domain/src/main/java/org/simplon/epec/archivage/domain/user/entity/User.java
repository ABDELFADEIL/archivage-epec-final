package org.simplon.epec.archivage.domain.user.entity;

import org.apache.commons.lang3.RandomUtils;

import java.io.Serializable;

/**
 * Class User
 */
public class User implements Serializable {

  //
  // Fields
  //

  private String user_id;
  private String lastName;
  private String firstName;
  private String UID;
  private String password;
  private String email;
  private Role role;
  
  //
  // Constructors
  //
  public User () { };

  public User(String UID, String email, String password, Role role) {
    this.user_id = RandomUtils.nextLong()+"";
    this.UID = UID;
    this.email = email;
    this.password = password;
    this.role = role;
  }
//
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of user_id
   * @param newVar the new value of user_id
   */
  public void setUser_id (String newVar) {
    user_id = newVar;
  }

  /**
   * Get the value of user_id
   * @return the value of user_id
   */
  public String getUser_id () {
    return user_id;
  }

  /**
   * Set the value of password
   * @param newVar the new value of password
   */
  public void setPassword(String newVar) {
    password = newVar;
  }

  /**
   * Get the value of password
   * @return the value of password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Set the value of lastName
   * @param newVar the new value of lastName
   */
  public void setLastName (String newVar) {
    lastName = newVar;
  }

  /**
   * Get the value of lastName
   * @return the value of lastName
   */
  public String getLastName () {
    return lastName;
  }

  /**
   * Set the value of firstName
   * @param newVar the new value of firstName
   */
  public void setFirstName (String newVar) {
    firstName = newVar;
  }

  /**
   * Get the value of firstName
   * @return the value of firstName
   */
  public String getFirstName () {
    return firstName;
  }

  /**
   * Set the value of UID
   * @param newVar the new value of UID
   */
  public void setUID (String newVar) {
    UID = newVar;
  }

  /**
   * Get the value of UID
   * @return the value of UID
   */
  public String getUID () {
    return UID;
  }

  /**
   * Set the value of email
   * @param newVar the new value of email
   */
  public void setEmail (String newVar) {
    email = newVar;
  }

  /**
   * Get the value of email
   * @return the value of email
   */
  public String getEmail () {
    return email;
  }

  /**
   * Set the value of role
   * @param newVar the new value of role
   */
  public void setRole (Role newVar) {
    role = newVar;
  }

  /**
   * Get the value of role
   * @return the value of role
   */
  public Role getRole () {
    return role;
  }

  //
  // Other methods
  //

}
