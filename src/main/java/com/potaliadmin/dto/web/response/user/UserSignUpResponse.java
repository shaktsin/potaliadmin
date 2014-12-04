package com.potaliadmin.dto.web.response.user;

import com.potaliadmin.dto.web.response.base.BaseResponse;

/**
 * Created by Shakti Singh on 10/6/14.
 */
public class UserSignUpResponse extends BaseResponse {

  private Long id;
  private String name;
  private String email;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
