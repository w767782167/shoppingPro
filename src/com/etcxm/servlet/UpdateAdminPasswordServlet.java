package com.etcxm.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.dao.AdminUserDao;

@WebServlet("/updatePassword")
public class UpdateAdminPasswordServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static AdminUserDao dao=new AdminUserDao();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		String newPassword = req.getParameter("password2");
		String username = req.getParameter("username");
		//System.out.println(username+"------"+newPassword);
		
		try {
			boolean b = dao.updatePassword(username,newPassword);
			if(b){
				req.setAttribute("Msg", "修改密码成功,下次登录有效");
			}else{
				req.setAttribute("Msg", "修改密码失败");
			}
			req.getRequestDispatcher("/houTai/updatePassword/UpdateAdminPassword.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
