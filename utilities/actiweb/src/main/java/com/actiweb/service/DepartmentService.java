package com.actiweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.actiweb.common.utils.ActiwebException;
import com.actiweb.entities.Department;

@Service
public class DepartmentService extends BaseService implements IDepartmentService {

  public List<Department> fetchDepartments() throws ActiwebException {
    return departmentDao.fetchDepartments();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.actiweb.service.IDepartmentService#addDepartment(com.actiweb.entities.
   * Department)
   */
  public void addDepartment(Department d) throws ActiwebException {
    departmentDao.addEntity(d);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.actiweb.service.IDepartmentService#updateDepartment(com.actiweb.entities.
   * Department)
   */
  public void updateDepartment(Department d) throws ActiwebException {
    departmentDao.updateEntity(d);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.actiweb.service.IDepartmentService#deleteDepartment(com.actiweb.entities.
   * Department)
   */
  public void deleteDepartment(Department d) throws ActiwebException {
    departmentDao.deleteEntity(d);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.actiweb.service.IDepartmentService#fetchDepartmentById(java.lang.String)
   */
  public Department fetchDepartmentById(String departmentId) throws ActiwebException {
    return departmentDao.fetchDepartment(departmentId);
  }

}
