package com.potaliadmin.security;

import com.potaliadmin.constants.DefaultConstants;
import com.potaliadmin.domain.user.User;
import com.potaliadmin.dto.web.response.user.UserResponse;
import com.potaliadmin.pact.service.users.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Shakti Singh on 10/6/14.
 */
@Component
public class SecureRealm extends AuthorizingRealm {

  @Autowired
  UserService userService;

  public SecureRealm() {
    super();
  }

  @Override
  @SuppressWarnings("deprecation")
  public CredentialsMatcher getCredentialsMatcher() {
    SecurityCredentialsMatcher credentialsMatcher = new SecurityCredentialsMatcher();
    credentialsMatcher.setHashSalted(true);
    credentialsMatcher.setStoredCredentialsHexEncoded(false);
    credentialsMatcher.setHashIterations(DefaultConstants.hashIterations);
    return credentialsMatcher;
  }

  @SuppressWarnings("deprecation")
  class SecurityCredentialsMatcher extends org.apache.shiro.authc.credential.Md5CredentialsMatcher {
    protected Object getSalt(AuthenticationToken token) {
      return DefaultConstants.passwordSalt;
    }
  }

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    return null;
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
    String username = upToken.getUsername();
    // Null username is invalid
    if (username == null) {
      throw new AccountException("Null username are not allowed by this realm.");
    }
    UserResponse userResponse = getUserService().findByEmail(username);
    if (null == userResponse) {
      throw new AccountException("No user found with name "+username);
    }
    String password = userResponse.getPasswordChecksum();
    if (password == null) {
      throw new AccountException("Password is null for "+username);
    }
    Principal principal = new Principal(userResponse.getId(),userResponse.getName(),userResponse.getEmail());

    return new SimpleAuthenticationInfo(principal, password.toCharArray(), DefaultConstants.realmName);
  }

  public UserService getUserService() {
    return userService;
  }
}
