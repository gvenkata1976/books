package com.actiweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.actiweb.common.utils.ActiwebException;
import com.actiweb.entities.Employee;

@Service
public class EmployeeService extends BaseService implements IEmployeeService {

  /*
   * (non-Javadoc)
   * 
   * @see com.actiweb.service.IEmployeeService#fetchEmployees()
   */
  public List<Employee> fetchEmployees(int start, int size) throws ActiwebException {
    return employeeDao.fetchEmployees(start, size);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.actiweb.service.IOrganizationService#findAllEmployees()
   */
  public List<Employee> fetchEmployees() throws ActiwebException {
    return employeeDao.fetchEmployees();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.actiweb.service.IOrganizationService#getHierarchy()
   */
  public List<String> getHierarchy() throws ActiwebException {
    return employeeDao.getHierarchy();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.actiweb.service.IOrganizationService#findAllEmployees(com.actiweb.entities.
   * Employee)
   */
  public List<Employee> fetchEmployees(Employee e) throws ActiwebException {

    return employeeDao.fetchEmployees(e);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.actiweb.service.IOrganizationService#saveEmployee(com.actiweb.entities.
   * Employee)
   */
  public void addEmployee(Employee e) throws ActiwebException {
    e.setEmployeeId(null);
    employeeDao.addEntity(e);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.actiweb.service.IOrganizationService#saveEmployee(com.actiweb.entities.
   * Employee)
   */
  public void updateEmployee(Employee e) throws ActiwebException {
    employeeDao.updateEntity(e);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.actiweb.service.IOrganizationService#deleteEmployee(com.actiweb.entities.
   * Employee)
   */
  public void deleteEmployee(Employee e) throws ActiwebException {
    employeeDao.deleteEntity(e);
  }

  @Override
  public Employee fetchEmployeeById(String employeeId) throws ActiwebException {
    return employeeDao.fetchEmployeeById(employeeId);
  }

  @Override
  public Long countEmployees() throws ActiwebException {

    return employeeDao.countEmployees();
  }
}
