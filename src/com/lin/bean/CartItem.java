package com.lin.bean;
/*
 * 代表当前商品及出现的次数
 * */
public class CartItem {
	private Product product;
	//数量
	private int quantity;
	//价格
	private double price;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return product.getPro_Price()*this.quantity;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
