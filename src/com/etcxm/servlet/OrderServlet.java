package com.etcxm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.dao.OrderDao;
import com.etcxm.entity.Consignee;
import com.etcxm.entity.OrderCart;
import com.etcxm.entity.User;

import com.etcxm.entity.User;
import com.etcxm.entity.UserDetails;

@WebServlet("/orderServlet")
public class OrderServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");

		User user = (User)req.getSession().getAttribute("USER_IN_SESSION");
		String username = user.getUsername();
		Long userId = user.getId();


		OrderDao dao =new OrderDao();
		try {

			List<OrderCart> list = dao.queryProduct(username);


			
			List<UserDetails> user2 = dao.queryUser(username, userId);
			req.getSession().setAttribute("SESSION_IN_USERDETAILS", user2);
			

			Double sumPrice=0.0;
			for (OrderCart Cart : list) {
				//System.out.println(Cart);
				sumPrice+=Cart.getTotalPrice();
			}
			//System.out.println(sumPrice);
			//System.out.println(list);
			req.getSession().setAttribute("totalPrice", sumPrice);
			req.getSession().setAttribute("products", list);
			
			List<Consignee> adress = dao.queryAdress(username);



			//System.out.println("111111"+adress);
			req.getSession().setAttribute("SESSION_IN_ADRESS", adress);
			resp.sendRedirect("/shoppingPro/home/pay.jsp");
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//resp.sendRedirect("/test/home/pay.jsp");
	}

}
