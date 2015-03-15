package com.potaliadmin.dto.internal.hibernate.user;

/**
 * Created by Shakti Singh on 12/6/14.
 */
public abstract class AbstractUserRequest {

  protected String name;
  protected String email;
  protected String hash;
  protected String password;
  protected String login;

  public abstract boolean verify();


  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
