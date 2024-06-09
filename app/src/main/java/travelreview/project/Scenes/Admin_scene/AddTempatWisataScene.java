package travelreview.project.Scenes.Admin_scene;

import java.io.File;
import java.io.IOException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import travelreview.project.Abstract.AScene;
import travelreview.project.Controllers.TempatWisataController;
import travelreview.project.Scenes.Components.Navbar;
import travelreview.project.Utils.ImageUtils;

public class AddTempatWisataScene extends AScene{
    private File selectedImageFile;

    public AddTempatWisataScene(Stage stage) {
        super(stage);
    }

    @Override
    public void show(int id) {
        /* ==> INSTANCE LAYOUT START <== */
        Label labelTitle = new Label("Tambah Tempat Wisata");
        labelTitle.setFont(Font.font("Sytem", FontWeight.BOLD, 24));
        labelTitle.setAlignment(Pos.CENTER);
        labelTitle.getStyleClass().add("title");

        Image imageUpload = new Image(getClass().getResourceAsStream("/images/ImageUpload.png"));
        ImageView imageViewUpload = new ImageView(imageUpload);
        imageViewUpload.setFitWidth(200);
        imageViewUpload.setFitHeight(200);
        imageViewUpload.setPreserveRatio(true);

        HBox hBoxImageUpload = new HBox(imageViewUpload);
        hBoxImageUpload.setAlignment(Pos.CENTER);
        hBoxImageUpload.setPadding(new javafx.geometry.Insets(10));
        hBoxImageUpload.setPrefSize(750, 200);
        hBoxImageUpload.getStyleClass().add("image-upload");

        Label labelnama = new Label("Nama Tempat Wisata");
        labelnama.getStyleClass().add("text");
        Label labelLokasi = new Label("Lokasi Tempat Wisata");
        labelLokasi.getStyleClass().add("text");
        Label labelKota = new Label("Kota");
        labelKota.getStyleClass().add("text");
        Label labelKategori = new Label("Kategori");
        labelKategori.getStyleClass().add("text");

        TextField textFieldNama = new TextField();
        textFieldNama.setPrefSize(360, 45);
        textFieldNama.getStyleClass().add("addTempatField");
        TextField textFieldLokasi = new TextField();
        textFieldLokasi.setPrefSize(360, 45);
        textFieldLokasi.getStyleClass().add("addTempatField");
        TextField textFieldKota = new TextField();
        textFieldKota.setPrefSize(360, 45);
        textFieldKota.getStyleClass().add("addTempatField");
        TextField textFieldKategori = new TextField();
        textFieldKategori.setPrefSize(360, 45);
        textFieldKategori.getStyleClass().add("addTempatField");

        VBox vBoxInputNama = new VBox(labelnama, textFieldNama);
        vBoxInputNama.setSpacing(5);
        VBox vBoxInputLokasi = new VBox(labelLokasi, textFieldLokasi);
        vBoxInputLokasi.setSpacing(5);

        VBox vBoxInput1 = new VBox(vBoxInputNama, vBoxInputLokasi);
        vBoxInput1.setSpacing(15);

        VBox vBoxInputKota = new VBox(labelKota, textFieldKota);
        vBoxInputKota.setSpacing(5);
        VBox vBoxInputKategori = new VBox(labelKategori, textFieldKategori);
        vBoxInputKategori.setSpacing(5);

        VBox vBoxInput2 = new VBox(vBoxInputKota, vBoxInputKategori);
        vBoxInput2.setSpacing(15);

        HBox hBoxInput = new HBox(vBoxInput1, vBoxInput2);
        hBoxInput.setSpacing(20);
        hBoxInput.setAlignment(Pos.CENTER);

        Label labelDeskripsi = new Label("Deskripsi Tempat Wisata");
        labelDeskripsi.getStyleClass().add("text");
        TextArea textAreaDeskripsi = new TextArea();
        textAreaDeskripsi.setPrefWidth(500);
        textAreaDeskripsi.setPrefHeight(200);
        textAreaDeskripsi.setWrapText(true);
        textAreaDeskripsi.getStyleClass().add("addTempatTextArea");

        VBox vBoxInputDeskripsi = new VBox(labelDeskripsi, textAreaDeskripsi);
        vBoxInputDeskripsi.setSpacing(5);

        Button buttonSubmit = new Button("Submit");
        buttonSubmit.setPrefSize(750, 45);
        buttonSubmit.getStyleClass().add("addTempatButton");

        VBox vBoxMainContent = new VBox(labelTitle, hBoxImageUpload, hBoxInput, vBoxInputDeskripsi, buttonSubmit);
        vBoxMainContent.setAlignment(Pos.CENTER);
        vBoxMainContent.setPadding(new Insets(10));
        vBoxMainContent.setSpacing(10);
        vBoxMainContent.setPrefWidth(750);
        vBoxMainContent.getStyleClass().add("scene");

        ScrollPane scrollPane = new ScrollPane(vBoxMainContent);
        scrollPane.setFitToWidth(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        Navbar navbar = new Navbar();
        HBox hBoxContent = new HBox(navbar.getAdminNavbar(stage, id), vBoxMainContent);
        stage.getScene().setRoot(hBoxContent);
        /* ==> INSTANCE LAYOUT END <== */

        /* ==> BUTTON ACTION START <== */
        buttonSubmit.setOnAction(e -> {
            // Add Tempat Wisata
            String nama = textFieldNama.getText();
            String lokasi = textFieldLokasi.getText();
            String kota = textFieldKota.getText();
            String kategori = textFieldKategori.getText();
            String deskripsi = textAreaDeskripsi.getText();

            String imagePath = null;
            if (selectedImageFile != null) {
                try {
                    imagePath = ImageUtils.saveImageTempat(selectedImageFile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }

            boolean isSuccessfulyAdd = TempatWisataController.addTempatWisata(nama, imagePath, lokasi, kota, kategori, deskripsi);
            if (isSuccessfulyAdd) {
                TableListScene tableListScene = new TableListScene(stage);
                tableListScene.show(id);
            }
        });

        imageViewUpload.setOnMouseClicked(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                selectedImageFile = file;
                Image image = new Image(file.toURI().toString());
                imageViewUpload.setImage(image);
            }
        });
    }



    protected void show() {}
    protected void show(int id, int tempatWisataId) {}
    
}
