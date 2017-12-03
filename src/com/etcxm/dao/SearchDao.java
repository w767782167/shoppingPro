package com.etcxm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etcxm.entity.Comment;
import com.etcxm.entity.Search;
import com.etcxm.entity.SearchgFromInfo;
import com.etcxm.page.PageResult;
import com.etcxm.utils.JDBCUtils;

public class SearchDao {
	JDBCUtils util=new JDBCUtils();
	public SearchDao(){
		util.getConnection();
	}
	//查找商品信息(模糊查询1111)
	public PageResult querySearchPage(Search search,Integer currentPage,Integer pageSize) throws Exception{
		//方式一：like or连接，效率低
		//String sql="select id,name,costprice,path,goodsFrom,introduce from tb_goods where name like ? or goodsFrom like ? limit ?,? ";
		//方式二：instr("字段名","匹配内容")找到返回位置，找不到返回0
		String sql="select id,name,price,costprice,path,goodsFrom,introduce from tb_goods where instr(name,?)>0 or instr(goodsFrom,?)>0 limit ?,? ";
		//查询结果集
				List<Object> params=new ArrayList<Object>();
				/*params.add("%"+search.getName()+"%");
				params.add("%"+search.getGoodsFrom()+"%");*/
				params.add(search.getName());
				params.add(search.getGoodsFrom());
				params.add((currentPage-1)*pageSize);
				params.add(pageSize);
				List<Search> list = util.findMoreRefResult(sql, params, Search.class);
				
				//查询总条数
				Integer totalCount=(int) totalCountSearch(search);
				PageResult pageResult = new PageResult(list,totalCount,currentPage,pageSize);
				util.releaseConn();
				return pageResult;
	}
	//按价格查询由低到高
	public PageResult queryPricePage(Integer currentPage,Integer pageSize) throws Exception{
		String sql="select id,name,price,costprice,path,goodsFrom,introduce from tb_goods order by costprice asc limit ?,?";
		//查询结果集
				List<Object> params=new ArrayList<Object>();
				params.add((currentPage-1)*pageSize);
				params.add(pageSize);
				List<Search> list = util.findMoreRefResult(sql, params, Search.class);
				
				//查询总条数
				Integer totalCount=(int) totalCount();
				PageResult pageResult = new PageResult(list,totalCount,currentPage,pageSize);
				util.releaseConn();
				return pageResult;
	}
	//显示商品所有信息
	public PageResult queryPage(Integer currentPage,Integer pageSize) throws Exception{
		
		String sql="select id,name,price,costprice,path,goodsFrom,introduce from tb_goods limit ?,?";
		//查询结果集
		List<Object> params=new ArrayList<Object>();
		params.add((currentPage-1)*pageSize);
		params.add(pageSize);
		List<Search> list = util.findMoreRefResult(sql, params, Search.class);
		//查询总条数
		Integer totalCount=(int) totalCount();
		PageResult pageResult = new PageResult(list,totalCount,currentPage,pageSize);
		util.releaseConn();
		return pageResult;
	}
	//查找商品总条数
	public long totalCount() throws Exception{
		String sql="select count(*) from tb_goods";
		ResultSet resultSet = util.query(sql, null);
		long result=0;
		if(resultSet.next()){
			result=resultSet.getLong(1);
		}
		util.releaseConn();
		return result;
		
	}

	//搜索页面商品总条数
	public long totalCountSearch(Search search) throws Exception{
		String sql="select count(*) from tb_goods where instr(name,?)>0 or instr(goodsFrom,?)>0";
		List<Object> params=new ArrayList<Object>();
		params.add(search.getName());
		params.add(search.getGoodsFrom());
		ResultSet resultSet = util.query(sql, params.toArray());
		long result=0;
		if(resultSet.next()){
			result=resultSet.getLong(1);
		}
		util.releaseConn();
		return result;
	}
	//显示search搜索页面品牌信息
	public ArrayList<Object> showGoodsFrom() throws SQLException{
	    String sql="select distinct goodsFrom from tb_goods";
	    ResultSet bland = util.query(sql, null);
	    ArrayList<Object> list=new ArrayList<Object>();
	    while(bland.next()){
	    	list.add(bland.getString(1));
	    }
	    util.releaseConn();
		return list;
	    
		
	}
	//显示search搜索页面品牌下的信息
	public List<SearchgFromInfo> showGfromInfo(String gFrom) throws Exception{
		String sql="select name from tb_goods where goodsFrom=? limit 6";
		ArrayList<Object> params=new ArrayList<Object>();
		params.add(gFrom);
		List<SearchgFromInfo> searchGoods = util.findMoreRefResult(sql,params, SearchgFromInfo.class);
		util.releaseConn();
		return searchGoods;
	}
	//显示喜爱的食品
	public List<Search> showFav() throws Exception{
		String sql="select id,name,price,costprice,path,goodsFrom,introduce from tb_goods limit 12";
		List<Search> list = util.findMoreRefResult(sql, null, Search.class);
		util.releaseConn();
		return list;
	}
	//把评论发进数据库
	public boolean addComment(String author,String comment) throws SQLException{
		String sql="insert into tb_comment values(null,?,null,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(author);
		params.add(comment);
		boolean flag = util.updateByPreparedStatement(sql, params);
		util.releaseConn();
		return flag;
	}
	//查询所有评论信息
	public List<Comment> showAllComment() throws Exception{
		String sql="select * from tb_comment order by id desc";
		List<Comment> result = util.findMoreRefResult(sql, null,Comment.class);
		util.releaseConn();
		return result;
	}
}
