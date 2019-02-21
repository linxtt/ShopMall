package com.lin.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lin.util.JDBCUtil;




/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// �õ��û�������û���������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("������û�����" + username);
		System.out.println("����������룺" + password);
		//�ж��ύ�����������Ƿ�Ϊ��
		if(username.equals("")&&username==null) {
			//��ת����½����
			response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
			return;
		}else {
			Connection conn = JDBCUtil.getConnection();
			String sql = "select * from user where username = ? and password =?";
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, username);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					System.out.println("��֤�ɹ���");
					//���浽session
					HttpSession session = request.getSession();
					session.setAttribute("username", username);
					session.setAttribute("password", password);
					//��ת
					response.sendRedirect("/ShopMall/jsp/index.jsp");
				}else {
					response.sendRedirect("/ShopMall/jsp/login.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*//����н��ܵ����ݣ�������֤
		if(username != null||password != null) {
			Users u = new Users();
			u.setUsername(username);
			UsersService us = new UsersServiceImpl();
			Users user = us.LoginUser(u);
			
			 * ����û���¼��֤��
			 * 1.���û���������ͬʱ��Ϊ����ȥ���ݿ�飬��������¼�ɹ������û�����¼ʧ�ܣ�����˼·������
			 * ���·�ʽ���Ǻ���ģ�
			 * 2.���û��������ݿ���ȥ��ѯ����ѯ�����ٷ������룬�ٽ��û���������������ݿ��ѯ�����������Ƚ�
			 
			if(user==null){
				System.out.println("��½ʧ�ܣ�");
				response.sendRedirect("/ShopMall/jsp/login.jsp");
			}else{
				//�����Ϊ�գ����û��������Ƚϣ�����ɹ�������session��cookie
				if(user.getPassword().equals(password)){
					HttpSession session = request.getSession();
					session.setAttribute("username", username);
					session.setAttribute("password", password);
					System.out.println("����ɹ���");
					request.setAttribute("username", user.getUsername());					
					response.sendRedirect("/ShopMall/jsp/index.jsp");
				}else{
					response.sendRedirect("/ShopMall/jsp/login.jsp");
				}
				
			}
		}*/
	}

}
