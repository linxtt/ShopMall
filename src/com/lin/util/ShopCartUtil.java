package com.lin.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.lin.bean.Product;

/*
 * 获取商品
 * */
public class ShopCartUtil {
	private static Map<String,Product> promap = new LinkedHashMap<>();
	public static Map<String,Product> getAllProduct(){
		Connection conn = JDBCUtil.getConnection();
		String sql = "select * from product";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String pro_Id = rs.getString(1);
				String pro_Num = rs.getString(2);
				String pro_Name = rs.getString(3);
				Double pro_Price = rs.getDouble(4);
				String imgPath = rs.getString(5);
				String pro_Desc = rs.getString(6);
				promap.put(pro_Id,new Product(pro_Id, pro_Num, pro_Name, pro_Price, imgPath, pro_Desc));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return promap;
	}
	public static void main(String[] args) {
		Map<String,Product> o = getAllProduct();
		for(Map.Entry<String, Product> a:o.entrySet()) {
			System.out.println("key:"+a.getKey()+",value:"+a.getValue());
		}
	}
}
