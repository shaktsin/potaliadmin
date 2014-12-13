package com.potaliadmin.domain.address;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Shakti Singh on 12/9/14.
 */
@Entity
@Table(name = "city")
public class City implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", unique = true, nullable = false)
  private Long id;

  @Column(name = "name", nullable = false, length = 45)
  private String name;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private State state;

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

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }
}
