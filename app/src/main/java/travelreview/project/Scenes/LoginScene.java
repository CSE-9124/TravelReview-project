package travelreview.project.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import travelreview.project.Abstract.AScene;
import travelreview.project.Controllers.UsersController;
import travelreview.project.Models.User;
import travelreview.project.Scenes.User_scene.HomeScene;

public class LoginScene extends AScene {

    public LoginScene(Stage stage) {
        super(stage);
    }

    @Override
    public void show() {
        /* ==> INSTANCE LAYOUT END <== */
        Label labelTitle = new Label("TravelReview");
        labelTitle.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 17));
        labelTitle.getStyleClass().add("title");
        Label labelLogin = new Label("Log in");
        labelLogin.setFont(Font.font("Arial", FontWeight.BOLD, 35));
        labelLogin.getStyleClass().add("title");

        VBox vBoxLogin = new VBox(labelTitle, labelLogin);
        vBoxLogin.setSpacing(1);
        
        Image logoTitle = new Image(getClass().getResourceAsStream("/images/OIG1.jpg"));
        ImageView logoViewTitle = new ImageView(logoTitle);
        logoViewTitle.setFitWidth(50);
        logoViewTitle.setFitHeight(50);
        HBox hBoxTitle = new HBox(logoViewTitle, vBoxLogin);
        hBoxTitle.setSpacing(15);
        VBox vBoxTitle = new VBox(hBoxTitle);


        Label labelWelcome = new Label("Selamat datang di TravelReview. Silahkan login untuk melanjutkan");
        labelWelcome.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        labelWelcome.getStyleClass().add("text");
        labelWelcome.setWrapText(true);
        VBox vBoxWelcome = new VBox(labelWelcome);
        vBoxWelcome.setSpacing(5);

        Label labelEmail = new Label("Email");
        labelEmail.getStyleClass().add("text");
        TextField textFieldEmail = new TextField();
        textFieldEmail.setPromptText("Masukkan email");
        textFieldEmail.setPrefWidth(300);
        textFieldEmail.setPrefHeight(35);
        textFieldEmail.getStyleClass().add("textfield");
        VBox vBoxEmail = new VBox(labelEmail, textFieldEmail);

        Label labelPassword = new Label("Password");
        labelPassword.getStyleClass().add("text");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Masukkan password");
        passwordField.setPrefWidth(350);
        passwordField.setPrefHeight(35);
        passwordField.getStyleClass().add("textfield");

        TextField passwordShowField = new TextField();
        passwordShowField.setPromptText("Masukkan password");
        passwordShowField.setPrefWidth(350);
        passwordShowField.setPrefHeight(35);
        passwordShowField.setManaged(false);
        passwordShowField.setVisible(false);
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
        VBox vBoxPassword = new VBox(labelPassword, hBoxPassword);

        Button buttonLogin = new Button("LOG IN");
        buttonLogin.setPrefWidth(150);
        buttonLogin.setPrefHeight(35);
        buttonLogin.getStyleClass().add("loginbutton");
        VBox.setMargin(buttonLogin, new Insets(0, 0, 0, 200));

        Label text = new Label("Belum punya akun?");
        text.getStyleClass().add("text");
        Hyperlink hyperlinkRegister = new Hyperlink("Daftar disini");
        hyperlinkRegister.getStyleClass().add("text-link");

        HBox labelRegister = new HBox(text, hyperlinkRegister);
        labelRegister.setAlignment(Pos.CENTER);
        VBox vBoxRegister = new VBox(labelRegister);
        vBoxRegister.setAlignment(Pos.CENTER);
        vBoxRegister.setPadding(new Insets(0, 0, 10, 80));

        VBox vBoxInputLogin = new VBox(vBoxEmail, vBoxPassword, vBoxRegister, buttonLogin);
        vBoxInputLogin.setSpacing(10);

        Label labelStatus = new Label();
        labelStatus.setAlignment(Pos.CENTER);
        labelStatus.getStyleClass().add("text-status");

        VBox vBoxMainContent = new VBox(vBoxTitle, vBoxWelcome, vBoxInputLogin, labelStatus);
        vBoxMainContent.setPrefWidth(520);
        vBoxMainContent.setSpacing(30);
        vBoxMainContent.setPadding(new Insets(0, 20, 0, 20));
        vBoxMainContent.setAlignment(Pos.CENTER);
        vBoxMainContent.getStyleClass().add("scene");

        Image imageCity = new Image(getClass().getResourceAsStream("/images/city.jpg"));
        ImageView imageViewCity = new ImageView(imageCity);
        // Set the image fit-content contain
        imageViewCity.setPreserveRatio(true);
        imageViewCity.setFitWidth(420);
        imageViewCity.setFitHeight(580);
        VBox vBoxImageCity = new VBox(imageViewCity);
        vBoxImageCity.setAlignment(Pos.CENTER);
        vBoxImageCity.setBackground(new Background(new BackgroundFill(Color.web("#090f30"), null, null)));

        HBox root = new HBox(vBoxImageCity, vBoxMainContent);
        stage.getScene().setRoot(root);
        // stage.getScene().getStylesheets().add(getClass().getResource("/styles/dark-theme.css").toExternalForm());
        /* ==> INSTANCE LAYOUT END <== */

        /* ==> BUTTON ACTION START <== */
        buttonLogin.setOnAction(e -> {
            String email = textFieldEmail.getText();
            String password = passwordField.getText();

            if (email.isEmpty() || password.isEmpty()) {
                labelStatus.setText("Email dan password tidak boleh kosong");
                return;
            }

            User user = UsersController.login(email, password);
            
            if (user != null) {
                int id = user.getId();
                String role = user.getRole();

                if (role.equals("admin")) {
                    labelStatus.setText("Login berhasil");
                } else {
                    HomeScene homeScene = new HomeScene(stage);
                    homeScene.show(id);
                }
            } else {
                labelStatus.setText("Login gagal, email atau password salah");
            }
        });

        hyperlinkRegister.setOnMouseClicked(e -> {
            RegisterScene registerScene = new RegisterScene(stage);
            registerScene.show();
        });
        /* ==> BUTTON ACTION END <== */

        /* ==> KEY ACTION START <== */
        textFieldEmail.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                passwordField.requestFocus();
            }
        });

        passwordField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                buttonLogin.fire();
            }
        });

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
    }

    @Override
    protected void show(int id) {}

    @Override
    protected void show(int id, int tempatWisataId) {}
}