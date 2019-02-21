package com.lin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lin.bean.Cart;
import com.lin.exception.ShopCartException;
import com.lin.service.impl.ProductServiceImpl;

/**
 * �ӹ��ﳵ��ɾ����Ʒ
 */
@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductServlet() {
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
		String product_id = request.getParameter("product_id");
		 Cart cart = (Cart) request.getSession().getAttribute("cart");
		 try {
			 ProductServiceImpl psi = new ProductServiceImpl();
			 psi.deletePorduct(product_id, cart);
			 request.getRequestDispatcher("/jsp/shopcart.jsp").forward(request, response);
		 }catch (ShopCartException e){
			 System.out.println("error!");
	        }catch (Exception e){
	            e.printStackTrace();
	            System.out.println("error!");
	        }
	    }
		

}
