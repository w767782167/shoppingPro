package com.etcxm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;
import com.etcxm.dao.SearchDao;
import com.etcxm.entity.Search;
import com.etcxm.page.PageResult;
@WebServlet("/showFavServlet")
public class showFav extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SearchDao dao=new SearchDao();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		  req.setCharacterEncoding("UTF-8");
		  resp.setContentType("text/json;charset=UTF-8");
		 //查询喜欢的商品(从前往后)
		  String jsonStr="";
		  try {
			//PageResult result = dao.queryPage(1, 12);
			  List<Search> result = dao.showFav();
			jsonStr = JSON.toJSONString(result);
			System.out.println(jsonStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  PrintWriter out = resp.getWriter();
		  out.print(jsonStr);
	}

}
