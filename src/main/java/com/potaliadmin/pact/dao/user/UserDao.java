package com.potaliadmin.pact.dao.user;

import com.potaliadmin.domain.user.User;
import com.potaliadmin.dto.internal.hibernate.user.UserSignUpQueryRequest;
import com.potaliadmin.pact.framework.BaseDao;

/**
 * Created by Shakti Singh on 10/6/14.
 */
public interface UserDao extends BaseDao {

  public User findByEmail(String email);

  public User findByLogin(String login);

  public User createUser(UserSignUpQueryRequest userSignUpQueryRequest);
}
