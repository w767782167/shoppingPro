package com.etcxm.entity;

import java.util.Date;

public class Comment {
	private Long id;
	private String author;
	private Date createtime;
	private String comment;
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(Long id, String author, Date createtime, String comment) {
		super();
		this.id = id;
		this.author = author;
		this.createtime = createtime;
		this.comment = comment;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", author=" + author + ", createtime="
				+ createtime + ", comment=" + comment + "]";
	}
	
}
