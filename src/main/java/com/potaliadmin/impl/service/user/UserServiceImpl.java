package com.potaliadmin.impl.service.user;

import com.potaliadmin.domain.user.User;
import com.potaliadmin.dto.internal.hibernate.user.UserSignUpQueryRequest;
import com.potaliadmin.dto.web.request.user.UserSignUpRequest;
import com.potaliadmin.dto.web.response.user.UserResponse;
import com.potaliadmin.exceptions.AlreadySignUpException;
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

  public UserResponse findByEmail(String email) {
    UserResponse userResponse = null;
    User user = getUserDao().findByEmail(email);
    if (null != user) {
      userResponse = new UserResponse();
      userResponse.setId(user.getId());
      userResponse.setEmail(user.getEmail());
      userResponse.setName(user.getAccountName());
      userResponse.setPasswordChecksum(user.getPasswordChecksum());
    }
    return userResponse;
  }

  @Override
  @Transactional
  public UserResponse signUp(UserSignUpRequest userSignUpRequest) {
    if (userSignUpRequest == null) {
      throw new InValidInputException("User request Parameters cannot be null");
    }
    if (userSignUpRequest.validate()) {
      throw new InValidInputException("Input Parameters are invalid!");
    }

    UserResponse userResponse = findByEmail(userSignUpRequest.getEmail());
    if (null != userResponse) {
      throw new AlreadySignUpException("You have already registered with us!");
    }

    UserSignUpQueryRequest userSignUpQueryRequest = new UserSignUpQueryRequest(userSignUpRequest);
    userSignUpQueryRequest.setHash(BaseUtil.passwordEncrypt(userSignUpRequest.getPassword()));
    User user = getUserDao().createUser(userSignUpQueryRequest);

    //create response
    userResponse = new UserResponse();
    userResponse.setId(user.getId());
    userResponse.setEmail(user.getEmail());
    userResponse.setName(user.getAccountName());

    return userResponse;
  }

  public UserDao getUserDao() {
    return userDao;
  }
}
