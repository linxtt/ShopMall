package com.lin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	// �������ݿ������Ϣ�ĳ���
		private static final String DRIVER = "com.mysql.jdbc.Driver";
		private static final String URL = "jdbc:mysql://127.0.0.1:3306/shopmall?useUnicode=true&characterEncoding=utf-8";
		private static final String USER = "root";
		private static final String PASSWORD = "linxtt";
		private static PreparedStatement ps = null;
		private static ResultSet rs = null;
		private static Connection ct = null;

		// 1.�����������ŵ���̬�����
		static {
			// 1.����������Ҫ����mysql������
			try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 2.�������
		public static Connection getConnection() {
			// 2.�������
			Connection ct = null;
			try {
				ct = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return ct;
		}
		
		// ��дһ����ѯ���ݿ�ķ��������ص���ResultSet
		public static ResultSet executeQuery(String sql) {
			try {
				ct = getConnection();
				ps = ct.prepareStatement(sql);
				

				// 4.����sql���
				rs = ps.executeQuery();
				// 5.�����صĽ��
				// ���������ݿ��в�ѯ���Ľ��
				return rs;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return null;
		}
		
		// ��дһ����ѯ���ݿ�ķ��������ص���ResultSet
		public static ResultSet executeQuery(String sql, String[] info) {
			try {
				ct = getConnection();
				ps = ct.prepareStatement(sql);
				// ����ռλ��������
				if (info != null) {
					for (int i = 0; i < info.length; i++) {
						ps.setString(1 + i, info[i]);
					}
				}

				// 4.����sql���
				rs = ps.executeQuery();
				// 5.�����صĽ��
				// ���������ݿ��в�ѯ���Ľ��
				return rs;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return null;
		}
		
		// ����executeQuery���� �����Դ���int���͵����飬���ص���ResultSet
				public static ResultSet executeQuery(String sql, int[] info) {
					try {
						ct = getConnection();
						ps = ct.prepareStatement(sql);
						// ����ռλ��������
						if (info != null) {
							for (int i = 0; i < info.length; i++) {
								ps.setInt(1 + i, info[i]);
							}
						}

						// 4.����sql���
						rs = ps.executeQuery();
						// 5.�����صĽ��
						// ���������ݿ��в�ѯ���Ľ��
						return rs;

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					return null;
				}
			
		
		// 3.����ɾ���ģ���������ݿⷢ��sql���Ķ���:���ص���һ��statement���󣬵�����ʵ�ʿ����в�����������ΪStatement��һע��©��
		public static int executeUpdate(String sql, String[] info) {
			try {
				ct = getConnection();
				ps = ct.prepareStatement(sql);
				// ����ռλ��������
				if (info != null) {
					for (int i = 0; i < info.length; i++) {
						ps.setString(1 + i, info[i]);
					}
				}

				// 4.����sql���
				int in = ps.executeUpdate();
				// 5.�����صĽ��
				if (in != 0) {
					System.out.println("�����ɹ���������" + in + "����¼����");
				} else {
					System.out.println("����ʧ�ܣ���");
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

		// 6.��װһ���ر���Դ�ķ���
		public static void close(Connection ct, PreparedStatement ps, ResultSet rs) {
			// 6.�ر���Դ
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
