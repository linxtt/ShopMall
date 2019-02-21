package com.lin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	// 定义数据库基本信息的常量
		private static final String DRIVER = "com.mysql.jdbc.Driver";
		private static final String URL = "jdbc:mysql://127.0.0.1:3306/shopmall?useUnicode=true&characterEncoding=utf-8";
		private static final String USER = "root";
		private static final String PASSWORD = "linxtt";
		private static PreparedStatement ps = null;
		private static ResultSet rs = null;
		private static Connection ct = null;

		// 1.将加载驱动放到静态代码块
		static {
			// 1.加载驱动：要导入mysql驱动包
			try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 2.获得链接
		public static Connection getConnection() {
			// 2.获得链接
			Connection ct = null;
			try {
				ct = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return ct;
		}
		
		// 编写一个查询数据库的方法，返回的是ResultSet
		public static ResultSet executeQuery(String sql) {
			try {
				ct = getConnection();
				ps = ct.prepareStatement(sql);
				

				// 4.发送sql语句
				rs = ps.executeQuery();
				// 5.处理返回的结果
				// 遍历从数据库中查询到的结果
				return rs;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return null;
		}
		
		// 编写一个查询数据库的方法，返回的是ResultSet
		public static ResultSet executeQuery(String sql, String[] info) {
			try {
				ct = getConnection();
				ps = ct.prepareStatement(sql);
				// 处理占位符的问题
				if (info != null) {
					for (int i = 0; i < info.length; i++) {
						ps.setString(1 + i, info[i]);
					}
				}

				// 4.发送sql语句
				rs = ps.executeQuery();
				// 5.处理返回的结果
				// 遍历从数据库中查询到的结果
				return rs;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return null;
		}
		
		// 重载executeQuery方法 ，可以处理int类型的数组，返回的是ResultSet
				public static ResultSet executeQuery(String sql, int[] info) {
					try {
						ct = getConnection();
						ps = ct.prepareStatement(sql);
						// 处理占位符的问题
						if (info != null) {
							for (int i = 0; i < info.length; i++) {
								ps.setInt(1 + i, info[i]);
							}
						}

						// 4.发送sql语句
						rs = ps.executeQuery();
						// 5.处理返回的结果
						// 遍历从数据库中查询到的结果
						return rs;

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					return null;
				}
			
		
		// 3.增，删，改，获得向数据库发送sql语句的对象，:返回的是一个statement对象，但是在实际开发中不能用它，因为Statement有一注入漏洞
		public static int executeUpdate(String sql, String[] info) {
			try {
				ct = getConnection();
				ps = ct.prepareStatement(sql);
				// 处理占位符的问题
				if (info != null) {
					for (int i = 0; i < info.length; i++) {
						ps.setString(1 + i, info[i]);
					}
				}

				// 4.发送sql语句
				int in = ps.executeUpdate();
				// 5.处理返回的结果
				if (in != 0) {
					System.out.println("操作成功，作用了" + in + "条记录！！");
				} else {
					System.out.println("操作失败！！");
				}
				return in;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close(ct, ps, null);
			}
			return 0;

		}
		
		public static Connection getCt(){
			return ct;
		}
		public static PreparedStatement getPs(){
			return ps;
		}

		// 6.封装一个关闭资源的方法
		public static void close(Connection ct, PreparedStatement ps, ResultSet rs) {
			// 6.关闭资源
			try {
				if (rs != null) {
					rs.close();
				}
				rs = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (ps != null) {
					ps.close();
				}
				ps = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (ct != null) {
					ct.close();
				}
				ct = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
