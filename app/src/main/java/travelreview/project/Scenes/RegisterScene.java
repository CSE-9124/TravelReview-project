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

public class RegisterScene extends AScene{

    public RegisterScene(Stage stage) {
        super(stage);
    }

    @Override
    protected void show() {
        /* ==> INSTANCE LAYOUT END <== */
        Label labelTitle = new Label("TravelReview");
        labelTitle.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 17));
        labelTitle.getStyleClass().add("title");
        Label labelRegister = new Label("Register");
        labelRegister.setFont(Font.font("Arial", FontWeight.BOLD, 35));
        labelRegister.getStyleClass().add("title");

        VBox vBoxRegister = new VBox(labelTitle, labelRegister);
        vBoxRegister.setSpacing(1);

        Image logoTitle = new Image(getClass().getResourceAsStream("/images/OIG1.jpg"));
        ImageView logoViewTitle = new ImageView(logoTitle);
        logoViewTitle.setFitWidth(50);
        logoViewTitle.setFitHeight(50);
        HBox hBoxTitle = new HBox(logoViewTitle, vBoxRegister);
        hBoxTitle.setSpacing(10);
        VBox vBoxTitle = new VBox(hBoxTitle);

        Label labelWelcome = new Label("Silahkan daftar untuk bergabung di TravelReview");
        labelWelcome.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        labelWelcome.getStyleClass().add("text");
        labelWelcome.setWrapText(true);
        VBox vBoxWelcome = new VBox(labelWelcome);
        vBoxWelcome.setSpacing(5);

        Label labelUsername = new Label("Username");
        labelUsername.getStyleClass().add("text");
        TextField textFieldUsername = new TextField();
        textFieldUsername.setPromptText("Masukkan username");
        textFieldUsername.setPrefHeight(35);
        textFieldUsername.getStyleClass().add("textfield");
        VBox vBoxUsername = new VBox(labelUsername, textFieldUsername);

        Label labelName = new Label("Nama");
        labelName.getStyleClass().add("text");
        TextField textFieldName = new TextField();
        textFieldName.setPromptText("Masukkan nama");
        textFieldName.setPrefHeight(35);
        textFieldName.getStyleClass().add("textfield");
        VBox vBoxName = new VBox(labelName, textFieldName);

        Label labelEmail = new Label("Email");
        labelEmail.getStyleClass().add("text");
        TextField textFieldEmail = new TextField();
        textFieldEmail.setPromptText("Masukkan email");
        textFieldEmail.setPrefHeight(35);
        textFieldEmail.getStyleClass().add("textfield");
        VBox vBoxEmail = new VBox(labelEmail, textFieldEmail);

        Label labelPassword = new Label("Password");
        labelPassword.getStyleClass().add("text");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Masukkan password");
        passwordField.setPrefWidth(360);
        passwordField.setPrefHeight(35);
        passwordField.getStyleClass().add("textfield");

        TextField passwordShowField = new TextField();
        passwordShowField.setPromptText("Masukkan password");
        passwordShowField.setPrefWidth(360);
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

        Button buttonRegister = new Button("REGISTER");
        buttonRegister.setPrefWidth(150);
        buttonRegister.setPrefHeight(35);
        buttonRegister.getStyleClass().add("registerbutton");
        VBox.setMargin(buttonRegister, new Insets(0, 0, 0, 210));

        Label text = new Label("Sudah punya akun?");
        text.getStyleClass().add("text");
        Hyperlink hyperlinkLogin = new Hyperlink("Login disini");
        hyperlinkLogin.getStyleClass().add("text-link");

        HBox labelLogin = new HBox(text, hyperlinkLogin);
        labelLogin.setAlignment(Pos.CENTER);
        VBox vBoxLogin = new VBox(labelLogin);
        vBoxLogin.setAlignment(Pos.CENTER);
        vBoxLogin.setPadding(new Insets(0, 0, 10, 85));

        VBox vBokInputRegister = new VBox(vBoxUsername, vBoxName, vBoxEmail, vBoxPassword, vBoxLogin, buttonRegister);
        vBokInputRegister.setSpacing(10);

        Label labelStatus = new Label();
        labelStatus.setFont(Font.font("Arial", 14));
        labelStatus.setAlignment(Pos.CENTER);
        labelStatus.getStyleClass().add("text-status");

        VBox vBoxMainContent = new VBox(vBoxTitle, vBoxWelcome, vBokInputRegister, labelStatus);
        vBoxMainContent.setPrefWidth(520);
        vBoxMainContent.setSpacing(30);
        vBoxMainContent.setPadding(new Insets(0, 20, 0, 20));
        vBoxMainContent.setAlignment(Pos.CENTER);
        vBoxMainContent.getStyleClass().add("scene");

        Image imageSunset = new Image(getClass().getResourceAsStream("/images/sunset.jpg"));
        ImageView imageViewSunset = new ImageView(imageSunset);
        // Set the image fit-content contain
        imageViewSunset.setFitWidth(420);
        imageViewSunset.setFitHeight(580);
        imageViewSunset.setPreserveRatio(true);
        VBox vBoxImageSunset = new VBox(imageViewSunset);
        vBoxImageSunset.setAlignment(Pos.CENTER);
        vBoxImageSunset.setBackground(new Background(new BackgroundFill(Color.web("#090f30"), null, null)));

        HBox root = new HBox(vBoxMainContent, vBoxImageSunset);
        stage.getScene().setRoot(root);
        stage.getScene().getStylesheets().add(getClass().getResource("/styles/dark-theme.css").toExternalForm());
        /* ==> INSTANCE LAYOUT END <== */

        /* ==> BUTTON ACTION START <== */
        buttonRegister.setOnAction(e -> {
            String username = textFieldUsername.getText();
            String name = textFieldName.getText();
            String email = textFieldEmail.getText();
            String password = passwordField.getText();

            if (username.isEmpty() || name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                labelStatus.setText("Username, Nama, Email, dan Password tidak boleh kosong");
                return;
            } else if (!email.matches("^[\\w._%+-]+@gmail\\.com$")) {
                labelStatus.setText("Email harus berakhiran @gmail.com");
                return;
            } else if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$")) {
                labelStatus.setText("Password minimal 8 karakter memiliki huruf besar, huruf kecil, dan angka");
                return;
            } else if (UsersController.isUsernameOrEmailTaken(username, email)) {
                labelStatus.setText("Email atau Username telah digunakan");
                return;
            } else {
                UsersController.register(username, name, email, password);
                LoginScene loginScene = new LoginScene(stage);
                loginScene.show();
            }
        });
        
        hyperlinkLogin.setOnMouseClicked(e -> {
            LoginScene loginScene = new LoginScene(stage);
            loginScene.show();
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
        /* ==> BUTTON ACTION END <== */

        /* ==> KEY ACTION START <== */
        textFieldUsername.setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER")) {
                textFieldName.requestFocus();
            }
        });

        textFieldName.setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER")) {
                textFieldEmail.requestFocus();
            }
        });

        textFieldEmail.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                if (passwordField.isVisible()) {
                    passwordField.requestFocus();
                } else {
                    passwordShowField.requestFocus();
                }
            }
        });

        passwordField.setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER")) {
                buttonRegister.fire();
            }
        });

        passwordShowField.setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER")) {
                buttonRegister.fire();
            }
        });
        /* ==> KEY ACTION END <== */
    }

    @Override
    protected void show(int id) {}

    @Override
    protected void show(int id, int tempatWisataId) {}
}