package lwd.dao;

import java.util.ArrayList;
import java.util.List;


import lwd.entity.shoppingCart;
import lwd.utils.JDBCUtils;

public class OrderDao {
	private JDBCUtils util=new  JDBCUtils();
	//连接数据库
	public OrderDao(){
		util.getConnection();
	}
	
	public List<shoppingCart> queryProduct(String username) throws Exception{
		String sql = "SELECT * FROM tb_shoppingcart WHERE sign=1 AND userName=?";
		List<Object> params=new ArrayList<Object>();
		params.add(username);
		List<shoppingCart> result = util.findMoreRefResult(sql, params, shoppingCart.class);
		util.releaseConn();
		return result;
		
	}		
}
