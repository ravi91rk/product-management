package com.project.First;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.project.First.DBInfo.*;

public class ViewproductDAO {
	
	public ArrayList<ProductBean> al =new ArrayList<ProductBean>();
	
	public ArrayList<ProductBean> viewData(){
		try {
			
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("select * from projectproduct");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ProductBean pb=new ProductBean();
				pb.setpCode(rs.getString(1));
				pb.setpName(rs.getString(2));
				pb.setPrice(rs.getFloat(3));
				pb.setQyt(rs.getInt(4));
				al.add(pb);
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}

}
