package com.rakesh.db.springbootmysql.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakesh.db.springbootmysql.model.Employee;
import com.rakesh.db.springbootmysql.repository.EmployeeRepository;

@Service
public class EmployeeDao {
	
	@Autowired
	EmployeeRepository employeeRepository;	
	/* to save an employee */
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
	}

	/* search all employee */
	
	public List<Employee> findall(){
		return employeeRepository.findAll();
	}
	/* get an employee */
	public Employee findbyid(Long empId){
		
		return employeeRepository.findById(empId).orElse(null);
	}
	/* delete an employee */
	public void delete(Employee emp) {
		employeeRepository.delete(emp);
	}
}
