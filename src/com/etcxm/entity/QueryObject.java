package com.etcxm.entity;

import java.util.List;
import java.util.ArrayList;

public class QueryObject {
	//存放参数的集合
	private List<Object> parames=new ArrayList<Object>();
	//存放sql语句的集合
	private List<Object> conditions=new ArrayList<Object>();
	//页面大小
	Integer pageSize=3;
	//当前页面
	Integer currentPage=1;
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
	
	//完整拼接sql语句
	public String getQuerySql(){
		parames=new ArrayList<Object>();
		conditions=new ArrayList<Object>();
		//拼接sql语句
		customQuery();
		StringBuilder sql=new StringBuilder();
		if(conditions.size()>0){
			sql.append("where");
			sql.append(org.apache.commons.lang3.StringUtils.join(conditions," or"));
		}
		System.out.println(sql.toString());
		return sql.toString();
	}
	
	//获取参数列表
	public List<Object> getParames(){
		return parames;
	}
	//该方法 把子类参数传过来
	public void addQuery(String condition,Object paramer){
		conditions.add(condition);
		parames.add(paramer);
	}
	//钩子方法
	protected void customQuery(){
		
	}

}
