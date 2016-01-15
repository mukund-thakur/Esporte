package com.esporte.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.esporte.model.Base.AddressType;
import com.esporte.model.Base.BaseData;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "address")
@Getter
@Setter
public class UserAddress extends BaseData{
	
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "city")
	private String city;
	
	@Column(name= "locality")
	private String locality;
	
	@Column(name="sublocality")
	private String subLocality;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "pin")
	private long pin;
	
	@Column(name = "landmark")
	private String landmark;
	
	@Column(name= "coordinates")
	private String coordinates;
	
	@Column(name="address_type")
	@Enumerated(EnumType.STRING)
	private AddressType addressType;
}
