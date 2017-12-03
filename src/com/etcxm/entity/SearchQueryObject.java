package com.etcxm.entity;

import java.util.ArrayList;
import java.util.List;

import com.etcxm.utils.StringUtils;

public class SearchQueryObject extends QueryObject{
	
	private String name;
	private String goodsFrom;
	
	public SearchQueryObject(String name, String goodsFrom) {
		super();
		this.name = name;
		this.goodsFrom = goodsFrom;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGoodsFrom() {
		return goodsFrom;
	}


	public void setGoodsFrom(String goodsFrom) {
		this.goodsFrom = goodsFrom;
	}


	public void customQuery(){
		if(StringUtils.hasLength(name)){

			super.addQuery(" name LIKE ?", "%"+name+"%");
		}
		if(StringUtils.hasLength(goodsFrom)){

			super.addQuery(" goodsFrom LIKE ?", "%"+goodsFrom+"%");
		}
	}
	

	public SearchQueryObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	

}