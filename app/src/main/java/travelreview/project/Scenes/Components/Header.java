package travelreview.project.Scenes.Components;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import travelreview.project.Models.User;

public class Header {
    public HBox getHeader(User user) {
        // Label labelTitle = new Label("TravelReview");
        // labelTitle.setTextFill(Color.WHITE);
        // labelTitle.setFont(Font.font("Arial", FontWeight.BLACK, 30));
        // VBox vBoxTitle = new VBox(labelTitle);
        // vBoxTitle.setAlignment(Pos.CENTER);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        ImageView profileView = new ImageView();
        profileView.setFitWidth(35);
        profileView.setFitHeight(35);
        profileView.setPreserveRatio(true);
        profileView.setSmooth(true);
        profileView.setCache(true);
        if (user.getImagePath() != null && !user.getImagePath().isEmpty()) {
            File fileImage = new File(user.getImagePath());
            if (fileImage.exists()) {
                Image image = new Image(fileImage.toURI().toString());
                profileView.setImage(image);
            }
        } else {
            Image defaultProfile = new Image(getClass().getResourceAsStream("/images/profile-photo/Default.png"));
            profileView.setImage(defaultProfile);
        }
        Image profileBorder = new Image(getClass().getResourceAsStream("/images/profile-photo/Border.png"));
        ImageView profileBorderView = new ImageView(profileBorder);
        profileBorderView.setFitWidth(35);
        profileBorderView.setFitHeight(35);
        profileBorderView.setPreserveRatio(true);
        profileBorderView.setSmooth(true);
        profileBorderView.setCache(true);
        StackPane imageCombine = new StackPane(profileView, profileBorderView);
        imageCombine.setAlignment(Pos.CENTER);

        Label labelUsername = new Label(user.getUsername());
        labelUsername.setTextFill(Color.WHITE);
        labelUsername.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        labelUsername.setAlignment(Pos.CENTER);
        labelUsername.getStyleClass().add("username-shadow");
        HBox hBoxProfile = new HBox(labelUsername, imageCombine);
        hBoxProfile.setAlignment(Pos.CENTER);
        hBoxProfile.setPadding(new Insets(0, 10, 0, 0));
        hBoxProfile.setSpacing(10);

        HBox header = new HBox(spacer, hBoxProfile);
        header.setPrefHeight(70);
        header.getStyleClass().add("header");
        header.setPadding(new Insets(15));
        return header;
    }
}
