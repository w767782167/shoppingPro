package com.etcxm.dao;

import java.util.ArrayList;
import java.util.List;


import com.etcxm.entity.Consignee;
import com.etcxm.entity.OrderCart;
import com.etcxm.entity.OrderData;
import com.etcxm.entity.OrderItem;
import com.etcxm.entity.User;
import com.etcxm.entity.UserDetails;

import com.etcxm.utils.JDBCUtils;

public class OrderDao {
	private JDBCUtils util=new  JDBCUtils();
	//连接数据库
	public OrderDao(){
		util.getConnection();
	}
	/**
	 * 查询用户个人详细信息
	 * @param username
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<UserDetails> queryUser(String username,Long userId) throws Exception{
		String sql="SELECT * FROM tb_member WHERE username=? AND id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(username);
		params.add(userId);
		List<UserDetails> user = util.findMoreRefResult(sql, params, UserDetails.class);
		util.releaseConn();
		return user;
	}
	
	/**
	 * 查询购物车结算物品
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public List<OrderCart> queryProduct(String username) throws Exception{
		String sql = "SELECT * FROM tb_shoppingcart WHERE sign=1 AND userName=?";
		List<Object> params=new ArrayList<Object>();
		params.add(username);
		List<OrderCart> result = util.findMoreRefResult(sql, params, OrderCart.class);
		util.releaseConn();
		return result;
		
	}	
	/**
	 * 提交订单后删除购物车结算的商品
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public boolean deleteProduct(String username) throws Exception{
		String sql = "DELETE FROM tb_shoppingcart WHERE sign=1 AND userName=?";
		List<Object> params=new ArrayList<Object>();
		params.add(username);
		boolean b = util.updateByPreparedStatement(sql, params);
		util.releaseConn();
		return b;
		
	}	
	
	
	/**
	 * 查询个人收货地址
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public List<Consignee> queryAdress(String username) throws Exception{
		String sql = "SELECT * FROM tb_shopingaddress WHERE userName=?";
		List<Object> params=new ArrayList<Object>();
		params.add(username);
		List<Consignee> result = util.findMoreRefResult(sql, params, Consignee.class);
		util.releaseConn();
		return result;
		
	}		
	/**
	 * 添加收货地址到数据库
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public boolean updateAdress(Consignee con) throws Exception{
		String sql = "INSERT INTO tb_shopingaddress VALUES(null,?,?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(con.getUserName());
		params.add(con.getConsignee());
		params.add(con.getConsigneeTel());
		params.add(con.getAdress());
		params.add(con.getCompleteAdress());
		boolean b = util.updateByPreparedStatement(sql, params);
		util.releaseConn();
		return b;
		
	}	
	/**
	 * 删除订单界面添加的地址
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean deleteAdress(Long id) throws Exception{
		String sql = "DELETE FROM tb_shopingaddress WHERE id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		boolean c = util.updateByPreparedStatement(sql, params);
		util.releaseConn();
		return c;
		
	}	
	/**
	 * 插入数据到订单表
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public boolean updateOrderData(OrderData od) throws Exception{
		String sql = "INSERT INTO tb_orderdata VALUES(null,?,?,?,?,?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(od.getUserId());
		params.add(od.getUserName());
		params.add(od.getProductNum());
		params.add(od.getConsignee());
		params.add(od.getConsigneeTel());
		params.add(od.getAdress());
		params.add(od.getLogistics());
		params.add(od.getPay());
		
		boolean d = util.updateByPreparedStatement(sql, params);
		util.releaseConn();
		return d;
		
	}
	
	/**
	 * 插入数据到订单详情表
	 * @param oi
	 * @return
	 * @throws Exception
	 */
	public boolean updateOrderItem(OrderItem oi) throws Exception{
		String sql = "INSERT INTO tb_orderitem VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(oi.getUserId());
		params.add(oi.getUserName());
		params.add(oi.getOrderNum());
		params.add(oi.getConsignee());
		params.add(oi.getConsigneeTel());
		params.add(oi.getAdress());
		params.add(oi.getLogistics());
		params.add(oi.getPay());
		
		params.add(oi.getProductImg());
		params.add(oi.getProductName());
		params.add(oi.getProperty());
		params.add(oi.getPacking());
		params.add(oi.getPrice());
		params.add(oi.getNumber());
		params.add(oi.getTotalPrice());
		params.add(oi.getJoint());
		params.add(oi.getMessage());
		params.add(oi.getInfo());
		params.add(oi.getOrderDate());
		
		boolean  e= util.updateByPreparedStatement(sql, params);
		util.releaseConn();
		return e;
		
	}
}
