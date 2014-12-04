package com.potaliadmin.domain.address;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Shakti Singh on 11/15/14.
 */
@Entity
@Table(name = "address")
public class State implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", unique = true, nullable = false)
  private Long id;

  @Column(name = "name", nullable = false, length = 45)
  private String name;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Country country;


}
