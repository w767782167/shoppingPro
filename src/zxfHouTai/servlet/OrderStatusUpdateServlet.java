package zxfHouTai.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zxfHouTai.dao.OrderQueryDao;

@WebServlet("/statusupdate1")
public class OrderStatusUpdateServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static OrderQueryDao dao=new OrderQueryDao();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		
		String orderNum = req.getParameter("orderNum").trim();
		String consigneeName = req.getParameter("consigneeName").trim();
		String info = req.getParameter("info").trim();
		//System.out.println(orderNum+","+consigneeName+","+info);
		
		try {
			boolean b = dao.updateOrderStatus(orderNum.trim(), consigneeName.trim(), Integer.valueOf(info));
			System.out.println(b);
			if(b){
				resp.sendRedirect("/shoppingPro/orderstatus");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
