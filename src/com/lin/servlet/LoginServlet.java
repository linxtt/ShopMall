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
		
		// 得到用户输入的用户名与密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("输入的用户名：" + username);
		System.out.println("输入的用密码：" + password);
		//判断提交过来的数据是否为空
		if(username.equals("")&&username==null) {
			//跳转到登陆界面
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
					System.out.println("验证成功！");
					//保存到session
					HttpSession session = request.getSession();
					session.setAttribute("username", username);
					session.setAttribute("password", password);
					//跳转
					response.sendRedirect("/ShopMall/jsp/index.jsp");
				}else {
					response.sendRedirect("/ShopMall/jsp/login.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*//如果有接受到数据，进行验证
		if(username != null||password != null) {
			Users u = new Users();
			u.setUsername(username);
			UsersService us = new UsersServiceImpl();
			Users user = us.LoginUser(u);
			
			 * 完成用户登录验证：
			 * 1.将用户名与密码同时作为条件去数据库查，如果有则登录成功，如果没有则登录失败（这种思路不合理）
			 * 以下方式才是合理的：
			 * 2.将用户名到数据库中去查询，查询到后再返回密码，再将用户输入的密码与数据库查询到的密码作比较
			 
			if(user==null){
				System.out.println("登陆失败！");
				response.sendRedirect("/ShopMall/jsp/login.jsp");
			}else{
				//如果不为空，则将用户密码作比较，如果成功，保存session和cookie
				if(user.getPassword().equals(password)){
					HttpSession session = request.getSession();
					session.setAttribute("username", username);
					session.setAttribute("password", password);
					System.out.println("保存成功！");
					request.setAttribute("username", user.getUsername());					
					response.sendRedirect("/ShopMall/jsp/index.jsp");
				}else{
					response.sendRedirect("/ShopMall/jsp/login.jsp");
				}
				
			}
		}*/
	}

}
