package travelreview.project.Scenes.Admin_scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import travelreview.project.Abstract.AScene;
import travelreview.project.Controllers.UsersController;
import travelreview.project.Models.User;
import travelreview.project.Scenes.Components.Navbar;

public class AdminHomeScene extends AScene{

    public AdminHomeScene(Stage stage) {
        super(stage);
    }

    @Override
    public void show(int id) {
        User admin = UsersController.getUserById(id);

        /* ==> INSTANCE LAYOUT START <== */
        Image image = new Image(getClass().getResourceAsStream("/images/Indo.jpg"));
        ImageView imageView = new ImageView(image);
        imageView.setSmooth(true);
        imageView.setCache(true);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(360);
        imageView.setFitHeight(240);
        VBox vBoxImage = new VBox(imageView);
        vBoxImage.setPadding(new Insets(100, 0, 10, 0));
        vBoxImage.setAlignment(Pos.CENTER);

        Label labelWelcome = new Label("Selamat Datang");
        labelWelcome.setFont(Font.font("Sytem", FontWeight.BOLD, 30));
        labelWelcome.getStyleClass().add("text");
        Label labelName = new Label(admin.getName());
        labelName.setFont(Font.font("Sytem", FontWeight.BOLD, 25));
        labelName.getStyleClass().add("text");
        Label labelRole = new Label("You are logged in as Admin");
        labelRole.setFont(Font.font("Sytem", FontWeight.BOLD, 17));
        labelRole.getStyleClass().add("text");
        VBox vBoxWelcome = new VBox(labelWelcome, labelName, labelRole);
        vBoxWelcome.setAlignment(Pos.CENTER);
        vBoxWelcome.setPadding(new Insets(0, 0, 10, 0));
        vBoxWelcome.setSpacing(5);

        VBox vBoxMainContent = new VBox(vBoxImage, vBoxWelcome);
        vBoxMainContent.setAlignment(Pos.TOP_CENTER);
        vBoxMainContent.setPadding(new Insets(10));
        vBoxMainContent.setSpacing(10);
        vBoxMainContent.setPrefWidth(750);
        vBoxMainContent.getStyleClass().add("scene");

        Navbar navbar = new Navbar();
        HBox hBoxContent = new HBox(navbar.getAdminNavbar(stage, id), vBoxMainContent);

        HBox root = new HBox(hBoxContent);
        stage.getScene().setRoot(root);
    }



    protected void show() {}
    protected void show(int id, int tempatWisataId) {}
}
