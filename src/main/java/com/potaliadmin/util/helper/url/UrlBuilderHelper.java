package com.potaliadmin.util.helper.url;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

/**
 * Created by Shakti Singh on 12/13/14.
 */
public class UrlBuilderHelper {


  public static String buildUrlFromController(Class controllerType, String methodName, Object... argumentValues) {
    UriComponents uriComponents = MvcUriComponentsBuilder.fromMethodName(controllerType, methodName, argumentValues).build();
    return uriComponents.encode().toUri().toString();
  }

  public static final String buildUrlFromRequestMapping(String requestMappingString) {
    return MvcUriComponentsBuilder.fromMappingName(requestMappingString).build();
    //return uriComponents.encode().toUri().toString();
  }
}
