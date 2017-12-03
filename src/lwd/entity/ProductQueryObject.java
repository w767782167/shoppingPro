package lwd.entity;

import java.util.ArrayList;
import java.util.List;

import lwd.utils.StringUtils;

public class ProductQueryObject extends QueryObject{
	
	private String productName;
	private Double minPrice;
	private Double maxPrice;
	private Long dir_id;
//	//存放参数的集合
//	private List<Object> parames = new ArrayList<Object>();
//	
//	//存放sql语句的集合
//	private List<Object> conditions = new ArrayList<Object>();
//	
//	//获取参数
//	public List<Object> getParames(){
//		return parames;
//	}
//	
//	
//	//获取Sql语句
//	public String getQuerySql(){
//		
//		//拼接sql语句
//		customQuery();
//		
//		StringBuilder sql  = new StringBuilder();
//		if(conditions.size()>0){
//			sql.append(" WHERE ");
//			sql.append(org.apache.commons.lang3.StringUtils.join(conditions, " AND "));
//		}
//		
//		
//		System.out.println(sql.toString());
//		
//		return sql.toString();
//	}
	
	public void customQuery(){
		if(StringUtils.hasLength(productName)){
//			conditions.add(" productName LIKE ?");
//			parames.add("%"+productName+"%");
			super.addQuery(" name LIKE ?", "%"+productName+"%");
		}
		if(minPrice!=null){
//			conditions.add(" salePrice >= ?");
//			parames.add(minPrice);
			super.addQuery(" price >= ?", minPrice);
		}
		if(maxPrice!=null){
//			conditions.add(" salePrice <= ?");
//			parames.add(maxPrice);
			super.addQuery(" price <= ?", maxPrice);
		}
		if(dir_id!=null && dir_id != -1){
			super.addQuery(" bigtype_id = ?", dir_id);
		}
		
	}
	

	public Long getDir_id() {
		return dir_id;
	}


	public void setDir_id(Long dir_id) {
		this.dir_id = dir_id;
	}


	public ProductQueryObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductQueryObject(String productName, Double minPrice,
			Double maxPrice, Long dir_id) {
		super();
		this.productName = productName;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.dir_id = dir_id;
	}


	public ProductQueryObject(String productName, Double minPrice,
			Double maxPrice) {
		super();
		this.productName = productName;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}
	public Double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}
	
	
	

}
