package com.etcxm.entity;

public class OrderItem {
	private long id;
	private long userId;
	private String userName;
	private String orderNum;
	private String consignee;
	private String consigneeTel;
	private String adress;
	private String logistics;
	private String pay;
	private String productImg;
	private String productName;
	private String property;
	private String packing;
	private Double price;
	private long number;
	private Double totalPrice;
	private String  joint;
	private String message;
	private int info;
	private String orderDate;
	
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItem(long id, long userId, String userName, String orderNum,
			String consignee, String consigneeTel, String adress,
			String logistics, String pay, String productImg,
			String productName, String property, String packing, Double price,
			long number, Double totalPrice, String joint, String message,
			int info, String orderDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.orderNum = orderNum;
		this.consignee = consignee;
		this.consigneeTel = consigneeTel;
		this.adress = adress;
		this.logistics = logistics;
		this.pay = pay;
		this.productImg = productImg;
		this.productName = productName;
		this.property = property;
		this.packing = packing;
		this.price = price;
		this.number = number;
		this.totalPrice = totalPrice;
		this.joint = joint;
		this.message = message;
		this.info = info;
		this.orderDate = orderDate;
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

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
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

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getPacking() {
		return packing;
	}

	public void setPacking(String packing) {
		this.packing = packing;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getJoint() {
		return joint;
	}

	public void setJoint(String joint) {
		this.joint = joint;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", userId=" + userId + ", userName="
				+ userName + ", orderNum=" + orderNum + ", consignee="
				+ consignee + ", consigneeTel=" + consigneeTel + ", adress="
				+ adress + ", logistics=" + logistics + ", pay=" + pay
				+ ", productImg=" + productImg + ", productName=" + productName
				+ ", property=" + property + ", packing=" + packing
				+ ", price=" + price + ", number=" + number + ", totalPrice="
				+ totalPrice + ", joint=" + joint + ", message=" + message
				+ ", info=" + info + ", orderDate=" + orderDate + "]\n";
	}
	
	
	
	
}
