package com.potaliadmin.exceptions;

/**
 * Created by Shakti Singh on 10/6/14.
 */
public class PotaliRuntimeException extends RuntimeException {

  private String messageKey;
  private Object[] params;


  public PotaliRuntimeException(String messageKey, Object... params) {
    super();
    this.params = params;
    this.messageKey = messageKey;
  }

  @Override
  public String getMessage() {
    return "Error: " + messageKey;
  }

  @Override
  public String toString() {

    return super.toString();
  }
}
