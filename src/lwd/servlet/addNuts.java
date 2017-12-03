package lwd.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lwd.dao.dao;
import lwd.entity.goods;
@WebServlet("/addNuts")
public class addNuts  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(arg0, arg1);
		//String parameter = arg0.getParameter("");
		arg0.setCharacterEncoding("UTF-8");
		dao dao = new dao();
		try {
			 List<goods> list = dao.addNuts();
//			 arg0.setAttribute("list", list);
			 arg0.getSession().setAttribute("list3", list);
			System.out.println(list);
			//注销adminsession
			arg0.getSession().removeAttribute("USER_IN_SESSION");
			//然后跳转到home.jsp
			arg1.sendRedirect("/shoppingPro/home/home.jsp");
//			arg0.getRequestDispatcher("").forward(arg0, arg1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
