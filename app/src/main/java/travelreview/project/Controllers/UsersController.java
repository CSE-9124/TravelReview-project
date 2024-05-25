package travelreview.project.Controllers;

import java.sql.ResultSet;

import travelreview.project.Config.DbConfig;
import travelreview.project.Models.User;

public class UsersController extends DbConfig {
    // Method login yang mengembalikan role user
    public static User login(String email, String password) {
        query = "SELECT * FROM users WHERE email=? AND password=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(0, email);
            preparedStatement.setString(1, password);
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
                    int age = resultSet.getInt("age");

                    User user = new User(id, username, name, phoneNumber, email, role, age);

                    return user;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
