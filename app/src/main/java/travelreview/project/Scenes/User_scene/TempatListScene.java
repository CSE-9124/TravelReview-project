package travelreview.project.Scenes.User_scene;

import java.io.File;
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
import travelreview.project.Models.TempatWisata;
import travelreview.project.Scenes.Components.Navbar;
import travelreview.project.Controllers.TempatWisataController;

public class TempatListScene extends AScene{

    public TempatListScene(Stage stage) {
        super(stage);
    }

    @Override
    public void show(int id) {
        List<TempatWisata> tempatWisataData = TempatWisataController.getAllTempatWisata();
        
        /* ==> INSTANCE LAYOUT START <== */
        Label labelTitle = new Label("Daftar Tempat Wisata");
        labelTitle.setFont(Font.font("Sytem", FontWeight.BOLD, 24));
        labelTitle.getStyleClass().add("title");

        // Menampilkan daftar Tempat Wisata dengan Card View Menggunakan GridPane
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        int row = 0;

        for (TempatWisata tempat : tempatWisataData) {
            ImageView imageViewTempat = new ImageView();
            imageViewTempat.setFitWidth(250);
            imageViewTempat.setFitHeight(200);
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
            VBox vBoxNamaTempat = new VBox(labelNamaTempat, labelLokasi);
            vBoxNamaTempat.setPadding(new Insets(10, 15, 15, 15));
            vBoxNamaTempat.setSpacing(5);
            vBoxNamaTempat.getStyleClass().add("card-detail");

            HBox hBoxTempat = new HBox(vBoxImageTempat, vBoxNamaTempat);
            hBoxTempat.setPrefWidth(750);
            hBoxTempat.setMaxHeight(100);
            hBoxTempat.getStyleClass().add("card");

            hBoxTempat.setOnMouseClicked(e -> {
                DetailTempatScene detailTempatScene = new DetailTempatScene(stage);
                detailTempatScene.show(id, tempat.getId());
            });

            gridPane.add(hBoxTempat, 0, row);

            row++;
        }

        VBox vBoxMainContent = new VBox(labelTitle, gridPane);
        vBoxMainContent.setPadding(new Insets(10));
        vBoxMainContent.setSpacing(10);
        vBoxMainContent.setPrefWidth(750);
        vBoxMainContent.getStyleClass().add("scene");

        ScrollPane scrollPane = new ScrollPane(vBoxMainContent);
        scrollPane.setFitToWidth(true);
        scrollPane.getStyleClass().add("scene");
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        Navbar navbar = new Navbar();
        HBox hBoxContent = new HBox(navbar.getUserNavbar(stage, id), scrollPane);

        HBox root = new HBox(hBoxContent);
        stage.getScene().setRoot(root);
        /* ==> INSTANCE LAYOUT END <== */


    }



    protected void show() {}
    protected void show(int id, int tempatWisataId) {}
}
