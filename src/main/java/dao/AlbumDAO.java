package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Album;
import utils.Database;

public class AlbumDAO {

    public static Album getAlbum(int id) {
		try {
			
			String query = "SELECT * FROM Albums WHERE albumId = ?";
			Object[] values = new Object[1];
			values[0] = id;
			
			Connection conn = Database.newConnection();
			ResultSet resultSet = Database.queryDB(conn, query, values);
			
			Album album = new Album(
					resultSet.getInt("albumId"),
					resultSet.getString("theme"),
					resultSet.getInt("audience"),
					resultSet.getTimestamp("created_at"),
					resultSet.getTimestamp("updated_at"),
					resultSet.getInt("userId"));
			
			conn.close();
			
			return album;
			
		} catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static ArrayList<Album> getUserAlbums(int userId) {
		try {
			
			String query = "SELECT * FROM Albums WHERE userId = ?";
			Object[] values = new Object[1];
			values[0] = userId;
			
			Connection conn = Database.newConnection();
			ResultSet resultSet = Database.queryDB(conn, query, values);
			
			ArrayList<Album> albums = new ArrayList<Album>();
			
			while (resultSet.next()) {
				albums.add(new Album(
						resultSet.getInt("albumId"),
						resultSet.getString("theme"),
						resultSet.getInt("audience"),
						resultSet.getTimestamp("created_at"),
						resultSet.getTimestamp("updated_at"),
						resultSet.getInt("userId")));
			}
			
			conn.close();
			
			return albums;
			
		} catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public static ArrayList<Album> getUserAlbumsThemes(int userId) {
		try {
			
			String query = "SELECT albumId, theme FROM Albums WHERE userId = ?";
			Object[] values = new Object[1];
			values[0] = userId;
			
			Connection conn = Database.newConnection();
			ResultSet resultSet = Database.queryDB(conn, query, values);
						
			ArrayList<Album> albums = new ArrayList<Album>();
			
			while (resultSet.next()) {
				albums.add(new Album(
					resultSet.getInt("albumId"),
					resultSet.getString("theme")));
			}
			
			conn.close();
			
			return albums;
			
		} catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

    public static boolean add(Album album) {
		if (album == null) return false;
		
		try {
			
			Connection conn = Database.newConnection();
			
			String query = "INSERT INTO Albums(theme, audience, userId) VALUES (?, ?, ?)";
			
			Object[] values = new Object[3];
			values[0] = album.getTheme();
			values[1] = album.getAudience();
			values[2] = album.getUserId();
			
			conn.close();
			
			return Database.updateDB(conn, query, values);
			
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
    public static boolean update(Album album) {
		if (album == null) return false;
		
		try {
			
			Connection conn = Database.newConnection();
			
			String query = "UPDATE albums SET theme = ?, audience = ?, userId = ? WHERE albumId = ?";
			
			Object[] values = new Object[4];
			values[0] = album.getTheme();
			values[1] = album.getAudience();
			values[2] = album.getUserId();
			values[3] = album.getId();
			
			conn.close();
			
			return Database.updateDB(conn, query, values);
			
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(Album album) {
		if (album == null) return false;
		
		try {
			Connection conn = Database.newConnection();
			
			String query = "DELETE FROM Albums WHERE albumId = ?";
			
			Object[] values = new Object[1];
			values[0] = album.getId();
			
			conn.close();
			
			return Database.updateDB(conn, query, values);
		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
