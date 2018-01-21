package com.actiweb.service;

import org.springframework.stereotype.Service;

import com.actiweb.common.utils.ActiwebException;
import com.actiweb.entities.User;

@Service
public class UserService extends BaseService implements IUserService {

  /*
   * (non-Javadoc)
   * 
   * @see com.actiweb.service.IUserService#isValidUser(com.actiweb.entities.User)
   */
  public void isValidUser(User user) throws ActiwebException {

    userDao.isValidUser(user);
  }

}
