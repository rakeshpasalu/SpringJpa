package com.rakesh.db.springbootmysql.savecontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rakesh.db.springbootmysql.dao.EmployeeDao;
import com.rakesh.db.springbootmysql.model.Employee;

@Controller
public class RegistrationForm {

	@Autowired
	EmployeeDao employeeDao;
/* sample controller to connect index.jsp */
	
	@RequestMapping(value ="/indexpage", method = RequestMethod.GET)
	public String indexController() {
		return "Index";
	}
	
	@PostMapping(value ="/save")
	public Employee savedetails(@RequestParam String name, String designation,String expertise, ModelMap model) {
		model.put("name", name);
		model.put("designation", designation);
		model.put("expertise", expertise);
		Employee emp = new Employee();
		emp.setName(name);
		emp.setDesignation(designation);
		emp.setExpertise(expertise);
		return employeeDao.save(emp);
		
	}
}
