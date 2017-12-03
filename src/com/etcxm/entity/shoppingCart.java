package com.etcxm.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class shoppingCart {
     private List<cartItem> items = new ArrayList<cartItem>();
     private Double totalPrice = 0.0;
     
  // 购物车添加商品
 	public void save(cartItem item) {

 		// 如果商品已经存在，只要修改数量就可以
 		for (cartItem item1 : items) {
 			// Long object
 			if (item.getId().equals(item1.getId())) {
 				item1.setGoodsNum(item1.getGoodsNum() + item.getGoodsNum());
 				return;
 			}
 		}
 		items.add(item);
 	}

 	//删除商品
 	public void delete(Long id) {
         Iterator<cartItem> iterator = items.iterator();
         while (iterator.hasNext()) {
 		    cartItem cartItem = iterator.next();
 			if(cartItem.getId().equals(id)){
 				iterator.remove();
 			}
 		}
 	}
 	
 	
 	//购物车结算总价格
 	public Double getTotalPrice(){
 	    totalPrice = 0.0;
 	    for (cartItem item : items) {
 			totalPrice += item.getTotalPrice();
 	    }
 		return totalPrice;
 	}

	public List<cartItem> getItems() {
		return items;
	}

	public void setItems(List<cartItem> items) {
		this.items = items;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "shoppingCart [items=" + items + ", totalPrice=" + totalPrice
				+ "]";
	}

	public shoppingCart(List<cartItem> items, Double totalPrice) {
		super();
		this.items = items;
		this.totalPrice = totalPrice;
	}

	public shoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}


}
