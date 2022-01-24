package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	public static Connection newConnection() {
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost/webphotos";
		String username = "root";
		String password = "";
		
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver"); //loading mysql driver
			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();			
			}
			
			try {
				conn = DriverManager.getConnection(url, username, password);
			} catch (SQLException ex) {
				ex.printStackTrace();			
			}
			
		} catch(Exception ex) {
			ex.printStackTrace();		
		}
		
		return conn;
	}
	
	public static ResultSet queryDB(String query) {
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			
			conn = Database.newConnection();
			statement = conn.createStatement();
			
			resultSet = statement.executeQuery(query);
			
			conn.close();
			
			return resultSet;
			
		} catch(SQLException ex) {
			ex.printStackTrace();			
			return null;
		}
	}

	public static ResultSet queryDB(String query, Object[] values) {
		Connection conn = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			conn = Database.newConnection();
			pStatement = conn.prepareStatement(query);
			
			if ((values != null) && (values.length != 0)) {
				int index = 0;
				for (Object value : values) {
					pStatement.setObject(++index, value);
				}
			}
			
			resultSet = pStatement.executeQuery();
			
			conn.close();
			
			return resultSet;
			
		} catch(SQLException ex) {
			ex.printStackTrace();			
			return null;
		}
	}
	
	public static boolean updateDB(String query, Object[] values) {
		Connection conn = null;
		PreparedStatement pStatement = null;
		int success = 0;
		
		try {
			
			conn = Database.newConnection();
			pStatement = conn.prepareStatement(query);
			
			if ((values != null) && (values.length != 0)) {
				int index = 0;
				for (Object value : values) {
					pStatement.setObject(++index, value);
				}
			}
			
			success = pStatement.executeUpdate();
			
			conn.close();
			
			return (success > 0 ? true:false);
			
		} catch(SQLException ex) {
			ex.printStackTrace();			
			return false;
		}
	}
	
}
