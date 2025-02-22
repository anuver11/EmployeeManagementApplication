package com.anu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Address {
	@Id
	@GeneratedValue(generator = "addIdGen", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "addIdGen", sequenceName = "addSeq",initialValue = 1001, allocationSize = 1)
	private int addressId;
	private String city;
	private int pincode;
	
	public Address() {
		super();
	}
	public Address(int addressId, String city, int pincode) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.pincode = pincode;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}	
	
	public AddressDTO prepareAddress(Address address) {
		AddressDTO addressDTO=new AddressDTO(address.getAddressId(), address.getCity(), address.getPincode());
		return addressDTO;
	}

}
