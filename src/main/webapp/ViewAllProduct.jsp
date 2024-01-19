<%@page import="java.util.*"%>
<%@page import="com.project.First.UserBean"%>
<%@page import="com.project.First.*"%>
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
UserBean ub=(UserBean)session.getAttribute("ubean");
ArrayList<ProductBean> al=(ArrayList<ProductBean>)session.getAttribute("viewallbook");
out.println("Welcome to "+ub.getFname());
if(al.size()==0){
	out.println("Product is not availeble...!");
}
else {
	Iterator<ProductBean> itr=al.iterator();
	while(itr.hasNext()){
		ProductBean pb= (ProductBean)itr.next();
		out.println(pb.getpCode()+"&nbsp&nbsp"+
		pb.getpName()+"&nbsp&nbsp"+pb.getPrice()+"&nbsp&nbsp"+pb.getQyt()+
		"<a href='editProduct?pcode="+pb.getpCode()+"'>Edit</a>"+
		"&nbsp&nbsp"+
		"<a href='deleteProduct?pcode="+pb.getpCode()+"'>Delete</a>"+"</br>");   
		
		
	}
	
}
%>
<a href=Product.html>AddProduct</a>
<a href=logout>LogOut</a>
</body>
</html>