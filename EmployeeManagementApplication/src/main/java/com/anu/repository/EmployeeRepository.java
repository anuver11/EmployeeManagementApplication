package com.anu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.anu.entity.Employee;
import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	List<Employee> findByEmpName(String empName);
	List<Employee> findByDepartment(String department);
	@Transactional
	@Modifying
	@Query(value = "update employee set emp_name=? where emp_id=?",nativeQuery = true)
	public void updateUsingQuery(String empName, int empId);
	
	
	

}
