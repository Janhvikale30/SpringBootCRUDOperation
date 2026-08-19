package com.app.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.app.model.Employee;
import com.app.repository.EmployeeRepositoryi;

@Service
public class EmployeeService implements EmployeeServicei{
	
	@Autowired
	private EmployeeRepositoryi er;

	@Override
	public Employee addEmployee(Employee Emp) {
		Employee emp= er.save(Emp);
		return emp;
	}

	@Override
	public List<Employee> getEmployee() {
		List<Employee> list = (List<Employee>) er.findAll();
		return list;
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		Employee e = er.save(emp);
		return e;
	}

	@Override
	public List<Employee> deleteEmployee(int id) {
		 er.deleteById(id);
		 List<Employee> emp = (List<Employee>) er.findAll();
		return emp;
	}

	@Override
	public boolean checkData(int id) {
	    if(er.existsById(id)) {
	    	return true;
	    }else {
	    	return false;
	    }
	}

	@Override
	public String countEmployee() {
		long empno = er.count();
		return "Number of Employees are "+empno;
	}

	@Override
	public Employee getById(int id) {
		Optional op = er.findById(id);
		if(op.isPresent()) {
			Employee emp = (Employee) op.get();
			return emp;
		}
		return null;
	}

	@Override 
	public List<Employee> getByName(String nm) {
		List<Employee> emp = er.findByName(nm);
		return emp;
	}

	@Override
	public Employee checkLogin(String un, String ps) {
		//Employee emp=er.findByUsernameOrPassword(un, ps);
         //Employee emp = er.validatebyusernameandpassword(un, ps);
		Employee emp = er.findByUsernameOrPassword(un, ps);
		return emp;
	}

	@Override
	public List<Employee> deleteByname(String nm) {
		 er.deleteByName(nm);
		return (List<Employee>)er.findAll();
	}

	@Override
	public List<Employee> paggingandsorting(int pageno) {
		int size=2;
		
		PageRequest pr = PageRequest.of(pageno, size, Sort.by("id").descending());
		Page<Employee> page =  er.findAll(pr);
		List<Employee> list = page.getContent();
		
		
		return list;
	}


	

}
