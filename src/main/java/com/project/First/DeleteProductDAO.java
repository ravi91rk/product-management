package com.project.First;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

public class DeleteProductDAO {
	
	public int k=0;
	
	public int deleteProduct(HttpServletRequest req) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("delete from projectproduct where CODE=?");
			ps.setString(1,req.getParameter("pcode"));
			k=ps.executeUpdate();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return k;
	}

}
