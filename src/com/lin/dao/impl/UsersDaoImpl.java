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
				// �����ѯ���û���Ϣ�������װ��Users������
				Users user = new Users();
				String name = rs.getString("username");// �����ݿ��еõ��û���
				String password = rs.getString("password");// �����ݿ��еõ�����
				user.setUsername(name);// ���û��������븳ֵ��user����
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
		//ע���Ñ�
				String sql = "insert into user(username,password,name,phoneNumber,address,email) values(?,?,?,?,?,?)";
				String[] info = { user.getUsername(), user.getPassword(),user.getName(),user.getPhoneNumber(),user.getAddress(),user.getEmail() };
				int rs = JDBCUtil.executeUpdate(sql, info);

				return rs;
	}

	

}
