package com.annotation.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class UIDA {
	Integer uid;
	String name;

	@Autowired
	Address address;

	@Autowired
	OfficeAddress officeAddress;
	
	public UIDA(){
		this.name = "Pranshi Dhingra";
		this.uid = 1122334455;
	}
	public UIDA(OfficeAddress officeAddress){
		this.officeAddress = officeAddress;
	}
	
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public OfficeAddress getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(OfficeAddress officeAddress) {
		this.officeAddress = officeAddress;
	}
	
}
