package com.anu.entity;

public class AddressDTO {
	
	private int addressId;
	private String city;
	private int pincode;
	
	public AddressDTO() {
		super();
	}
	public AddressDTO(int addressId, String city, int pincode) {
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
	
	public Address prepareAddress(AddressDTO addressDTO) {		
		Address address=new Address(addressDTO.getAddressId(), addressDTO.getCity(), addressDTO.getPincode());
		return address;
	}


}
