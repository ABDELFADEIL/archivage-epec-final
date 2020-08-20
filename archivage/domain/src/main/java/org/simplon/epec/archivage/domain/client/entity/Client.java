package org.simplon.epec.archivage.domain.client.entity;

import org.apache.commons.lang3.RandomUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * Class Client
 */
public class Client implements Serializable {

  //
  // Fields
  //

  private String client_id;
  private String client_number;
  private int client_nature_id;
  private String client_name;
  private String client_first_name;
  private int civility_id;
  private Date birth_date;
  private String birth_dept;
  private String siren_number;
  private String siret_number;
  private String user_id;


  //
  // Constructors
  //
  public Client () { };
  
  //
  // Methods
  //

  public Client(int client_nature_id, String client_number, String client_name,
                String client_first_name, int civility_id, Date birth_date,
                String birth_dept, String siren_number, String siret_number, String user_id) {
    this.client_id = RandomUtils.nextLong()+"";
    this.client_nature_id = client_nature_id;
    this.client_number = client_number;
    this.client_name = client_name;
    this.client_first_name = client_first_name;
    this.civility_id = civility_id;
    this.birth_date = birth_date;
    this.birth_dept = birth_dept;
    this.siren_number = siren_number;
    this.siret_number = siret_number;
    this.user_id = user_id;
  }


  //
  // Accessor methods
  //

  public String getClient_id() {
    return client_id;
  }

  public String getClient_number() {
    return client_number;
  }

  public int getClient_nature_id() {
    return client_nature_id;
  }

  public String getClient_name() {
    return client_name;
  }

  public String getClient_first_name() {
    return client_first_name;
  }

  public int getCivility_id() {
    return civility_id;
  }

  public Date getBirth_date() {
    return birth_date;
  }

  public String getBirth_dept() {
    return birth_dept;
  }

  public String getSiren_number() {
    return siren_number;
  }

  public String getSiret_number() {
    return siret_number;
  }

  public String getUser_id() {
    return user_id;
  }

  public void setClient_id(String client_id) {
    this.client_id = client_id;
  }

  public void setClient_number(String client_number) {
    this.client_number = client_number;
  }

  public void setClient_nature_id(int client_nature_id) {
    this.client_nature_id = client_nature_id;
  }

  public void setClient_name(String client_name) {
    this.client_name = client_name;
  }

  public void setClient_first_name(String client_first_name) {
    this.client_first_name = client_first_name;
  }

  public void setCivility_id(int civility_id) {
    this.civility_id = civility_id;
  }

  public void setBirth_date(Date birth_date) {
    this.birth_date = birth_date;
  }

  public void setBirth_dept(String birth_dept) {
    this.birth_dept = birth_dept;
  }

  public void setSiren_number(String siren_number) {
    this.siren_number = siren_number;
  }

  public void setSiret_number(String siret_number) {
    this.siret_number = siret_number;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

//
  // Other methods
  //


  @Override
  public String toString() {
    return "Client{" +
            "client_id=" + client_id +
            ", client_number='" + client_number + '\'' +
            ", client_nature_id=" + client_nature_id +
            ", client_name='" + client_name + '\'' +
            ", client_first_name='" + client_first_name + '\'' +
            ", civility_id=" + civility_id +
            ", birth_date=" + birth_date +
            ", birth_dept='" + birth_dept + '\'' +
            ", siren_number=" + siren_number +
            ", siret_number=" + siret_number +
            ", user_id=" + user_id +
            '}';
  }
}
