package com.etcxm.entity;
public class Search {
	private Long id;
	private String name;
	private Double price;
	private Double costprice;
	private String path;
	private String goodsFrom;
	private String introduce;
	public Search() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Search(String name, String goodsFrom) {
		super();
		this.name = name;
		this.goodsFrom = goodsFrom;
	}

	public Search(Long id, String name, Double price, Double costprice,
			String path, String goodsFrom, String introduce) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.costprice = costprice;
		this.path = path;
		this.goodsFrom = goodsFrom;
		this.introduce = introduce;
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
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
	@Override
	public String toString() {
		return "Search [id=" + id + ", name=" + name + ", price=" + price
				+ ", costprice=" + costprice + ", path=" + path
				+ ", goodsFrom=" + goodsFrom + ", introduce=" + introduce + "]\n";
	}
	

}
