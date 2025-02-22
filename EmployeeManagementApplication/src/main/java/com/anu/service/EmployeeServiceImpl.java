package com.anu.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anu.entity.Address;
import com.anu.entity.AddressDTO;
import com.anu.entity.Employee;
import com.anu.entity.EmployeeDTO;
import com.anu.repository.AddressRepository;
import com.anu.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository empRepository;
	
	@Autowired
	private AddressRepository addressRepo;

	@Override
	public void insert(EmployeeDTO empDTO) {
		empRepository.saveAndFlush(empDTO.prepareEmployee(empDTO));		
	}

	@Override
	public void remove(int empId) {
		empRepository.deleteById(empId);		
	}

	@Override
	public EmployeeDTO getEmployee(int id) {
		Optional<Employee> optionalEmp=empRepository.findById(id);
		Employee employee=optionalEmp.get();
		EmployeeDTO empDTO= employee.prepareEmpDTO(employee);
		return empDTO;
	}

	@Override
	public List<EmployeeDTO> getAllEmployee() {
		List<EmployeeDTO> list=new ArrayList<>();
		List<Employee> employees= empRepository.findAll();
		for(Employee emp : employees) {			
			list.add(emp.prepareEmpDTO(emp));
		}		
		return list;
	}

	@Override
	public Page<Employee> findAll(Pageable page) {
		return empRepository.findAll(page);
	}

	@Override
	public List<Employee> findAll(Sort sort) {
		return empRepository.findAll(sort);
	}
	
	public int count() {
		return (int)empRepository.count();
	}

	@Override
	public List<EmployeeDTO> findByEmpName(String empName) {	
		List<EmployeeDTO> list=new ArrayList<>();
		List<Employee> employees= empRepository.findByEmpName(empName);
		for(Employee emp : employees) {			
			list.add(emp.prepareEmpDTO(emp));
		}
		return list;
	}

	@Override
	public List<EmployeeDTO> findByDepartment(String department) {	
		List<EmployeeDTO> list=new ArrayList<>();
		List<Employee> employees= empRepository.findByDepartment(department);
		for(Employee emp : employees) {			
			list.add(emp.prepareEmpDTO(emp));
		}
		return list;
	}

	@Override
	public void update(EmployeeDTO emp, AddressDTO ad) {
		
		Optional<Employee> opEmp= empRepository.findById(emp.getEmpId());
		Employee employee=opEmp.get();
		employee.setEmpName(emp.getEmpName());
				
		empRepository.saveAndFlush(employee);
		
	}

	@Transactional
	@Override
	public void updateUsingQuery(EmployeeDTO emp, AddressDTO ad) {
		empRepository.updateUsingQuery(emp.getEmpName(), emp.getEmpId());
		addressRepo.updateUsingQuery(ad.getCity(), ad.getAddressId());
		
	}

	@Override
	public boolean exist(int id) {
		return empRepository.existsById(id);		
	}

}
