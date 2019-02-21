package com.lin.service;

import java.util.Map;

import com.lin.bean.Cart;
import com.lin.bean.PageBean;
import com.lin.bean.Product;
import com.lin.bean.QueryInfo;

public interface ProductService {
		//��ȡ������Ʒ
		public Map getAllProduct();
		//����id��ȡ��Ʒ
		public Product findProduct (String pro_id);
		//������Ʒ
		public void buyPorduct(String pro_id,Cart cart);
		//ɾ����Ʒ
		public void deletePorduct(String pro_id,Cart cart);
		//�����Ʒ
		public void clearPorduct(Cart cart);
		
		PageBean pageQuery (QueryInfo queryInfo);
}
