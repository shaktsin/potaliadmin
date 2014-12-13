package com.potaliadmin.constants.institute;

/**
 * Created by Shakti Singh on 12/6/14.
 */
public enum  EnumInstitute {

  OFC(1L, "OfCampus", "gmail.com"),
  ISB(2L, "ISB", "pgp.isb.edu");

  private Long id;
  private String name;
  private String emailSuffix;


  EnumInstitute(Long id, String name, String emailSuffix) {
    this.id = id;
    this.name = name;
    this.emailSuffix = emailSuffix;
  }

  public static boolean contains(Long id) {
    boolean contains = Boolean.FALSE;
    for (EnumInstitute enumInstitute : EnumInstitute.values()) {
      if (enumInstitute.id.equals(id)) {
        contains = Boolean.TRUE;
        break;
      }
    }
    return contains;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmailSuffix() {
    return emailSuffix;
  }

  public void setEmailSuffix(String emailSuffix) {
    this.emailSuffix = emailSuffix;
  }
}
