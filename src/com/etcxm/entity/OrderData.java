package com.etcxm.entity;

public class OrderData {
	private long id;
	private long userId;
	private String userName;
	private String productNum;
	private String consignee;
	private String consigneeTel;
	private String adress;
	private String logistics;
	private String pay;
	
	public OrderData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderData(long id, long userId, String userName, String productNum,
			String consignee, String consigneeTel, String adress,
			String logistics, String pay) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.productNum = productNum;
		this.consignee = consignee;
		this.consigneeTel = consigneeTel;
		this.adress = adress;
		this.logistics = logistics;
		this.pay = pay;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProductNum() {
		return productNum;
	}

	public void setProductNum(String productNum) {
		this.productNum = productNum;
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

	public String getLogistics() {
		return logistics;
	}

	public void setLogistics(String logistics) {
		this.logistics = logistics;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	@Override
	public String toString() {
		return "OrderData [id=" + id + ", userId=" + userId + ", userName="
				+ userName + ", productNum=" + productNum + ", consignee="
				+ consignee + ", consigneeTel=" + consigneeTel + ", adress="
				+ adress + ", logistics=" + logistics + ", pay=" + pay + "]\n";
	}
	
	
}
