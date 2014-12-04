package com.potaliadmin.impl.service.user;

import com.potaliadmin.domain.user.User;
import com.potaliadmin.dto.web.request.user.UserSignUpRequest;
import com.potaliadmin.dto.web.response.user.UserSignUpResponse;
import com.potaliadmin.pact.service.users.LoginService;
import com.potaliadmin.pact.service.users.UserService;
import com.potaliadmin.security.Principal;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Shakti Singh on 10/6/14.
 */
@Service
public class LoginServiceImpl implements LoginService {

  @Autowired
  UserService userService;

  @Override
  public UserSignUpResponse signUp(UserSignUpRequest userSignUpRequest) {
    UserSignUpResponse userSignUpResponse = new UserSignUpResponse();
    try {
      User user = getUserService().signUp(userSignUpRequest);
      UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userSignUpRequest.getEmail(), userSignUpRequest.getPassword());
      usernamePasswordToken.setRememberMe(true);
      SecurityUtils.getSubject().login(usernamePasswordToken);

      userSignUpResponse.setEmail(user.getEmail());
      userSignUpResponse.setName(user.getName());
      userSignUpResponse.setId(user.getId());
    } catch (Exception e) {
      userSignUpResponse.setException(Boolean.TRUE);
      userSignUpResponse.addMessage(e.getMessage());
    }
    return userSignUpResponse;
  }

  @Override
  public void logOut() {
    SecurityUtils.getSubject().logout();
  }

  @Override
  public UserSignUpResponse login(String email, String password) {
    UserSignUpResponse userSignUpResponse = new UserSignUpResponse();
    if (null == email || null == password) {
      userSignUpResponse.setException(Boolean.TRUE);
      userSignUpResponse.addMessage("Please enter your credentials");
      return userSignUpResponse;
    }
    try {

      UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(email, password);
      usernamePasswordToken.setRememberMe(true);
      SecurityUtils.getSubject().login(usernamePasswordToken);

      userSignUpResponse = getLoggedInUser();

    } catch (Exception e) {
      userSignUpResponse.setException(Boolean.TRUE);
      userSignUpResponse.addMessage(e.getMessage());
    }
    return userSignUpResponse;
  }

  @Override
  public UserSignUpResponse getLoggedInUser() {
    UserSignUpResponse userSignUpResponse = new UserSignUpResponse();
    Principal principal =(Principal) SecurityUtils.getSubject().getPrincipal();
    userSignUpResponse.setEmail(principal.getEmail());
    userSignUpResponse.setId(principal.getId());
    userSignUpResponse.setName(principal.getName());
    return userSignUpResponse;
  }

  public UserService getUserService() {
    return userService;
  }
}
