package com.model;

import java.sql.Date;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Generated;
@Embeddable
//@Entity
//@Table(name = "user_address")
public class Address {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	int aid;
	@Column(name = "city_name",length = 320)
	String city;
	@Temporal(TemporalType.DATE)
	java.util.Date rdate;
	@Column(name ="openOrNot")
	
	boolean isOpen;
	@Lob
	byte[] image;
	@Transient
	int not;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public int getId() {
//		return aid;
//	}
//	public void setId(int id) {
//		this.aid = id;
//	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public java.util.Date getDate() {
		return rdate;
	}
	public void setDate(java.util.Date rdate) {
		this.rdate = rdate;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public int getNot() {
		return not;
	}
	public void setNot(int not) {
		this.not = not;
	}
	@Override
	public String toString() {
		return "Address [, city=" + city + ", rdate=" + rdate + ", isOpen=" + isOpen + ", image="
				+ Arrays.toString(image) + ", not=" + not + "]";
	}
	
}
