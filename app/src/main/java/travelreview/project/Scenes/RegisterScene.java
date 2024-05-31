package travelreview.project.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        labelTitle.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 30));
        labelTitle.getStyleClass().add("title");
        Image logoTitle = new Image(getClass().getResourceAsStream("/images/OIG1.jpg"));
        ImageView logoViewTitle = new ImageView(logoTitle);
        logoViewTitle.setFitWidth(50);
        logoViewTitle.setFitHeight(50);
        HBox hBoxTitle = new HBox(logoViewTitle, labelTitle);
        hBoxTitle.setSpacing(10);
        VBox vBoxTitle = new VBox(hBoxTitle);

        Label labelHello = new Label("Register");
        labelHello.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        labelHello.getStyleClass().add("text");
        Label labelWelcome = new Label("Silahkan daftar untuk bergabung di TravelReview");
        labelWelcome.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        labelWelcome.getStyleClass().add("text");
        // Overflow text
        labelWelcome.setWrapText(true);
        VBox vBoxWelcome = new VBox(labelHello, labelWelcome);
        vBoxWelcome.setSpacing(5);

        Label labelUsername = new Label("Username");
        labelUsername.getStyleClass().add("text");
        TextField textFieldUsername = new TextField();
        textFieldUsername.setPromptText("Masukkan username");
        textFieldUsername.getStyleClass().add("textfield");
        VBox vBoxUsername = new VBox(labelUsername, textFieldUsername);

        Label labelName = new Label("Nama");
        labelName.getStyleClass().add("text");
        TextField textFieldName = new TextField();
        textFieldName.setPromptText("Masukkan nama");
        textFieldName.getStyleClass().add("textfield");
        VBox vBoxName = new VBox(labelName, textFieldName);

        Label labelEmail = new Label("Email");
        labelEmail.getStyleClass().add("text");
        TextField textFieldEmail = new TextField();
        textFieldEmail.setPromptText("Masukkan email");
        textFieldEmail.getStyleClass().add("textfield");
        VBox vBoxEmail = new VBox(labelEmail, textFieldEmail);

        Label labelPassword = new Label("Password");
        labelPassword.getStyleClass().add("text");
        TextField textFieldPassword = new TextField();
        textFieldPassword.setPromptText("Masukkan password");
        textFieldPassword.getStyleClass().add("textfield");
        VBox vBoxPassword = new VBox(labelPassword, textFieldPassword);

        Button buttonRegister = new Button("Register");
        buttonRegister.setPrefWidth(300);
        buttonRegister.getStyleClass().add("registerbutton");

        Label labelLogin = new Label("Sudah punya akun? Login disini");
        // labelLogin.setTextFill(Color.web("#0076a3"));
        labelLogin.getStyleClass().add("text-link");
        VBox vBoxLogin = new VBox(labelLogin);
        vBoxLogin.setAlignment(Pos.CENTER);

        VBox vBokInputRegister = new VBox(vBoxUsername, vBoxName, vBoxEmail, vBoxPassword, buttonRegister, vBoxLogin);
        vBokInputRegister.setSpacing(10);

        Label labelStatus = new Label();
        labelStatus.getStyleClass().add("text-status");

        VBox vBoxMainContent = new VBox(vBoxTitle, vBoxWelcome, vBokInputRegister, labelStatus);
        vBoxMainContent.setPrefWidth(520);
        vBoxMainContent.setSpacing(30);
        vBoxMainContent.setPadding(new Insets(0, 20, 0, 20));
        vBoxMainContent.setAlignment(Pos.CENTER);
        vBoxMainContent.getStyleClass().add("scene");

        Image imageCity = new Image(getClass().getResourceAsStream("/images/city.jpg"));
        ImageView imageViewNoxbrary = new ImageView(imageCity);
        // Set the image fit-content contain
        imageViewNoxbrary.setPreserveRatio(true);
        imageViewNoxbrary.setFitWidth(420);
        imageViewNoxbrary.setFitHeight(580);
        VBox vBoxImageNoxbrary = new VBox(imageViewNoxbrary);
        vBoxImageNoxbrary.setAlignment(Pos.CENTER);
        vBoxImageNoxbrary.setBackground(new Background(new BackgroundFill(Color.web("#090f30"), null, null)));

        HBox root = new HBox(vBoxMainContent, vBoxImageNoxbrary);
        stage.getScene().setRoot(root);
        stage.getScene().getStylesheets().add(getClass().getResource("/styles/dark-theme.css").toExternalForm());
        /* ==> INSTANCE LAYOUT END <== */

        /* ==> BUTTON ACTION START <== */
        buttonRegister.setOnAction(e -> {
            String username = textFieldUsername.getText();
            String name = textFieldName.getText();
            String email = textFieldEmail.getText();
            String password = textFieldPassword.getText();

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
        
        labelLogin.setOnMouseClicked(e -> {
            LoginScene loginScene = new LoginScene(stage);
            loginScene.show();
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
            if (e.getCode().toString().equals("ENTER")) {
                textFieldPassword.requestFocus();
            }
        });

        textFieldPassword.setOnKeyPressed(e -> {
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
