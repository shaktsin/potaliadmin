package com.potaliadmin.controller.home;

import com.potaliadmin.constants.model.ModelKeyConstants;
import com.potaliadmin.util.helper.login.GoogleLoginHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {

  @Autowired
  GoogleLoginHelper googleLoginHelper;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
    model.addAttribute(ModelKeyConstants.MSG, "Hello world!");
    return "hello";
	}


  public GoogleLoginHelper getGoogleLoginHelper() {
    return googleLoginHelper;
  }
}