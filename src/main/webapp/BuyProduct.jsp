<%@page import="com.project.First.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ProductBean pb=(ProductBean)request.getAttribute("pb");
out.println("Buy Product details "+"<br>");


%>
<form action="billing" method="post">
<table>
	<tr>
		<td>Name</td>
		<td><%=pb.getpName() %></td>
		<input type="hidden" name="pcode" value=<%=pb.getpCode() %>>
	</tr>
	<tr>
		<td>Price</td>
		<td><%=pb.getPrice() %></td>
	</tr>
	<tr>
		<td>Required qut:</td>
		<td><input type="number" name='qty'></td>
	</tr>
	<tr><td><button type="submit">Billing</button></td></tr>
	
	
</table>
</form>
</body>
</html>