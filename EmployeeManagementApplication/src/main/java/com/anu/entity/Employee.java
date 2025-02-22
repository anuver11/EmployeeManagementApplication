package com.anu.entity;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Employee {
	@Id
	@GeneratedValue(generator = "empIdGen", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "empIdGen", sequenceName = "empSeq",initialValue = 501, allocationSize = 1)
	private int empId;
    private String empName;
    private String department;
    private String baseLocation;
    @JoinColumn(name = "addressId")
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    
	public Employee() {
		super();
	}
	public Employee(int empId, String empName, String department, String baseLocation, Address address) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.department = department;
		this.baseLocation = baseLocation;
		this.address = address;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getBaseLocation() {
		return baseLocation;
	}
	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
		
	@Override
	public String toString() {
		return "Employee\n "+ "EmpId : " + empId + " \nEmpName : " + empName + "\nDepartment : " + department + "\nBaseLocation : "
				+ baseLocation + "\nAddressId :" + address.getAddressId() +"\nCity : "+address.getCity()+"Pincode : "+address.getPincode();
	}
	public EmployeeDTO prepareEmpDTO(Employee employee) {
		Address address=new Address(employee.getAddress().getAddressId(), employee.getAddress().getCity(), employee.getAddress().getPincode());
		
		EmployeeDTO newEmpDTO= new EmployeeDTO();
		newEmpDTO.setEmpId(employee.getEmpId());
		newEmpDTO.setEmpName(employee.getEmpName());
		newEmpDTO.setDepartment(employee.getDepartment());
		newEmpDTO.setBaseLocation(employee.getBaseLocation());
		newEmpDTO.setAddress(address);
		return newEmpDTO;		
	}    

}
