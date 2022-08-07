package com.productdetails;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Servlet implementation class SaveProduct
 */
public class SaveProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName  = request.getParameter("product_name");
		String productOwner = request.getParameter("product_owner");
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		Product product = new Product(productName, productOwner, quantity);
		Integer productId = saveProduct(product);
		RequestDispatcher rd = request.getRequestDispatcher("/ProductDetails?product_id="+productId);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	public Integer saveProduct(Product product){
		SessionFactory factory = ProductSessionFactory.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		Integer productId = null;
		try {
			tx = session.beginTransaction();
			productId = (Integer) session.save(product);
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		return productId;
	}

}
