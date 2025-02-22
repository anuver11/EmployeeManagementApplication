package com.anu;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.anu.entity.Address;
import com.anu.entity.Employee;
import com.anu.entity.EmployeeDTO;
import com.anu.service.EmployeeService;
import com.anu.entity.AddressDTO;

@SpringBootApplication
public class EmployeeManagementApplication implements CommandLineRunner {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	EmployeeUtil employeeUtil;
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
//		Address address1=new Address(1001, "Patna", 210012);
//		Address address2=new Address(1002,"Manali",452001);
//		Address address3=new Address(1003,"Raipur","423652");
//		Address address4=new Address(1004, "Mumbai", "215562");
//		EmployeeDTO emp1=new EmployeeDTO(501, "Aman", "Devloper", "Hydrabad", address1);
//		EmployeeDTO emp2=new EmployeeDTO(502,"John","Designer","Hydrabad",address2);
//		EmployeeDTO emp3=new EmployeeDTO(503,"Max","Devloper","Hydrabad",address3);
//		EmployeeDTO emp4=new EmployeeDTO(504,"Bob","Devloper","Chennai",address4);
//		empService.insert(emp1);
//		empService.insert(emp2);
//		empService.insert(emp3);
//		empService.insert(emp4);
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to the Employee Management System...!");
		int choice=0;		
		
		while(choice!=5) {
			try {
				employeeUtil.display();
				System.out.println("Enter your choice : ");
				choice=sc.nextInt();
				switch(choice) {
				case 1:					
					
					try {										
						int choice1=0;
						while(choice1!=5) {
							employeeUtil.searchType();
							System.out.println("Enter your choice : ");	
							choice1=sc.nextInt();
							switch(choice1) {
							case 1:
								System.out.println("Enter Employee ID : ");
								int id=employeeUtil.takeInt(sc);
								if(empService.exist(id)) {
									System.out.println(empService.getEmployee(id));
								}else {
									System.out.println("Employee Id "+id+" is not exist in the database.");
									}
								break;
							case 2:
								System.out.println("Enter Employee Name : ");
								String name=sc.next();
								List<EmployeeDTO> empList = empService.findByEmpName(name);
								if(empList.isEmpty()) {
									System.out.println("Name "+name+" is not exist in the database.");
								}else {
									for(EmployeeDTO emp : empList) {
										System.out.println(emp);
										}
									}
								break;
						
							case 3:
								System.out.println("Enter Employee Department : ");
								String dept=sc.next();
								List<EmployeeDTO> empList1 = empService.findByDepartment(dept);
								if(empList1.isEmpty()) {
									System.out.println("Department "+dept+" is not exist in the database.");
								}else {
									for(EmployeeDTO emp : empList1) {
										System.out.println(emp);
										}
									}	
								break;
							case 4:
								List<EmployeeDTO> empList2 = empService.getAllEmployee();
								if(empList2.isEmpty()) {
									System.out.println("No Data Available.");
								}else {
									for(EmployeeDTO emp : empList2) {
										System.out.println(emp);
										}
									}
								break;
							case 5:
			    				break;	
			    				
							default:
								System.out.println("Invalid choice!!, Please enter your choice again.");
								break;    	
								
								}
							}
						}catch (Exception e) {
							System.out.println(e.getMessage());
							sc.nextLine();
					}
					break;
				case 2:
					EmployeeDTO empDto=new EmployeeDTO();
					AddressDTO addressDto =new AddressDTO();
					employeeUtil.create(sc, empDto, addressDto);
					empService.insert(empDto);
					System.out.println("Employee Successfully Inserted.");	
					break;
					
				case 3:
					EmployeeDTO empUpdate;
					AddressDTO addressUpdate;
					Address address;
					System.out.println("Enter Employee ID : ");
					int empId= employeeUtil.takeInt(sc);
					if(empService.exist(empId)) {
						empUpdate=empService.getEmployee(empId);
						address=empUpdate.getAddress();
						addressUpdate=address.prepareAddress(address);						
						employeeUtil.create(sc, empUpdate, addressUpdate);	
						empService.insert(empUpdate);
						System.out.println("Employee updated successfully.");
					}else {
						System.out.println("Employee Id "+empId+" is not EXIST in the database.");
					}
					break;
					
				case 4:
					System.out.println("Enter Employee ID : ");
					int empIdDEL=employeeUtil.takeInt(sc);
					if(empService.exist(empIdDEL)) {
						empService.remove(empIdDEL);
						System.out.println("Scussfully Removed.");
					}else {
						System.out.println("Employee Id "+empIdDEL+" is not EXIST int the database.");
					}
					break;
					
				case 5:
					sc.close();
    				System.exit(1);
    				break;
    				
				default:
					System.out.println("Invalid choice!!, Please enter your choice again");
					break;    	
					
				}
			}catch (Exception e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		
//		System.out.println("Enter the ID of employee You want to see the details : ");
//		int id=sc.nextInt();
//		System.out.println(empService.getEmployee(id));
//		for(EmployeeDTO emp: empService.getAllEmployee()) {
//			System.out.println(emp);
//		}
//		
//		int k=empService.count()/2;
//		for(int i=0; i<=k;i++) {
//			Pageable pageable=PageRequest.of(i, 3);
//			
//			System.out.println("Records are:  ");
//			Iterable<Employee> employee=empService.findAll(pageable);
//			for(Employee emp:employee) {
//				System.out.println(emp);
//			}
//		}
		
		
//		Iterable<Employee> employee1= empService.findAll(Sort.by(Sort.Direction.DESC, "empId"));
//		
//		for(Employee emp:employee1) {
//			System.out.println(emp);
//		}
//		
//		List<Employee> list= empService.findByDepartment("Devloper");
//		
//		for(Employee emp:list) {
//			System.out.println(emp);
//		}
//		
//		AddressDTO address=new AddressDTO(1002, "Surat", "210012");
//		EmployeeDTO emp=new EmployeeDTO(502,"Deepak", "Developer", "Delhi", address.prepareAddress(address));
//		
//		empService.updateUsingQuery(emp, address);
	
	}
}
