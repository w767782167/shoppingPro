package zxfHouTai.daotest;

import java.sql.ResultSet;
import java.util.List;

import com.etcxm.entity.OrderData;
import com.etcxm.entity.OrderItem;

import zxfHouTai.dao.OrderQueryDao;

public class OrderQueryTest {
	public static void main(String[] args) throws Exception {
		OrderQueryDao dao=new OrderQueryDao();
		List<OrderItem> list = dao.queryOrderItem();
		System.out.println(list);
		
	}
}
