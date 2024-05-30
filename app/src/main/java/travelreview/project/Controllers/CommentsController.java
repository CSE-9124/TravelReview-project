package travelreview.project.Controllers;
import travelreview.project.Config.DbConfig;
import travelreview.project.Models.Comment;
import java.util.ArrayList;
import java.util.List;

public class CommentsController extends DbConfig {
    // CREATE
    public static boolean addComment(String text, int userId, int tempatWisataId, int rating) {
        query = "INSERT INTO comments (komentar, user_id, tempat_wisata_id, rating) VALUES (?, ?, ?, ?)";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, text);
            preparedStatement.setInt(2, userId);
            preparedStatement.setInt(3, tempatWisataId);
            preparedStatement.setInt(4, rating);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // READ
    public static List<Comment> getAllCommentsByTempatWisataId(int tempatWisataId) {
        List<Comment> comments = new ArrayList<>();
        query = "SELECT * FROM comments WHERE tempat_wisata_id=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, tempatWisataId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String text = resultSet.getString("komentar");
                int userId = resultSet.getInt("user_id");
                int rating = resultSet.getInt("rating");
                // Fill the comment
                Comment comment = new Comment(id, text, userId, tempatWisataId, rating);
                comments.add(comment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }
}