package com.etcxm.dao;

import java.util.ArrayList;
import java.util.List;

import com.etcxm.entity.OrderCart;
import com.etcxm.entity.OrderItem;
import com.etcxm.utils.JDBCUtils;

public class PrivateOrderDao {
	private JDBCUtils util=new  JDBCUtils();
	//连接数据库
	public PrivateOrderDao(){
		util.getConnection();
	}
	
	/**
	 * 查询个人订单
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public List<OrderItem> queryPrivateOrder(String username) throws Exception{
		String sql = "SELECT * FROM tb_orderitem WHERE userName=?";
		List<Object> params=new ArrayList<Object>();
		params.add(username);
		List<OrderItem> result = util.findMoreRefResult(sql, params, OrderItem.class);
		util.releaseConn();
		return result;
		
	}	
	
	
}
