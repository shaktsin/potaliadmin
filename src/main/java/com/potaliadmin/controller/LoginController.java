package com.potaliadmin.controller;

import com.potaliadmin.dto.web.request.user.UserSignUpRequest;
import com.potaliadmin.dto.web.response.user.UserSignUpResponse;
import com.potaliadmin.pact.service.users.LoginService;
import org.omg.CORBA.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Shakti Singh on 10/4/14.
 */
@Controller
public class LoginController {

  private Logger logger = LoggerFactory.getLogger(LoginController.class);

  @Autowired
  LoginService loginService;


  @RequestMapping(value = "/login",method = RequestMethod.POST)
  public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
    logger.info("Login request received : email " + email + "  password " + password);
    UserSignUpResponse userSignUpResponse = loginService.login(email,password);
    model.addAttribute("response", userSignUpResponse);
    if (userSignUpResponse.isException()) {
      return "hello";
    } else {
      return "dashboard";
    }
  }

  @RequestMapping(value = "/signUp",method = RequestMethod.POST)
  public String signUp(@ModelAttribute("userSignUpRequest")UserSignUpRequest userSignUpRequest, Model model) {
    UserSignUpResponse userSignUpResponse = new UserSignUpResponse();
    if (userSignUpRequest == null) {
      userSignUpResponse.setException(Boolean.TRUE);
      userSignUpResponse.addMessage("Don't be silly! I need some input");
      model.addAttribute("response", userSignUpResponse);
      return "hello";
    }
    logger.info("SignUp request received : email " + userSignUpRequest.getEmail() + "  password " + userSignUpRequest.getPassword());
    userSignUpResponse = loginService.signUp(userSignUpRequest);
    model.addAttribute("response", userSignUpResponse);
    return "dashboard";
  }

  @RequestMapping(value = "/logout",method = RequestMethod.GET)
  public String signUp() {
    loginService.logOut();
    return "hello";
  }
}
