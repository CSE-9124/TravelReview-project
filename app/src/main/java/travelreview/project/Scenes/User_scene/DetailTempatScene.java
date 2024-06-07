package travelreview.project.Scenes.User_scene;

import java.io.File;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import travelreview.project.Abstract.AScene;
import travelreview.project.Models.Comment;
import travelreview.project.Models.TempatWisata;
import travelreview.project.Models.User;
import travelreview.project.Scenes.Components.Navbar;
import travelreview.project.Utils.RateUtils;
import travelreview.project.Controllers.CommentsController;
import travelreview.project.Controllers.TempatWisataController;
import travelreview.project.Controllers.UsersController;

public class DetailTempatScene extends AScene {

    public DetailTempatScene(Stage stage) {
        super(stage);
    }

    @Override
    public void show(int id, int tempatWisataId) {
        User user = UsersController.getUserById(id);

        TempatWisata tempatWisata = TempatWisataController.getTempatWisataById(tempatWisataId);

        List<Comment> comments = CommentsController.getAllCommentsByTempatWisataId(tempatWisataId);


        /* ==> INSTANCE LAYOUT START <== */
        Label labelTitle = new Label("Detail Tempat Wisata");
        labelTitle.setFont(Font.font("Sytem", FontWeight.BOLD, 24));
        labelTitle.getStyleClass().add("title");

        Label labelName = new Label(tempatWisata.getNama());
        labelName.setFont(Font.font("Sytem", FontWeight.BOLD, 24));
        labelName.getStyleClass().add("title");
        VBox vBoxName = new VBox(labelName);
        vBoxName.setAlignment(Pos.CENTER);

        ImageView imageViewTempat = new ImageView();
        imageViewTempat.setFitWidth(750);
        imageViewTempat.setFitHeight(400);
        imageViewTempat.setPreserveRatio(true);
        if (tempatWisata.getImagePath() != null && !tempatWisata.getImagePath().isEmpty()) {
            File fileImage = new File(tempatWisata.getImagePath());
            if (fileImage.exists()) {
                Image image = new Image(fileImage.toURI().toString());
                imageViewTempat.setImage(image);
            }
        }

        VBox vBoxImageTempat = new VBox(imageViewTempat);
        vBoxImageTempat.setAlignment(Pos.CENTER);

        Label labelLokasi = new Label("Lokasi");
        labelLokasi.getStyleClass().add("text");
        Label labelKota = new Label("Kota");
        labelKota.getStyleClass().add("text");
        Label labelKategori = new Label("Kategori");
        labelKategori.getStyleClass().add("text");
        Label labelRating = new Label("Rating");
        labelRating.getStyleClass().add("text");
        VBox VBoxTempatKey = new VBox(labelLokasi, labelKota, labelKategori, labelRating);

        Label labelLokasiValue = new Label(": " + tempatWisata.getLokasi());
        labelLokasiValue.getStyleClass().add("text");
        Label labelKotaValue = new Label(": " + tempatWisata.getKota());
        labelKotaValue.getStyleClass().add("text");
        Label labelKategoriValue = new Label(": " + tempatWisata.getKategori());
        labelKategoriValue.getStyleClass().add("text");
        Label labelRatingValue = new Label(": " + tempatWisata.getTotal_rating());
        labelRatingValue.getStyleClass().add("text");
        VBox VBoxTempatValue = new VBox(labelLokasiValue, labelKotaValue, labelKategoriValue, labelRatingValue);

        HBox hBoxTempat = new HBox(VBoxTempatKey, VBoxTempatValue);
        hBoxTempat.setSpacing(10);
        hBoxTempat.setPadding(new Insets(0, 20, 0, 20));

        Label labelDeskripsi = new Label("Deskripsi :");
        labelDeskripsi.setFont(Font.font("Sytem", FontWeight.BOLD, 16));
        labelDeskripsi.getStyleClass().add("text");
        Label labelDeskripsiValue = new Label(tempatWisata.getDeskripsi());
        labelDeskripsiValue.setWrapText(true);
        labelDeskripsiValue.getStyleClass().add("text");
        VBox vBoxDeskripsi = new VBox(labelDeskripsi, labelDeskripsiValue);
        vBoxDeskripsi.setPadding(new Insets(10, 20, 10, 20));
        vBoxDeskripsi.getStyleClass().add("text");

        Label labelComment = new Label("Komentar");
        labelComment.setFont(Font.font("Sytem", FontWeight.BOLD, 16));
        labelComment.setPadding(new Insets(10, 0, 0, 0));
        labelComment.getStyleClass().add("title");

        VBox vboxUsersComment = new VBox();
        vboxUsersComment.setSpacing(10);
        if (comments.size() > 0) {
            for (Comment comment : comments) {
                User userComment = UsersController.getUserById(comment.getUserId());
                Label labelUserComment = new Label(userComment.getName());
                labelUserComment.setFont(Font.font("Sytem", FontWeight.BOLD, 12));
                labelUserComment.getStyleClass().add("text");
                Label labelCommentValue = new Label(comment.getText());
                labelCommentValue.setWrapText(true);
                labelCommentValue.getStyleClass().add("text");
                VBox vBoxComment = new VBox(labelUserComment, labelCommentValue);
                vBoxComment.getStyleClass().add("comment");
                vboxUsersComment.getChildren().add(vBoxComment);
            }
        } else {
            Label labelNoComment = new Label("Belum ada komentar");
            labelNoComment.getStyleClass().add("text");
            vboxUsersComment.getChildren().add(labelNoComment);
        }

        Label labelAddComment = new Label("Tambah Komentar");
        labelAddComment.getStyleClass().add("text");
        TextField textFieldComment = new TextField();
        textFieldComment.setPromptText("Masukkan Komentar");
        textFieldComment.setPrefHeight(50);
        textFieldComment.getStyleClass().add("commentField");

        Button buttonAddComment = new Button("Tambah");
        buttonAddComment.getStyleClass().add("addCommentButton");
        ComboBox<Integer> comboBoxRating = new ComboBox<>();
        comboBoxRating.setPromptText("Rate");
        comboBoxRating.getItems().addAll(1, 2, 3, 4, 5);
        HBox hBoxComentRating = new HBox(buttonAddComment, comboBoxRating);
        hBoxComentRating.setSpacing(10);

        VBox vBoxPostComment = new VBox(labelAddComment, textFieldComment, hBoxComentRating);
        vBoxPostComment.setSpacing(5);

        VBox vBoxComments = new VBox(labelComment, vboxUsersComment, vBoxPostComment);
        vBoxComments.setSpacing(10);

        VBox vBoxMainContent = new VBox(labelTitle, vBoxName, vBoxImageTempat, hBoxTempat, vBoxDeskripsi, vBoxComments);
        vBoxMainContent.setPadding(new Insets(10));
        vBoxMainContent.setSpacing(15);
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

        /* ==> BUTTON ACTION START <== */
        buttonAddComment.setOnAction(e -> {
            String text = textFieldComment.getText();

            if (!text.isEmpty() && text != null) {
                if (CommentsController.addComment(text, user.getId(), tempatWisataId, comboBoxRating.getValue())) {
                    int jumlahReview = TempatWisataController.getJumlahReview(tempatWisataId);
                    if (TempatWisataController.updateJumlahReview(tempatWisataId, jumlahReview + 1)) {
                        jumlahReview++;
                        double totalRate = RateUtils.calculateRatingAverageDouble(jumlahReview, CommentsController.getTotalRatingByTempatWisataId(tempatWisataId));
                        if (TempatWisataController.updateTotalRating(tempatWisataId, totalRate)) {
                        DetailTempatScene detailTempatScene = new DetailTempatScene(stage);
                        detailTempatScene.show(id, tempatWisataId);
                        }
                    }
                }
            }
        });
        /* ==> BUTTON ACTION END <== */
    }



    protected void show() {}
    protected void show(int id) {}
}
