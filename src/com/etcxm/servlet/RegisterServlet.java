package com.etcxm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.dao.UserDao;
import com.etcxm.entity.User;
import com.etcxm.utils.StringUtils;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	/**
	 *  	
	 */
	private static final long serialVersionUID = 1L;
	private UserDao dao = new UserDao();
	private boolean flag;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		String cmd= req.getParameter("cmd");
		if(cmd!=null){
		   if(cmd.equals("email")){
			try {
				boolean flag = email_reg(req,resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
			if(cmd.equals("mob")){
				try {
					boolean flag = mob_reg(req,resp);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		   }
			
			if(flag){ //注册成功
				resp.sendRedirect("/shoppingPro/home/login.jsp");	
			
		}
		
	}
	//邮箱注册
	protected boolean email_reg(HttpServletRequest req,HttpServletResponse resp) throws Exception{
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String passwordRepeat = req.getParameter("passwordRepeat");
		System.out.println("用户名="+email+",密码="+password+",重复密码="+passwordRepeat);
		User user = dao.checkRegister(email);
		if (!StringUtils.hasLength(email)||!StringUtils.hasLength(password)) { // 不能为空
			req.setAttribute("errorMsg", "请填写完整!");
			req.getRequestDispatcher("/home/register.jsp").forward(req, resp);
			return false;
		} 
		if (user != null) { // 用户名已被使用
			req.setAttribute("errorMsg", "该用户名已存在，请重新输入!");
			req.getRequestDispatcher("/home/register.jsp").forward(req, resp);
			return false;
		} 
		if (!password.equals(passwordRepeat)) { // 重复密码不同
			req.setAttribute("errorMsg", "两次密码不一样，请重新输入!");
			req.getRequestDispatcher("/home/register.jsp").forward(req, resp);
			return false;
		} 
		// 合法，允许注册--添加至数据库
		   user = new User();
		   user.setUsername(email);
		   user.setPassword(password);
		   flag = dao.addUser(user);
		return flag;
		
	}
	//手机注册
	protected boolean mob_reg(HttpServletRequest req,HttpServletResponse resp) throws Exception{
		//获取注册手机号码
		String mobno=req.getParameter("mobno");
		System.out.println(mobno+"sadasdasd");
		//获取验证码
		String randomCode= req.getParameter("randomCode");
		String sessionrandomCode=(String)req.getSession().getAttribute("RANDOMCODE_IN_SESSION");
		
		//获取注册密码
		String pwd=req.getParameter("pwd");
		String pwdRep=req.getParameter("pwdRep");
		if(!randomCode.equals(sessionrandomCode)){
			req.setAttribute("errorMsg", "亲，验证码输入错误，请重新输入！");
			req.getRequestDispatcher("/home/register.jsp").forward(req,resp);
		}
	      User user = dao.checkByMob(mobno);
	      if(user!=null){
			req.setAttribute("errorMsg", "亲，手机号码已存在，请重新输入！");
			req.getRequestDispatcher("/home/register.jsp").forward(req,resp);
	      }
	      if (!pwd.equals(pwdRep)) { // 重复密码不同
			req.setAttribute("errorMsg", "两次密码不一样，请重新输入!");
			req.getRequestDispatcher("/home/register.jsp").forward(req, resp);
	      } 		// 合法，允许注册--添加至数据库
			if(StringUtils.hasLength(pwd)&&StringUtils.hasLength(mobno)){
				User user1=new User();
				user1.setPassword(pwd);
				user1.setTelp(mobno);
				flag = dao.addUserBymobno(user1);
			}
				return flag;
		
	}
	
}
	

