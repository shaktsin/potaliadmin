package com.potaliadmin.domain.industry;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Shakti Singh on 12/9/14.
 */
@Entity
@Table(name = "industry_roles")
public class IndustryRoles implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", unique = true, nullable = false)
  private Long id;

  @Column(name = "name", nullable = false, length = 45)
  private String name;

  @ManyToOne
  @JoinColumn(name = "industry_id")
  private Industry industry;

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

  public Industry getIndustry() {
    return industry;
  }

  public void setIndustry(Industry industry) {
    this.industry = industry;
  }
}
