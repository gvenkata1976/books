package com.actiweb.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.actiweb.common.utils.ActiwebException;
import com.actiweb.dao.BaseDao;
import com.actiweb.dao.IUserDao;
import com.actiweb.entities.Function;
import com.actiweb.entities.User;
import com.actiweb.entities.UserRole;

@Repository("userDao")
public class UserDao extends BaseDao implements IUserDao {

  @Override
  public boolean isValidUser(User user) throws ActiwebException {
    if ("unknown".equals(user.getUserName())) {
      throw new ActiwebException("ERR_ACW_USR_01", "Invalid User");
    }
    return false;
  }

  @Override
  public List<UserRole> getUserRoles(User user) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Function> getRoleFunctions(UserRole role) {
    // TODO Auto-generated method stub
    return null;
  }

}
