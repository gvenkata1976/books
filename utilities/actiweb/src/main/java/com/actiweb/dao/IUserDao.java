package com.actiweb.dao;

import java.util.List;

import com.actiweb.common.utils.ActiwebException;
import com.actiweb.entities.Function;
import com.actiweb.entities.User;
import com.actiweb.entities.UserRole;

public interface IUserDao extends IBaseDao {
  public boolean isValidUser(User user) throws ActiwebException;

  public List<UserRole> getUserRoles(User user) throws ActiwebException;

  public List<Function> getRoleFunctions(UserRole role) throws ActiwebException;
}
