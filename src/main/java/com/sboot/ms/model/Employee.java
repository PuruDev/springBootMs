package com.sboot.ms.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class Employee {
	//@Id
	//@GeneratedValue
	private BigInteger eid;
	private String ename;
	private String address;
	
	public BigInteger getEid() {
		return eid;
	}
	public void setEid(BigInteger eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
