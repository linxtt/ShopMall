package com.lin.dao;

import com.lin.bean.Users;

public interface UsersDao {
	//�û���¼���� (��ѯ�û��Ƿ���ڣ���������򷵻��û���Ϣ���������򷵻�һ��null)
	 Users getUserByName(String username);//��дһ�����󷽷� 
	 
	 //�����û���Ϣ
	 int regUser(Users user);
	
	
}
