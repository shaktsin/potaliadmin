package com.potaliadmin.pact.service.users;

import com.potaliadmin.domain.user.User;
import com.potaliadmin.dto.web.request.user.UserSignUpRequest;

/**
 * Created by Shakti Singh on 10/6/14.
 */
public interface UserService {

  User findByEmail(String email);

  User signUp(UserSignUpRequest userSignUpRequest);

  User save(User user);
}
