package com.lin.bean;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 * ���ﳵ
 * */
public class Cart {
	private Map<String,CartItem> productMap = new LinkedHashMap<>();
	//���ﳵ���ܼ�
	private double total;
	
	//ʵ�ֹ��ﳵ����
	public void addProduct(Product product) {
		CartItem cartItem = productMap.get(product.getPro_Id());
		//�жϹ��ﳵ�Ƿ���ڹ�����
		if(cartItem == null) {
			//�����ڣ������ù���Ķ���
			cartItem = new CartItem();
			//���빺����
			cartItem.setProduct(product);
			//����������Ϊ1
			cartItem.setQuantity(1);
			//���뵽���ﳵ
			productMap.put(product.getPro_Id(), cartItem);
		}else {
			//���ڹ�������ﳵ����+1
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
