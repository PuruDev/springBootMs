package com.sboot.ms.repository;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sboot.ms.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, BigInteger> {
	

	
	//@Query("select e from Employee e")
	//public List<Employee> findAll();
	
	//@Query("select e from Employee e where e.eid = :id")
	//public Employee findOne(@Param("id") BigInteger id );
	
	//public Employee update(@Param("id") BigInteger id );
	
	//public Employee create(@Param("id") BigInteger id );
	
}
