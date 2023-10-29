package com.example2.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example2.Entity.Employee;



public interface EmployeeService 
{
	
	List<Employee> getAllEmployees();
	
	Optional<Employee> getEmployeeById(int id);
	Employee updateEmployee(int id,Employee employee);
	String deleteEmployee(int id);
	
	
}
