package com.actiweb.entities;

import java.io.Serializable;
import java.util.List;

public class UserRole implements IBaseEntity, Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private int roleId;
  private String roleName;
  private List<Function> functions;

  public int getRoleId() {
    return roleId;
  }

  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public List<Function> getFunctions() {
    return functions;
  }

  public void setFunctions(List<Function> functions) {
    this.functions = functions;
  }

}
