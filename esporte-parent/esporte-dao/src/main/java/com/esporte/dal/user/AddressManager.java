package com.esporte.dal.user;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esporte.model.user.Address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Repository("addressManager")
@Transactional(propagation = Propagation.REQUIRED)
public class AddressManager {
	
	@PersistenceContext
	private EntityManager addressManager;
	
	public Address getAddressById(long id) {
		return addressManager.find(Address.class, id);
		
	}

}
