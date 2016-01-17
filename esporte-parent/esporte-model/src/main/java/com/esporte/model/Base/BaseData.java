package com.esporte.model.Base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import org.joda.time.DateTimeUtils;

import com.esporte.common.utils.DateTimeUtil;

@MappedSuperclass
public class BaseData {

	@Id
	@GeneratedValue
	@Column(name="id",unique=true,nullable=false)
	private long id;
	
	@Column(name="created_at")
	private String createdAt;
	
	@Column(name="updated_at")
	private String updatedAt;
	
	@PrePersist
	protected void onCreate() {
		createdAt = DateTimeUtil.getCurrentDateTime();
		updatedAt = createdAt;
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
	
	
}
