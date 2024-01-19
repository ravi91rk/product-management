package com.project.First;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

public class PayBillDAO {
	public int k=0;
	
	public int papBill(HttpServletRequest req) {
		
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("Update projectproduct set QUANTITY=? where CODE=?");
			ps.setString(2, req.getParameter("pcode"));
			ps.setInt(1, Integer.parseInt(req.getParameter("qyt")));
			
			k=ps.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return k;
	}

}
