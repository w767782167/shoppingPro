package com.etcxm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.dao.UserDao;
import com.etcxm.dao.shoppingCartDao;
import com.etcxm.entity.User;
import com.etcxm.utils.StringUtils;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDao dao = new UserDao();
	private shoppingCartDao cartDao = new shoppingCartDao();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		try {
			User user = dao.checkLogin(username, password);
			if(user==null){
				req.setAttribute("errorMsg", "亲，用户名或密码错误");
				req.getRequestDispatcher("/home/login.jsp").forward(req, resp);
				return;
			}
			req.getSession().setAttribute("USER_IN_SESSION", user);
			Long cartNumByName = cartDao.getCartNumByName(username);
			System.out.println(cartNumByName);
			System.out.println(123);
			req.getSession().setAttribute("CARTNUM_IN_SESSION", cartNumByName);
			resp.sendRedirect("/shoppingPro/home/home.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
