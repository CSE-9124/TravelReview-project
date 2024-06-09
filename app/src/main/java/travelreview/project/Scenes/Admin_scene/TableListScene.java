package travelreview.project.Scenes.Admin_scene;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Callback;
import travelreview.project.Abstract.AScene;
import travelreview.project.Controllers.TempatWisataController;
import travelreview.project.Models.TempatWisata;
import travelreview.project.Scenes.Components.Navbar;

public class TableListScene extends AScene{

    public TableListScene(Stage stage) {
        super(stage);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void show(int id) {
        List<TempatWisata> tempatWisataData = TempatWisataController.getAllTempatWisata();

        /* ==> INSTANCE LAYOUT START <== */
        Label labelTitle = new Label("Daftar Tempat Wisata");
        labelTitle.setFont(Font.font("Sytem", FontWeight.BOLD, 24));
        labelTitle.setAlignment(Pos.CENTER);
        labelTitle.getStyleClass().add("title");

        ObservableList<TempatWisata> data = FXCollections.observableArrayList();
        data.addAll(tempatWisataData);

        TableView<TempatWisata> tableView = new TableView<>();

        TableColumn<TempatWisata, String> columnId = new TableColumn<>("Id");
        TableColumn<TempatWisata, String> columnNama = new TableColumn<>("Nama Tempat");
        TableColumn<TempatWisata, String> columnLokasi = new TableColumn<>("Lokasi Tempat");
        TableColumn<TempatWisata, String> columnKota = new TableColumn<>("Kota");
        TableColumn<TempatWisata, String> columnKategori = new TableColumn<>("Kategori");
        TableColumn<TempatWisata, String> columnJumlahRating = new TableColumn<>("Jumlah Rating");
        TableColumn<TempatWisata, String> columnTotalRate = new TableColumn<>("Total Rate");
        TableColumn<TempatWisata, String> columnAction = new TableColumn<>("Action");

        columnId.setPrefWidth(40);
        columnNama.setPrefWidth(200);
        columnLokasi.setPrefWidth(150);
        columnKota.setPrefWidth(100);
        columnKategori.setPrefWidth(200);
        columnJumlahRating.setPrefWidth(150);
        columnTotalRate.setPrefWidth(100);
        columnAction.setPrefWidth(140);

        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        columnLokasi.setCellValueFactory(new PropertyValueFactory<>("lokasi"));
        columnKota.setCellValueFactory(new PropertyValueFactory<>("kota"));
        columnKategori.setCellValueFactory(new PropertyValueFactory<>("kategori"));
        columnJumlahRating.setCellValueFactory(new PropertyValueFactory<>("jumlah_review"));
        columnTotalRate.setCellValueFactory(new PropertyValueFactory<>("total_rating"));

        tableView.getColumns().addAll(columnId, columnNama, columnLokasi, columnKota, columnKategori, columnJumlahRating, columnTotalRate, columnAction);
        tableView.setItems(data);
        tableView.getStyleClass().add("table");

        VBox vBoxMainContent = new VBox(labelTitle, tableView);
        vBoxMainContent.setPadding(new Insets(10));
        vBoxMainContent.setSpacing(10);
        vBoxMainContent.setPrefWidth(750);
        vBoxMainContent.setPrefHeight(500);
        vBoxMainContent.setAlignment(Pos.CENTER);
        vBoxMainContent.getStyleClass().add("scene");

        Navbar navbar = new Navbar();
        HBox hBoxContent = new HBox(navbar.getAdminNavbar(stage, id), vBoxMainContent);
        stage.getScene().setRoot(hBoxContent);
        /* ==> INSTANCE LAYOUT END <== */

        /* ==> ACTION EVENT <== */
        columnAction.setCellFactory(new Callback<TableColumn<TempatWisata, String>, TableCell<TempatWisata, String>>() {
            @Override
            public TableCell<TempatWisata, String> call(TableColumn<TempatWisata, String> param) {
                TableCell<TempatWisata, String> cell = new TableCell<TempatWisata, String>() {

                    final Button btnEdit = new Button("Edit");
                    final Button btnDelete = new Button("Delete");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btnEdit.setOnAction(event -> {
                                TempatWisata tempatWisata = getTableView().getItems().get(getIndex());
                                EditTempatWisataScene editTempatWisataScene = new EditTempatWisataScene(stage);
                                editTempatWisataScene.show(id, tempatWisata.getId());
                            });
                            btnDelete.setOnAction(event -> {
                                TempatWisata tempatWisata = getTableView().getItems().get(getIndex());
                                boolean isSuccessfulyDelete = TempatWisataController.deleteTempatWisata(tempatWisata.getId());
                                if (isSuccessfulyDelete) {
                                    TableListScene tableListScene = new TableListScene(stage);
                                    tableListScene.show(id);
                                }
                            });
                            HBox hBox = new HBox(btnEdit, btnDelete);
                            hBox.setSpacing(5);
                            setGraphic(hBox);
                            setText(null);
                        }
                    }
                };
                return cell;
                
            }
        });
    }



    protected void show() {}
    protected void show(int id, int tempatWisataId) {}
}
