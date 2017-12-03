package com.etcxm.entity;

public class Introduction {
		private Long id;
		private String name;
		private Double price;
		private Double costprice;
		private String property;
		private String packing;
		private Long stock;
		private String path;
		private String goodsFrom;
		private String introduce;
		public Introduction() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Introduction(Long id, String name, Double price,
				Double costprice, String property, String packing, Long stock,
				String path, String goodsFrom, String introduce) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
			this.costprice = costprice;
			this.property = property;
			this.packing = packing;
			this.stock = stock;
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
			return "Introduction [id=" + id + ", name=" + name + ", price="
					+ price + ", costprice=" + costprice + ", property="
					+ property + ", packing=" + packing + ", stock=" + stock
					+ ", path=" + path + ", goodsFrom=" + goodsFrom
					+ ", introduce=" + introduce + "]";
		}
		

		
		
}
