package com.lin.service.impl;

import java.util.Map;

import com.lin.bean.Cart;
import com.lin.bean.PageBean;
import com.lin.bean.Product;
import com.lin.bean.QueryBean;
import com.lin.bean.QueryInfo;
import com.lin.dao.ProductDao;
import com.lin.dao.impl.ProductDaoImpl;
import com.lin.exception.ShopCartException;
import com.lin.service.ProductService;
import com.lin.util.ShopCartUtil;

public class ProductServiceImpl implements ProductService{
	 ProductDao productDao = new ProductDaoImpl() ;
	 ProductDaoImpl dao = new ProductDaoImpl();
	 
	@Override
	public  Map getAllProduct() {
		// TODO Auto-generated method stub
		return ShopCartUtil.getAllProduct();
	}

	@Override
	public Product findProduct(String pro_id) {
		return productDao.findProduct(pro_id);
	}

	@Override
	public void buyPorduct(String pro_id, Cart cart) {
		// TODO Auto-generated method stub
		Product product = productDao.findProduct(pro_id);
		cart.addProduct(product);
	}

	@Override
	public void deletePorduct(String pro_id, Cart cart) {
		// TODO Auto-generated method stub
		if(cart == null) {
			throw new ShopCartException("购物车为空！");
		}else {
			cart.getProductMap().remove(pro_id);
		}
		
	}

	@Override
	public void clearPorduct(Cart cart) throws ShopCartException {
		// TODO Auto-generated method stub
		if(cart == null) {
			throw new ShopCartException("购物车为空！");
		}else {
			cart.getProductMap().clear();
		}
	}

	@Override
	public PageBean pageQuery(QueryInfo queryInfo) {
		// TODO Auto-generated method stub
		int startindex =queryInfo.getStartindex();
		int pagesize = queryInfo.getPagesize();
		System.out.println("------------>"+startindex);
		System.out.println("++++++++++++>"+pagesize);
		 QueryBean qr = dao.pageQuery(startindex, pagesize);
		//根据查询结果，生成页面显示属性数据
		
		 //往pageBean中封装数据
		 PageBean bean = new PageBean();
		 bean.setCurrentpage(queryInfo.getCurrentpage());//当前页，用户会带过来的
		 bean.setList(qr.getList());//从查询结果里面获得
		 bean.setPagesize(queryInfo.getPagesize());//页面显示大小，用户会带过来
		 bean.setTotalrecord(qr.getTatalrecord());
		 return bean;
	}


	/*public static void main(String[] args) {
		ProductServiceImpl psi = null;
		Map<String,Product> o = psi.getAllProduct();
		for(Map.Entry<String, Product> a:o.entrySet()) {
			System.out.println("key:"+a.getKey()+",value:"+a.getValue());
		}
	}*/


}
