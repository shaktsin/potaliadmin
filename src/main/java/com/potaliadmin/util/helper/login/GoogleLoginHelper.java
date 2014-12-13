package com.potaliadmin.util.helper.login;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.gson.Gson;
import com.potaliadmin.controller.login.LoginController;
import com.potaliadmin.dto.web.response.sso.GoogleIdentityResponse;
import com.potaliadmin.util.helper.url.UrlBuilderHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Shakti Singh on 12/11/14.
 */
@Component
public class GoogleLoginHelper {

  @Value("${GOOGLE_CLIENT_ID}")
  private String clientId;

  @Value("${GOOGLE_SECRET_KEY}")
  private String secretKey;


  private static final Collection<String> SCOPE;
  private static final String USER_INFO_URL;
  private static final JsonFactory JSON_FACTORY;
  private static final HttpTransport HTTP_TRANSPORT;

  private static GoogleAuthorizationCodeFlow flow;


  static {
    SCOPE = Arrays.asList("https://www.googleapis.com/auth/userinfo.profile;https://www.googleapis.com/auth/userinfo.email".split(";"));
    USER_INFO_URL = "https://www.googleapis.com/oauth2/v1/userinfo";
    JSON_FACTORY = new JacksonFactory();
    HTTP_TRANSPORT =  new NetHttpTransport();
  }


  public void init() {
    flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT,
        JSON_FACTORY, clientId, secretKey, SCOPE).build();

  }


  public String buildLoginUrl(String stateToken) {
    GoogleAuthorizationCodeRequestUrl url = flow.newAuthorizationUrl();
    String callBackUrl = UrlBuilderHelper.buildUrlFromRequestMapping("callback");
    return url.setRedirectUri(callBackUrl).setState(stateToken).build();
  }



  /**
   * Generates a secure state token
   */
  public String generateStateToken() {
    SecureRandom sr1 = new SecureRandom();
    return "google;"+sr1.nextInt();
  }

  /**
   * Expects an Authentication Code, and makes an authenticated request for the user's profile information
   * @return JSON formatted user profile information
   * @param authCode authentication code provided by google
   */
  public GoogleIdentityResponse getUserInfoJson(final String authCode) throws IOException {
    String callBackUrl = UrlBuilderHelper.buildUrlFromRequestMapping("callback");
    final GoogleTokenResponse response = flow.newTokenRequest(authCode).setRedirectUri(callBackUrl).execute();
    final Credential credential = flow.createAndStoreCredential(response, null);
    final HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory(credential);
    // Make an authenticated request
    final GenericUrl url = new GenericUrl(USER_INFO_URL);
    final HttpRequest request = requestFactory.buildGetRequest(url);
    request.getHeaders().setContentType("application/json");
    final String jsonIdentity = request.execute().parseAsString();
    Gson gson = new Gson();
    return gson.fromJson(jsonIdentity, GoogleIdentityResponse.class);
  }

  public void destroy() {

  }
}
