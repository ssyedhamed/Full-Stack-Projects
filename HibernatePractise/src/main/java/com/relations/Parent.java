package com.relations;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
@Entity
public class Parent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "parent_id")
	private int id;
	@Column(name = "parent_name",length = 290)
	private String name;
	@Column(name = "birth_date",length = 290)
	private Date birth;
	@Column(name="parent_age",length = 232)
	private int age;
	private int children;
	 private boolean isOld;
	 @OneToMany
	 @JoinColumn(name = "parent_id")
	 private List<Child> child;
	
	public List<Child> getChild() {
		return child;
	}
	public void setChild(List<Child> child) {
		this.child = child;
	}
	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Parent(String name, Date birth, int age, int children, boolean isOld) {
		super();
		
		this.name = name;
		this.birth = birth;
		this.age = age;
		this.children = children;
		this.isOld = isOld;
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
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getChildren() {
		return children;
	}
	public void setChildren(int children) {
		this.children = children;
	}
	public boolean isOld() {
		return isOld;
	}
	public void setOld(boolean isOld) {
		this.isOld = isOld;
	}
	@Override
	public String toString() {
		return "Parent [name=" + name + ", birth=" + birth + ", age=" + age + ", children=" + children
				+ ", isOld? =" + isOld + "]";
	}
	
}
