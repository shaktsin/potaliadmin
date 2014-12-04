package com.potaliadmin.dto.web.response.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shakti Singh on 10/6/14.
 */
public class BaseResponse {

  boolean exception;
  List<String> messages = new ArrayList<String>();

  public void addMessage(String message) {
    messages.add(message);
  }

  public boolean isException() {
    return exception;
  }

  public void setException(boolean exception) {
    this.exception = exception;
  }

  public List<String> getMessages() {
    return messages;
  }

  public void setMessages(List<String> messages) {
    this.messages = messages;
  }
}
