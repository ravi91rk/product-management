<%@page import="com.project.First.ProductBean"%>
<%@page import="com.project.First.UserBean"%>
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
UserBean ub= (UserBean)session.getAttribute("ubean");

ProductBean pb=(ProductBean)request.getAttribute("data");
out.println("Welcome to "+ub.getFname()+"<br>");

%>

<form action="updateProduct"  method="post">
<input type="hidden" name="code" value=<%=pb.getpCode() %>>
ProductPrice:<input type="text" name ="price"value=<%=pb.getPrice() %>>
ProductQyt:<input type="text" name ="qyt"value=<%=pb.getQyt() %>>
<input type="submit" value="updateProduct">
</body>
</html>