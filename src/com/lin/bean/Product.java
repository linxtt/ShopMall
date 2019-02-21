package com.lin.bean;
/*
 * 商品类信息
 * */
public class Product {
	//商品id
	private String  pro_Id;
	//商品编号
	private String pro_Num;
	//商品名称
	private String pro_Name;
	//商品价格
	private double pro_Price;
	//商品图片路径
	private String imgPath;
	//商品描述
	private String pro_Desc;
	
	public Product() {
		super();
	}
	
	public Product(String pro_Id, String pro_Num, String pro_Name, Double pro_Price, String imgPath, String pro_Desc) {
		super();
		this.pro_Id = pro_Id;
		this.pro_Num = pro_Num;
		this.pro_Name = pro_Name;
		this.pro_Price = pro_Price;
		this.imgPath = imgPath;
		this.pro_Desc = pro_Desc;
	}

	public String getPro_Id() {
		return pro_Id;
	}

	public void setPro_Id(String pro_Id) {
		this.pro_Id = pro_Id;
	}

	public String getPro_Num() {
		return pro_Num;
	}

	public void setPro_Num(String pro_Num) {
		this.pro_Num = pro_Num;
	}

	public String getPro_Name() {
		return pro_Name;
	}

	public void setPro_Name(String pro_Name) {
		this.pro_Name = pro_Name;
	}

	public Double getPro_Price() {
		return pro_Price;
	}

	public void setPro_Price(Double pro_Price) {
		this.pro_Price = pro_Price;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getPro_Desc() {
		return pro_Desc;
	}

	public void setPro_Desc(String pro_Desc) {
		this.pro_Desc = pro_Desc;
	}

	@Override
	public String toString() {
		return "product [pro_Id=" + pro_Id + ", pro_Num=" + pro_Num + ", pro_Name=" + pro_Name + ", pro_Price="
				+ pro_Price + ", imgPath=" + imgPath + ", pro_Desc=" + pro_Desc + "]";
	}
	
	
	
}
