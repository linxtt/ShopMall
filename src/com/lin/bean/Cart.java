package com.lin.bean;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * 购物车
 * */
public class Cart {
	private Map<String,CartItem> productMap = new LinkedHashMap<>();
	//购物车的总价
	private double total;
	
	//实现购物车功能
	public void addProduct(Product product) {
		CartItem cartItem = productMap.get(product.getPro_Id());
		//判断购物车是否存在购物项
		if(cartItem == null) {
			//不存在，创建该购物的对象
			cartItem = new CartItem();
			//存入购物项
			cartItem.setProduct(product);
			//购物数量设为1
			cartItem.setQuantity(1);
			//加入到购物车
			productMap.put(product.getPro_Id(), cartItem);
		}else {
			//存在购物项，购物车数量+1
			cartItem.setQuantity(cartItem.getQuantity()+1);
		}
	}
	
	public Map<String, CartItem> getProductMap() {
		return productMap;
	}
	public void setProductMap(Map<String, CartItem> productMap) {
		this.productMap = productMap;
	}
	public double getTotal() {
		double totalPrice = 0;
		for(Map.Entry<String, CartItem> map : productMap.entrySet()) {
			CartItem cartItem = map.getValue();
			totalPrice += cartItem.getPrice();
		}
		return totalPrice;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
