package com.potaliadmin.constants.user;

import com.potaliadmin.domain.institute.Institute;

/**
 * Created by Shakti Singh on 12/6/14.
 */
public enum  EnumGender {

  MALE(0, "Male"),
  FEMALE(1, "Female"),
  OTHERS(2, "Others");

  private Integer id;
  private String name;

  EnumGender(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public static boolean contains(Integer id) {
    boolean contains = Boolean.FALSE;
    for (EnumGender enumGender : EnumGender.values()) {
      if (enumGender.id.equals(id)) {
        contains = Boolean.TRUE;
        break;
      }
    }
    return contains;
  }

  public static Integer getGenderIdFromName(String name) {
    Integer id = 0;
    for (EnumGender enumGender : EnumGender.values()) {
      if (enumGender.name.equalsIgnoreCase(name)) {
        id = enumGender.getId();
        break;
      }
    }
    return id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
