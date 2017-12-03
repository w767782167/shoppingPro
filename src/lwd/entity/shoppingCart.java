package lwd.entity;

public class shoppingCart {
   private Long id;
   private String userName;
   private String orderNum;
   private String picture;
   private String productName;
   private String property;
   private String packing;
   private String goodsInfo;
   private Double singlePrice;
   private Long goodsNum;
   private Double totalPrice;
   private String joint;
   private Long sign;
   
   public shoppingCart() {
	  super();
	  // TODO Auto-generated constructor stub
    }

   public shoppingCart(Long id, String userName, String orderNum, String picture,
		String productName, String property, String packing, String goodsInfo,
		Double singlePrice, Long goodsNum, Double totalPrice, String joint,
		Long sign) {
	super();
	this.id = id;
	this.userName = userName;
	this.orderNum = orderNum;
	this.picture = picture;
	this.productName = productName;
	this.property = property;
	this.packing = packing;
	this.goodsInfo = goodsInfo;
	this.singlePrice = singlePrice;
	this.goodsNum = goodsNum;
	this.totalPrice = totalPrice;
	this.joint = joint;
	this.sign = sign;
   }

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
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

public String getPicture() {
	return picture;
}

public void setPicture(String picture) {
	this.picture = picture;
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

public String getGoodsInfo() {
	return goodsInfo;
}

public void setGoodsInfo(String goodsInfo) {
	this.goodsInfo = goodsInfo;
}

public Double getSinglePrice() {
	return singlePrice;
}

public void setSinglePrice(Double singlePrice) {
	this.singlePrice = singlePrice;
}

public Long getGoodsNum() {
	return goodsNum;
}

public void setGoodsNum(Long goodsNum) {
	this.goodsNum = goodsNum;
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

public Long getSign() {
	return sign;
}

public void setSign(Long sign) {
	this.sign = sign;
}

@Override
public String toString() {
	return "shoppingCart [id=" + id + ", userName=" + userName + ", orderNum="
			+ orderNum + ", picture=" + picture + ", productName="
			+ productName + ", property=" + property + ", packing=" + packing
			+ ", goodsInfo=" + goodsInfo + ", singlePrice=" + singlePrice
			+ ", goodsNum=" + goodsNum + ", totalPrice=" + totalPrice
			+ ", joint=" + joint + ", sign=" + sign + "]";
}
   
   
   
}
