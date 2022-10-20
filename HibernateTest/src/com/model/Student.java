package com.model;

public class Student implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String rollNo;
	private String branch;
	public Student(int id, String name, String rollNo, String branch) {
		super();
		this.id = id;
		this.name = name;
		this.rollNo = rollNo;
		this.branch = branch;
	}
	public Student( String name, String rollNo, String branch) {
		this.name = name;
		this.rollNo = rollNo;
		this.branch = branch;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
