package zxfHouTai.dao;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import zxfHouTai.entity.OrderQueryObject;


import com.etcxm.entity.Consignee;
import com.etcxm.entity.OrderData;
import com.etcxm.entity.OrderItem;

import com.etcxm.utils.JDBCUtils;

public class OrderQueryDao {
	private JDBCUtils util=new  JDBCUtils();
	//连接数据库
	public OrderQueryDao(){
		util.getConnection();
	}
	
	/**
	 * 查询订单数据
	 * @param username
	 * @return
	 * @throws Exception
	 */
	
	public List<OrderItem> queryOrderItem() throws Exception{
		String sql = "SELECT * FROM tb_orderitem ";
		List<OrderItem> result = util.findMoreRefResult(sql, null, OrderItem.class);
		util.releaseConn();
		return result;
	
	 }
	
	public boolean updateOrderStatus(String orderNum,String consigneeName,int info) throws Exception{
		String sql = "UPDATE tb_orderitem SET info=? WHERE orderNum=? AND consignee=?";
		List<Object> params=new ArrayList<Object>();
		params.add(info);
		params.add(orderNum);
		params.add(consigneeName);
		boolean b = util.updateByPreparedStatement(sql, params);
		util.releaseConn();
		return b;
		
	}	
	
	/**
	 * 高级查询      只需要一个参数对象
	 * @param op
	 * @return
	 * @throws Exception
	 */
		public List<OrderItem> advancedQuery(OrderQueryObject op) throws Exception{
			String sql="SELECT * FROM tb_orderitem "+op.getQuerySql();
			List<OrderItem> list = util.findMoreRefResult(sql, op.getParames(), OrderItem.class);
			util.releaseConn();
			return list;
		}
}
