package com.lin.bean;

public class QueryInfo {
	
	private int currentpage = 1;// 记录用户想看的页面，可以从客户端提交数据过来，默认是第一页
	private int pagesize = 10;// 用户一页面想显示多少条，可以从客户端提交数据过来，默认是第五条
	private int startindex;// 从第几条开始查询,是自己计算出来的


	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getStartindex() {
		// 计算出查询的开始位置
		// 查询开始位置==(当前页面-1)*显示数据条数
		this.startindex = (this.currentpage - 1) * this.pagesize;
		return startindex;
	}

	public void setStartindex(int startindex) {

		this.startindex = startindex;
	}

	
}
