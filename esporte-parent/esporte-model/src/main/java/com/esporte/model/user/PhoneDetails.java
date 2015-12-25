package com.esporte.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.esporte.model.Base.BaseData;

@Entity
@Table(name="phone_details")
public class PhoneDetails extends BaseData{
	
	@Column(name="imei_code")
	private String imeiCode;
	
	@Column(name="gcm_id")
	private String gcmId;

	public String getImeiCode() {
		return imeiCode;
	}

	public void setImeiCode(String imeiCode) {
		this.imeiCode = imeiCode;
	}

	public String getGcmId() {
		return gcmId;
	}

	public void setGcmId(String gcmId) {
		this.gcmId = gcmId;
	}
	
	
}
