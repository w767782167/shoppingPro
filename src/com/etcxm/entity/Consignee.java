package com.etcxm.entity;

public class Consignee {

	private long id;
	private String userName;
	private String consignee;
	private String consigneeTel;
	private String adress;
	private String completeAdress;
	
	public Consignee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consignee(long id, String userName, String consignee,
			String consigneeTel, String adress, String completeAdress) {
		super();
		this.id = id;
		this.userName = userName;
		this.consignee = consignee;
		this.consigneeTel = consigneeTel;
		this.adress = adress;
		this.completeAdress = completeAdress;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getConsigneeTel() {
		return consigneeTel;
	}

	public void setConsigneeTel(String consigneeTel) {
		this.consigneeTel = consigneeTel;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCompleteAdress() {
		return completeAdress;
	}

	public void setCompleteAdress(String completeAdress) {
		this.completeAdress = completeAdress;
	}

	@Override
	public String toString() {
		return "Consignee [id=" + id + ", userName=" + userName
				+ ", consignee=" + consignee + ", consigneeTel=" + consigneeTel
				+ ", adress=" + adress + ", completeAdress=" + completeAdress
				+ "]";
	}

	
	
}
