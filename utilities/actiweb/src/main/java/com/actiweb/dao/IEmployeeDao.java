package com.actiweb.dao;

import java.util.List;

import com.actiweb.entities.Employee;

public interface IEmployeeDao extends IBaseDao {

  Long countEmployees();

  List<Employee> fetchEmployees();

  List<Employee> fetchEmployees(int start, int end);

  List<String> getHierarchy();

  List<Employee> fetchEmployees(Employee e);

  Employee fetchEmployeeById(String employeeId);

}
