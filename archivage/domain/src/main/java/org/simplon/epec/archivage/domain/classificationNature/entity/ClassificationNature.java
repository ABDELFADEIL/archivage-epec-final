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
  private int classification_nature_code;
  private int duration;

  public ClassificationNature() {
  }

  public ClassificationNature(String classification_nature_label, int classification_nature_code, int duration) {
    classification_nature_id = RandomUtils.nextLong();
    this.classification_nature_label = classification_nature_label;
    this.classification_nature_code = classification_nature_code;
    this.duration = duration;
  }

  public void setClassification_nature_id(Long classification_nature_id) {
    this.classification_nature_id = classification_nature_id;
  }

  public Long getClassification_nature_id() {
    return classification_nature_id;
  }

  public String getClassification_nature_label() {
    return classification_nature_label;
  }

  public int getClassification_nature_code() {
    return classification_nature_code;
  }

  public int getDuration() {
    return duration;
  }


  public void setClassification_nature_label(String classification_nature_label) {
    this.classification_nature_label = classification_nature_label;
  }

  public void setClassification_nature_code(int classification_nature_code) {
    this.classification_nature_code = classification_nature_code;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }
}
