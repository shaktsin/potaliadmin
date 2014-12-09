package com.potaliadmin.constants.query;

/**
 * Created by Shakti Singh on 12/9/14.
 */
public enum EnumJoinType {

  INNER("inner"),
  LEFT("left"),
  RIGHT("right"),
  LEFT_OUTER("left outer"),
  RIGHT_OUTER("right_outer"),
  FULL("full")
  ;

  private String token;
  EnumJoinType(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
