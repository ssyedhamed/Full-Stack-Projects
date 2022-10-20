package com.relations;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Child {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "child_id")
	private int id;
	@Column(name = "Child_name",length = 290)
	private String name;
	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date")
	private Date birth;
	@Column(name="child_age",length = 232)
	private int age;
//	@ManyToOne
//	private Parent parent; 
//	public Parent getParent() {
//		return parent;
//	}
//	public void setParent(Parent parent) {
//		this.parent = parent;
//	}
	public Child() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Child(String name, Date birth, int age) {
		super();
		this.name = name;
		this.birth = birth;
		this.age = age;
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
	@Override
	public String toString() {
		return "Child [name=" + name + ", birth=" + birth + ", age=" + age + "]";
	}
	
}
