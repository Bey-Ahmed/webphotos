package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Photo;
import utils.Database;

public class PhotoDAO {

    public static Photo getPhoto(int id) {
		try {
			
			String query = "SELECT * FROM Photos WHERE photoId = ?";
			Object[] values = new Object[1];
			values[0] = id;
			ResultSet resultSet = Database.queryDB(query, values);
			
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
			
			return photo;
			
		} catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

    public static boolean add(Photo photo) {
		if (photo == null) return false;
		
		String query = "INSERT INTO Photos(filepath, bio, hauteur, largeur, albumId) VALUES (?, ?, ?, ?, ?)";
		
		Object[] values = new Object[5];
		values[0] = photo.getFilepath();
		values[1] = photo.getBio();
		values[2] = photo.getHauteur();
		values[3] = photo.getLargeur();
		values[4] = photo.getAlbumId();
		
		return Database.updateDB(query, values);
	}
	
    public static boolean update(Photo photo) {
		if (photo == null) return false;
		
		String query = "UPDATE Photos SET filepath = ?, bio = ?, hauteur = ?, largeur = ?, albumId = ? WHERE photoId = ?";
		
		Object[] values = new Object[6];
		values[0] = photo.getFilepath();
		values[1] = photo.getBio();
		values[2] = photo.getHauteur();
		values[3] = photo.getLargeur();
		values[4] = photo.getAlbumId();
		values[5] = photo.getId();
		
		return Database.updateDB(query, values);
	}
	
	public static boolean delete(Photo photo) {
		if (photo == null) return false;
		
		String query = "DELETE FROM Photos WHERE photoId = ?";
		
		Object[] values = new Object[1];
		values[0] = photo.getId();
		
		return Database.updateDB(query, values);
	}

}
