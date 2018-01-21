package com.actiweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.actiweb.common.utils.Constants;
import com.actiweb.dao.IDepartmentDao;
import com.actiweb.dao.IEmployeeDao;
import com.actiweb.dao.IUserDao;

@Service
public class BaseService implements Constants {

  @Autowired
  protected IEmployeeDao employeeDao;
  @Autowired
  protected IUserDao userDao;
  @Autowired
  protected IDepartmentDao departmentDao;

  public IDepartmentDao getDepartmentDao() {
    return departmentDao;
  }

  public void setDepartmentDao(IDepartmentDao departmentDao) {
    this.departmentDao = departmentDao;
  }

  public IEmployeeDao getEmployeeDao() {
    return employeeDao;
  }

  public void setEmployeeDao(IEmployeeDao employeeDao) {
    this.employeeDao = employeeDao;
  }

  public IUserDao getUserDao() {
    return userDao;
  }

  public void setUserDao(IUserDao userDao) {
    this.userDao = userDao;
  }

}
