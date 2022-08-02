package com.productdetails;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductDetails
 */
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId=request.getParameter("product_id");
		
		try{  
			Integer.parseInt(productId);
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/productdetail","root",null);  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from product where product_id=" + productId);  
			int rowcount=0;
			while(rs.next()) {  
				rowcount++;
			
			response.getWriter().append(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+ rs.getInt(4)).append("\n");  
			}
			if(rowcount==0)
			{
				response.getWriter().append("No prodcut details where found for the product ID "+ productId );
			}
			con.close();  
			}catch(NumberFormatException e){ response.getWriter().append("Product ID is invalid, Enter a valid Product ID");}
		catch(Exception e){ response.getWriter().append(e.getMessage());  
			} 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
