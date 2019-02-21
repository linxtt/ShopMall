package com.lin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lin.bean.Cart;
import com.lin.service.impl.ProductServiceImpl;



/**
 * Servlet implementation class ShopCartServlet
 */
@WebServlet("/ShopCartServlet")
public class ShopCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopCartServlet() {
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
		String pro_id = request.getParameter("pro_id");
		
		//»á»°¸ú×Ù
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		
		if(cart == null){
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }else {
		ProductServiceImpl psi = new ProductServiceImpl();
		psi.buyPorduct(pro_id, cart);
		request.getRequestDispatcher("/jsp/shopcart.jsp").forward(request, response);
        }
	}
}
