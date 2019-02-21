package com.lin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lin.bean.Users;
import com.lin.service.UsersService;
import com.lin.service.impl.UsersServiceImpl;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
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
		// TODO Auto-generated method stub
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				
				// 得到用户输入的所有信息
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String name = request.getParameter("name");
				String phone = request.getParameter("phone");
				String address = request.getParameter("address");
				String email = request.getParameter("email");
				String inputcode = request.getParameter("inputCode");
				System.out.println("输入的用户名：" + username);
				System.out.println("输入的用密码：" + password);
				System.out.println("输入的姓名：" + name);
				System.out.println("输入的手机号码：" + phone);
				System.out.println("输入的地址：" + address);
				System.out.println("输入的邮箱：" + email);
				System.out.println("输入的验证码：" + inputcode);
				Users inputUser = new Users(username,password,name,phone,address,email);
				System.out.println(inputUser.toString());
				HttpSession session = request.getSession();
				String sesscode = (String) session.getAttribute("sesscode");
				UsersService us = new UsersServiceImpl();
				//判斷驗證码不爲空進行 
				if(sesscode != null) {
					if (sesscode.equalsIgnoreCase(inputcode)) {
						boolean b =  us.regUser(inputUser);
						System.out.println(b);
						if(b){
							String success = "注册成功！";
							request.setAttribute("success", success);
							//response.sendRedirect("/ShopMall/jsp/registsuccess.jsp");
							request.getRequestDispatcher("jsp/registsuccess.jsp").forward(request, response);
						}else{
							String error ="111";
							request.setAttribute("error", error);
							request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
						}
					}else {
						String error ="222";
						request.setAttribute("error", error);
						request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
					}
				}
	}
}
