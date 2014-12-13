package com.potaliadmin.domain.address;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Shakti Singh on 10/2/14.
 */
@Entity
@Table(name = "country")
public class Country implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", unique = true, nullable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "country_code", nullable = false,length = 2)
  private String countryCode;

  @Column(name = "iso_code", nullable = true,length = 3)
  private String isoCode;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public String getIsoCode() {
    return isoCode;
  }

  public void setIsoCode(String isoCode) {
    this.isoCode = isoCode;
  }
}
