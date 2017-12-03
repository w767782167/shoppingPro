package zxfHouTai.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.entity.OrderItem;

import zxfHouTai.dao.OrderQueryDao;

@WebServlet("/orderstatus")
public class OderStatusServlet extends HttpServlet{

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
		
		try {
			List<OrderItem> list = dao.queryOrderItem();
			req.setAttribute("orderItem1", list);
			req.getRequestDispatcher("/houTai/admin/orderStatus.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
