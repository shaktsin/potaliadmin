package com.potaliadmin.pact.service.users;

import com.potaliadmin.dto.web.request.user.UserSignUpRequest;
import com.potaliadmin.dto.web.response.user.UserSignUpResponse;

/**
 * Created by Shakti Singh on 10/6/14.
 */
public interface LoginService {

  public UserSignUpResponse signUp(UserSignUpRequest userSignUpRequest);

  public UserSignUpResponse login(String email,String password);

  public UserSignUpResponse getLoggedInUser();

  public void logOut();
}
