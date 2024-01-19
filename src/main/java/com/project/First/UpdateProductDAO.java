package com.project.First;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;

public class UpdateProductDAO {
	
	public int k=0;
	
	public int updateProduct(ProductBean pb) {
		
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("update projectproduct set PRICE=? , QUANTITY=? where  CODE=?");
			ps.setFloat(1, pb.getPrice());
			ps.setInt(2,pb.getQyt());
			ps.setString(3, pb.getpCode());
			k=ps.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return k;
	}

}
