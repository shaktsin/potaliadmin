package com.potaliadmin.web.filters;

import com.potaliadmin.dto.web.response.base.GenericBaseResponse;
import com.potaliadmin.dto.web.wrapper.GenericResponseWrapper;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import org.springframework.http.HttpStatus;

import javax.ws.rs.ext.Provider;
import java.awt.*;

/**
 * Created by Shakti Singh on 12/7/14.
 */
@Provider
public class ResponseWrapperFilter implements ContainerResponseFilter {

  @Override
  public ContainerResponse filter(ContainerRequest containerRequest, ContainerResponse containerResponse) {
    String contentType = containerResponse.getMediaType().toString();
    if (contentType != null && contentType.equalsIgnoreCase("application/json"))  {
      GenericResponseWrapper genericResponseWrapper = new GenericResponseWrapper();
      GenericBaseResponse genericBaseResponse = new GenericBaseResponse();
      Object object = containerResponse.getEntity();
      if (object instanceof GenericBaseResponse) {
        genericResponseWrapper.setResults(object);
        genericResponseWrapper.setStatus(HttpStatus.OK.value());
      } else {
        genericBaseResponse.setException(Boolean.TRUE);
        genericBaseResponse.addMessage("Are you out of your mind, check whether you have extended generic response");
        genericResponseWrapper.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
      }
      containerResponse.setEntity(genericResponseWrapper);
    }
    return containerResponse;
  }
}
