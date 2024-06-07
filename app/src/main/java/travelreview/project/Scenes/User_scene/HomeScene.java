package travelreview.project.Scenes.User_scene;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import travelreview.project.Abstract.AScene;
import travelreview.project.Controllers.TempatWisataController;
import travelreview.project.Controllers.UsersController;
import travelreview.project.Models.TempatWisata;
import travelreview.project.Models.User;
import travelreview.project.Scenes.Components.Navbar;

public class HomeScene extends AScene{

    public HomeScene(Stage stage) {
        super(stage);
    }

    @Override
    public void show(int id) {
        List<TempatWisata> tempatWisataData = TempatWisataController.getAllTempatWisata();

        User user = UsersController.getUserById(id);

        /* ==> INSTANCE LAYOUT START <== */
        Label labelTitle = new Label("Beranda");
        labelTitle.setFont(Font.font("Sytem", FontWeight.BOLD, 24));
        labelTitle.getStyleClass().add("title");

        Label labelWelcome = new Label("Selamat Datang di TravelReview");
        labelWelcome.setFont(Font.font("Sytem", FontWeight.BOLD, 28));
        labelWelcome.getStyleClass().add("text");
        Label labelName = new Label(user.getName());
        labelName.setFont(Font.font("Sytem", 22));
        labelName.getStyleClass().add("text");
        VBox vBoxWelcome = new VBox(labelWelcome, labelName);
        vBoxWelcome.setAlignment(Pos.CENTER);
        vBoxWelcome.setPadding(new Insets(100, 0, 0, 0));
        vBoxWelcome.setSpacing(5);

        Label recomendLabel = new Label("Rekomendasi Tempat Wisata :");
        recomendLabel.setFont(Font.font("Sytem", FontWeight.BOLD, 24));
        recomendLabel.setPadding(new Insets(50, 10, 0, 10));
        recomendLabel.getStyleClass().add("text");

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(0, 10, 0, 10));

        int column = 0;

        // Sort tempatWisataData based on total_rating
        Collections.sort(tempatWisataData, Comparator.comparingDouble(TempatWisata::getTotal_rating).reversed());

        for (TempatWisata tempat : tempatWisataData) {
            if (tempat.getTotal_rating() == 0) {
            continue;
            }

            ImageView imageViewTempat = new ImageView();
            imageViewTempat.setFitWidth(250);
            imageViewTempat.setFitHeight(100);
            imageViewTempat.setPreserveRatio(true);

            if (tempat.getImagePath() != null && !tempat.getImagePath().isEmpty()) {
            File fileImage = new File(tempat.getImagePath());
            if (fileImage.exists()) {
                Image image = new Image(fileImage.toURI().toString());
                imageViewTempat.setImage(image);
            }
            }
            VBox vBoxImageTempat = new VBox(imageViewTempat);
            vBoxImageTempat.setAlignment(Pos.CENTER);

            Label labelNamaTempat = new Label(tempat.getNama());
            labelNamaTempat.setFont(Font.font("Sytem", FontWeight.BOLD, 16));
            labelNamaTempat.getStyleClass().add("text");
            Label labelLokasi = new Label(tempat.getLokasi() + ", " + tempat.getKota());
            labelLokasi.getStyleClass().add("text");
            Label labelRating = new Label("Rate : ⭐" + tempat.getTotal_rating());
            labelRating.setFont(Font.font("Sytem", FontWeight.BOLD, 14));
            labelRating.getStyleClass().add("text");
            VBox vBoxNamaTempat = new VBox(labelNamaTempat, labelLokasi, labelRating);
            vBoxNamaTempat.setPadding(new Insets(10, 15, 15, 15));
            vBoxNamaTempat.setSpacing(5);
            vBoxNamaTempat.getStyleClass().add("card-detail");

            VBox vBoxTempat = new VBox(vBoxImageTempat, vBoxNamaTempat);
            vBoxTempat.getStyleClass().add("card");
            vBoxTempat.setPrefWidth(180);
            vBoxTempat.setMaxHeight(100);;

            vBoxTempat.setOnMouseClicked(e -> {
                DetailTempatScene detailTempatScene = new DetailTempatScene(stage);
                detailTempatScene.show(id, tempat.getId());
            });

            gridPane.add(vBoxTempat, column, 0);

            column++;
        }

        VBox vBoxRecomend = new VBox(gridPane);
        vBoxRecomend.setPadding(new Insets(10));
        vBoxRecomend.setSpacing(10);
        vBoxRecomend.getStyleClass().add("scene");

        ScrollPane scrollPane = new ScrollPane(vBoxRecomend);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.getStyleClass().add("scene");
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        VBox vBoxMainContent = new VBox(labelTitle, vBoxWelcome, recomendLabel, scrollPane);
        vBoxMainContent.setPadding(new Insets(10));
        vBoxMainContent.setSpacing(10);
        vBoxMainContent.setPrefWidth(750);
        vBoxMainContent.getStyleClass().add("scene");

        Navbar navbar = new Navbar();
        HBox hBoxContent = new HBox(navbar.getUserNavbar(stage, id), vBoxMainContent);
        

        HBox root = new HBox(hBoxContent);
        stage.getScene().setRoot(root);
        /* ==> INSTANCE LAYOUT END <== */
        
    }



    protected void show() {}
    protected void show(int id, int tempatWisataId) {}
}