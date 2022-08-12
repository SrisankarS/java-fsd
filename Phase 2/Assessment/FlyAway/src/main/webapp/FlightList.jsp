<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.*"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight List</title>
</head>
<body>
	<br>
	<a href=HomePage.jsp
		style="color: black; text-decoration: none; font-size: 35px; font-weight: bold;">FlyAway</a>
	<br>
	<br>
	<%
	@SuppressWarnings("unchecked")
	List<String[]> flights = (List<String[]>) session.getAttribute("flights");
	if (flights != null) {
	%>

	<h1>Available Flights</h1>

	<center>
		<table border="1">
			<tr>
				<th>Name</th>
				<th>Time</th>
				<th>Price</th>
				<th>Action</th>
			</tr>



			<%
			for (String[] flight : flights) {
			%>

			<tr>
				<td><%=flight[0]%></td>
				<td><%=flight[1]%></td>
				<td><%=flight[2]%></td>
				<%
					String redirectURL="UserPage.jsp";
					@SuppressWarnings("unchecked")
					HashMap<String, String> user = (HashMap<String, String>) session.getAttribute("user");
					if (user != null)
	
					 redirectURL ="Payment.jsp?name="+user.get("name")+"&flight="+flight[0]+"&price="+flight[2];
				%>
				<td><a href="<%=redirectURL%>">Book Now</a></td>
			</tr>
			<%
			}
			%>
			
		</table>
	</center>


	<%
	} else {
	%>
	<h1>There are no available flights</h1>
	<%
	}
	%>
</body>
</html>