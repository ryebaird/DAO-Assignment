package DAO_Interface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

	public class ConnectionDAO {
		
		static Connection con = null;
		protected PreparedStatement ps = null;
		protected ResultSet rs = null;
		
		public static Connection getConnection() throws ClassNotFoundException {
			final String  DBURL  = "jdbc:mariadb://localhost/demodb";
			final String DBUSERNAME = "root";
			final String  DBPASSWORD = "Password";
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				con = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
				System.out.println("Connected Database Successfully");
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return con;
		}
		
		public void disconnect() {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null)	con.close();
				
			} 
			catch (Exception e) {
					e.printStackTrace();
			}
			
		}
		
	}
