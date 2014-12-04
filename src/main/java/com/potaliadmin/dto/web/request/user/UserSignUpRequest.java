package com.potaliadmin.dto.web.request.user;


import com.potaliadmin.util.BaseUtil;

/**
 * Created by Shakti Singh on 10/6/14.
 */
public class UserSignUpRequest {

  private String name;
  private String email;
  private String password;
  private String rePassword;
  private String phone;
  private String company;
  private String url;

  public boolean validate() {
    boolean isValid = Boolean.TRUE;
    if (null == name) {
      isValid = Boolean.FALSE;
    }
    if (isValid && (null == email)) {
      isValid = Boolean.FALSE;
    }
    if (isValid && BaseUtil.isValidEmail(email)) {
      isValid = Boolean.FALSE;
    }
    if (isValid && (null == password || null == rePassword)) {
      isValid = Boolean.FALSE;
    }
    if (isValid && (password.equalsIgnoreCase(rePassword))) {
      isValid = Boolean.FALSE;
    }
    return isValid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRePassword() {
    return rePassword;
  }

  public void setRePassword(String rePassword) {
    this.rePassword = rePassword;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
