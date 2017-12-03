package com.etcxm.page;
/**
 * 页码的开始索引和结束索引
 */
public class PageIndex {
	private Integer beginIndex;
	private Integer endIndex;
	
	/**
	 * 首页 上页 [1] 2 3 4 5 6 7 8 9 10 下页 末页 当前第1/18页一共53条记录 每页5 条
	 * @param totalIndexCount	总索引数
	 * @param currentPage		当前页
	 * @param totalPage			总页数
	 * @return
	 */
	public static PageIndex getPageIndex(Integer totalIndexCount,
			Integer currentPage, Integer totalPage) {
		Integer startPageIndex = currentPage
				- (totalIndexCount % 2 == 0 ? totalIndexCount / 2 - 1 : totalIndexCount / 2);
		Integer endPageIndex = currentPage + totalIndexCount / 2;
		if (startPageIndex < 1) {
			startPageIndex = 1;
			if (totalPage >= totalIndexCount)
				endPageIndex = totalIndexCount;
			else
				endPageIndex = totalPage;
		}
		if (endPageIndex > totalPage) {
			endPageIndex = totalPage;
			if ((endPageIndex - totalIndexCount) > 0)
				startPageIndex = endPageIndex - totalIndexCount + 1;
			else
				startPageIndex = 1;
		}
		return new PageIndex(startPageIndex, endPageIndex);
	}
	public PageIndex(Integer beginIndex, Integer endIndex) {
		this.beginIndex = beginIndex;
		this.endIndex = endIndex;
	}
	public Integer getBeginIndex() {
		return beginIndex;
	}
	public Integer getEndIndex() {
		return endIndex;
	}
}
