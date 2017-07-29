package com.sboot.ms.controller;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sboot.ms.model.Employee;
import com.sboot.ms.service.EmployeeService;

@RestController
public class EmployeeController {
	@RequestMapping(value ="/hello")
	public String helloMs(){
		System.out.println("hello ms syso");
		return "hello first spring boot Ms";
	}
	@Autowired
	private EmployeeService eservice;
	
	/**
	 * Get all the employees
	 * @return
	 */
	@RequestMapping(
			value = "/employee",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Employee>> getEmployees(){
		Collection<Employee> empls = eservice.findAll();
		return new ResponseEntity<Collection<Employee>>(empls, HttpStatus.OK);
	}
	
	/**
	 * get employee from id
	 * @param id
	 * @return
	 */
	@RequestMapping(
			value = "/employee/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") BigInteger id){
		Employee empl = eservice.findOne(id);
		if(empl==null){
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(empl, HttpStatus.OK);
	}
	
	/**
	 * update employee with id
	 * @param id
	 * @return
	 */
	@RequestMapping(
			value = "/employee/update/{id}",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp){
		Employee updateEmp = eservice.update(emp);
		if(updateEmp==null){
			return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Employee>(updateEmp, HttpStatus.OK);
	}
	
	/**
	 * insert employee object
	 * @param emp
	 * @return
	 */
	@RequestMapping(
			value = "/employee/insert/{id}",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
		Employee insertEmp = eservice.create(emp);
		if(insertEmp==null){
			return new ResponseEntity<Employee>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Employee>(insertEmp, HttpStatus.OK);
	}
	
	
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
	

}
