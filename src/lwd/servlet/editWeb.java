package lwd.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/editWeb")
public class editWeb extends HttpServlet{

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
		String name = arg0.getParameter("name");
		String price = arg0.getParameter("price");
		String costprice = arg0.getParameter("costprice");
		String property = arg0.getParameter("property");
		String[] pro = property.split("/");
		ArrayList<String> propertyList=new ArrayList<String>(Arrays.asList(pro));
		String packing = arg0.getParameter("packing");
		String[] pack = packing.split("/");
		ArrayList<String> packingList=new ArrayList<String>(Arrays.asList(pack));
		
		String stock = arg0.getParameter("stock");
		String bigtype_id = arg0.getParameter("bigtype_id");
		String path = arg0.getParameter("path");
		String website = arg0.getParameter("website");
		String edit_website = arg0.getParameter("edit_website");
		String goodsFrom = arg0.getParameter("goodsFrom");
		String introduce = arg0.getParameter("introduce");
	/*	ArrayList<String> introduction = new ArrayList<String>();
		introduction.add(id);*/
	
	/*	introduction.add(name);
		introduction.add(price);
		introduction.add(costprice);
		introduction.add(property);
		introduction.add(packing);
		introduction.add(stock);
		introduction.add(bigtype_id);
		introduction.add(path);
		introduction.add(website);
		introduction.add(edit_website);
		introduction.add(goodsFrom);
		introduction.add(introduce);*/
		/*System.out.println(introduction.toString());
		arg0.getSession().setAttribute("introduction", introduction);
		arg0.getSession().setAttribute("name", name);*/
		arg0.getSession().setAttribute("id", id);
		arg0.getSession().setAttribute("name", name);
		arg0.getSession().setAttribute("price", price);
		arg0.getSession().setAttribute("costprice", costprice);
		arg0.getSession().setAttribute("property", propertyList);
		arg0.getSession().setAttribute("packing", packingList);
		arg0.getSession().setAttribute("stock", stock);
		arg0.getSession().setAttribute("bigtype_id", bigtype_id);
		arg0.getSession().setAttribute("path", path);
		arg0.getSession().setAttribute("website", website);
		arg0.getSession().setAttribute("edit_website", edit_website);
		arg0.getSession().setAttribute("goodsFrom", goodsFrom);
		arg0.getSession().setAttribute("introduction", introduce);
		arg1.sendRedirect("/shoppingPro/home/introduction.jsp");
		System.out.println(propertyList+"::"+packingList);
	}

}
