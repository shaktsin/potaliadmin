package com.potaliadmin.pact.service.users;

import com.potaliadmin.dto.web.request.user.UserSignUpRequest;
import com.potaliadmin.dto.web.response.user.UserResponse;

/**
 * Created by Shakti Singh on 10/6/14.
 */
public interface LoginService {

  public UserResponse signUp(UserSignUpRequest userSignUpRequest);

  public UserResponse login(String email,String password);

  public UserResponse getLoggedInUser();

  public void logOut();
}
