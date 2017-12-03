package com.etcxm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.etcxm.dao.AdminUserDao;
import com.etcxm.entity.AdminUser;
import com.etcxm.utils.StringUtils;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static AdminUserDao dao= new AdminUserDao();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		
		//1.获取请求信息
		  String userName = req.getParameter("user.userName");
		  String passWord = req.getParameter("user.password");
		  String randomCode = req.getParameter("randomCode");
		//2.处理业务逻辑
		//session的验证码
		    String sessionRandomCode=(String)req.getSession().getAttribute("RANDOMCODE_IN_SESSION");
			
			/*if(!StringUtils.hasLength(randomCode)||!StringUtils.hasLength(sessionRandomCode)){
				req.setAttribute("error","亲，验证码不能为空或验证码过时");
				req.getRequestDispatcher("/houTai/login.jsp").forward(req, resp);
				return;
			}*/
			
			if(!randomCode.equals(sessionRandomCode)){
				req.setAttribute("error","亲，验证码错误，请重新输入");
				req.getRequestDispatcher("/houTai/login.jsp").forward(req, resp);
				return;
			}
			
		//3.响应
			try {
				  AdminUser user = dao.queryAdmin(userName, passWord);
				
				if(user==null){
					req.setAttribute("error", "亲，用户名或密码错误");
					req.getRequestDispatcher("/houTai/login.jsp").forward(req, resp);
					
				}else{
					req.getSession().setAttribute("USER_IN_SESSION", user);
					resp.sendRedirect("/shoppingPro/houTai/admin/main.jsp");
				}
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	}

}
