package com.actiweb.dao;

import java.util.List;

import com.actiweb.common.utils.ActiwebException;
import com.actiweb.entities.Department;

public interface IDepartmentDao extends IBaseDao {

  List<Department> fetchDepartments() throws ActiwebException;

  Department fetchDepartment(String departmentId) throws ActiwebException;

}
