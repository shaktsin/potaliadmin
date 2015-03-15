package com.potaliadmin.dto.internal.hibernate.user;

import com.potaliadmin.constants.user.EnumGender;
import com.potaliadmin.dto.web.request.user.UserSignUpRequest;
import org.apache.commons.lang.StringUtils;

/**
 * Created by Shakti Singh on 12/6/14.
 */
public class UserSignUpQueryRequest extends AbstractUserRequest {

  public UserSignUpQueryRequest() {  }

//  public UserSignUpQueryRequest(UserSignUpRequest userSignUpRequest) {
//    this.firstName = userSignUpRequest.getFirstName();
//    this.lastName = userSignUpRequest.getLastName();
//    this.accountName = userSignUpRequest.getAccountName();
//    if (null == accountName) {
//      accountName = firstName;
//    }
//    this.gender =userSignUpRequest.getGender();
//    this.email = userSignUpRequest.getEmail();
//    this.verified = userSignUpRequest.getVerified();
//    this.instituteId = userSignUpRequest.getInstituteId();
//  }

  public UserSignUpQueryRequest(UserSignUpRequest userSignUpRequest) {
    this.name = userSignUpRequest.getName();
    this.email = userSignUpRequest.getEmail();
    this.login = userSignUpRequest.getLogin();
    this.password = userSignUpRequest.getPassword();
  }

  public boolean verify() {
    Boolean isVerified = Boolean.TRUE;

    if (null == email) {
      isVerified = Boolean.FALSE;
    }
    if (isVerified && (null == hash)) {
      isVerified = Boolean.FALSE;
    }

    return isVerified;
  }


}
