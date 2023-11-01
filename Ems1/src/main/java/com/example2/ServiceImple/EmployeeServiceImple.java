package com.example2.ServiceImple;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example2.DTO.EmployeeDTO;
import com.example2.Entity.Employee;
import com.example2.Exception.ResourceNotFoundException;
import com.example2.Repository.EmployeeRepository;
import com.example2.Service.EmployeeService;
import com.example2.Util.Converter;


@Service
public class EmployeeServiceImple implements EmployeeService 
{

	@Autowired
    private EmployeeRepository employeeRepository;
	
	@Autowired
	private Converter converter;
	
	@Override
	public List<Employee> getAllEmployees()
	{
		List<Employee> employeeList=employeeRepository.findAll();
		ArrayList<Employee> employees=new  ArrayList<>(employeeList);
		return employees;
	}

	public Employee addEmployee(Employee employee)
	{
		employeeRepository.save(employee);
		return employee;
	}
	
	
	@Override
	public Employee updateEmployee(int emp_id, Employee employee)
	{
		try
		{
		Employee newEmployee=employeeRepository.findById(emp_id).get();
		if(employee.getEmp_name()!=null)
		{
			newEmployee.setEmp_name(employee.getEmp_name());
		}
		if(employee.getEmp_email()!=null)
		{
			newEmployee.setEmp_email(employee.getEmp_email());
		}
		if(employee.getEmp_phone_no()!=null)
		{
			newEmployee.setEmp_phone_no(employee.getEmp_phone_no());
		}
		if(employee.getGender()!=null)
		{
			newEmployee.setGender(employee.getGender());
		}
		if(employee.getSalary()!=null)
		{
			newEmployee.setSalary(employee.getSalary());
		}
		employeeRepository.save(newEmployee);
		return newEmployee;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		}
	
	
	@Override
	public String deleteEmployee(int emp_id) 
	{
		try
		{
		employeeRepository.deleteById(emp_id);
		return "Employees got deleted successfully!!";
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}


	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		try
		{
			Employee employee=employeeRepository.findById(id).get();
		return employee;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	
	
}
	
	
