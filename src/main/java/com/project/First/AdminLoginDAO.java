package com.project.First;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

public class AdminLoginDAO {
	
	public UserBean ub=null;
	
	public UserBean getAdminData(HttpServletRequest req ) {
		
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("select * from AdminUser where UNAME=? AND  PWORD=?");
			ps.setString(1, req.getParameter("uname"));
			ps.setString(2, req.getParameter("pword"));
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				ub=new UserBean();
				ub.setFname(rs.getString(3));
				ub.setLname(rs.getString(4));
				ub.setAddr(rs.getString(5));
				ub.setEmail(rs.getString(6));
				ub.setPhon(rs.getLong(7));
				
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return ub;
	}
	
	

}
