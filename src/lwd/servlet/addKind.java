package lwd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lwd.dao.ProductDirDao;
import lwd.entity.kind;
import lwd.utils.StringUtils;

@WebServlet("/addKind")
public class addKind extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.service(arg0, arg1);
		arg1.setContentType("text/html; charset=UTF-8");
		ProductDirDao dao = new ProductDirDao();
		String token = arg0.getParameter("token");
		String kindname = arg0.getParameter("kindname");
		System.out.println(token+"1");
		System.out.println(kindname+"2");
		kind kind = new kind(null, kindname);
		String sessiontoken = (String) arg0.getSession().getAttribute(
				"TOKEN_IN_SESSION");
		System.out.println(sessiontoken+"3");
		
		if (StringUtils.hasLength(token)) {
			if (token.equals(sessiontoken)) {
				System.out.println("一样");
				arg0.getSession().removeAttribute("TOKEN_IN_SESSION");
				System.out.println("一样");
			} else {
				PrintWriter w = arg1.getWriter();
				System.out.println("shoujian");
				System.out.println("不一样");
				//w.print("<script>alert('请勿重复提交');</script>");
				arg0.setAttribute("re1", "请勿重复提交,如要重新添加商品请于添加页面按'F5'刷新再添加");
				arg0.getRequestDispatcher("/tiaozhuan").forward(arg0,
						arg1);
				return;
				//req.getRequestDispatcher("/upload").forward(req, resp);
				
				
			}
		}

		try {
			

		
			boolean f = dao.addKind(kind);
			System.out.println("成功");
			arg0.setAttribute("success", "添加成功");
			arg0.getRequestDispatcher("/tiaozhuan").forward(arg0,
					arg1);

		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
