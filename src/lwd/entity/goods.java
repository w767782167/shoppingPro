package lwd.entity;

import java.io.Serializable;
import java.util.Date;

public class goods implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private Double price;
	private Double costprice;
	private String property;
	private String packing;
	private Long stock;
	private Long bigtype_id;
	private String path;
	private String website;
	private String edit_website;
	private String goodsFrom;
	private String introduce;
	private Date createTime;
	public goods(Long id, String name, Double price, Double costprice,
			String property, String packing, Long stock, Long bigtype_id,
			String path, String website, String edit_website, String goodsFrom,
			String introduce, Date createTime) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.costprice = costprice;
		this.property = property;
		this.packing = packing;
		this.stock = stock;
		this.bigtype_id = bigtype_id;
		this.path = path;
		this.website = website;
		this.edit_website = edit_website;
		this.goodsFrom = goodsFrom;
		this.introduce = introduce;
		this.createTime = createTime;
	}
	public goods(Long id, String name, Double price, Double costprice,
			String property, String packing, Long stock, Long bigtype_id,
			String path, String website, String edit_website, String goodsFrom,
			String introduce) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.costprice = costprice;
		this.property = property;
		this.packing = packing;
		this.stock = stock;
		this.bigtype_id = bigtype_id;
		this.path = path;
		this.website = website;
		this.edit_website = edit_website;
		this.goodsFrom = goodsFrom;
		this.introduce = introduce;
	
	}
	public goods() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getCostprice() {
		return costprice;
	}
	public void setCostprice(Double costprice) {
		this.costprice = costprice;
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
	public Long getStock() {
		return stock;
	}
	public void setStock(Long stock) {
		this.stock = stock;
	}
	public Long getBigtype_id() {
		return bigtype_id;
	}
	public void setBigtype_id(Long bigtype_id) {
		this.bigtype_id = bigtype_id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getEdit_website() {
		return edit_website;
	}
	public void setEdit_website(String edit_website) {
		this.edit_website = edit_website;
	}
	public String getGoodsFrom() {
		return goodsFrom;
	}
	public void setGoodsFrom(String goodsFrom) {
		this.goodsFrom = goodsFrom;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "goods [id=" + id + ", name=" + name + ", price=" + price
				+ ", costprice=" + costprice + ", property=" + property
				+ ", packing=" + packing + ", stock=" + stock + ", bigtype_id="
				+ bigtype_id + ", path=" + path + ", website=" + website
				+ ", edit_website=" + edit_website + ", goodsFrom=" + goodsFrom
				+ ", introduce=" + introduce + ", createTime=" + createTime
				+ "]";
	}

	

}
