package com.lin.dao;

import java.util.Map;

import com.lin.bean.Product;
import com.lin.bean.QueryBean;

public interface ProductDao {
	//获取所有商品
	public Map getAllProduct();
	//根据id获取商品
	public Product findProduct (String pro_id);
	 //查询数据，返回一个QueryResult对象
	 QueryBean pageQuery(int startindex, int pagesize);
}
