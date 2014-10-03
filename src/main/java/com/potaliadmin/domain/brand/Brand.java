package com.potaliadmin.domain.brand;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Shakti Singh on 10/2/14.
 */
@Entity
@Table(name = "brand")
public class Brand implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", unique = true, nullable = false)
  private Long id;

}
