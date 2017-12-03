package com.etcxm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.etcxm.dao.shoppingCartDao;
import com.etcxm.entity.User;
import com.etcxm.entity.cartItem;

import com.etcxm.utils.StringUtils;

@WebServlet("/shoppingCart")
public class shoppingCartServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private shoppingCartDao dao = new shoppingCartDao();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");

		String parameter = req.getParameter("cmd");
		if (StringUtils.hasLength(parameter)) {
			if (parameter.equals("delete")) {
				delete(req, resp);
			} else if (parameter.equals("cartNum")) {
				cartNum(req, resp);
			} else if (parameter.equals("showCart")) {
				showCart(req, resp);
			} else if (parameter.equals("changeSign")) {
				changeSign(req, resp);
			} else if (parameter.equals("changeSingleSign")) {
				changeSingleSign(req, resp);
			} else if (parameter.equals("changeNum")) {
				changeNum(req, resp);
			} else if (parameter.equals("toPay")) {
				toPay(req, resp);
			}
		} else {
			// list(req, resp);
		}
	}

	protected void showCart(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User obj = (User) req.getSession().getAttribute("USER_IN_SESSION");

		String userName = obj.getUsername();
		if (StringUtils.hasLength(userName)) {
			List<cartItem> shopCart = dao.queryCartsByName(userName);
			/* System.out.println(shopCart); */
			/* ResultSet totalPrice = dao.getTotalPrice(); */
			req.setAttribute("shopCart", shopCart);
			/* req.setAttribute("totalPrice", totalPrice); */
			req.getRequestDispatcher("/home/shopcart.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("/shoppingPro/home/login.jsp");
		}

	}

	protected void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String idStr = req.getParameter("id");
		boolean flag = dao.deleteCartItemById(Long.valueOf(idStr));
		if (flag) {
			resp.sendRedirect("/shoppingPro/shoppingCart?cmd=showCart");
		}

	}

	protected void cartNum(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User obj = (User) req.getSession().getAttribute("USER_IN_SESSION");
		if (obj != null) {
			String userName = obj.getUsername();

			PrintWriter out = resp.getWriter();
			Long cartNumByName = dao.getCartNumByName(userName);
			req.setAttribute("cartNumByName", cartNumByName);
			req.getSession().setAttribute("goodsNum", cartNumByName);
			out.print(cartNumByName);
		}

	}

	protected void changeSign(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		boolean checkBox = Boolean.valueOf(req.getParameter("checkBox"));
		User obj = (User) req.getSession().getAttribute("USER_IN_SESSION");

		String userName = obj.getUsername();

		/* System.out.println(checkBox); */
		PrintWriter out = resp.getWriter();
		boolean updateSign = dao.updateSign(checkBox, userName);
		Long selectGoodsNum = dao.getCartNumBySign(userName);
		Double selectTotalPrice = dao.getTotalPriceBySign(userName);

		/*
		 * List<Object> list = new ArrayList<Object>();
		 * list.add(selectGoodsNum); list.add(selectTotalPrice);
		 * 
		 * String jsonString = JSON.toJSONString(list);
		 * System.out.println(jsonString);
		 */

		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append("{'selectGoodsNum':'" + selectGoodsNum
				+ "','selectTotalPrice':'" + selectTotalPrice + "'}");
		sb.append("]");

		out.print(sb);

		/*
		 * if(updateSign){
		 * req.getRequestDispatcher("/shoppingCart?cmd=showCart").forward(req,
		 * resp); }
		 */

	}

	protected void changeSingleSign(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		boolean checkBox = Boolean.valueOf(req.getParameter("checkBox"));
		User obj = (User) req.getSession().getAttribute("USER_IN_SESSION");

		String userName = obj.getUsername();
		Long id = Long.valueOf(req.getParameter("id"));
		PrintWriter out = resp.getWriter();

		boolean updateSingleSign = dao.updateSingleSign(checkBox, userName, id);
		Long selectGoodsNum = dao.getCartNumBySign(userName);
		Double selectTotalPrice = dao.getTotalPriceBySign(userName);

		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append("{'selectGoodsNum':'" + selectGoodsNum
				+ "','selectTotalPrice':'" + selectTotalPrice + "'}");
		sb.append("]");

		out.print(sb);
		/*
		 * if(updateSingleSign){
		 * req.getRequestDispatcher("/shoppingCart?cmd=showCart").forward(req,
		 * resp); }
		 */

	}

	protected void changeNum(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		User obj = (User) req.getSession().getAttribute("USER_IN_SESSION");

		String userName = obj.getUsername();
		boolean upOrDown = Boolean.valueOf(req.getParameter("upOrDowm"));
		Long id = Long.valueOf(req.getParameter("id"));

		PrintWriter out = resp.getWriter();
		boolean changGoodsNum = dao.changGoodsNum(upOrDown, id);
		Double totalPriceById = dao.getTotalPriceById(id);
		Double selectTotalPrice = dao.getTotalPriceBySign(userName);

		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append("{'totalPriceById':'" + totalPriceById
				+ "','selectTotalPrice':'" + selectTotalPrice + "'}");
		sb.append("]");

		out.print(sb);

	}

	protected void toPay(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// String userName =
		// (String)req.getSession().getAttribute("USER_IN_SESSION");

		resp.sendRedirect("/shoppingPro/orderServlet");
	}

}
