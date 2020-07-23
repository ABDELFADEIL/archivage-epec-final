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

  public Long getDocument_id() {
    return document_id;
  }

  public String getFile_name() {
    return file_name;
  }

  public String getArchive_format() {
    return archive_format;
  }

  public byte[] getEncoding_doc() {
    return encoding_doc;
  }

  public Context getContext() {
    return context;
  }

  public void setDocument_id(Long document_id) {
    this.document_id = document_id;
  }

  public void setFile_name(String file_name) {
    this.file_name = file_name;
  }

  public void setArchive_format(String archive_format) {
    this.archive_format = archive_format;
  }

  public void setEncoding_doc(byte[] encoding_doc) {
    this.encoding_doc = encoding_doc;
  }

  public void setContext(Context context) {
    this.context = context;
  }
//
  // Other methods
  //

}
