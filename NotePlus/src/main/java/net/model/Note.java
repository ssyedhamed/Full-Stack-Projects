package net.model;

import javax.persistence.*;

@Entity
public class Note implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="note_title",length = 255)
	private String title;
	@Column(name="note_content",length = 1500)
	private String content;
	@Column(length = 500)
	private String image;
	public Note(String title, String content, String image) {
		super();
		this.title = title;
		this.content = content;
		this.image = image;
	}
	public Note() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
