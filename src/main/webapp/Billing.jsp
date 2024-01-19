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
int qyt=(int)request.getAttribute("qyt");


ProductBean pb=(ProductBean)request.getAttribute("pb");

%>
<form action="Paybill" method="post">
<table>	
		<tr>
			<td>Code</td>
			<td><%=pb.getpCode() %><input type="hidden" name="pcode" value=<%=pb.getpCode() %>></td>
		</tr>
		<tr>
			<td>Product Name</td>
			<td><%=pb.getpName() %></td>
		</tr>
		<tr>
			<td>Price</td>
			<td><%=pb.getPrice() %></td>
		</tr>
		<tr>
			<td>Quentity</td>
			<td><%=qyt %><input type="hidden" name="qyt" value=<%=qyt %>></td>
		</tr>
		
		<tr>
			<td>Total Pay Amount</td>
			<td><%=qyt*pb.getPrice() %></td>
		</tr>
		<tr>
			<td><button value="submit"  >PayBill</button></td>
			
		</tr>
	</table>
	</form>
</body>
</html>