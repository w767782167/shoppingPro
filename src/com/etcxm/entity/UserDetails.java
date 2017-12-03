package com.etcxm.entity;

public class UserDetails {
	private Long id;
	private String username;
	private String sex;
	private String password;
	private String reallyName;
	private String brithday;
	private String telp;
	private String email;
	private String question;
	private String result;
	private String adress;
	
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDetails(Long id, String username, String sex, String password,
			String reallyName, String brithday, String telp, String email,
			String question, String result, String adress) {
		super();
		this.id = id;
		this.username = username;
		this.sex = sex;
		this.password = password;
		this.reallyName = reallyName;
		this.brithday = brithday;
		this.telp = telp;
		this.email = email;
		this.question = question;
		this.result = result;
		this.adress = adress;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getReallyName() {
		return reallyName;
	}

	public void setReallyName(String reallyName) {
		this.reallyName = reallyName;
	}

	public String getBrithday() {
		return brithday;
	}

	public void setBrithday(String brithday) {
		this.brithday = brithday;
	}

	public String getTelp() {
		return telp;
	}

	public void setTelp(String telp) {
		this.telp = telp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", username=" + username + ", sex="
				+ sex + ", password=" + password + ", reallyName=" + reallyName
				+ ", brithday=" + brithday + ", telp=" + telp + ", email="
				+ email + ", question=" + question + ", result=" + result
				+ ", adress=" + adress + "]\n";
	}
	
	
	
}
