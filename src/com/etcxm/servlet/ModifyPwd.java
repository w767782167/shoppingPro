package com.etcxm.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.dao.AdminUserDao;
import com.etcxm.utils.StringUtils;
@WebServlet("/modifyPwd")
public class ModifyPwd extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AdminUserDao dao=new AdminUserDao();
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			req.setCharacterEncoding("UTF-8");
			String pwd=req.getParameter("pwd");
			String admin = req.getParameter("admin");
			
			boolean flag=false;
			try {
				flag = dao.updateAdminPwd(pwd, admin);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(flag){
				resp.sendRedirect("/shoppingPro/houTai/login.jsp");
			}
			
			//退出系统
			String cmd = req.getParameter("cmd");
			if(StringUtils.hasLength(cmd)){
			if(cmd.equals("exit")){
				//注销session
				req.getSession().invalidate();
				//反回home页面
				resp.sendRedirect("/shoppingPro/addAllGoods");
			}
		}
		}
}
