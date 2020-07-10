package org.simplon.epec.archivage.domain.classificationNature.entity;

import org.apache.commons.lang3.RandomUtils;

import java.io.Serializable;

/**
 * Class ClassificationNature
 */
public class ClassificationNature implements Serializable {

  //
  // Fields
  //

  private Long classification_nature_id;
  private String classification_nature_label;
  private String classification_nature_code;
  private int duration;
  
  //
  // Constructors
  //
  public ClassificationNature () { };

  public ClassificationNature(String classification_nature_code, int duration) {
    classification_nature_id = RandomUtils.nextLong();
    this.classification_nature_code = classification_nature_code;
    this.duration = duration;
  }
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of classification_nature_id
   * @param newVar the new value of classification_nature_id
   */
  public void setClassification_nature_id (Long newVar) {
    classification_nature_id = newVar;
  }

  /**
   * Get the value of classification_nature_id
   * @return the value of classification_nature_id
   */
  public Long getClassification_nature_id () {
    return classification_nature_id;
  }

  /**
   * Set the value of classification_nature_code
   * @param newVar the new value of classification_nature_code
   */
  public void setClassification_nature_code (String newVar) {
    classification_nature_code = newVar;
  }

  /**
   * Get the value of classification_nature_code
   * @return the value of classification_nature_code
   */
  public String getClassification_nature_code () {
    return classification_nature_code;
  }

  /**
   * Set the value of classification_nature_label
   * @param classification_nature_label the new value of classification_nature_label
   */
  public void setClassification_nature_label (String classification_nature_label) {
    classification_nature_label = classification_nature_label;
  }

  /**
   * Get the value of classification_nature_label
   * @return the value of classification_nature_label
   */
  public String getClassification_nature_label () {
    return classification_nature_label;
  }


  /**
   * Set the value of duration
   * @param newVar the new value of duration
   */
  public void setDuration (int newVar) {
    duration = newVar;
  }

  /**
   * Get the value of duration
   * @return the value of duration
   */
  public int getDuration () {
    return duration;
  }

  //
  // Other methods
  //

}
