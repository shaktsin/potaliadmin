package com.potaliadmin.constants.query;

/**
 * Created by Shakti Singh on 12/8/14.
 */
public enum EnumQueryOperation {

  EQUAL("="),
  GREATER_THAN_EQUAL(">="),
  IN("in"),
  IS_NOT_NULL("is not")
  ;

  private String token;
  EnumQueryOperation(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
