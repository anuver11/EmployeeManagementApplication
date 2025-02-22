package com.anu.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.anu.entity.Address;
import com.anu.entity.AddressDTO;
import com.anu.entity.Employee;
import com.anu.entity.EmployeeDTO;

public interface EmployeeService {
	
	public void insert(EmployeeDTO empDTO);
	public void remove(int empId);
	public EmployeeDTO getEmployee(int id);
	public List<EmployeeDTO> getAllEmployee();
	public Page<Employee> findAll(Pageable page);
	public List<Employee> findAll(Sort sort);
	public int count();
	public List<EmployeeDTO> findByEmpName(String empName);
	public List<EmployeeDTO> findByDepartment(String department);
	public void update(EmployeeDTO emp, AddressDTO ad);
	public void updateUsingQuery(EmployeeDTO emp, AddressDTO ad);
	public boolean exist(int id);
}
