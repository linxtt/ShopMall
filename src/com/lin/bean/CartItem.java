package com.lin.bean;
/*
 * ����ǰ��Ʒ�����ֵĴ���
 * */
public class CartItem {
	private Product product;
	//����
	private int quantity;
	//�۸�
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
