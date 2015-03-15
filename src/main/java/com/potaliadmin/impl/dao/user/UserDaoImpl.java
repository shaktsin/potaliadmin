package com.potaliadmin.impl.dao.user;

import com.potaliadmin.domain.user.User;
import com.potaliadmin.dto.internal.hibernate.user.UserSignUpQueryRequest;
import com.potaliadmin.exceptions.InValidInputException;
import com.potaliadmin.exceptions.PotaliRuntimeException;
import com.potaliadmin.impl.framework.BaseDaoImpl;
import com.potaliadmin.pact.dao.user.UserDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Shakti Singh on 10/6/14.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

  @Override
  public User findByEmail(String email) {
    return (User) findUniqueByNamedQueryAndNamedParam("findByEmail", new String[]{"email"}, new Object[]{email});
  }

  @Override
  public User findByLogin(String login) {
    return (User) findUniqueByNamedQueryAndNamedParam("findByLogin", new String[]{"login"}, new Object[]{login});
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public User createUser(UserSignUpQueryRequest userSignUpQueryRequest) {
    if (!userSignUpQueryRequest.verify()) {
      throw new InValidInputException("User sign up parameters are invalid");
    }
    User user = findByEmail(userSignUpQueryRequest.getEmail());
    if (user != null) {
      throw new PotaliRuntimeException("You are already registered with us");
    }

    try {
      user = new User();
      user.setName(userSignUpQueryRequest.getName());
      user.setLogin(userSignUpQueryRequest.getLogin());
      user.setEmail(userSignUpQueryRequest.getEmail());
      user.setPasswordChecksum(userSignUpQueryRequest.getHash());
      user = (User) save(user);
    } catch (Exception e) {
      e.printStackTrace();
    }


    return user;
  }
}
