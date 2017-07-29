package com.sboot.ms.service;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.stereotype.Service;

import com.sboot.ms.model.Employee;

public interface EmployeeService {
	
	Collection<Employee> findAll();
	
	Employee findOne(BigInteger id);
	
	Employee update(Employee emp);
	
	Employee create(Employee emp);

}
