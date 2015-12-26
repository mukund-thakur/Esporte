package com.esporte.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.esporte.model.Base.BaseData;

@Entity
@Table(name="email")
public class Email extends BaseData{
	
	@Column(name="email")
	private String email;
	
	@Column(name="provider")
	private String provider;
	
	@Column(name="email_type")
	private String emailType;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getEmailType() {
		return emailType;
	}

	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}
	
	
	
}
