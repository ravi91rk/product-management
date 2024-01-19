package com.project.First;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class CustomerLoginDAO {
	
	public CustomerBean cb=null;
	
	public CustomerBean getDetails(HttpServletRequest req){
		
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("select * from CustomerDetails where UNAME=? AND PWROD=?");
			ps.setString(1, req.getParameter("uname"));
			ps.setString(2, req.getParameter("pword"));
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				cb=new CustomerBean();
				cb.setFName(rs.getString(3));
				cb.setLName(rs.getString(5));
				cb.setAddr(rs.getString(6));
				cb.setMid(rs.getString(7));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return cb;
	}
	

}
