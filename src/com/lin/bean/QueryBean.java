package com.lin.bean;

import java.util.List;

public class QueryBean {
	
	private List<Product> list;//记住查询的数据，放入到list中
	private int tatalrecord;//记住总记录数
	public List<Product> getList() {
		return list;
	}
	public void setList(List<Product> list) {
		this.list = list;
	}
	public int getTatalrecord() {
		return tatalrecord;
	}
	public void setTatalrecord(int tatalrecord) {
		this.tatalrecord = tatalrecord;
	}
	
}
