package lwd.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lwd.dao.ProductDirDao;
import lwd.entity.goods;
import lwd.entity.kind;
@WebServlet("/tiaozhuan")
public class kindServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(arg0, arg1);
		kind kind = new kind();
		ProductDirDao dirDao = new ProductDirDao();
		
		try {
			List<lwd.entity.kind> productDirs = dirDao.queryAllproductDirs();
			arg0.setAttribute("productDirs",productDirs );
			arg0.getRequestDispatcher("/add.jsp").forward(arg0, arg1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
