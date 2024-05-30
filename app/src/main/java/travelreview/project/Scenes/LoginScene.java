package travelreview.project.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
        labelTitle.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 30));
        labelTitle.getStyleClass().add("title");
        Image logoTitle = new Image(getClass().getResourceAsStream("/images/OIG1.jpg"));
        ImageView logoViewTitle = new ImageView(logoTitle);
        logoViewTitle.setFitWidth(50);
        logoViewTitle.setFitHeight(50);
        HBox hBoxTitle = new HBox(logoViewTitle, labelTitle);
        hBoxTitle.setSpacing(10);
        VBox vBoxTitle = new VBox(hBoxTitle);

        Label labelLogin = new Label("Login");
        labelLogin.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        labelLogin.getStyleClass().add("text");
        Label labelWelcome = new Label("Selamat datang di TravelReview. Silahkan login untuk melanjutkan");
        labelWelcome.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        labelWelcome.getStyleClass().add("text");
        // Overflow text
        labelWelcome.setWrapText(true);
        VBox vBoxWelcome = new VBox(labelLogin, labelWelcome);
        vBoxWelcome.setSpacing(5);

        Label labelEmail = new Label("Email");
        labelEmail.getStyleClass().add("text");
        TextField textFieldEmail = new TextField();
        textFieldEmail.setPromptText("Masukkan email");
        textFieldEmail.setPrefWidth(300);
        textFieldEmail.getStyleClass().add("textfield");
        VBox vBoxEmail = new VBox(labelEmail, textFieldEmail);

        Label labelPassword = new Label("Password");
        labelPassword.getStyleClass().add("text");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Masukkan password");
        passwordField.setPrefWidth(300);
        passwordField.getStyleClass().add("textfield");
        VBox vBoxPassword = new VBox(labelPassword, passwordField);
        vBoxPassword.setPadding(new Insets(0, 0, 10, 0));

        Button buttonLogin = new Button("LOG IN");
        buttonLogin.setPrefWidth(300);
        buttonLogin.getStyleClass().add("loginbutton");

        Label labelRegister = new Label("Belum punya akun? Daftar disini");
        labelRegister.getStyleClass().add("text-link");

        VBox vBoxRegister = new VBox(labelRegister);
        vBoxRegister.setAlignment(Pos.CENTER);

        VBox vBoxInputLogin = new VBox(vBoxEmail, vBoxPassword, buttonLogin, vBoxRegister);
        vBoxInputLogin.setSpacing(10);

        Label labelStatus = new Label();
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

        labelRegister.setOnMouseClicked(e -> {
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
        
    }

    @Override
    protected void show(int id) {}

    @Override
    protected void show(int id, int tempatWisataId) {}
}
