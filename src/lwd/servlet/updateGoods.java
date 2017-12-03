package lwd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lwd.dao.dao;
import lwd.entity.goods;
@WebServlet("/updateGoods")
public class updateGoods extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(arg0, arg1);
		String id = arg0.getParameter("id");
		dao dao = new dao();
		try {
			goods empleGoods = dao.queryEmple(Long.valueOf(id));
			arg0.setAttribute("empleGoods", empleGoods);
			arg0.getRequestDispatcher("/update.jsp").forward(arg0, arg1);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
