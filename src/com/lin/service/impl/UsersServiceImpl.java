package com.lin.service.impl;

import com.lin.bean.Users;
import com.lin.dao.UsersDao;
import com.lin.dao.impl.UsersDaoImpl;
import com.lin.service.UsersService;




public class UsersServiceImpl implements UsersService {
	
	@Override
	public Users LoginUser(Users user) {
		UsersDao dao = new UsersDaoImpl();
		return 	dao.getUserByName(user.getUsername());
	}

	@Override
	public boolean regUser(Users user) {
		UsersDao dao = new UsersDaoImpl();
		int  rs = dao.regUser(user);
		if(rs!=0){
			return true;
		}
		return false;
	}

	

}
