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
import com.etcxm.entity.User;
import com.etcxm.utils.StringUtils;

@WebServlet("/adress")
public class AdressServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static OrderDao dao=new OrderDao();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		String consignee = req.getParameter("consignee");
		String consigneeTel = req.getParameter("consigneeTel");
		String province = req.getParameter("province");
		String city = req.getParameter("city");
		String district = req.getParameter("district");
		String completeAdress = req.getParameter("completeAdress");
		System.out.println(consignee+","+consigneeTel+","+province+","+city+","+district+","+completeAdress);
		String Adressid = req.getParameter("Adressid");
		
		User user = (User)req.getSession().getAttribute("USER_IN_SESSION");
		String username = user.getUsername();
		Long userId = user.getId();
		
		try {
			
			if(StringUtils.hasLength(consignee)||StringUtils.hasLength(consigneeTel)){
				Consignee con=new Consignee(0,username,consignee,consigneeTel,province+city+district,completeAdress);
				boolean b = dao.updateAdress(con);
				if(b){
					//System.out.println("----------------ggggggg");
					resp.sendRedirect("/shoppingPro/orderServlet");
				}
			}
		
			
			if(StringUtils.hasLength(Adressid)){

				boolean c = dao.deleteAdress(Long.valueOf(Adressid));
				resp.sendRedirect("/shoppingPro/orderServlet");
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
