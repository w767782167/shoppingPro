package com.etcxm.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.dao.IntroductionDao;
import com.etcxm.entity.Introduction;
@WebServlet("/intrServlet")
public class IntrServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IntroductionDao dao=new IntroductionDao();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		
		String goodId = req.getParameter("goodId");
		System.out.println("获得的ID:"+goodId);
		try {
			Introduction goodIntroduction = dao.showIntroduction(Long.valueOf(goodId));
			req.setAttribute("goodInfo",goodIntroduction);
			String property = goodIntroduction.getProperty();
			String packing=goodIntroduction.getPacking();
			//看是否有逗号，判断是否多个值
			System.out.println(property);
			req.setAttribute("list",property);
			req.setAttribute("pack", packing);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//req.getServletContext().getContextPath();
		req.getRequestDispatcher("/home/introduction.jsp").forward(req, resp);
	}

}
