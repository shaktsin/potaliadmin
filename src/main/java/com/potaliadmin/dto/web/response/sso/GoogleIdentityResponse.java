package com.potaliadmin.dto.web.response.sso;

import com.potaliadmin.constants.json.DtoJsonConstants;
import com.potaliadmin.framework.json.JSONObject;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shakti Singh on 12/13/14.
 */
public class GoogleIdentityResponse {

  @JsonProperty("id")
  private String id;
  @JsonProperty("email")
  private String email;
  @JsonProperty("verified_email")
  private Boolean verified_email;
  @JsonProperty("name")
  private String name;
  @JsonProperty("given_name")
  private String given_name;
  @JsonProperty("family_name")
  private String family_name;
  @JsonProperty("picture")
  private String picture;
  @JsonProperty("gender")
  private String gender;
  @JsonProperty("locale")
  private String locale;
  @JsonProperty("link")
  private String link;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Boolean getVerified_email() {
    return verified_email;
  }

  public void setVerified_email(Boolean verified_email) {
    this.verified_email = verified_email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGiven_name() {
    return given_name;
  }

  public void setGiven_name(String given_name) {
    this.given_name = given_name;
  }

  public String getFamily_name() {
    return family_name;
  }

  public void setFamily_name(String family_name) {
    this.family_name = family_name;
  }

  public String getPicture() {
    return picture;
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getLocale() {
    return locale;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }
}
