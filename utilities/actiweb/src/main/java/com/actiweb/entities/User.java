package com.actiweb.entities;

import java.io.Serializable;
import java.util.List;

public class User implements IBaseEntity, Serializable {

  private static final long serialVersionUID = 1L;
  private Long id;
  private String userName;
  private String password;
  private Employee employeeId;
  private String startTime;
  private String endTime;
  private Boolean active;
  private List<UserRole> roles;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public List<UserRole> getRoles() {
    return roles;
  }

  public void setRoles(List<UserRole> roles) {
    this.roles = roles;
  }

  public Employee getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Employee employeeId) {
    this.employeeId = employeeId;
  }

  public Boolean isActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

}
