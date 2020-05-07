package org.simplon.epec.archivage.domain.user.entity;

import java.io.Serializable;
import java.util.UUID;

/**
 * Class Role
 */
public class Role implements Serializable {

  //
  // Fields
  //

  private String role_id;
  private String name;
  
  //
  // Constructors
  //
  public Role () { };

  public Role(String name) {
    this.role_id = UUID.randomUUID().toString();
    this.name = name;
  }
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of role_id
   * @param newVar the new value of role_id
   */
  public void setRole_id (String newVar) {
    role_id = newVar;
  }

  /**
   * Get the value of role_id
   * @return the value of role_id
   */
  public String getRole_id () {
    return role_id;
  }

  /**
   * Set the value of name
   * @param newVar the new value of name
   */
  public void setName (String newVar) {
    name = newVar;
  }

  /**
   * Get the value of name
   * @return the value of name
   */
  public String getName () {
    return name;
  }

  //
  // Other methods
  //

}
