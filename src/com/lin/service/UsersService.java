package com.lin.service;

import com.lin.bean.Users;

public interface UsersService {
		//�û���¼�ķ��� 
		Users LoginUser(Users user);
		//ע���û��ķ��� 
		boolean regUser(Users user);
		
}
