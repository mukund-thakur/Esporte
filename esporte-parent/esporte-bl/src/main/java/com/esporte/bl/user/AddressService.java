package com.esporte.bl.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.esporte.dal.user.AddressManager;
import com.esporte.model.user.Address;

public class AddressService {
	
	@Autowired
	private AddressManager addressManager;

	public Address getAddressById(long id) {
		return addressManager.getAddressById(id);
	}
}
