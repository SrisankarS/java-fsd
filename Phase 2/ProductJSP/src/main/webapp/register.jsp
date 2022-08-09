<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="" method="post">
	Enter Product ID: <input type="text" name="productid"/><br/>
	Enter Product Name: <input type="text" name="pname"/><br/>
	Enter Product Owner: <input type="text" name="powner"/><br/>
	Enter Quantity <input type="text" name="quantity"/><br/>
	<input type="submit" name="register" value="submit"/>
</form>
<%
	if(request.getParameter("register")!=null){%>
		<jsp:useBean id="product" class="com.jsp.Product" scope="request"></jsp:useBean>
		<jsp:setProperty property="*" name="product"/>
		<jsp:forward page="RegisterServlet"></jsp:forward>
	<%} 
%>
</body>
</html>