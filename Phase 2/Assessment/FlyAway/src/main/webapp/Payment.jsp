<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<div align="center">
    <h1>Payment Check Out</h1>
    <br/>
    <form action="BookFlight.jsp" method="post">
    
    <table>
        <tr>
            <td>Card No:</td>
            <td><input type="number" name="cardno" value="" pattern='.{16}'/></td>
        </tr>
        <tr>
            <td>Expiry:</td>
            <td><input type="date" name="expirydate" value="" /></td>
        </tr>
        <tr>
            <td>CVC:</td>
            <td><input type="number" name="cvc" value="" pattern='.{3}'/></td>
        </tr>    
        <tr>
            <td>Country:</td>
            <td><input type="text" name="country" value="" /></td>
        </tr>    
        <tr>
            <td>ZIP:</td>
            <td><input type="number" name="zip" value="" pattern='.{4}'/></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Checkout" />
            </td>
        </tr>
        <tr>
            
            <td><input type="hidden" name="flight" value="${param.flight}" /></td>
        </tr>
        <tr>
         
         <td><input type="hidden" name="name" value="${param.name}"/></td>
       </tr>
      <tr>
         
         <td><input type="hidden" name="price" value="${param.price}" /></td>
       </tr>
    </table>
    </form>
</div>
</body>
</html>