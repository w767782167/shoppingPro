package com.etcxm.daotext;

import java.util.Date;
import java.util.List;

import com.etcxm.dao.OrderDao;
import com.etcxm.dao.PrivateOrderDao;
import com.etcxm.entity.OrderData;
import com.etcxm.entity.OrderItem;
import com.etcxm.entity.User;
import com.etcxm.entity.UserDetails;

public class OrderDaoTest {
	public static void main(String[] args) throws Exception  {
		OrderDao dao=new OrderDao();
		Date date=new Date();
		/*OrderData od=new OrderData(0,0002,"jack","12021","李四","15742001","湖北省黄石市","圆通","微信");
		boolean b = dao.updateOrderData(od);
		System.out.println(b);*/
		/*OrderItem oi=new OrderItem(0L,02L,"losig","桔子","江西南丰","精装",
				50.0,2L,100.0,"包邮","什么时候发货",0,date.toString());
	*/
		/*try {
			boolean c = dao.updateOrderItem(oi);
			System.out.println(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*PrivateOrderDao dao1=new PrivateOrderDao();
		
		List<OrderItem> order = dao1.queryPrivateOrder("tom");
			System.out.println(order);*/
		List<UserDetails> user = dao.queryUser("jack",Long.valueOf(1));
		System.out.println(user);
	}
}
