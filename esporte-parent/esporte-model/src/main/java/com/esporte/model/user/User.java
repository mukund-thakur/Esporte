package com.esporte.model.user;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

import lombok.*;
import scala.util.parsing.combinator.testing.Str;;

@Entity
@Table(name="user")
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
	@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
})
@Getter
@Setter
public class User {

	public enum Type {
		PLAYER,
		COACH,
		VENDOR
	}
	
	@Id
	@GeneratedValue
	@Column(name="id",unique=true,nullable=false)
	private long id;
	
	@Column(name="created_at")
	private String createdAt;
	
	@Column(name="updated_at")
	private String updatedAt;
	
	@Column(name="gender")
	private int gender;
	
	@Column(name="dob")
	private String dob;
	
	@Column(name="name")
	private String name;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="status")
	private int status;
	
	
	@Column(name="user_type")
	@Enumerated(EnumType.STRING)
	Type userType;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_email_mapping", joinColumns={@JoinColumn(name="user_id",referencedColumnName="id")}
	,inverseJoinColumns={@JoinColumn(name="email_id",referencedColumnName="id")})
	private Set<Email> emailIds;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_phone_number_mapping",
	joinColumns={@JoinColumn(name="user_id",referencedColumnName="id")},
	inverseJoinColumns={@JoinColumn(name="phone_number_id",referencedColumnName="id")})
	private Set<PhoneNumber> phoneNumbers;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_phone_details_mapping",
	joinColumns={@JoinColumn(name="user_id",referencedColumnName="id")},
	inverseJoinColumns={@JoinColumn(name="phone_details_id",referencedColumnName="id")})
	private Set<PhoneDetails> phoneDetails;
	public Set<Email> getEmailIds() {
		return emailIds;
	}

	public void setEmailIds(Set<Email> emailIds) {
		this.emailIds = emailIds;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Type getUserType() {
		return userType;
	}

	public void setUserType(Type userType) {
		this.userType = userType;
	}

	public Set<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Set<PhoneDetails> getPhoneDetails() {
		return phoneDetails;
	}

	public void setPhoneDetails(Set<PhoneDetails> phoneDetails) {
		this.phoneDetails = phoneDetails;
	}
	
}

