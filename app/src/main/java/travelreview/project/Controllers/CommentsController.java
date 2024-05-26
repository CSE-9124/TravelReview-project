package travelreview.project.Controllers;
import travelreview.project.Config.DbConfig;
import travelreview.project.Models.Comment;
import java.util.ArrayList;
import java.util.List;

public class CommentsController extends DbConfig {
    // CREATE
    public static boolean addComment(String text, int userId, int travelDestinationId, int star) {
        query = "INSERT INTO comments (text, user_id, travel_destination_id, star) VALUES (?, ?, ?, ?)";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, text);
            preparedStatement.setInt(2, userId);
            preparedStatement.setInt(3, travelDestinationId);
            preparedStatement.setInt(4, star);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // READ
    public static List<Comment> getAllCommentsByTravelDestinationId(int travelDestinationId) {
        List<Comment> comments = new ArrayList<>();
        query = "SELECT * FROM comments WHERE travel_destination_id=?";
        try {
            getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, travelDestinationId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String text = resultSet.getString("text");
                int userId = resultSet.getInt("user_id");
                int star = resultSet.getInt("star");
                // Fill the comment
                Comment comment = new Comment(id, text, userId, travelDestinationId, star);
                comments.add(comment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }
}