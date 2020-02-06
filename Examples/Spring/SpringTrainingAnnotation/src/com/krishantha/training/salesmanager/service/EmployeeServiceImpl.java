package com.krishantha.training.salesmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krishantha.training.salesmanager.model.Employee;
import com.krishantha.training.salesmanager.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	
	EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl() {
		System.out.println("EmployeeService Constructor No Args");
	}

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
		System.out.println("EmployeeService Constructor EmployeeRepository");
	}

	@Override
	public List<Employee> getAllEmployees(){
		return employeeRepository.getAllEmployees();
	}

	
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
		System.out.println("EmployeeService Setter EmployeeRepository");
	}
	
	

}
