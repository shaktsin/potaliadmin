package com.potaliadmin.controller.login;

import com.potaliadmin.constants.institute.EnumInstitute;
import com.potaliadmin.dto.web.request.user.UserSignUpRequest;
import com.potaliadmin.dto.web.response.sso.GoogleIdentityResponse;
import com.potaliadmin.dto.web.response.user.UserResponse;
import com.potaliadmin.exceptions.AlreadySignUpException;
import com.potaliadmin.pact.service.users.LoginService;
import com.potaliadmin.util.helper.login.GoogleLoginHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Shakti Singh on 10/4/14.
 */
@Controller
public class LoginController {

  private Logger logger = LoggerFactory.getLogger(LoginController.class);

  @Autowired
  LoginService loginService;

  @Autowired
  GoogleLoginHelper googleLoginHelper;


  @RequestMapping(value = "/login",method = RequestMethod.POST)
  public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
    logger.info("Login request received : email " + email + "  password " + password);
    UserResponse userResponse = loginService.login(email,password);
    model.addAttribute("response", userResponse);
    if (userResponse.isException()) {
      return "hello";
    } else {
      return "dashboard";
    }
  }

  @RequestMapping(value = "/signUp",method = RequestMethod.POST)
  public String signUp(@ModelAttribute("userSignUpRequest")UserSignUpRequest userSignUpRequest, Model model) {
    UserResponse userResponse = new UserResponse();
    if (userSignUpRequest == null) {
      userResponse.setException(Boolean.TRUE);
      userResponse.addMessage("Don't be silly! I need some input");
      model.addAttribute("response", userResponse);
      return "hello";
    }
    logger.info("SignUp request received : email " + userSignUpRequest.getEmail() + "  password " + userSignUpRequest.getPassword());
    userResponse = loginService.signUp(userSignUpRequest);
    model.addAttribute("response", userResponse);
    return "dashboard";
  }

  @RequestMapping(name = "callback",value = "/oauth", method = RequestMethod.GET)
  public String callback(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Model model) {
    String authCode = httpServletRequest.getParameter("code");
    String state = httpServletRequest.getParameter("state");
    UserResponse userResponse = new UserResponse();
    if (authCode == null || state == null) {
      userResponse.setException(Boolean.TRUE);
      userResponse.addMessage("Something went wrong in google sign on process");
      model.addAttribute("response", userResponse);
      return "hello";
    }

    String sessionToken = (String)httpServletRequest.getSession().getAttribute("state");

    if (sessionToken == null || !sessionToken.equalsIgnoreCase(state)) {
      userResponse.setException(Boolean.TRUE);
      userResponse.addMessage("Your session is expired, please try again");
      model.addAttribute("response", userResponse);
      return "hello";
    }

    httpServletRequest.removeAttribute("state");


    try {

      GoogleIdentityResponse googleIdentityResponse = googleLoginHelper.getUserInfoJson(authCode);
      if (googleIdentityResponse == null) {
        userResponse.setException(Boolean.TRUE);
        userResponse.addMessage("Failed to make google sign on credential exchange");
        model.addAttribute("response", userResponse);
        return "hello";
      }

      String email = googleIdentityResponse.getEmail();
      String password = "DEFAULT_PASSWORD"+email;

      try {
        UserSignUpRequest userSignUpRequest = new UserSignUpRequest(googleIdentityResponse);
        userSignUpRequest.setInstituteId(EnumInstitute.OFC.getId());
        userSignUpRequest.setPassword(password);
        userSignUpRequest.setRePassword(password);

        userResponse = getLoginService().signUp(userSignUpRequest);
        model.addAttribute("response", userResponse);
        return "dashboard";

      } catch (AlreadySignUpException e) {
        try {
          userResponse = getLoginService().login(email,password);
          model.addAttribute("response", userResponse);
          return "dashboard";
        } catch (Exception ex) {
          logger.error("Error ",ex);
          userResponse.setException(Boolean.TRUE);
          userResponse.addMessage("Could not login with email "+email);
          model.addAttribute("response", userResponse);
          return "hello";

        }
      } catch (Exception e) {
        logger.info("Error ",e);
        userResponse.setException(Boolean.TRUE);
        userResponse.addMessage("Could not sign up with "+email);
        model.addAttribute("response", userResponse);
        return "hello";
      }


    } catch (Exception e) {
      logger.info("Error ",e);
      userResponse.setException(Boolean.TRUE);
      userResponse.addMessage("Failed to make google sign on credential exchange");
      model.addAttribute("response", userResponse);
      return "hello";
    }
  }

  @RequestMapping(value = "/sso", method = RequestMethod.GET)
  public ModelAndView sso(HttpServletRequest httpServletRequest) {
    String stateToken = getGoogleLoginHelper().generateStateToken();
    String url = getGoogleLoginHelper().buildLoginUrl(stateToken);
    httpServletRequest.getSession().setAttribute("state", stateToken);

    return new ModelAndView("redirect:"+url);
  }

  @RequestMapping(value = "/logout",method = RequestMethod.GET)
  public String signUp() {
    loginService.logOut();
    return "hello";
  }


  public GoogleLoginHelper getGoogleLoginHelper() {
    return googleLoginHelper;
  }

  public LoginService getLoginService() {
    return loginService;
  }
}
