package lwd.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;



import lwd.entity.ProductQueryObject;
import lwd.entity.kind;

import lwd.entity.PageRuselt;

import lwd.entity.QueryObject;

import lwd.utils.StringUtils;

import lwd.dao.ProductDirDao;
import lwd.dao.dao;
import lwd.entity.goods;

@WebServlet("/upload")
public class upload extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
resp.setContentType("text/html; charset=UTF-8");
		// String contents = req.getParameter("contents");
		// System.out.println(contents+"213141");
		String productName = req.getParameter("productName");
		String minPriceStr = req.getParameter("minPrice");
		String maxPriceStr = req.getParameter("maxPrice");
		String dir_idStr = req.getParameter("dir_id");
		ProductQueryObject op = new ProductQueryObject();
		op.setProductName(productName);
		if (StringUtils.hasLength(minPriceStr)) {
			op.setMinPrice(Double.valueOf(minPriceStr));
		}
		if (StringUtils.hasLength(maxPriceStr)) {
			op.setMaxPrice(Double.valueOf(maxPriceStr));
		}
		if (StringUtils.hasLength(dir_idStr)) {
			op.setDir_id(Long.valueOf(dir_idStr));
		}
		ProductDirDao dirDao = new ProductDirDao();
		dao dao = new dao();
		goods sp = null;
		boolean f = false;
		// dao.add(sp);
		// System.out.println(username);
		// System.out.println(password);
		// System.out.println(headImg);
		boolean flag = ServletFileUpload.isMultipartContent(req);
		String pageSize = req.getParameter("pageSize");
		// System.out.println("dddddd"+pageSize);
		String currentPage = req.getParameter("currentPage");

		Integer icurrentPage = 1;
		if (StringUtils.hasLength(currentPage)) {
			icurrentPage = Integer.valueOf(currentPage);
			op.setCurrentPage(icurrentPage);
		}

		Integer ipageSize = 3;
		if (StringUtils.hasLength(pageSize)) {
			ipageSize = Integer.valueOf(pageSize);
			op.setPageSize(ipageSize);
		}

		PageRuselt result;
		try {
			result = dao.queryPageResult(op);

			System.out.println(result.getCurrentPage());

			req.setAttribute("pageResult", result);
			req.setAttribute("op", op);

			List<kind> dirs = dirDao.queryAllproductDirs();
			// 把商品分类的数据放在作用域中共享数据
			req.setAttribute("dirs", dirs);
			if (!flag) {
				req.getRequestDispatcher("/lwdlist.jsp").forward(req, resp);
			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (!flag) {
			return;
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(700 * 1024);// 700k
		ServletFileUpload upload = new ServletFileUpload(factory);

		try {
			// List<FileItem> list1 = upload.parseRequest(req);

			// List<goods> list = dao.queryAllproducts();
			// req.setAttribute("list", list);

			List<FileItem> list = upload.parseRequest(req);
			
			/***************参数都在map里面了***********************************/
			Map<String,Object> map = new HashMap<String,Object>();
			for(FileItem fileItem : list) {
				if(fileItem.isFormField()) {//如果是普通表单字段
					map.put(fileItem.getFieldName(), fileItem.getString("UTF-8"));
				}
			}
			System.out.println("map"+map.toString());
			/**************************************************/
			
			String name = list.get(0).getString("utf-8");
			String price = list.get(1).getString("utf-8");
			String costprice = list.get(2).getString("utf-8");
			String property = list.get(3).getString("utf-8");
			String packing = list.get(4).getString("utf-8");
			String stock = list.get(5).getString("utf-8");
			System.out.println("stock:" +stock);
			//String kind_id = list.get(6).getString("utf-8");

			String headImg = list.get(6).getName();
			
			String website = list.get(7).getString("utf-8");
			
			System.out.println("website 8"+website);
			String edit_website = list.get(8).getString("utf-8");
			String token = list.get(9).getString("utf-8");
			String goodsFrom = list.get(10).getString("utf-8");
			String introduce = list.get(11).getString("utf-8");
			System.out.println("11"+introduce);
			System.out.println(list.size());
	String kind_id = list.get(12).getString("utf-8");
	//System.out.println(select);

			String sessiontoken = (String) req.getSession().getAttribute(
					"TOKEN_IN_SESSION");

			if (StringUtils.hasLength(token)) {
				if (token.equals(sessiontoken)) {
					req.getSession().removeAttribute("TOKEN_IN_SESSION");
				} else {
					PrintWriter w = resp.getWriter();
					System.out.println("shoujian");
					//w.print("<script>alert('请勿重复提交');</script>");
					req.setAttribute("re", "请勿重复提交,如要重新添加商品请于添加页面按'F5'刷新再添加");
					req.getRequestDispatcher("/lwdlist.jsp").include(req, resp);
					return;
					//req.getRequestDispatcher("/upload").forward(req, resp);
					
					
				}
			}
			System.out.println(name + price + headImg + website + token);
			for (FileItem fileItem : list) {
				if (fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName());
				} else {
					String realPath = req.getServletContext().getRealPath(
							"/images");
					System.out.println(realPath);
					String string = UUID.randomUUID().toString();// 随机名
					String filename1 = fileItem.getName();// 文件名
					String extension = FilenameUtils.getExtension(filename1);// 后缀名
					System.out.println(filename1);
					req.setAttribute("string", string);
					req.setAttribute("extension", extension);

					File file = new File(realPath, string + "." + extension);
					System.out.println(file);
					fileItem.write(file);
					System.out.println(fileItem.isInMemory());
					System.out.println(string);
					System.out.println(extension);
					String s = "/pic/" + string + "." + extension;
					
					// System.out.println(contents+"123455");
					sp = new goods(null, name, Double.valueOf(price),
							Double.valueOf(costprice), property, packing,
							Long.valueOf(stock), Long.valueOf(kind_id), s,
							website, edit_website,goodsFrom,introduce);
					f = dao.add(sp);
					System.out.println(f);

					List<goods> list2 = dao.querySp();
					result = dao.queryPageResult(op);

					System.out.println(result.getCurrentPage());

					req.setAttribute("pageResult", result);

					req.getRequestDispatcher("/lwdlist.jsp").forward(req, resp);

				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}