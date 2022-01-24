package com.sts.rest.services;

import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.sts.rest.model.Employee;

@Component
public class EmpRest {

	private static List<Employee> list1 = new ArrayList<Employee>();

	static {		
		  list1.add(new Employee(10, "Pradeep0", "CTC0"));
		  list1.add(new Employee(11, "Pradeep1", "CTC1"));
		  list1.add(new Employee(12, "Pradeep2", "CTC2"));
		  list1.add(new Employee(13, "Pradeep3", "CTC"));
		 }

	public List<Employee> getEmpDetails() {
		return list1;
	}

	// Old Style retrieval
	/*
	 * public Employee getEmp(int id) { Employee employee = null; Iterator<Employee>
	 * iterator = list1.iterator(); while (iterator.hasNext()) { employee =
	 * iterator.next(); if (employee.getId() == id) { return employee; }
	 * 
	 * employee = null; } return employee; }
	 */

	// Stream API----------------------------------------------GET
	public Employee getEmp(int id) {
		Employee employee = null;
		
		try {
		employee = list1.stream().filter(e -> e.getId() == id).findFirst().get();
		}
		catch(Exception e) {
			e.printStackTrace();
			}
		return employee;
	}

	// Stream API----------------------------------------------POST FOR UPDATE

	public Employee createEmp(Employee emp) {
		System.out.println(emp);
		list1.add(emp);
		return emp;

	}
	
	
	// Stream API----------------------------------------------POST FOR DELETE
	
	public void removeEmp(int id) {
		list1=list1.stream().filter(emp->{
			if(emp.getId()!=id) {
				return true;
			}
			else {
				return false;
			}
		} ).collect(Collectors.toList());
			
		}
	
	
	// Stream API----------------------------------------------POST FOR UPDATE
	
	public void updateEmp(Employee em,int id) {
		list1=list1.stream().map(emp->{
			if(emp.getId()==id) {
				emp.setEmpname(em.getEmpname());
				emp.setEmpadd(em.getEmpadd());
				}
			return emp;
		} ).collect(Collectors.toList());
	
			}
		
	}
	
	
