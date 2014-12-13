package com.potaliadmin.exceptions;

import org.apache.commons.lang.StringUtils;

/**
 * Created by Shakti Singh on 12/13/14.
 */
public class AlreadySignUpException extends RuntimeException {

  private String messageKey;
  private Object[] params;


  public AlreadySignUpException(String messageKey, Object... params) {
    super();
    this.params = params;
    this.messageKey = messageKey;
  }

  @Override
  public String getMessage() {
    String message = super.getMessage();

    if (StringUtils.isBlank(message)) {
      message = "You have already sign up with us";
    }
    return message;
  }

  @Override
  public String toString() {

    return super.toString();
  }
}
