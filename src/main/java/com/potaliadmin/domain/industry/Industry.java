package com.potaliadmin.domain.industry;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Shakti Singh on 12/9/14.
 */
@Entity
@Table(name = "industry")
public class Industry implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", unique = true, nullable = false)
  private Long id;

  @Column(name = "name", nullable = false, length = 45)
  private String name;
}
