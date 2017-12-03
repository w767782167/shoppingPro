package com.etcxm.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.dao.PrivateOrderDao;
import com.etcxm.entity.OrderItem;



@WebServlet("/privateorder")
public class PrivateOrderManageServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static PrivateOrderDao dao=new PrivateOrderDao();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		//System.out.println("使用了该servlet=======---------------");
		try {
			List<OrderItem> orderlist0=new ArrayList();
			List<OrderItem> orderlist1=new ArrayList();
			List<OrderItem> orderlist2=new ArrayList();
			List<OrderItem> order = dao.queryPrivateOrder("jack");
			for (OrderItem orderItem : order) {
				if(orderItem.getInfo()==0){
					orderlist0.add(orderItem);
				}
				if(orderItem.getInfo()==1){
					orderlist1.add(orderItem);
				}
				if(orderItem.getInfo()==2){
					orderlist2.add(orderItem);
				}
				
			}
			/*System.out.println(list);
			System.out.println("---------------------------");
			System.out.println(list1);
			System.out.println("---------------------------");
			System.out.println(list2);*/
			req.getSession().setAttribute("privateOrder", order);
			req.getSession().setAttribute("orderlist0", orderlist0);
			req.getSession().setAttribute("orderlist1", orderlist1);
			req.getSession().setAttribute("orderlist2", orderlist2);
			//req.setAttribute("privateOrder", order);
			resp.sendRedirect("/shoppingPro/person/order.jsp");
			//req.getRequestDispatcher("/person/order.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
