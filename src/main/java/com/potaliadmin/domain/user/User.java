package com.potaliadmin.domain.user;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by Shakti Singh on 10/2/14.
 */
@Entity
@Table(name = "store_admin",uniqueConstraints = @UniqueConstraint(columnNames = {"email", "login"}))
@NamedQueries({
    @NamedQuery(name = "findByEmail", query = "from User u where u.email = :email"),
    @NamedQuery(name = "findByLogin", query = "from User u where u.login = :login")
})
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", unique = true, nullable = false)
  private Long id;

  @Column(name = "login", unique = false, nullable = false,length = 45)
  private String login;

  @Column(name = "email", unique = true, nullable = false,length = 80)
  private String email;

  @Column(name = "name", unique = true, nullable = false,length = 80)
  private String name;

  @Column(name = "password_checksum", nullable = false)
  private String passwordChecksum;


//  @Temporal(TemporalType.DATE)
//  @Column(name = "created_date", nullable = false)
//  private Date createDate = new Date();


  @ManyToMany(cascade = {CascadeType.ALL})
  @JoinTable(name="store_admin_has_role", joinColumns = {@JoinColumn(name = "store_admin_id")},
      inverseJoinColumns = {@JoinColumn(name = "role_id")})
  private Set<Role> roleSet;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
      this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  public String getPasswordChecksum() {
    return passwordChecksum;
  }

  public void setPasswordChecksum(String passwordChecksum) {
    this.passwordChecksum = passwordChecksum;
  }

  public Set<Role> getRoleSet() {
    return roleSet;
  }

  public void setRoleSet(Set<Role> roleSet) {
    this.roleSet = roleSet;
  }
}
