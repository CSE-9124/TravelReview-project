package travelreview.project.Models;

public class Comment {
    private int id;
    private String text;
    private int userId;
    private int travelDestinationId;
    private int star;

    // Constructor
    public Comment(int id, String text, int userId, int travelDestinationId, int star) {
        this.id = id;
        this.text = text;
        this.userId = userId;
        this.travelDestinationId = travelDestinationId;
        this.star = star;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getTravelDestinationId() { return travelDestinationId; }
    public void setTravelDestinationId(int travelDestinationId) { this.travelDestinationId = travelDestinationId; }

    public int getStar() { return star; }
    public void setStar(int star) { this.star = star; }
}