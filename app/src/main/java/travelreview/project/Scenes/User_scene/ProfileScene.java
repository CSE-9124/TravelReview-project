package travelreview.project.Scenes.User_scene;

import java.io.File;
import java.io.IOException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import travelreview.project.Abstract.AScene;
import travelreview.project.Controllers.UsersController;
import travelreview.project.Models.User;
import travelreview.project.Scenes.Components.Header;
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
        // Label labelTitle = new Label("Profil Anda");
        // labelTitle.setFont(Font.font("Sytem", FontWeight.BOLD, 24));
        // labelTitle.getStyleClass().add("title");

        Label labelDetailProfile = new Label("Detail Profil");
        labelDetailProfile.setFont(Font.font("Sytem", FontWeight.BOLD, 18));
        labelDetailProfile.setTextFill(Color.BLACK);
        labelDetailProfile.setPadding(new Insets(0, 0, 0,10));
        Rectangle rectangle = new Rectangle(380, 40);
        rectangle.getStyleClass().add("rectangle");
        rectangle.setArcWidth(10); // Change the horizontal border radius
        rectangle.setArcHeight(10); // Change the vertical border radius

        StackPane stackPane = new StackPane(rectangle, labelDetailProfile);
        stackPane.setAlignment(Pos.CENTER_LEFT);
        stackPane.setPadding(new Insets(0, 10, 0, 0));
        stackPane.getStyleClass().add("stackpane");

        Label labelUsername = new Label("Username");
        labelUsername.setFont(Font.font("Sytem", FontWeight.SEMI_BOLD, 14));
        labelUsername.setPrefHeight(35);
        labelUsername.getStyleClass().add("text");
        Label labelName = new Label("Nama");
        labelUsername.setFont(Font.font("Sytem", FontWeight.SEMI_BOLD, 14));
        labelName.setPrefHeight(35);
        labelName.getStyleClass().add("text");
        Label labelEmail = new Label("Email");
        labelEmail.setFont(Font.font("Sytem", FontWeight.SEMI_BOLD, 14));
        labelEmail.setPrefHeight(35);
        labelEmail.getStyleClass().add("text");
        Label labelPassword = new Label("Password");
        labelPassword.setFont(Font.font("Sytem", FontWeight.SEMI_BOLD, 14));
        labelPassword.setPrefHeight(35);
        labelPassword.getStyleClass().add("text");

        VBox vBoxLabelProfile = new VBox(labelUsername, labelName, labelEmail, labelPassword);
        vBoxLabelProfile.setSpacing(10);

        TextField textFieldUsername = new TextField(user.getUsername());
        textFieldUsername.setPrefSize(260, 35);
        textFieldUsername.getStyleClass().add("profileField");
        TextField textFieldName = new TextField(user.getName());
        textFieldName.setPrefSize(260, 35);
        textFieldName.getStyleClass().add("profileField");
        TextField textFieldEmail = new TextField(user.getEmail());
        textFieldEmail.setPrefSize(260, 35);
        textFieldEmail.setEditable(false);
        textFieldEmail.getStyleClass().add("profileField");
        PasswordField passwordField = new PasswordField();
        passwordField.setText(user.getPassword());
        passwordField.setPrefSize(260, 35);
        passwordField.getStyleClass().add("profileField");
            TextField passwordShowField = new TextField();
            passwordShowField.setPromptText(user.getPassword());
            passwordShowField.setPrefSize(260, 35);
            passwordShowField.setManaged(false);
            passwordShowField.setVisible(false);
            passwordShowField.getStyleClass().add("profileField");
            passwordShowField.textProperty().bindBidirectional(passwordField.textProperty());
        
            Button buttonEye = new Button();
            Image imageEye = new Image(getClass().getResourceAsStream("/images/EyeClose.png"));
            ImageView imageViewEye = new ImageView(imageEye);
            imageViewEye.setFitWidth(30);
            imageViewEye.setFitHeight(30);
            buttonEye.setGraphic(imageViewEye);
            buttonEye.getStyleClass().add("eye-button");

            HBox hBoxPassword = new HBox(passwordField, passwordShowField, buttonEye);
            hBoxPassword.setSpacing(5);

        VBox vBoxDetailProfileField = new VBox(textFieldUsername, textFieldName, textFieldEmail, hBoxPassword);
        vBoxDetailProfileField.setSpacing(10);

        HBox hBoxDetailProfile = new HBox(vBoxLabelProfile, vBoxDetailProfileField);
        hBoxDetailProfile.setSpacing(20);

        Label labelUmurTelpon = new Label("Umur & No. Telepon");
        labelUmurTelpon.setFont(Font.font("Sytem", FontWeight.BOLD, 18));
        labelUmurTelpon.setTextFill(Color.BLACK);
        labelUmurTelpon.setPadding(new Insets(0, 0, 0,10));
        Rectangle rectangle2 = new Rectangle(380, 40);
        rectangle2.getStyleClass().add("rectangle");
        rectangle2.setArcWidth(10); // Change the horizontal border radius
        rectangle2.setArcHeight(10); // Change the vertical border radius

        StackPane stackPane2 = new StackPane(rectangle2, labelUmurTelpon);
        stackPane2.setAlignment(Pos.CENTER_LEFT);
        stackPane2.setPadding(new Insets(0, 10, 0, 0));
        stackPane2.getStyleClass().add("stackpane");

        Label labelAge = new Label("Umur");
        labelAge.setFont(Font.font("Sytem", FontWeight.SEMI_BOLD, 14));
        labelAge.setPrefHeight(35);
        labelAge.getStyleClass().add("text");
        Label labelPhoneNumber = new Label("No. Telepon");
        labelPhoneNumber.setFont(Font.font("Sytem", FontWeight.SEMI_BOLD, 14));
        labelPhoneNumber.setPrefHeight(35);
        labelPhoneNumber.getStyleClass().add("text");

        VBox vBoxLabelProfile2 = new VBox(labelAge, labelPhoneNumber);
        vBoxLabelProfile2.setSpacing(10);

        TextField textFieldAge = new TextField(String.valueOf(user.getAge()));
        textFieldAge.setPrefSize(260, 35);
        textFieldAge.getStyleClass().add("profileField");
        TextField textFieldPhoneNumber = new TextField(user.getPhoneNumber());
        textFieldPhoneNumber.setPrefSize(260, 35);
        textFieldPhoneNumber.getStyleClass().add("profileField");

        VBox vBoxDetailProfileField2 = new VBox(textFieldAge, textFieldPhoneNumber);
        vBoxDetailProfileField2.setSpacing(10);

        HBox hBoxDetailProfile2 = new HBox(vBoxLabelProfile2, vBoxDetailProfileField2);
        hBoxDetailProfile2.setSpacing(5);

        Button buttonUpdate = new Button("Update");
        buttonUpdate.setPrefWidth(200);
        buttonUpdate.setPrefHeight(35);
        buttonUpdate.getStyleClass().add("profileUpdateButton");
        VBox.setMargin(buttonUpdate, new Insets(0, 10, 0, 230));

        VBox vBoxDetailProfile = new VBox(stackPane, hBoxDetailProfile, stackPane2, hBoxDetailProfile2, buttonUpdate);
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
        vBoxPhotoProfile.setSpacing(20);
        vBoxPhotoProfile.setPrefWidth(700);

        HBox hBoxProfileContent = new HBox(vBoxPhotoProfile, vBoxDetailProfile);

        VBox vBoxMainContent = new VBox(hBoxProfileContent);
        vBoxMainContent.setPadding(new Insets(10));
        vBoxMainContent.setSpacing(10);
        vBoxMainContent.setPrefWidth(750);
        vBoxMainContent.setPrefHeight(510);
        vBoxMainContent.getStyleClass().add("scene");

        Header header = new Header();
        VBox vBoxHeader = new VBox(header.getHeader(user), vBoxMainContent);

        Navbar navbar = new Navbar();
        HBox hBoxContent = new HBox(navbar.getUserNavbar(stage, id), vBoxHeader);

        HBox root = new HBox(hBoxContent);
        stage.getScene().setRoot(root);
        /* ==> INSTANCE LAYOUT END <== */

        /* ==> BUTTON ACTION START <== */
        buttonEye.setOnAction(e -> {
            if (passwordField.isVisible()) {
                passwordField.setVisible(false);
                passwordField.setManaged(false);
                passwordShowField.setVisible(true);
                passwordShowField.setManaged(true);
                passwordShowField.requestFocus();
                passwordShowField.positionCaret(passwordShowField.getText().length());
                passwordShowField.getStyleClass().add("passwordfield-hide");
                Image imageOpenEye = new Image(getClass().getResourceAsStream("/images/EyeOpen.png"));
                ImageView imageViewOpenEye = new ImageView(imageOpenEye);
                imageViewOpenEye.setFitWidth(30);
                imageViewOpenEye.setFitHeight(30);
                buttonEye.setGraphic(imageViewOpenEye);
            } else {
                passwordField.setVisible(true);
                passwordField.setManaged(true);
                passwordShowField.setVisible(false);
                passwordShowField.setManaged(false);
                passwordField.requestFocus();
                passwordField.positionCaret(passwordField.getText().length());
                passwordField.getStyleClass().add("passwordfield-show");
                Image imageCloseEye = new Image(getClass().getResourceAsStream("/images/EyeClose.png"));
                ImageView imageViewCloseEye = new ImageView(imageCloseEye);
                imageViewCloseEye.setFitWidth(30);
                imageViewCloseEye.setFitHeight(30);
                buttonEye.setGraphic(imageViewCloseEye);
            }
        });

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