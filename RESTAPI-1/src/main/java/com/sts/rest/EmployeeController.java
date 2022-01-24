package com.sts.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sts.rest.model.Employee;
import com.sts.rest.services.EmpRest;

@RestController
public class EmployeeController {

	@Autowired
	private EmpRest empRest;

	/* @GetMapping(value = "/empdetails")
	public List<Employee> getEmployees() {
		List<Employee> empDetails = empRest.getEmpDetails();
		return empDetails;
	} */

	// ---------------------------- Implemented Status code for GETAll---------------Start
	
	 @GetMapping(value = "/empdetails")
		public ResponseEntity<List<Employee>> getEmployees() {
			List<Employee> empDetails = empRest.getEmpDetails();
			if(empDetails.size()==0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();	
			}
			else {
				return ResponseEntity.of(Optional.of(empDetails));
			}
			
		}
	// ---------------------------- Implemented Status code for GET----------------End
	
	
	/*@GetMapping(path = "/emp/{id}")
	public Employee getEmployee(@PathVariable("id") int id) {

		Employee emp = empRest.getEmp(id);
		return emp;
	} */
		
	// ---------------------------- Implemented Status code for GET----------------Start
	
	@GetMapping(path = "/emp/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id) {
		Employee emp = empRest.getEmp(id);
		if(emp == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			return ResponseEntity.of(Optional.of(emp));			
		}		
	} 
	
	// ---------------------------- Implemented Status code for GET----------------End

	@PostMapping("/crtemp")
	public Employee createEmployee(@RequestBody Employee emp1) {
		empRest.createEmp(emp1);
		return emp1;
	}

	@DeleteMapping("/dltemp/{id}")
	public void deleteEmploee(@PathVariable("id") int id) {
		empRest.removeEmp(id);

	}
	
	// ---------------------------- Implemented Status code for GET----------------Start
	
	@PutMapping("/updemp/{id2}")
	public ResponseEntity<Employee> updateEmploee(@RequestBody Employee em,@PathVariable("id2") int id2) {
		try {
			 return ResponseEntity.ok().body(em); 
		 		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
		}
		
	}
	
	// ---------------------------- Implemented Status code for GET----------------End
	
	/*
	 * @PutMapping("/updemp/{id2}") public void updateEmploee(@RequestBody Employee
	 * em,@PathVariable("id2") int id2) { empRest.updateEmp(em, id2);
	 * 
	 * }
	 */	
}
