package com.lin.dao;

import java.util.Map;

import com.lin.bean.Product;
import com.lin.bean.QueryBean;

public interface ProductDao {
	//��ȡ������Ʒ
	public Map getAllProduct();
	//����id��ȡ��Ʒ
	public Product findProduct (String pro_id);
	 //��ѯ���ݣ�����һ��QueryResult����
	 QueryBean pageQuery(int startindex, int pagesize);
}
