package com.rakesh.db.springbootmysql.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rakesh.db.springbootmysql.dao.EmployeeDao;
import com.rakesh.db.springbootmysql.model.Employee;

@RestController
@RequestMapping("/company")
public class EmployeeController {
	@Autowired
	EmployeeDao employeeDao;
	
	/* to save an employee*/
	
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return employeeDao.save(emp);
	}
	
	/* get all employees*/
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeDao.findall();
	}
	/* get employee by empId */
	@GetMapping("/notes/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") long empId){
		
		Employee emp=employeeDao.findbyid(empId);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
	}
	
	/*update an employee by empid*/
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value ="id") long empId, @Valid @RequestBody Employee empDetails){
		Employee emp=employeeDao.findbyid(empId);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		emp.setName(empDetails.getName());
		emp.setDesignation(empDetails.getDesignation());
		emp.setExpertise(empDetails.getExpertise());
		Employee updateEmployee=employeeDao.save(emp);
		return ResponseEntity.ok().body(updateEmployee);
		
	}
	
	/*delete an employee*/
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") Long empId){
		Employee emp=employeeDao.findbyid(empId);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		employeeDao.delete(emp);
		return ResponseEntity.ok().build();
		
	}
	
	
	
}
