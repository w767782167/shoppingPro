package com.etcxm.daotext;




import java.sql.ResultSet;
import java.util.List;

import com.etcxm.dao.shoppingCartDao;


import com.etcxm.entity.cartItem;
import com.etcxm.entity.goods;


public class shoppingCartText {
public static void main(String[] args) throws Exception {
	shoppingCartDao dao = new shoppingCartDao();
	/*List<cartItem> list = dao.queryAllCarts();
	System.out.println(list);*/
	
	
	/*goods goods = dao.queryGoodsById(1L);
	System.out.println(goods);
	Long price = 100L;
	String joint =price>200?"包邮":"邮费10元";
	System.out.println(joint);*/
	
	
	/*cartItem catrItem = new cartItem(null,"rose","1196074670468","/klsdfs",
    		"坚果","盐焗","两袋装","小册子",34.3,3L,43.2,"包邮",1L);
	boolean b = dao.addToShopCart(catrItem);
	System.out.println(b);*/
	
	/*Double totalPrice = dao.getTotalPrice();
	System.out.println(totalPrice);*/

	
	/*List<cartItem> shopCart = dao.queryCartsByName("jack");
	System.out.println(shopCart);*/
	
	
	
	/*Long cartNumByName = dao.getCartNumByName("jack");
	
	System.out.println(cartNumByName);*/
	
/*	boolean updateSign = dao.updateSign(false, "jack");
	System.out.println(updateSign);*/
	
	
	/*Long sign = dao.getCartNumBySign("jack");
	System.out.println(sign);*/
	
	/*Double totalPriceBySign = dao.getTotalPriceBySign("jack");
	System.out.println(totalPriceBySign);*/
	
/*	boolean b = dao.changGoodsNum(true, 1L);*/
	
	Double totalPriceById = dao.getTotalPriceById(1L);
	System.out.println(totalPriceById);
	
}
}