package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Photo;
import utils.Database;

public class PhotoDAO {

    public static Photo getPhoto(int id) {
		try {
			
			String query = "SELECT * FROM Photos WHERE photoId = ?";
			Object[] values = new Object[1];
			values[0] = id;
			
			Connection conn = Database.newConnection();
			ResultSet resultSet = Database.queryDB(conn, query, values);
			
			Photo photo = new Photo(
					resultSet.getInt("photoId"),
					resultSet.getString("filepath"),
					"",
					resultSet.getInt("hauteur"),
					resultSet.getInt("largeur"),
					resultSet.getTimestamp("created_at"),
					resultSet.getTimestamp("updated_at"),
					resultSet.getInt("albumId"));
			
			String bio = resultSet.getString("bio");
						
			if (bio != null && !bio.isEmpty()) photo.setBio(bio);

			conn.close();
			
			return photo;
			
		} catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
    
	public static ArrayList<Photo> getAllPhotos() {
		try {
			
			String query = "SELECT * FROM Photos";
			
			Connection conn = Database.newConnection();
			ResultSet resultSet = Database.queryDB(conn, query);

			ArrayList<Photo> photos = new ArrayList<Photo>();
			Photo photo = null;
			
			while (resultSet.next()) {
				photo = new Photo(
						resultSet.getInt("photoId"),
						resultSet.getString("filepath"),
						"",
						resultSet.getInt("hauteur"),
						resultSet.getInt("largeur"),
						resultSet.getTimestamp("created_at"),
						resultSet.getTimestamp("updated_at"),
						resultSet.getInt("albumId"));
				
				String bio = resultSet.getString("bio");
							
				if (bio != null && !bio.isEmpty()) photo.setBio(bio);

				photos.add(photo);
			}

			conn.close();
			
			return photos;
			
		} catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

    public static boolean add(Photo photo) {
		if (photo == null) return false;
		
		try {
			
			Connection conn = Database.newConnection();
	
			String query = "INSERT INTO Photos(filepath, bio, hauteur, largeur, albumId) VALUES (?, ?, ?, ?, ?)";
			
			Object[] values = new Object[5];
			values[0] = photo.getFilepath();
			values[1] = photo.getBio();
			values[2] = photo.getHauteur();
			values[3] = photo.getLargeur();
			values[4] = photo.getAlbumId();
			
			boolean update = Database.updateDB(conn, query, values);

			conn.close();

			return update;

		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
    public static boolean update(Photo photo) {
		if (photo == null) return false;
		
		try {

			Connection conn = Database.newConnection();

			String query = "UPDATE Photos SET filepath = ?, bio = ?, hauteur = ?, largeur = ?, albumId = ? WHERE photoId = ?";
			
			Object[] values = new Object[6];
			values[0] = photo.getFilepath();
			values[1] = photo.getBio();
			values[2] = photo.getHauteur();
			values[3] = photo.getLargeur();
			values[4] = photo.getAlbumId();
			values[5] = photo.getId();
			
			boolean update = Database.updateDB(conn, query, values);

			conn.close();

			return update;

		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(Photo photo) {
		if (photo == null) return false;
		
		try {

			Connection conn = Database.newConnection();

			String query = "DELETE FROM Photos WHERE photoId = ?";
			
			Object[] values = new Object[1];
			values[0] = photo.getId();
			
			boolean update = Database.updateDB(conn, query, values);

			conn.close();

			return update;

		} catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
