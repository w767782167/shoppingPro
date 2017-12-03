package lwd.entity;

import java.io.Serializable;

public class Notice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	private String content;
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notice(long id, String name, String content) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Notice [id=" + id + ", name=" + name + ", content=" + content
				+ "]";
	}
	
}
