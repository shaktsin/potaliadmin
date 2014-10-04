package com.potaliadmin.controller;

import org.omg.CORBA.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Shakti Singh on 10/4/14.
 */
@Controller
public class LoginController {

  private Logger logger = LoggerFactory.getLogger(LoginController.class);

  @RequestMapping(value = "/login",method = RequestMethod.POST)
  public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
    logger.info("Login request received : email " + email + "  password " + password);
    return "hello";
  }
}
