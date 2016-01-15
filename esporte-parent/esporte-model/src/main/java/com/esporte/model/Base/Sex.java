package com.esporte.model.Base;


public enum Sex {
	M("M",0),
	F("F",1);
	private final String sex;
	private final int value;
	
	Sex(String sex,int value) {
		this.sex = sex;
		this.value = value;
	}

	public String getSex() {
		return sex;
	}

	public int getValue() {
		return value;
	}
	
	
}
