package com.lin.service;

import java.util.Map;

import com.lin.bean.Cart;
import com.lin.bean.PageBean;
import com.lin.bean.Product;
import com.lin.bean.QueryInfo;

public interface ProductService {
		//获取所有商品
		public Map getAllProduct();
		//根据id获取商品
		public Product findProduct (String pro_id);
		//购买商品
		public void buyPorduct(String pro_id,Cart cart);
		//删除商品
		public void deletePorduct(String pro_id,Cart cart);
		//清空商品
		public void clearPorduct(Cart cart);
		
		PageBean pageQuery (QueryInfo queryInfo);
}
