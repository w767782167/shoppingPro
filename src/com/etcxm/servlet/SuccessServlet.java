
package com.etcxm.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.dao.OrderDao;
import com.etcxm.entity.OrderCart;
import com.etcxm.entity.OrderData;
import com.etcxm.entity.OrderItem;

@WebServlet("/success")
public class SuccessServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		String logis = req.getParameter("logis");
		String bank = req.getParameter("bank");
		String Msg = req.getParameter("Msg");
		String totalPrice = req.getParameter("totalPrice");
		String newAdress1 = req.getParameter("newAdress1");
		String newAdress2 = req.getParameter("newAdress2");
		String newname = req.getParameter("newname");
		String newtel = req.getParameter("newtel");
		//String overAdress=newAdress1+newAdress2;
		
	      long orderNum=System.currentTimeMillis();
	      req.getSession().setAttribute("SESSION_IN_ORDERNUM", orderNum);

		   //创建success界面的session
		   req.getSession().setAttribute("SESSION_IN_LOGIS", logis);
		   req.getSession().setAttribute("SESSION_IN_BANK", bank);
		   req.getSession().setAttribute("SESSION_IN_MSG", Msg);
		   req.getSession().setAttribute("SESSION_IN_TOTALPRICE", totalPrice);
		   req.getSession().setAttribute("SESSION_IN_SIGNAME", newname);
		   req.getSession().setAttribute("SESSION_IN_TEL", newtel);
		   req.getSession().setAttribute("SESSION_IN_ADRESS1", newAdress1+newAdress2);
		//System.out.println(logis+","+bank+","+Msg+","+totalPrice+","+newAdress1+","+newAdress2+","+newname+","+newtel);
		
		/*	User user = (User)req.getSession().getAttribute("USER_IN_SESSION");
		String username = user.getUsername();
		Long userId = user.getId();*/
		resp.sendRedirect("/shoppingPro/payMoney/payMoney.jsp");
		
		
		
		
		
		
		
		
		//req.getRequestDispatcher("/home/success.jsp").forward(req, resp);
	}

}
