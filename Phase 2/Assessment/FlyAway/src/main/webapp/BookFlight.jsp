<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway</title>
</head>
<body>
	<br>
	<a href=HomePage.jsp
		style="color: black; text-decoration: none; font-size: 35px; font-weight: bold;">FlyAway</a>
	<br>
	<br>

	<%
	@SuppressWarnings("unchecked")
	HashMap<String, String> user = (HashMap<String, String>) session.getAttribute("user");
	if (user == null) {
		response.sendRedirect("UserPage.jsp");
	}
	%>
	<p align="center"
		style="color: green; font-size: 40px; font-weight: bold">Flight
		Booked Successfully</p>
		<div align="center">
		
		<table>
      
      <tr>
          <td>Name:</td>
          <td><input type="text" name="name" value="${param.name}"disabled/></td>
      </tr>
      <tr>
         <td>Price:</td>
         <td><input type="text" name="price" value="${param.price}"disabled/></td>
       </tr>
       <tr>
          <td>Flight:</td>
          <td><input type="text" name="flight" value="${param.flight}"disabled/></td>
       </tr>
       <tr>
         <td>Card:</td>
         <td><input type="text" name="cardno" value="${param.cardno}"disabled/></td>
      </tr>
      <tr>
         <td>Country:</td>
         <td><input type="text" name="country" value="${param.country}"disabled/></td>
     </tr>
     
  </table>
  </div>
</body>
</html>
