package com.potaliadmin.domain.address;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Shakti Singh on 10/2/14.
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", unique = true, nullable = false)
  private Long id;

  @Column(name = "name", nullable = false, length = 150)
  private String name;

  @Column(name = "line1", nullable = false, length = 1000)
  private String line1;

  @Column(name = "landmark", length = 200)
  private String landmark;
}
