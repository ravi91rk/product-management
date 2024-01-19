package com.project.First;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

public class CustomerRegisterDAO {
	
	public int k=0;
	
	public int insertData(HttpServletRequest req ) {
		
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("insert into CustomerDetails values(?,?,?,?,?,?,?)");
			ps.setString(1, req.getParameter("uname"));
			ps.setString(2, req.getParameter("pword"));
			ps.setString(3, req.getParameter("fname"));
			ps.setString(4, req.getParameter("lname"));
			ps.setString(5, req.getParameter("addr"));
			ps.setString(6, req.getParameter("mid"));
			ps.setLong(7, Long.parseLong(req.getParameter("phon")));
			
			k=ps.executeUpdate();
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return k;
	}

}
