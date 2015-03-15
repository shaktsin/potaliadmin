package com.potaliadmin.pact.service.users;

import com.potaliadmin.dto.web.request.user.UserSignUpRequest;
import com.potaliadmin.dto.web.response.user.UserResponse;

/**
 * Created by Shakti Singh on 10/6/14.
 */
public interface UserService {

  UserResponse findByEmail(String email);

  UserResponse findByLogin(String login);

  UserResponse signUp(UserSignUpRequest userSignUpRequest);
}
