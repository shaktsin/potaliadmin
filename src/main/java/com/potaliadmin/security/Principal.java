package com.potaliadmin.security;

import java.io.Serializable;

/**
 * Created by Shakti Singh on 10/6/14.
 */
public class Principal implements Serializable{

  private Long id;
  private String name;
  private String email;

  public Principal(Long id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }
}
