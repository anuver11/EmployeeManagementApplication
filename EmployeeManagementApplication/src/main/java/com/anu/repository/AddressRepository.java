package com.anu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.anu.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
	
	@Transactional
	@Modifying
	@Query(value = "update address set city=? where address_id=?",nativeQuery = true)
	public void updateUsingQuery(String city,int addressId);

}
