package com.potaliadmin.impl.service.user;

import com.potaliadmin.domain.user.User;
import com.potaliadmin.dto.web.request.user.UserSignUpRequest;
import com.potaliadmin.exceptions.InValidInputException;
import com.potaliadmin.exceptions.PotaliRuntimeException;
import com.potaliadmin.pact.dao.user.UserDao;
import com.potaliadmin.pact.service.users.UserService;
import com.potaliadmin.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Shakti Singh on 10/6/14.
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserDao userDao;

  public User findByEmail(String email) {
    return getUserDao().findByEmail(email);
  }

  @Override
  @Transactional
  public User signUp(UserSignUpRequest userSignUpRequest) {
    if (userSignUpRequest == null) {
      throw new InValidInputException("User request Parameters cannot be null");
    }
    if (userSignUpRequest.validate()) {
      throw new InValidInputException("Input Parameters are invalid!");
    }
    User user = findByEmail(userSignUpRequest.getEmail());
    if (null != user) {
      throw new PotaliRuntimeException("You have already registered with us!");
    }

    user = new User();
    user.setName(userSignUpRequest.getName());
    user.setEmail(userSignUpRequest.getEmail());
    user.setPasswordChecksum(BaseUtil.passwordEncrypt(userSignUpRequest.getPassword()));
    user = save(user);
    return user;
  }

  @Override
  @Transactional
  public User save(User user) {
    return (User) userDao.save(user);
  }

  public UserDao getUserDao() {
    return userDao;
  }
}
