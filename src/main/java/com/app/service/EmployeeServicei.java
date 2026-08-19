package com.app.service;

import java.util.List;

import com.app.model.Employee;

public interface EmployeeServicei {
	public Employee addEmployee(Employee Emp);
	public List<Employee> getEmployee();
	public Employee updateEmployee(Employee emp);
	public List<Employee> deleteEmployee(int id);
    public boolean checkData(int id);
    public String countEmployee();
    public Employee getById(int id);
    public List<Employee> getByName(String nm);
    public Employee checkLogin(String un, String ps);
    public List<Employee> deleteByname(String nm);
    
   public List<Employee> paggingandsorting(int pageno);
}
  