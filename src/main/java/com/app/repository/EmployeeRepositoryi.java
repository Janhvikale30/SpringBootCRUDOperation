package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Employee;

import jakarta.transaction.Transactional;

//public interface EmployeeRepositoryi extends CrudRepository<Employee, Integer>{
@Repository
public interface EmployeeRepositoryi extends JpaRepository<Employee, Integer>{
	public List<Employee> findByName(String name);
	public Employee findByUsernameOrPassword(String username, String password);
	
	//jpql positional parameter
	@Query("from Employee where username=?1 and password=?2")
	public Employee validatebyusernameandpassword(String username, String password);
	
	//named parameter
	@Query("from Employee where username=:un and password=:ps")
	public Employee findEmployeeUsingUsernameAndPassword(String username, String password);
	@Transactional
	@Modifying
	public void deleteByName(String name);
	

}
