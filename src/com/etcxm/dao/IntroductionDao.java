package com.etcxm.dao;

import java.util.ArrayList;

import com.etcxm.entity.Introduction;
import com.etcxm.utils.JDBCUtils;

public class IntroductionDao {

	private JDBCUtils util=new JDBCUtils();
	public IntroductionDao(){
		util.getConnection();
	}
	//显示商品详情
	public Introduction showIntroduction(Long id) throws Exception{
		String sql="select id,name,price,costprice,property," +
	"packing,stock,path,goodsFrom,introduce from tb_goods where id=?";
		ArrayList<Object> params=new ArrayList<Object>();
		params.add(id);
		Introduction goodIntroduction = util.findSimpleRefResult(sql, params, Introduction.class);
		util.releaseConn();
		return goodIntroduction;
		}
}
