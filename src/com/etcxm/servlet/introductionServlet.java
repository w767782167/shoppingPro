package com.etcxm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.etcxm.dao.shoppingCartDao;
import com.etcxm.entity.User;
import com.etcxm.entity.cartItem;
import com.etcxm.entity.goods;
import com.etcxm.utils.StringUtils;

@WebServlet("/introduction")
public class introductionServlet extends HttpServlet {

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
			if (parameter.equals("buy")) {
				buy(req, resp);
			} else if (parameter.equals("edit")) {
				// edit(req, resp);
			} else if (parameter.equals("addToCart")) {
				addToCart(req, resp);
			}
		} else {
			// list(req, resp);
		}

	}

	protected void buy(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 获取参数
		
		Long id = Long.valueOf(req.getParameter("goodIdInput"));
		goods goods = dao.queryGoodsById(id);

		User obj = (User) req.getSession().getAttribute("USER_IN_SESSION");
		/* System.out.println(obj.getUsername()); */
		if (obj != null) {
			String userName = obj.getUsername();
			if (StringUtils.hasLength(userName)) {
				
				String orderNum = new Date().getTime() + "";
				String picture = goods.getPath();
				String productName = goods.getName();
				String property = req.getParameter("kouwei");
				String packing = req.getParameter("baozhuang");
				String goodsInfo = goods.getIntroduce();
				Double singlePrice = goods.getPrice();
				Long goodsNum = Long.valueOf(req.getParameter("number"));
				Double totalPrice = goodsNum * singlePrice;
				String joint = totalPrice > 200 ? "包邮" : "邮费10元";
				Long sign = 1L;

				cartItem careItem = new cartItem(null, userName, orderNum,
						picture, productName, property, packing, goodsInfo,
						singlePrice, goodsNum, totalPrice, joint, sign);

				boolean flag = dao.addToShopCart(careItem);		
				if (flag) {
					System.out.println("添加成功");
					resp.sendRedirect("/shoppingPro/orderServlet");
				}
			} else {
				resp.sendRedirect("/shoppingPro/home/login.jsp");

			}
		} else {
			resp.sendRedirect("/shoppingPro/home/login.jsp");
		}
	       
	}

	protected void addToCart(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 验证表单是否重复提交

		/*
		 * String token = req.getParameter("token"); String sessiontoken =
		 * (String) req.getSession().getAttribute( "TOKEN_IN_SESSION");
		 * 
		 * if (StringUtils.hasLength(token)) { if (token.equals(sessiontoken)) {
		 * req.getSession().removeAttribute("TOKEN_IN_SESSION"); } else {
		 * System.out.println("手贱"); return; }
		 * 
		 * }
		 */

		PrintWriter out = resp.getWriter();
		User obj = (User) req.getSession().getAttribute("USER_IN_SESSION");
		/* System.out.println(obj.getUsername()); */
		String msg = "";
		if (obj != null) {
			String userName = obj.getUsername();
			
			if (StringUtils.hasLength(userName)) {
				Long id = Long.valueOf(req.getParameter("id"));
				goods goods = dao.queryGoodsById(id);
				String orderNum = new Date().getTime() + "";
				String picture = goods.getPath();
				String productName = goods.getName();
				String property = req.getParameter("kouwei");
				String packing = req.getParameter("baozhuang");
				String goodsInfo = goods.getIntroduce();
				Double singlePrice = goods.getPrice();
				Long goodsNum = Long.valueOf(req.getParameter("num"));
				Double totalPrice = goodsNum * singlePrice;
				String joint = totalPrice > 200 ? "包邮" : "邮费10元";
				Long sign = 0L;

				cartItem careItem = new cartItem(null, userName, orderNum,
						picture, productName, property, packing, goodsInfo,
						singlePrice, goodsNum, totalPrice, joint, sign);
				boolean flag = dao.addToShopCart(careItem);

				/*
				 * cartItem careItem = new cartItem(null,"jack","1372600781205",
				 * "/shoppingPro/images/01_small.jpg",
				 * "坚果","盐焗","两袋装","小册子",34.3,3L,43.2,"包邮",1L); boolean flag =
				 * dao.addToShopCart(careItem);
				 */
				if (flag) {
					System.out.println("添加成功");
					msg="添加成功";
					Long cartNumByName = dao.getCartNumByName(userName);
					/*StringBuilder sb = new StringBuilder();
					sb.append("[");
					sb.append("{'msg':'" + msg+ "'}");
					sb.append("]");
					System.out.println(sb);*/
					out.print(cartNumByName);
				}
			} else {
				out.print("用户还未登入，请登录");
				msg="用户还未登入，请登录";
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				sb.append("{'msg':'" + msg+ "'}");
				sb.append("]");
				System.out.println(sb);
				out.print(sb);
				resp.sendRedirect("/shoppingPro/home/login.jsp");
			}
		} else {
			out.print("用户还未登入，请登录");
			msg="用户还未登入，请登录";
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			sb.append("{'msg':'" + msg+ "'}");
			sb.append("]");
			System.out.println(sb);
			out.print(sb);
			resp.sendRedirect("/shoppingPro/home/login.jsp");
		}

	}
}
