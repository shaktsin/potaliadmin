package com.potaliadmin.impl.service.user;

import com.potaliadmin.domain.user.User;
import com.potaliadmin.dto.web.request.user.UserSignUpRequest;
import com.potaliadmin.dto.web.response.user.UserResponse;
import com.potaliadmin.exceptions.AlreadySignUpException;
import com.potaliadmin.pact.service.users.LoginService;
import com.potaliadmin.pact.service.users.UserService;
import com.potaliadmin.security.Principal;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Shakti Singh on 10/6/14.
 */
@Service
public class LoginServiceImpl implements LoginService {

  @Autowired
  UserService userService;

  @Override
  @Transactional
  public UserResponse signUp(UserSignUpRequest userSignUpRequest) {
    try {
      UserResponse userResponse = getUserService().signUp(userSignUpRequest);
      UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userSignUpRequest.getEmail(), userSignUpRequest.getPassword());
      usernamePasswordToken.setRememberMe(true);
      SecurityUtils.getSubject().login(usernamePasswordToken);
      return userResponse;
    } catch (Exception e) {
      throw new AlreadySignUpException(e.getMessage());
    }
  }

  @Override
  public void logOut() {
    SecurityUtils.getSubject().logout();
  }

  @Override
  public UserResponse login(String email, String password) {
    UserResponse userResponse = new UserResponse();
    if (null == email || null == password) {
      userResponse.setException(Boolean.TRUE);
      userResponse.addMessage("Please enter your credentials");
      return userResponse;
    }
    try {

      UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(email, password);
      usernamePasswordToken.setRememberMe(true);
      SecurityUtils.getSubject().login(usernamePasswordToken);

      userResponse = getLoggedInUser();

    } catch (Exception e) {
      userResponse.setException(Boolean.TRUE);
      userResponse.addMessage(e.getMessage());
    }
    return userResponse;
  }

  @Override
  public UserResponse getLoggedInUser() {
    UserResponse userResponse = new UserResponse();
    Principal principal =(Principal) SecurityUtils.getSubject().getPrincipal();
    userResponse.setEmail(principal.getEmail());
    userResponse.setId(principal.getId());
    userResponse.setName(principal.getName());
    return userResponse;
  }

  public UserService getUserService() {
    return userService;
  }
}
