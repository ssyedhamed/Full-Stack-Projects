package com.blog.model;

import java.sql.Timestamp;

public class Post {
	private int id;
	private String title;
	private String content;
	private String code;
	private String image;
	private Timestamp time;
	private int catId;
	private int userId;
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Post(int id, String title, String content, String code, Timestamp time, int catId, int userId, String image) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.code = code;
		this.time = time;
		this.catId = catId;
		this.userId = userId;
		this.image=image;
	}
	public Post(String title, String content, String code,  int catId, int userId,String image) {
		super();
		this.title = title;
		this.content = content;
		this.code = code;
		this.catId = catId;
		this.userId = userId;
		this.image=image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
