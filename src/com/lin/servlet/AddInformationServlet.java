package com.lin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddInformationServlet
 */
@WebServlet("/AddInformationServlet")
public class AddInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInformationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		//Éú³É¶©µ¥±àºÅ
		int orderNumber = (int)(Math.random()*10000000);
		request.getSession().setAttribute("name", name);
		request.getSession().setAttribute("phone", phone);
		request.getSession().setAttribute("address", address);
		request.getSession().setAttribute("orderNumber", orderNumber);
		if(name!=null||address!=null||phone!=null) {
			request.getRequestDispatcher("/jsp/order.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/jsp/information.jsp").forward(request, response);
		}
		
	}

}
