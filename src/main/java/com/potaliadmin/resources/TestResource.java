package com.potaliadmin.resources;

import com.potaliadmin.dto.web.response.TestResponse;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;

/**
 * Created by Shakti Singh on 12/6/14.
 */
@Resource
@Path("/test")
public class TestResource {

  @GET
  @Path("/greetings")
  @Produces("application/json")
  public TestResponse sayHello() {
    String message = "Howdy! Greetings from OfCampus!" + " " + new Date();
    TestResponse testResponse = new TestResponse();
    testResponse.setMessage(message);
    return testResponse;
  }
}
