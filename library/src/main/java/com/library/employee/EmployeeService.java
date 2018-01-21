package com.library.employee;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.library.common.ResourceNotFoundException;
import com.library.domain.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Transactional(readOnly = true)
	public List<Employee> findAll() {
		List<Employee> target = new ArrayList<Employee>();
		repo.findAll().forEach(target::add);
		return target;
	}

	@Transactional(readOnly = true)
	public Employee findOne(String id) {
		Employee employee = repo.findOne(new BigInteger(id));
		if (employee == null) {
			throw new ResourceNotFoundException(id);
		}
		return employee;
	}

	@Transactional(rollbackFor = { Exception.class }, readOnly = false)
	public void save(Employee employee) {
		repo.save(employee);
	}

	public void update(String id, Employee employee) {
		Employee emp2 = findOne(id);
		BeanUtils.copyProperties(emp2, employee);
		employee.setModifiedDate(new Date());
		repo.save(employee);
	}

	public void delete(String id) {
		Employee emp2 = findOne(id);
		repo.delete(emp2); 
	} 
}
