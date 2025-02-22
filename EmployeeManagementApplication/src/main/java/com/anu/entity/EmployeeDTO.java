package com.anu.entity;

public class EmployeeDTO {
	
	private int empId;
    private String empName;
    private String department;
    private String baseLocation;
    private Address address;
    
	public EmployeeDTO() {
		super();
	}
	public EmployeeDTO(int empId, String empName, String department, String baseLocation, Address address) {
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
		return "\nEmployee\n"+ "EmpId        : " + empId + " \nEmpName      : " + empName + "\nDepartment   : " + department + "\nBaseLocation : "
				+ baseLocation + "\nAddressId    : " + address.getAddressId() +"\nCity         : "+address.getCity()+"\nPincode      : "+address.getPincode();
	}
	public Employee prepareEmployee(EmployeeDTO empDTO) {
		Address address= new Address(empDTO.getAddress().getAddressId(), empDTO.getAddress().getCity(), empDTO.getAddress().getPincode());
		
		Employee newEmployee=new Employee();
		newEmployee.setEmpId(empDTO.getEmpId());
		newEmployee.setEmpName(empDTO.getEmpName());
		newEmployee.setDepartment(empDTO.getDepartment());
		newEmployee.setBaseLocation(empDTO.getBaseLocation());
		newEmployee.setAddress(address);
		return newEmployee;
	}

}
