package edu.ap.jdbc;

import java.util.ArrayList;
import java.sql.*;

public class JDBConnection {
	
	private static JDBConnection instance = null;
	private Connection conn = null;
	
	private JDBConnection() {}
	
	public void openConnection(String database, String user, String pwd) {        

			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://127.0.0.1/" + database;
			    conn = DriverManager.getConnection (url, user, pwd);
			} 
			catch (Exception e) {
				System.out.println(e);
			}
	}
	
	public void closeConnection() {
		
		if (conn != null) {
			try {
				conn.close();
		     }
		     catch (SQLException ex) {
		    	 System.out.println("Error: " + ex);
		     }
		}
	}

	public static synchronized JDBConnection getJDBConnection() {
	
		if(instance == null) {
            instance = new JDBConnection();
        }
        return instance;
	}

	public void executeInsert(String sql) {
		
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		}
		catch(SQLException ex) {
			System.out.println("Error: " + ex);
		}
	}
	
	public ArrayList<String> selectAll(String sql) {
		
		ResultSet rs = null;
		ArrayList<String> result = new ArrayList<String>();
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				result.add(rs.getString(1) + ";" + rs.getString(2) + ";" + rs.getInt(3));
			}
			stmt.close();
		}
		catch(SQLException ex) {
			System.out.println("Error: " + ex);
		}
		
		return result;
	}
}
