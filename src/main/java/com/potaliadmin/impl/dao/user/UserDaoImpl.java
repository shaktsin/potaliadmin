package com.potaliadmin.impl.dao.user;

import com.potaliadmin.domain.user.User;
import com.potaliadmin.impl.framework.BaseDaoImpl;
import com.potaliadmin.pact.dao.user.UserDao;
import org.springframework.stereotype.Repository;

/**
 * Created by Shakti Singh on 10/6/14.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

  @Override
  public User findByEmail(String email) {
    return (User) findUniqueByNamedQueryAndNamedParam("findByEmail", new String[]{"email"}, new Object[]{email});
  }
}
