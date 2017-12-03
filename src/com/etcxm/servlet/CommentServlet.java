package com.etcxm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.etcxm.dao.SearchDao;
import com.etcxm.entity.Comment;
import com.etcxm.entity.User;
import com.etcxm.utils.StringUtils;
import com.etcxm.utils.StringUtils;
@WebServlet("/commentServlet")
public class CommentServlet extends HttpServlet{

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
		resp.setContentType("text/html;charset=UTF-8");
		User obj=(User) req.getSession().getAttribute("USER_IN_SESSION");
		String author="";
		String comment="";
		
		//验证表单是否重复提交
				String token=req.getParameter("token");
				String sessiontoken=(String)req.getSession().getAttribute("TOKEN_IN_SESSION");
				if(StringUtils.hasLength(token)){
					if(token.equals(sessiontoken)){
						req.getSession().removeAttribute("TOKEN_IN_SESSION");
					}else{
						System.out.println("手贱");
						return;
					}
				}
			//验证结束	
		if(obj!=null){
		author = obj.getUsername();
		}
		comment = req.getParameter("comment");
		//把评论内容发入数据库
		boolean flag=false;
		PrintWriter out;
		String jsonStr="";
		try {
			if(StringUtils.hasLength(author)&&StringUtils.hasLength(comment))
			flag= dao.addComment(author, comment);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag){
			try {
				List<Comment> result = dao.showAllComment();
				jsonStr= JSON.toJSONString(result);
				System.out.println(jsonStr);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}else{
				List<Comment> result;
				try {
					result = dao.showAllComment();
					jsonStr= JSON.toJSONString(result);
					System.out.println(jsonStr);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		out = resp.getWriter();
		out.print(jsonStr);
	}

}
