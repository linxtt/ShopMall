package com.lin.service;

import com.lin.bean.Users;

public interface UsersService {
		//用户登录的方法 
		Users LoginUser(Users user);
		//注册用户的方法 
		boolean regUser(Users user);
		
}
