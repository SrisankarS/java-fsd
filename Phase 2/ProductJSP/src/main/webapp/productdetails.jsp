<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "com.jsp.Product" %>
    <%
		Product p = (Product)session.getAttribute("product");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h3>Product Details</h3>
 <div>Product ID: <% out.print(p.getProductid()); %></div>
<div>Product Name: <% out.print(p.getPname()); %></div>
<div>Product Owner: <% out.print(p.getPowner()); %></div>
<div>Quantity: <% out.print(p.getQuantity()); %></div>
</html>