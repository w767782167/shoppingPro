package lwd.entity;

import java.util.ArrayList;
import java.util.List;


//通用的查询对象
public class QueryObject {
	//存放参数的集合
	private List<Object> parames = new ArrayList<Object>();
	StringBuilder sql;

	// 存放sql语句的集合
	private List<Object> conditions = new ArrayList<Object>();
	
	//页面大小
	Integer pageSize = 3;
	
	//当前页面
	Integer currentPage = 1;
	
	

	public Integer getPageSize() {
		return pageSize;
	}


	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


	public Integer getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}


	// 获取参数
	// 获取参数
		public List<Object> getParames() {
			return parames;
		}
		
		
		//完整拼接sql语句
		public String getQuerySql(){
			
			//拼接sql语句
			customQuery();
			
			 sql  = new StringBuilder();
			if(conditions.size()>0){
				sql.append(" WHERE ");
				sql.append(org.apache.commons.lang3.StringUtils.join(conditions, " AND "));
			}
			System.out.println(sql.toString());
			
			return sql.toString();
		}
		
		//该方法 把子类参数传过来
		public void addQuery(String condition,Object paramer){
			conditions.add(condition);
			parames.add(paramer);
		}
		
		//钩子方法：给子类覆盖
		protected void customQuery() {
			
		}

	

}
