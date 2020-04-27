package org.simplon.epec.archivageElectronique.infrastructure.user.entity;

/**
 * Class Role
 */
public class Role {

  //
  // Fields
  //

  private String role_id;
  private String name;
  
  //
  // Constructors
  //
  public Role () { };
  
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
