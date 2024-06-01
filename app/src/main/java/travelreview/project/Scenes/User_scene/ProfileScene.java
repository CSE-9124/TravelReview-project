package travelreview.project.Scenes.User_scene;

import java.io.File;
import java.io.IOException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import travelreview.project.Abstract.AScene;
import travelreview.project.Controllers.UsersController;
import travelreview.project.Models.User;
import travelreview.project.Scenes.Components.Navbar;
import travelreview.project.Utils.ImageUtils;

public class ProfileScene extends AScene {
    private File selectedImageFile;

    public ProfileScene(Stage stage) {
        super(stage);
    }

    @Override
    public void show(int id) {
        User user = UsersController.getUserById(id);

        /* ==> INSTANCE LAYOUT START <== */
        Label labelTitle = new Label("Profil Anda");
        labelTitle.setFont(Font.font("Sytem", FontWeight.BOLD, 24));
        labelTitle.getStyleClass().add("title");

        Label labelUsername = new Label("Username");
        labelUsername.getStyleClass().add("text");
        TextField textFieldUsername = new TextField(user.getUsername());
        textFieldUsername.getStyleClass().add("profileField");
        VBox vBoxUsername = new VBox(labelUsername, textFieldUsername);

        Label labelName = new Label("Nama");
        labelName.getStyleClass().add("text");
        TextField textFieldName = new TextField(user.getName());
        textFieldName.getStyleClass().add("profileField");
        VBox vBoxName = new VBox(labelName, textFieldName);

        Label labelAge = new Label("Umur");
        labelAge.getStyleClass().add("text");
        TextField textFieldAge = new TextField(String.valueOf(user.getAge()));
        textFieldAge.getStyleClass().add("profileField");
        VBox vBoxAge = new VBox(labelAge, textFieldAge);

        Label labelPhoneNumber = new Label("Nomor Telepon");
        labelPhoneNumber.getStyleClass().add("text");
        TextField textFieldPhoneNumber = new TextField(user.getPhoneNumber());
        textFieldPhoneNumber.getStyleClass().add("profileField");
        VBox vBoxPhoneNumber = new VBox(labelPhoneNumber, textFieldPhoneNumber);

        Label labelEmail = new Label("Email");
        labelEmail.getStyleClass().add("text");
        TextField textFieldEmail = new TextField(user.getEmail());
        textFieldEmail.setEditable(false);
        textFieldEmail.getStyleClass().add("profileField");
        VBox vBoxEmail = new VBox(labelEmail, textFieldEmail);

        Button buttonUpdate = new Button("Update");
        buttonUpdate.setPrefWidth(200);
        buttonUpdate.getStyleClass().add("profileUpdateButton");

        VBox vBoxDetailProfile = new VBox(vBoxUsername, vBoxName, vBoxAge, vBoxPhoneNumber, vBoxEmail, buttonUpdate);
        vBoxDetailProfile.setSpacing(10);
        vBoxDetailProfile.setPrefWidth(750);

        ImageView profileView = new ImageView();
        profileView.setFitWidth(200);
        profileView.setFitHeight(200);
        profileView.setPreserveRatio(true);
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
        profileBorderView.setFitWidth(200);
        profileBorderView.setFitHeight(200);
        profileBorderView.setPreserveRatio(true);
        StackPane imageCombine = new StackPane(profileView, profileBorderView);
        imageCombine.setAlignment(Pos.CENTER);

        Button buttonUpload = new Button("Upload Foto");
        buttonUpload.setPrefWidth(200);
        buttonUpload.getStyleClass().add("profileUpdateButton");

        VBox vBoxPhotoProfile = new VBox(imageCombine, buttonUpload);
        vBoxPhotoProfile.setAlignment(Pos.CENTER);
        vBoxPhotoProfile.setSpacing(10);
        vBoxPhotoProfile.setPrefWidth(700);

        HBox hBoxProfileContent = new HBox(vBoxPhotoProfile, vBoxDetailProfile);

        VBox vBoxMainContent = new VBox(labelTitle, hBoxProfileContent);
        vBoxMainContent.setPadding(new Insets(10));
        vBoxMainContent.setSpacing(10);
        vBoxMainContent.setPrefWidth(750);
        vBoxMainContent.getStyleClass().add("scene");

        Navbar navbar = new Navbar();
        HBox hBoxContent = new HBox(navbar.getUserNavbar(stage, id), vBoxMainContent);

        HBox root = new HBox(hBoxContent);
        stage.getScene().setRoot(root);
        /* ==> INSTANCE LAYOUT END <== */

        /* ==> BUTTON ACTION START <== */
        buttonUpdate.setOnAction(e -> {
            String username = textFieldUsername.getText();
            String name = textFieldName.getText();
            String phoneNumber = textFieldPhoneNumber.getText();
            int age = Integer.parseInt(textFieldAge.getText());

            String imagePath = null;
            if (selectedImageFile != null) {
                try {
                    imagePath = ImageUtils.saveImage(selectedImageFile);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

            boolean isSuccessfulyUpdate = UsersController.updateUser(id, username, name, phoneNumber, user.getEmail(), imagePath, age);
            if (isSuccessfulyUpdate) {
                System.out.println("Berhasil update data");
                HomeScene homeScene = new HomeScene(stage);
                homeScene.show(id);
            }
        });

        buttonUpload.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
            File file = fileChooser.showOpenDialog(stage);
            if(file != null) {
                selectedImageFile = file;
                Image image = new Image(file.toURI().toString());
                profileView.setImage(image);
            }
        });
        /* ==> BUTTON ACTION END <== */

        /* ==> KEY ACTION START <== */
        textFieldUsername.setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER")) {
                buttonUpdate.fire();
            }
        });

        textFieldName.setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER")) {
                buttonUpdate.fire();
            }
        });

        textFieldAge.setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER")) {
                buttonUpdate.fire();
            }
        });

        textFieldPhoneNumber.setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER")) {
                buttonUpdate.fire();
            }
        });
        /* ==> KEY ACTION END <== */
    }



    protected void show() {}
    protected void show(int id, int tempatWisataId) {}
}