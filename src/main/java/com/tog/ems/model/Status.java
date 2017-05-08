package com.tog.ems.model;

public enum Status {
	ACTIVE("ACTIVE"),
	INACTIVE("INACTIVE");
	
	String value;
	
	Status(String value){
	  this.value = value;
	}
	
	@Override
	public String toString(){
		return value;
	}

}
