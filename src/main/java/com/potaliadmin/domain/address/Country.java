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

  @Column(name = "short_iso_code", nullable = false,length = 2)
  private String shortIsoCode;

  @Column(name = "long_iso_code", nullable = true,length = 3)
  private String longIsoCode;

  @Column(name = "country_code", nullable = false)
  private Integer countryCode;

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

  public String getShortIsoCode() {
    return shortIsoCode;
  }

  public void setShortIsoCode(String shortIsoCode) {
    this.shortIsoCode = shortIsoCode;
  }

  public String getLongIsoCode() {
    return longIsoCode;
  }

  public void setLongIsoCode(String longIsoCode) {
    this.longIsoCode = longIsoCode;
  }

  public Integer getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(Integer countryCode) {
    this.countryCode = countryCode;
  }
}
