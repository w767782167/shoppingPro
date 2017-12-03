package com.etcxm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.etcxm.entity.cartItem;
import com.etcxm.entity.goods;
import com.etcxm.entity.shoppingCart;

import com.etcxm.utils.JDBCUtils;

public class shoppingCartDao {
	// 创建一个JDBC
	private JDBCUtils util = new JDBCUtils();

	public shoppingCartDao() {
		util.getConnection();
	}

	// 获取所有的购物车信息
	public List<cartItem> queryAllCarts() {
		String sql = "select * from tb_shoppingCart";

		List<cartItem> list;
		try {
			list = util.findMoreRefResult(sql, null,
					cartItem.class);
			util.releaseConn();
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		

	}
	// 通过名字获取购物车信息
		public List<cartItem> queryCartsByName(String userName) {
			String sql = "select * from tb_shoppingCart where userName=?";
			List<Object> params = new ArrayList<Object>();
			params.add(userName);
			List<cartItem> list;
			try {
				list = util.findMoreRefResult(sql, params,
						cartItem.class);
				util.releaseConn();
				return list;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			

		}
	
	//通过Id获取商品信息
	public goods queryGoodsById(Long id){
		String sql = "select * from tb_goods where id=?";
	    List<Object> params = new ArrayList<Object>();
		params.add(id);
		
		try {
		goods goods = util.findSimpleRefResult(sql, params, goods.class);
			util.releaseConn();
			return goods;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	//将购物车对象加入购物车
	public boolean addToShopCart(cartItem cartItem){
		String sql = "insert tb_shoppingCart(userName,orderNum,picture,productName,property,packing,goodsInfo,singlePrice,goodsNum,totalPrice,joint,sign)" +
				" values(?,?,?,?,?,?,?,?,?,?,?,?)";
		 List<Object> params = new ArrayList<Object>();
		 params.add(cartItem.getUserName());
		 params.add(cartItem.getOrderNum());
		 params.add(cartItem.getPicture());
		 params.add(cartItem.getProductName());
		 params.add(cartItem.getProperty());
		 params.add(cartItem.getPacking());
		 params.add(cartItem.getGoodsInfo());
		 params.add(cartItem.getSinglePrice());
		 params.add(cartItem.getGoodsNum());
		 params.add(cartItem.getTotalPrice());
		 params.add(cartItem.getJoint());
		 params.add(cartItem.getSign());
		try {
			boolean flag = util.updateByPreparedStatement(sql, params);
			return flag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	//通过id删除购物车
	public boolean deleteCartItemById(Long id){
		String sql = "delete from tb_shoppingCart where id=?";
		 List<Object> params = new ArrayList<Object>();
		 params.add(id);
		try {
			boolean flag = util.updateByPreparedStatement(sql, params);
			return flag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}
	//查找被选中的的总价
	public Double getTotalPrice(){
		String sql = "select SUM(totalPrice) FROM tb_shoppingcart where sign=1";
		
		ResultSet resultSet = util.query(sql, null);
		Double totalPrice =0.0;
		try {
			if(resultSet.next()){
				totalPrice = resultSet.getDouble(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		util.releaseConn();
		return totalPrice;
	}
	//通过名字查找购物车商品数量
	public Long getCartNumByName(String userName){
		String sql = "select * FROM tb_shoppingcart where userName=?";
		List<Object> params = new ArrayList<Object>();
		params.add(userName);
		try {
			List<cartItem> list = util.findMoreRefResult(sql, params, cartItem.class);
			return (long) list.size();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	//将购物车的sign修改
	public boolean updateSign(boolean checkBox,String userName){
		String sql = "";
		if(checkBox){
			 sql = "update tb_shoppingcart set sign=1 where sign=0 and userName= ?;";
		}else{
			 sql = "update tb_shoppingcart set sign=0 where sign=1 and userName= ?;";
		}
		List<Object> params = new ArrayList<Object>();
		params.add(userName);
		
		try {
			boolean flag = util.updateByPreparedStatement(sql, params);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//修改单个的购物车
		public boolean updateSingleSign(boolean checkBox,String userName,Long id){
			String sql = "";
			if(checkBox){
				 sql = "update tb_shoppingcart set sign=1 where sign=0 and userName= ? and id=?";
			}else{
				 sql = "update tb_shoppingcart set sign=0 where sign=1 and userName= ? and id=?";
			}
			List<Object> params = new ArrayList<Object>();
			params.add(userName);
			params.add(id);
			
			try {
				boolean flag = util.updateByPreparedStatement(sql, params);
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		//获取sign=1的数量
		public Long getCartNumBySign(String userName){
			String sql = "select * FROM tb_shoppingcart where userName=? and sign = 1";
			List<Object> params = new ArrayList<Object>();
			params.add(userName);
			
			try {
				List<cartItem> list = util.findMoreRefResult(sql, params, cartItem.class);
				return (long) list.size();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
		}
		//查询选中的价格
		public Double getTotalPriceBySign(String userName){
			String sql = "select SUM(totalPrice) FROM tb_shoppingcart where sign=1 and userName = ?";
			ResultSet resultSet = util.query(sql, userName);
			Double totalPrice =0.0;
			try {
				if(resultSet.next()){
					totalPrice = resultSet.getDouble(1);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			util.releaseConn();
			return totalPrice;
		}
		//改变商品的数量
		public boolean changGoodsNum(boolean a,Long id){
			String sql = "";
			if(a){
				 sql = "update tb_shoppingcart set goodsNum=goodsNum-1,totalPrice=singlePrice*goodsNum where id=?";
			}else{
				 sql = "update tb_shoppingcart set goodsNum=goodsNum+1,totalPrice=singlePrice*goodsNum where id=?";
			}
			List<Object> params = new ArrayList<Object>();
			params.add(id);
			try {
				boolean flag = util.updateByPreparedStatement(sql, params);
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		//通过ID获取总价
		public Double getTotalPriceById(Long id){
			String sql = "select totalPrice FROM tb_shoppingcart where id=?";
			ResultSet resultSet = util.query(sql, id);
			Double totalPrice =0.0;
			try {
				if(resultSet.next()){
					totalPrice = resultSet.getDouble(1);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			util.releaseConn();
			return totalPrice;
		} 
		


	
}
