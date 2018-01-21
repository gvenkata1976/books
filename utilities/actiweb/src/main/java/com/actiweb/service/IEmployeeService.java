package com.actiweb.service;

import java.util.List;

import com.actiweb.common.utils.ActiwebException;
import com.actiweb.entities.Employee;

public interface IEmployeeService {

  public List<Employee> fetchEmployees() throws ActiwebException;

  public List<Employee> fetchEmployees(int start, int size) throws ActiwebException;

  public Long countEmployees() throws ActiwebException;

  public List<String> getHierarchy() throws ActiwebException;

  public List<Employee> fetchEmployees(Employee e) throws ActiwebException;

  public void addEmployee(Employee e) throws ActiwebException;

  public void updateEmployee(Employee e) throws ActiwebException;

  public void deleteEmployee(Employee e) throws ActiwebException;

  public Employee fetchEmployeeById(String employeeId) throws ActiwebException;

}
