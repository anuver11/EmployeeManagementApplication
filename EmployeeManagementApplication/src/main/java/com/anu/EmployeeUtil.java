package com.anu;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.anu.entity.AddressDTO;
import com.anu.entity.EmployeeDTO;

@Component
public class EmployeeUtil {
	
	public void display() {
		 String line="********************************";
		 System.out.println(line);
		 System.out.println("*           M E N U            *");
		 System.out.println(line);
		 System.out.println("* 1. Search Employees          *");	
		 System.out.println("* 2. Add Employee              *");
		 System.out.println("* 3. Update Employee Details   *");
		 System.out.println("* 4. Delete Employee Details   *");
		 System.out.println("* 5. Exit                      *");
		 System.out.println(line+"\n");
		
	}
	
	public void searchType() {
		String line="********************************";
		 System.out.println(line);
		 System.out.println("*           M E N U            *");
		 System.out.println(line);
		 System.out.println("* 1. Search By ID              *");	
		 System.out.println("* 2. Search By Name            *");
		 System.out.println("* 3. Search By Department      *");
		 System.out.println("* 4. Get All Employees         *");
		 System.out.println("* 5. Return To MAIN MENU       *");
		 System.out.println(line+"\n");
		
	}
	
	public EmployeeDTO create(Scanner sc, EmployeeDTO empdto,AddressDTO addressDto) {
		
		System.out.println("Enter Employee Name : ");
		String name =sc.next();
		empdto.setEmpName(name);
		System.out.println("Enter Employee Department: ");
		String department =sc.next();
		empdto.setDepartment(department);
		System.out.println("Enter Employee BaseLocation: ");
		String baseLocation =sc.next();
		empdto.setBaseLocation(baseLocation);
		System.out.println("Enter Employee City : ");		
		String city =sc.next();
		addressDto.setCity(city);
		System.out.println("Enter City Pincode : ");
		int pincode =takeInt(sc);
		addressDto.setPincode(pincode);
		empdto.setAddress(addressDto.prepareAddress(addressDto));
		return empdto;			
	}
	
	public int takeInt(Scanner sc) {
		 
		 int number=0;
		 boolean flag=true;
		 
		 while(flag) {
			 try {
				 number=sc.nextInt();
				 flag=false;
				 
			 }catch (Exception e) {
				System.out.println("Enter valid Number.");
				sc.nextLine();
			}
		 }
		 return number;
	 }

}
