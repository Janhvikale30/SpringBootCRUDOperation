package com.app.controller;

import com.app.repository.EmployeeRepositoryi;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Employee;
import com.app.service.EmployeeServicei;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServicei es;

	
	

	@PostMapping("/Employee")
	public Employee EmployeeData(@RequestBody Employee Employee) {
		Employee emp = es.addEmployee(Employee);

		return emp;

	}

	@GetMapping("/get")
	public List<Employee> retrieveData() {
		List<Employee> em = es.getEmployee();
		return em;
	}

	@PutMapping("/update")
	public Employee updateData(@RequestBody Employee emp) {
		Employee update = es.updateEmployee(emp);
		return update;
	}
      
	@DeleteMapping("/delete/{id}")
	public List<Employee> deleteData(@PathVariable("id") int id) {
		List<Employee> data = es.deleteEmployee(id);
		return data;
	}
	@GetMapping("/exist/{id}")
	public boolean checkdata(@PathVariable("id") int id) {
		return es.checkData(id);
	}
	@GetMapping("/count")
	public String EmployeeCount() {
		String num = es.countEmployee();
		return num;
	}
	@GetMapping("/getbyid/{id}")
	public Employee getById(@PathVariable("id") int id) {
		Employee employee= es.getById(id);
		return employee;
		
	}
	@GetMapping("/getbyname/{name}")
	public List<Employee> getbyname(@PathVariable("name") String name){
	List<Employee> emp = es.getByName(name);
	return emp;
	}
	@GetMapping("/check/{username}/{password}")
	public Employee checkLogin(@PathVariable("username") String username, @PathVariable("password") String password) {
		Employee e = es.checkLogin(username, password);
		return e;
	}
	@DeleteMapping("/deletebyname/{name}")
	public List<Employee> deleteByName(@PathVariable("name") String name){
	List<Employee> e= 	es.deleteByname(name);
	return e;
	}
	
	@GetMapping("/pagging/{pageno}")
	public List<Employee> paggingEmployeeData(@PathVariable("pageno") int pageno){
		List<Employee> list= es.paggingandsorting(pageno);
		return list;
	}

	
	

	
}
