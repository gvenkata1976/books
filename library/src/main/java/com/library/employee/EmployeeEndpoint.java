package com.library.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.common.Endpoints;
import com.library.domain.Employee;
import com.library.generic.GenericEndpoint;
import com.library.generic.GenericService;

@RestController
@RequestMapping(Endpoints.Employee.REQUEST_URL)
public class EmployeeEndpoint extends GenericEndpoint<Employee> {

	@Autowired
	public EmployeeEndpoint(GenericService<Employee> service) {
		super(service);
	}
}
