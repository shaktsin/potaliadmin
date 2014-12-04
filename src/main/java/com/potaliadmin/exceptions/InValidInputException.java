package com.potaliadmin.exceptions;

import org.apache.commons.lang.StringUtils;

/**
 * Created by Shakti Singh on 10/6/14.
 */
public class InValidInputException extends PotaliRuntimeException {

  public InValidInputException(String messageKey, Object... params) {
    super(messageKey, params);
  }

  @Override
  public String getMessage() {
    String message = super.getMessage();

    if (StringUtils.isBlank(message)) {
      message = "Input provided is not valid";
    }
    return message;
  }
}
