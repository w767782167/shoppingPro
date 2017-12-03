package com.etcxm.daotext;

import java.util.List;

import com.etcxm.dao.SearchDao;
import com.etcxm.entity.Search;
import com.etcxm.entity.SearchQueryObject;
import com.etcxm.page.PageResult;

public class SearchDaoTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SearchDao dao=new SearchDao();
		//调试总分页
		/*PageResult queryPage = dao.queryPage(1, 3);
		long totalCount = dao.totalCount();
		System.out.println(totalCount+"条" );
		System.out.println(queryPage);*/
		//调试按价钱从低到高分页
		/*PageResult queryPricePage = dao.queryPricePage(2, 12);
		System.out.println(queryPricePage);*/
		//高级查询调试
		SearchDao dao1=new SearchDao();
		SearchQueryObject op = new SearchQueryObject();
		//PageResult result = dao.queryPageResult(op);
		//System.out.println(result);
	}

}
