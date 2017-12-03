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
import com.etcxm.entity.OrderItem;
import com.etcxm.entity.User;

@WebServlet("/paysuccess")
public class PaySuccessServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  static OrderDao dao=new OrderDao();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		User user = (User)req.getSession().getAttribute("USER_IN_SESSION");
		String username = user.getUsername();
		Long userId = user.getId();
		
		 String status =(String) req.getSession().getAttribute("SESSION_IN_STATUS");
		
		String logis =(String) req.getSession().getAttribute("SESSION_IN_LOGIS");
		String bank =(String) req.getSession().getAttribute("SESSION_IN_BANK");
		String Msg =(String) req.getSession().getAttribute("SESSION_IN_MSG");
		String totalPrice =(String) req.getSession().getAttribute("SESSION_IN_TOTALPRICE");
		String newname =(String) req.getSession().getAttribute("SESSION_IN_SIGNAME");
		String newtel =(String) req.getSession().getAttribute("SESSION_IN_TEL");
		String adress =(String) req.getSession().getAttribute("SESSION_IN_ADRESS1");
		
		if("1".equals(status)){
			
			try {
				Date date=new Date();
				
				boolean item1=false;
				List<OrderCart> list = dao.queryProduct("jack");
				for (int i = 0; i < list.size(); i++) {
					OrderCart cart=(OrderCart)list.get(i);
					//System.out.println(cart);
					OrderItem oi=new OrderItem(0,userId,username,cart.getOrderNum(),newname,newtel,adress,logis,bank,cart.getPicture(),cart.getProductName(),cart.getProperty(),cart.getPacking(),
							cart.getSinglePrice(),cart.getGoodsNum(),cart.getTotalPrice(),cart.getJoint(),Msg,0,date.toLocaleString());
					 item1 = dao.updateOrderItem(oi);
				}
				boolean bp=false;
				if(item1){
					bp = dao.deleteProduct(username);
				}
				
				if(bp){
				
					//销毁orderServlet创建的session
					req.getSession().removeAttribute("totalPrice");
					req.getSession().removeAttribute("products");
					req.getSession().removeAttribute("SESSION_IN_ADRESS");
					
					resp.sendRedirect("/shoppingPro/home/success.jsp");
					
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			
			try {
				Date date=new Date();
				
				boolean item1=false;
				List<OrderCart> list = dao.queryProduct(username);
				for (int i = 0; i < list.size(); i++) {
					OrderCart cart=(OrderCart)list.get(i);
					//System.out.println(cart);
					OrderItem oi=new OrderItem(0,userId,username,cart.getOrderNum(),newname,newtel,adress,logis,bank,cart.getPicture(),cart.getProductName(),cart.getProperty(),cart.getPacking(),
							cart.getSinglePrice(),cart.getGoodsNum(),cart.getTotalPrice(),cart.getJoint(),Msg,2,date.toLocaleString());
					 item1 = dao.updateOrderItem(oi);
				}
				boolean bp=false;
				if(item1){
					bp = dao.deleteProduct(username);
				}
				
				if(bp){
				
					//销毁orderServlet创建的session
					req.getSession().removeAttribute("totalPrice");
					req.getSession().removeAttribute("products");
					req.getSession().removeAttribute("SESSION_IN_ADRESS");
					
					resp.sendRedirect("/shoppingPro/home/defeat.jsp");
					
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("支付失败");
		}
		
		
	}

}
