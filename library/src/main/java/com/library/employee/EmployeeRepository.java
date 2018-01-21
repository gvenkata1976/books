package com.library.employee;

import org.springframework.stereotype.Repository;

import com.library.domain.Employee;
import com.library.generic.GenericRepository;

@Repository 
public interface EmployeeRepository extends GenericRepository<Employee> {
	
}
