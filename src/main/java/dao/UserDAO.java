package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.User;
import utils.Database;

public class UserDAO {
	
	public static User getUser(int id) {
		try {
			
			String query = "SELECT * FROM Users WHERE userId = ?";
			Object[] values = new Object[1];
			values[0] = id;
			ResultSet resultSet = Database.queryDB(query, values);
			
			User user = new User(
					resultSet.getInt("userId"),
					resultSet.getString("username"),
					resultSet.getString("passwd"),
					"", "", "",
					resultSet.getBoolean("is_admin"));
			
			String name = resultSet.getString("nom"), surname = resultSet.getString("prenom"), email = resultSet.getString("email");
			
			if (name != null && !name.isEmpty()) user.setName(name);
			
			if (surname != null && !surname.isEmpty()) user.setSurname(surname);
			
			if (email != null && !email.isEmpty()) user.setEmail(email);
			
			return user;
			
		} catch(SQLException ex) {
			ex.printStackTrace();			
			return null;
		}
	}
	
	public static User getUser(String username) {
		try {
			
			String query = "SELECT * FROM Users WHERE username = ?";
			Object[] values = new Object[1];
			values[0] = username;
			ResultSet resultSet = Database.queryDB(query, values);
			
			User user = new User(
					resultSet.getInt("userId"),
					resultSet.getString("username"),
					resultSet.getString("passwd"),
					"", "", "",
					resultSet.getBoolean("is_admin"));
			
			String name = resultSet.getString("nom"), surname = resultSet.getString("prenom"), email = resultSet.getString("email");
			
			if (!name.isEmpty()) user.setName(name);
			
			if (!surname.isEmpty()) user.setSurname(surname);
			
			if (!email.isEmpty()) user.setEmail(email);
			
			return user;
			
		} catch(SQLException ex) {
			ex.printStackTrace();			
			return null;
		}
	}
	
	public static boolean add(User user) {
		if (user == null) return false;
		
		String query = "INSERT INTO Users(username, passwd, nom, prenom, email, is_admin) VALUES (?, ?, ?, ?, ?, ?)";
		
		Object[] values = new Object[6];
		values[0] = user.getUsername();
		values[1] = user.getPassword();
		values[2] = user.getName();
		values[3] = user.getSurname();
		values[4] = user.getEmail();
		values[5] = user.isAdmin();
		
		return Database.updateDB(query, values);
	}
	
	public static boolean update(User user) {
		if (user == null) return false;
		
		String query = "UPDATE Users SET username = ?, passwd = ?, nom = ?, prenom = ?, email = ?, is_admin = ? WHERE userId = ?";
		
		Object[] values = new Object[7];
		values[0] = user.getUsername();
		values[1] = user.getPassword();
		values[2] = user.getName();
		values[3] = user.getSurname();
		values[4] = user.getEmail();
		values[5] = user.isAdmin();
		values[6] = user.getId();
		
		return Database.updateDB(query, values);
	}
	
	public static boolean delete(User user) {
		if (user == null) return false;
		
		String query = "DELETE FROM Users WHERE userId = ?";
		
		Object[] values = new Object[1];
		values[0] = user.getId();
		
		return Database.updateDB(query, values);
	}
	
	public static ArrayList<User> listUsers() {
		try {
			
			String query = "SELECT * FROM Users";
			ResultSet resultSet = Database.queryDB(query);

            ArrayList<User> users = new ArrayList<User>();
            User user = null;
			
			while (resultSet.next()) {
                user = new User(
					resultSet.getInt("id"),
					resultSet.getString("username"),
					resultSet.getString("passwd"),
					"", "", "",
					resultSet.getBoolean("is_admin"));
			
                String name = resultSet.getString("nom"), surname = resultSet.getString("prenom"), email = resultSet.getString("email");
                
                if (!name.isEmpty()) user.setName(name);
                
                if (!surname.isEmpty()) user.setSurname(surname);
                
                if (!email.isEmpty()) user.setEmail(email);

                users.add(user);

                user = null;
            }

            return users;
			
		} catch(SQLException ex) {
			ex.printStackTrace();			
			return null;
		}
	}

    public static boolean authenticate(User user) {
        if (user == null) return false;

        String username = user.getUsername(), password = user.getPassword();
        String usernameDB = "", passwordDB = "";

        ArrayList<User> users = new ArrayList<User>();
        users = UserDAO.listUsers();
        if (users == null) return false;

        for (User userDB : users) {
            usernameDB = userDB.getUsername();
            passwordDB = userDB.getPassword();

            if (username.equals(usernameDB) && password.equals(passwordDB)) {
                return true;
            }
        }

        return false;
    }
	
}
