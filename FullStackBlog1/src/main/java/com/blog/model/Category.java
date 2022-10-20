package com.blog.model;

public class Category {
	private int id;
	private  String name;
	private String desc;
	public Category(int id, String name, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
	}
	public Category(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public  int getId() {
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
