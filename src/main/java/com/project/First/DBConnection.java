package com.project.First;


import java.sql.Connection;
import java.sql.DriverManager;

import static com.project.First.DBInfo.*;
public class DBConnection{
	
		private static Connection con;
		
		private DBConnection() {}
	
	static {
		try {
			//loading Driver
			Class.forName(driver);
			// Conection Stablishtesd
			con=DriverManager.getConnection(url,user,pWord);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
		public static Connection getCon() {
			return con;
		}

	}
		
	
