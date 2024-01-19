package com.project.First;
import static com.project.First.DBInfo.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class AddProductDAO {
	public int k=0;
	
	public int addProduct(ProductBean pb) {
		
		try {
			Class.forName(driver);
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("insert into  projectproduct values(?,?,?,?)");
			ps.setString(1, pb.getpCode());
			ps.setString(2, pb.getpName());
			ps.setFloat(3, pb.getPrice());
			ps.setInt(4, pb.getQyt());
			
			k=ps.executeUpdate();
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return k;
		
	}

}
