package com.etcxm.entity;

public class AdminUser {
	private Long id;
	private String admin;
	private String password;
	
	public AdminUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminUser(Long id, String admin, String password) {
		super();
		this.id = id;
		this.admin = admin;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminUser [id=" + id + ", admin=" + admin + ", password="
				+ password + "]";
	}
	
	
}
