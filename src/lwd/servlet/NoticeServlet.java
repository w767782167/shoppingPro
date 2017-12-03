package lwd.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lwd.dao.NoticeDao;
@WebServlet("/addnotice")
public class NoticeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NoticeDao dao=new NoticeDao();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		//获取公告名称
		String title = req.getParameter("noticetitle");
		String content=req.getParameter("noticecontent");
		boolean flag=false;
		try {
			 flag = dao.addNotice(title, content);
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag){
			resp.sendRedirect("/shoppingPro/houTai/admin/showNotice.jsp");
		}
	}

}
