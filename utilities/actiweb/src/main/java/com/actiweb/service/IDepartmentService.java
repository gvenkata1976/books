package com.actiweb.service;

import java.util.List;

import com.actiweb.common.utils.ActiwebException;
import com.actiweb.entities.Department;

public interface IDepartmentService {

  public List<Department> fetchDepartments() throws ActiwebException;

  public void addDepartment(Department e) throws ActiwebException;

  public void updateDepartment(Department e) throws ActiwebException;

  public void deleteDepartment(Department e) throws ActiwebException;

  public Department fetchDepartmentById(String departmentId) throws ActiwebException;

}
