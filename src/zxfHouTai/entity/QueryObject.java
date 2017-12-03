package zxfHouTai.entity;

import java.util.ArrayList;
import java.util.List;

public class QueryObject {
	    //存放参数的集合
		private List<Object> parames = new ArrayList<Object>();
		//存放sql语句的集合
		private	List<Object> conditions = new ArrayList<Object>();

		// 获取参数
		public List<Object> getParames(){
			return parames;
		}
		
		public String getQuerySql(){
			
			parames = new ArrayList<Object>();
			//存放sql语句的集合
			conditions = new ArrayList<Object>();
			//拼接sql语句
			customQuery();
		
			StringBuilder sql=new StringBuilder();
			
			if(conditions.size()>0){
				sql.append(" WHERE");
				sql.append(org.apache.commons.lang3.StringUtils.join(conditions, " AND "));
			}
			System.out.println(sql.toString());
			return sql.toString();
		}
		
		//该方法  把子类参数传过来
		public void addQuery(String condition,Object paramer){
			conditions.add(condition);
			parames.add(paramer);
		}
		
		//钩子方法:  给子类覆盖
		protected void customQuery(){
			
		}
}
