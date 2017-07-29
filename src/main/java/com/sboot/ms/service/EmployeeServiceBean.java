package com.sboot.ms.service;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 


import com.sboot.ms.model.Employee;
import com.sboot.ms.repository.EmployeeRepository;
@Service
public class EmployeeServiceBean implements EmployeeService {
	
//	@Autowired
//	private EmployeeRepository empRepository;
	
	private static BigInteger nexId;
	public static Map<BigInteger, Employee> emap;
	static {
		Employee e1 = new Employee();
		e1.setEname("Puru");
		e1.setAddress("Bangalore");
		save(e1);
		Employee e2 = new Employee();
		e2.setEname("Manoj");
		e2.setAddress("Mumbai");
		save(e2);
		Employee e3 = new Employee();
		e3.setEname("Debasish");
		e3.setAddress("Pune");
		save(e3);
	}
	public static Employee save (Employee emp){
	if(emap==null){
		emap= new HashMap<BigInteger, Employee>();
		nexId = BigInteger.ONE;
	}
	//update logic
	if(emp.getEid()!=null){
		Employee oldEmp = emap.get(emp.getEid());
		if(oldEmp==null){
			return null;
		}
		emap.remove(emp.getEid());
		emap.put(emp.getEid(), emp);
		return emp;
	}
	//create logic
	emp.setEid(nexId);
	nexId=nexId.add(BigInteger.ONE);
	emap.put(emp.getEid(), emp);
	return emp;
}
	

	@Override
	public Collection<Employee> findAll() {
		Collection<Employee> empls = emap.values();
		//Collection<Employee> empls = empRepository.findAll();
		return empls;
	}

	@Override
	public Employee findOne(BigInteger id) {
		Employee empl = emap.get(id);
		//Employee empl =empRepository.findOne(id);
		return empl;
	}

	@Override
	public Employee update(Employee emp) {
		Employee updateEmp = save(emp);
		return updateEmp;
	}

	@Override
	public Employee create(Employee emp) {
		Employee insertEmp = save(emp);
		return insertEmp;
	}

}
