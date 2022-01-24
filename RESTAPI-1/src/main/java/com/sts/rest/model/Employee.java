package com.sts.rest.model;

import org.springframework.stereotype.Component;

@Component
public class Employee {

	private int id;
	private String empname;
	private String empadd;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String empname, String empadd) {
		super();
		this.id = id;
		this.empname = empname;
		this.empadd = empadd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmpadd() {
		return empadd;
	}

	public void setEmpadd(String empadd) {
		this.empadd = empadd;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empname=" + empname + ", empadd=" + empadd + "]";
	}
	
	
}
