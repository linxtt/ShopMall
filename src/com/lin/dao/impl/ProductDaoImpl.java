package com.lin.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lin.bean.Product;
import com.lin.bean.QueryBean;
import com.lin.dao.ProductDao;
import com.lin.service.impl.ProductServiceImpl;
import com.lin.util.JDBCUtil;
import com.lin.util.ShopCartUtil;

public class ProductDaoImpl implements ProductDao{

	@Override
	public Map getAllProduct() {
		// TODO Auto-generated method stub
		return ShopCartUtil.getAllProduct();
	}

	@Override
	public Product findProduct(String pro_id) {
		// TODO Auto-generated method stub
		return ShopCartUtil.getAllProduct().get(pro_id);
	}

	@Override
	public QueryBean pageQuery(int startindex, int pagesize) {
		// 获取页面数据（查询条数与总记录数）
		ResultSet rs = null;
		QueryBean qb = new QueryBean();
		try {
			String sql = "select * from product limit ?,?";
			int info[] = {startindex,pagesize};
			rs = JDBCUtil.executeQuery(sql, info);
			List<Product> list = new ArrayList<Product>();
			while(rs.next()) {
				Product p = new Product();
				p.setPro_Id(rs.getString("pro_Id"));
				p.setPro_Num(rs.getString("pro_Num"));
				p.setPro_Name(rs.getString("pro_Name"));
				p.setPro_Price(rs.getDouble("pro_Price"));
				p.setImgPath(rs.getString("imgPath"));
				p.setPro_Desc(rs.getString("pro_Desc"));
				System.out.println(p.toString());
				list.add(p);
			}
			qb.setList(list);
			sql = "select count(*) from product";
			rs = JDBCUtil.executeQuery(sql);
			if(rs.next()) {
				int count = rs.getInt(1);
				System.out.println("数据条数："+count );
				qb.setTatalrecord(count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return qb;
	}
	
	
}
