package com.lin.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lin.bean.Product;
import com.lin.bean.QueryBean;
import com.lin.bean.Users;
import com.lin.dao.UsersDao;
import com.lin.util.JDBCUtil;



public class UsersDaoImpl implements UsersDao {

	@Override
	public Users getUserByName(String username) {
		/*String sql = "select * from user where username=?";
		String[] info = { username };
		ResultSet rs = JDBCUtil.executeQuery(sql, info);
		try {

			if (rs.next()) {
				// 如果查询到用户信息，则将其封装到Users对象中
				Users user = new Users();
				String name = rs.getString("username");// 从数据库中得到用户名
				String password = rs.getString("password");// 从数据库中得到密码
				user.setUsername(name);// 将用户名与密码赋值给user对象
				user.setPassword(password);
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		return null;
	}

	@Override
	public int regUser(Users user) {
		//注冊用戶
				String sql = "insert into user(username,password,name,phoneNumber,address,email) values(?,?,?,?,?,?)";
				String[] info = { user.getUsername(), user.getPassword(),user.getName(),user.getPhoneNumber(),user.getAddress(),user.getEmail() };
				int rs = JDBCUtil.executeUpdate(sql, info);

				return rs;
	}

	

}
