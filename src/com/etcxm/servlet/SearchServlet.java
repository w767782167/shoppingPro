package com.etcxm.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.dao.SearchDao;
import com.etcxm.entity.Search;
import com.etcxm.entity.SearchgFromInfo;
import com.etcxm.page.PageResult;
import com.etcxm.utils.StringUtils;
@WebServlet("/search")
public class SearchServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SearchDao dao=new SearchDao();
	 ArrayList<Object> list;
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			//获取搜索框传过来的参数
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html;charset=UTF-8");

			String gFrom = req.getParameter("gFrom");
			System.out.println("获得gFrom的值："+gFrom);
			//取出商品品牌放到作用域中
			req.setAttribute("gbrank",gFrom);
			
			
			try {
				List<SearchgFromInfo> goodsInfo = dao.showGfromInfo(gFrom);
				 req.setAttribute("goodsInfo",goodsInfo);
					System.out.println(goodsInfo);
				list = dao.showGoodsFrom();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			  req.setAttribute("GoodsFrom",list);
			
				System.out.println(list);
			
			
			
			
			//获得搜素框内容

			String searchGoods = req.getParameter("index_none_header_sysc");
		    String currentPageStr = req.getParameter("currentPage");
			Integer currentPage=1;
			if(StringUtils.hasLength(currentPageStr)){
			currentPage = Integer.valueOf(currentPageStr);
			
			}else{
				currentPage=1;
			}
			System.out.println("输入框的值 是:"+searchGoods);
			
		
			
			if(StringUtils.hasLength(searchGoods)){

				Search searchs=new Search(searchGoods,searchGoods);
				
				try {
					PageResult resultSet = dao.querySearchPage(searchs, currentPage, 12);
					req.setAttribute("result",resultSet);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println(searchGoods);
			}else{
				try {
					PageResult resultSet = dao.queryPage(currentPage,12);
					req.setAttribute("result",resultSet);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//通过价格查询
			String parameter = req.getParameter("cmd");
			if(StringUtils.hasLength(parameter)){
				if(parameter.equals("sortPrice")){
				try {
					PageResult resultSet = dao.queryPricePage(currentPage, 12);
					req.setAttribute("result",resultSet);
					//req.getSession().setAttribute("result",resultSet);
					
					//req.getRequestDispatcher("/home/search.jsp").forward(req, resp);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
			
			req.getRequestDispatcher("/home/search.jsp").forward(req, resp);
			
		}
}
