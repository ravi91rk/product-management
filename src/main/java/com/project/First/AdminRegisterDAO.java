package com.project.First;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdminRegisterDAO {
	
	private int k=0;
	
	public int insertData(UserBean ub) {
		
		try{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("insert into AdminUser values(?,?,?,?,?,?,?)");
			ps.setString(1, ub.getUser());
			ps.setString(2, ub.getpWord());
			ps.setString(3, ub.getFname());
			ps.setString(4, ub.getLname());
			ps.setString(5, ub.getAddr());
			ps.setString(6, ub.getEmail());
			ps.setLong(7, ub.getPhon());
			
			k=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return k;
		
		
	}

}
