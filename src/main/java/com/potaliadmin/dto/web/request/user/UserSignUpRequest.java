package com.potaliadmin.dto.web.request.user;


import com.potaliadmin.constants.institute.EnumInstitute;
import com.potaliadmin.constants.user.EnumGender;
import com.potaliadmin.dto.web.response.sso.GoogleIdentityResponse;
import com.potaliadmin.util.BaseUtil;

/**
 * Created by Shakti Singh on 10/6/14.
 */
public class UserSignUpRequest {

  private String name;
  private String login;
  private String email;
  private String password;

  public UserSignUpRequest() {
  }

//  public UserSignUpRequest(GoogleIdentityResponse googleIdentityResponse) {
//    this.firstName = googleIdentityResponse.getName();
//    this.lastName = googleIdentityResponse.getFamily_name();
//    this.accountName = googleIdentityResponse.getGiven_name();
//    this.email = googleIdentityResponse.getEmail();
//    this.gender = EnumGender.getGenderIdFromName(googleIdentityResponse.getGender());
//    this.verified = googleIdentityResponse.getVerified_email();
//  }



  public boolean validate() {
    boolean isValid = Boolean.TRUE;


    return isValid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
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

}
