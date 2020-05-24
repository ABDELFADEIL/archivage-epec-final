package org.simplon.epec.archivage.domain.document.entity;

import org.apache.commons.lang3.RandomUtils;

import java.io.Serializable;

/**
 * Class DigitalDocument
 */
public class DigitalDocument implements Serializable {

  //
  // Fields
  //

  private Long document_id;
  private String file_name;
  private String archive_format;
  private byte [] encoding_doc;
  private Context context;
  
  //
  // Constructors
  //
  public DigitalDocument () { };

  public DigitalDocument(String file_name, String archive_format, byte [] encoding_doc, Context context) {
    this.document_id = RandomUtils.nextLong();
    this.file_name = file_name;
    this.archive_format = archive_format;
    this.encoding_doc = encoding_doc;
    this.context = context;
  }
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
  public void setDocument_id (Long newVar) {
    document_id = newVar;
  }

  /**
   * Get the value of document_id
   * @return the value of document_id
   */
  public Long getDocument_id () {
    return document_id;
  }

  /**
   * Set the value of file_name
   * @param newVar the new value of file_name
   */
  public void setFile_name (String newVar) {
    file_name = newVar;
  }

  /**
   * Get the value of file_name
   * @return the value of file_name
   */
  public String getFile_name () {
    return file_name;
  }

  /**
   * Set the value of archive_format
   * @param newVar the new value of archive_format
   */
  public void setArchive_format (String newVar) {
    archive_format = newVar;
  }

  /**
   * Get the value of archive_format
   * @return the value of archive_format
   */
  public String getArchive_format () {
    return archive_format;
  }

  /**
   * Set the value of encoding_doc
   * @param newVar the new value of encoding_doc
   */
  public void setEncoding_doc (byte [] newVar) {
    encoding_doc = newVar;
  }

  /**
   * Get the value of encoding_doc
   * @return the value of encoding_doc
   */
  public byte [] getEncoding_doc () {
    return encoding_doc;
  }

  /**
   * Set the value of context
   * @param newVar the new value of context
   */
  public void setContext (Context newVar) {
    context = newVar;
  }

  /**
   * Get the value of context
   * @return the value of context
   */
  public Context getContext () {
    return context;
  }

  //
  // Other methods
  //

}
