package travelreview.project.Controllers;

import java.sql.ResultSet;

import travelreview.project.Config.DbConfig;
import travelreview.project.Models.User;

public class UsersController extends DbConfig {
    // CREATE
    public static boolean register(String username, String name, String email, String password) {
        query = "INSERT INTO users (username, name, email, password, role) VALUES (?, ?, ?, ?, ?)";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, "user");
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // READ
    // Method login yang mengembalikan role user
    public static User login(String email, String password) {
        query = "SELECT * FROM users WHERE email=? AND password=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            try (ResultSet userResult = preparedStatement.executeQuery()) {
                if (userResult.next()) {
                    int id = userResult.getInt("id");
                    String role = userResult.getString("role");

                    User user = new User(id, role);

                    return user;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // READ
    // Method untuk mengambil info user berdasarkan id
    public static User getUserById(int id) {
        query = "SELECT * FROM users WHERE id=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String name = resultSet.getString("name");
                    String phoneNumber = resultSet.getString("phone_number");
                    String email = resultSet.getString("email");
                    String role = resultSet.getString("role");
                    String imagePath = resultSet.getString("image_path");
                    int age = resultSet.getInt("age");

                    User user = new User(id, username, name, phoneNumber, email, role, imagePath, age);

                    return user;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // UPDATE
    public static boolean updateUser(int id, String username, String name, String phoneNumber, String email, String imagePath, int age) {
        query = "UPDATE users SET username=?, name=?, phone_number=?, email=?, age=?, image_path=? WHERE id=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, phoneNumber);
            preparedStatement.setString(4, email);
            preparedStatement.setInt(5, age);
            preparedStatement.setString(6, imagePath);
            preparedStatement.setInt(7, id);

            int affctRows = preparedStatement.executeUpdate();

            return affctRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
