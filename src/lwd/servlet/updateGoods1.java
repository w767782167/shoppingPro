package lwd.servlet;

import java.io.File;
import java.io.IOException;
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
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import lwd.dao.dao;
import lwd.entity.goods;
import lwd.utils.StringUtils;
@WebServlet("/updateGoods1")
public class updateGoods1 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(arg0, arg1);
		boolean flag = ServletFileUpload.isMultipartContent(req);
	
			if (!flag) {
				System.out.println("执行了");
				return;
			
		}
		dao dao = new dao();
		try {
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(700 * 1024);// 700k
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> list = upload.parseRequest(req);
			/***************参数都在map里面了***********************************/
/*	Map<String,Object> map = new HashMap<String,Object>();
			for(FileItem fileItem : list) {
				if(fileItem.isFormField()) {//如果是普通表单字段
					map.put(fileItem.getFieldName(), fileItem.getString("UTF-8"));
				}
			}
			System.out.println("map"+map.toString());*/
			String name = list.get(0).getString("utf-8");
			String price = list.get(1).getString("utf-8");
			String costprice = list.get(2).getString("utf-8");
			String property = list.get(3).getString("utf-8");
			String packing = list.get(4).getString("utf-8");
			String stock = list.get(5).getString("utf-8");
			String bigtype_id = list.get(6).getString("utf-8");
			//String price = list.get(1).getString("utf-8");
			System.out.println(name);
			System.out.println(price);
			String img = list.get(7).getName();
			String website = list.get(8).getString("utf-8");
			String edit_website = list.get(9).getString("utf-8");
			String introduce = list.get(10).getString("utf-8");
			String goodsFrom = list.get(11).getString("utf-8");
			String path = list.get(12).getString("utf-8");
			String id = list.get(13).getString("utf-8");
			System.out.println("lwdimg"+img);
			System.out.println("id"+id);
			/**************************************************/
			
			
			
			
			
			
			for (FileItem fileItem : list) {
				if (fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName());
				} else {
					String realPath = req.getServletContext().getRealPath(
							"/images");
					//System.out.println(realPath);
					String string = UUID.randomUUID().toString();// 随机名
					String filename1 = fileItem.getName();// 文件名
					String extension = FilenameUtils.getExtension(filename1);// 后缀名
					System.out.println(filename1);
					req.setAttribute("string", string);
					req.setAttribute("extension", extension);

					File file = new File(realPath, string + "." + extension);
					System.out.println("file"+file);
					fileItem.write(file);
					System.out.println(fileItem.isInMemory());
					//System.out.println(string);
					//System.out.println(extension);
					String s = "/pic/" + string + "." + extension;
					
					// System.out.println(contents+"123455");
				
System.out.println("new"+s);
if(StringUtils.hasLength(img)){
	//boolean updateGood = dao.updateGood(Long.valueOf(id), name,  Double.valueOf(price), Double.valueOf(costprice) , property, packing,Long.valueOf(stock) ,Long.valueOf(bigtype_id) , website, edit_website, goodsFrom, introduce,s);
	boolean updateGood = dao.updateGood(Long.valueOf(id), name,  Double.valueOf(price), Double.valueOf(costprice) , property, packing,Long.valueOf(stock) ,Long.valueOf(bigtype_id) , website, edit_website, goodsFrom, introduce,s);
	System.out.println(updateGood);
	req.setAttribute("update", "修改成功");
	req.getRequestDispatcher("/updateGoods").forward(req, resp);
}else{
	/*boolean updateGood = dao.updateGood(Long.valueOf(id), name,  Double.valueOf(price));
	System.out.println(updateGood);*/
	boolean updateGood = dao.updateGood(Long.valueOf(id), name,  Double.valueOf(price), Double.valueOf(costprice) , property, packing,Long.valueOf(stock) ,Long.valueOf(bigtype_id) , website, edit_website, goodsFrom, introduce,path);
	req.setAttribute("update", "修改成功");
	req.getRequestDispatcher("/updateGoods").forward(req, resp);
}
					//req.getRequestDispatcher("/lwdlist.jsp").forward(req, resp);

				}
			}
			
			
			
			
			
			
			
			
			
			
			
			
		/*	goods g = dao.queryEmple(Long.valueOf(id));
			String name = g.getName();
			Double price = g.getPrice();
			Double costprice = g.getCostprice();
			String property = g.getProperty();
			String packing = g.getPacking();
			Long stock = g.getStock();
			Long bigtype_id = g.getBigtype_id();
			String path2 = g.getPath();
			String website = g.getWebsite();
			String edit_website = g.getEdit_website();
			String goodsFrom = g.getGoodsFrom();
			String introduce = g.getIntroduce();*/
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
