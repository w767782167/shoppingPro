package com.etcxm.page;

import java.util.List;

public class PageResult {
	private List listData;//结果集
	private Integer currentPage;//当前页面
	private Integer pageSize;//页面大小
	private Integer totalCount;//总条数
	
	private Integer totalPage;//总页数
	private Integer prePage;//上一页
	private Integer nextPage;//下一页
	
	private PageIndex index;
	
	public PageIndex getIndex(){
		return index;
	}
	public void setIndex(PageIndex index){
		this.index=index;
	}
	
	public PageResult(List listData, Integer totalCount, Integer currentPage,
			Integer pageSize) {
		super();
		this.listData = listData;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		//计算得来
		this.totalPage=this.totalCount%this.pageSize==0?(this.totalCount/this.pageSize):
			(this.totalCount/this.pageSize)+1;
		this.prePage=this.currentPage-1>=1?(this.currentPage-1):1;
		this.nextPage=this.currentPage+1<=totalPage?(this.currentPage+1):this.totalPage;
		
		this.index=PageIndex.getPageIndex(5, this.currentPage, this.totalPage);
	}
	public PageResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PageResult [listData=" + listData + ", currentPage="
				+ currentPage + ", pageSize=" + pageSize + ", totalCount="
				+ totalCount + ", totalPage=" + totalPage + ", prePage="
				+ prePage + ", nextPage=" + nextPage + ", index=" + index + "]";
	}
	public List getListData() {
		return listData;
	}
	public void setListData(List listData) {
		this.listData = listData;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getPrePage() {
		return prePage;
	}
	public void setPrePage(Integer prePage) {
		this.prePage = prePage;
	}
	public Integer getNextPage() {
		return nextPage;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	
	
}
