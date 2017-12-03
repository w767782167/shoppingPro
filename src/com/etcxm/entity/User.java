package com.etcxm.entity;

public class User {

	 private Long id;
	 private String username;
	 private String password;
	 private String telp;
	 private String email;
	 
	 public void setEmail(String email){
		 this.email=email;
	 }
	 public String getEmail(){
		 return email;
	 }
	public void setTelp(String telp){
		this.telp=telp;
	}
	public String getTelp(){
		return telp;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + "]";
	}
	
	 
	 
	 
	
}
