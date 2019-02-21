package com.lin.bean;

import java.util.List;

public class PageBean {
	private List<Product> list;// 数据，用来保存查询结果UsersBean
	private int totalrecord;// 页面总记录数：从数据查询出来
	private int pagesize;// 每页显示多少条：客户传送过来
	private int totalpage;// 总共有多少页：我们自己计算来的
	private int currentpage;// 当前第几页：
	private int previouspage;// 上一页
	private int nextpage;// 下一页
	private int[] pagebar;// 页码条:
	public List<Product> getList() {
		return list;
	}
	public void setList(List<Product> list) {
		this.list = list;
	}
	public int getTotalrecord() {
		return totalrecord;
	}
	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getTotalpage() {
		if (this.totalrecord % this.pagesize == 0) {
				this.totalpage = this.totalrecord / this.pagesize;
		} else {
				this.totalpage = this.totalrecord / this.pagesize + 1;
		}
			return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getPreviouspage() {
		if (this.currentpage - 1 < 1) {
			this.previouspage = 1;
		} else {
			this.previouspage = this.currentpage - 1;
		}
		return previouspage;
	}
	public void setPreviouspage(int previouspage) {
		this.previouspage = previouspage;
	}
	public int getNextpage() {
		if (this.currentpage + 1 > this.totalpage) {
			this.nextpage = this.totalpage;
		} else {
			this.nextpage = this.currentpage + 1;
		}
		return nextpage;
	}
	public void setNextpage(int nextpage) {
		this.nextpage = nextpage;
	}
	public int[] getPagebar() {
		//重在赋值：
				int pagebar[] = new int[10];//定义一个固定长度的数组
				int startpage;//记录从哪个值开始赋值
				int endpage;//记录从哪个值结束

				//有可以我的总页面没有10页的情况
				if (this.totalpage <= 10) {
					//如果没有10页面，则将从1开始赋值
					startpage = 1;
					endpage = this.totalpage;
				} else {
					//startpage=当前页面-4;
					//endpage=当前页面+5;
					startpage = this.currentpage - 5;
					endpage = this.currentpage + 4;

					//如果开始中小于1说明页面已经到最前页了，只用将其头设置为1,尾设置为10
					if (startpage < 1) {
						startpage = 1;
						endpage = 10;
					}
					//如果结束页大于总页 数说明页面已经到最后页面了，只用将尾页设置为总页数,首页设置为总页数-9
					if (endpage > this.totalpage) {
						endpage = this.totalpage;
						startpage = this.totalpage - 9;
					}
				}

				//赋值
				int index = 0;//数组下标一定是0开始的
				for (int i = startpage; i <= endpage; i++) {
					//给数组赋值
					pagebar[index++] = i;
				}
				this.pagebar = pagebar;
		return pagebar;
	}
	public void setPagebar(int[] pagebar) {
		this.pagebar = pagebar;
	}
	
	
	
}
