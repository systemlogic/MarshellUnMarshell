package com.annotation.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

public class UIDA {
	Integer uid;
	String name;
	
	@Autowired
	Address address;

	OfficeAddress officeAddress;
	
	public UIDA(){}
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
