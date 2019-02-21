package com.lin.dao;

import com.lin.bean.Users;

public interface UsersDao {
	//用户登录方法 (查询用户是否存在，如果存在则返回用户信息，不存在则返回一个null)
	 Users getUserByName(String username);//编写一个抽象方法 
	 
	 //保存用户信息
	 int regUser(Users user);
	
	
}
