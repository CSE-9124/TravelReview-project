package travelreview.project.Scenes.Components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import travelreview.project.Scenes.LoginScene;
import travelreview.project.Scenes.Admin_scene.AdminHomeScene;
import travelreview.project.Scenes.Admin_scene.TableListScene;
import travelreview.project.Scenes.Admin_scene.AddTempatWisataScene;
import travelreview.project.Scenes.User_scene.HomeScene;
import travelreview.project.Scenes.User_scene.ProfileScene;
import travelreview.project.Scenes.User_scene.TempatListScene;

public class Navbar {
    public VBox getUserNavbar(Stage stage, int id) {
        /* ==> INSTANCE LAYOUT START <== */

        Image logoApp = new Image(getClass().getResourceAsStream("/images/LOGO.jpg"));
        ImageView logoViewApp = new ImageView(logoApp);
        logoViewApp.setFitWidth(50);
        logoViewApp.setFitHeight(50);

        Image space = new Image(getClass().getResourceAsStream("/images/navbar-icon/Space.png"));
        ImageView spaceView = new ImageView(space);
        spaceView.setFitWidth(30);
        spaceView.setFitHeight(30);

        Button buttonHome = new Button();
        Image homeIcon = new Image(getClass().getResourceAsStream("/images/navbar-icon/HomeIcon.png"));
        ImageView homeIconView = new ImageView(homeIcon);
        homeIconView.setFitWidth(30);
        homeIconView.setFitHeight(30);
        buttonHome.setGraphic(homeIconView);
        buttonHome.getStyleClass().add("navbarbutton");

        Button buttonListTempat = new Button();
        Image listTempatIcon = new Image(getClass().getResourceAsStream("/images/navbar-icon/ListIcon.png"));
        ImageView listTempatIconView = new ImageView(listTempatIcon);
        listTempatIconView.setFitWidth(30);
        listTempatIconView.setFitHeight(30);
        buttonListTempat.setGraphic(listTempatIconView);
        buttonListTempat.getStyleClass().add("navbarbutton");
        
        Button buttonProfile = new Button();
        Image profileIcon = new Image(getClass().getResourceAsStream("/images/navbar-icon/ProfileIcon.png"));
        ImageView profileIconView = new ImageView(profileIcon);
        profileIconView.setFitWidth(30);
        profileIconView.setFitHeight(30);
        buttonProfile.setGraphic(profileIconView);
        buttonProfile.getStyleClass().add("navbarbutton");

        Button buttonLogout = new Button();
        Image logoutIcon = new Image(getClass().getResourceAsStream("/images/navbar-icon/LogoutIcon.png"));
        ImageView logoutIconView = new ImageView(logoutIcon);
        logoutIconView.setFitWidth(30);
        logoutIconView.setFitHeight(30);
        buttonLogout.setGraphic(logoutIconView);
        buttonLogout.getStyleClass().add("navbarbutton");

        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);

        VBox navbar = new VBox(logoViewApp, spaceView, buttonHome, buttonListTempat, buttonProfile, spacer, buttonLogout);
        navbar.setPrefWidth(90);
        navbar.setPrefHeight(580);
        navbar.setAlignment(Pos.CENTER);
        navbar.setPadding(new Insets(10, 0, 10, 0));
        navbar.getStyleClass().add("navbar");
        /* ==> INSTANCE LAYOUT END <== */

        /* ==> BUTTON ACTION START <== */
        // Button Home
        buttonHome.setOnMouseEntered(e -> {
            Image homeIconHover = new Image(getClass().getResourceAsStream("/images/navbar-icon/HomeIconHover.png"));
            homeIconView.setImage(homeIconHover);
            Tooltip tooltip = new Tooltip("Home");
            tooltip.setStyle("-fx-font-size: 13");
            tooltip.setShowDelay(Duration.millis(100)); // Set the show delay to 100 milliseconds
            tooltip.setShowDuration(Duration.INDEFINITE);
            buttonHome.setTooltip(tooltip);
        });

        buttonHome.setOnMouseExited(e -> {
            homeIconView.setImage(homeIcon);
            buttonHome.setTooltip(null);
        });

        buttonHome.setOnAction(e -> {
            HomeScene homeScene = new HomeScene(stage);
            homeScene.show(id);
        });

        // Button List Tempat
        buttonListTempat.setOnMouseEntered(e -> {
            Image listTempatIconHover = new Image(getClass().getResourceAsStream("/images/navbar-icon/ListIconHover.png"));
            listTempatIconView.setImage(listTempatIconHover);
            Tooltip tooltip = new Tooltip("List Tempat Wisata");
            tooltip.setStyle("-fx-font-size: 13");
            tooltip.setShowDelay(Duration.millis(100)); // Set the show delay to 100 milliseconds
            tooltip.setShowDuration(Duration.INDEFINITE);
            buttonListTempat.setTooltip(tooltip);
        });

        buttonListTempat.setOnMouseExited(e -> {
            listTempatIconView.setImage(listTempatIcon);
            buttonListTempat.setTooltip(null);
        });

        buttonListTempat.setOnAction(e -> {
            TempatListScene tempatListScene = new TempatListScene(stage);
            tempatListScene.show(id);
        });

        // Button Profile
        buttonProfile.setOnMouseEntered(e -> {
            Image profileIconHover = new Image(getClass().getResourceAsStream("/images/navbar-icon/ProfileIconHover.png"));
            profileIconView.setImage(profileIconHover);
            Tooltip tooltip = new Tooltip("Profile");
            tooltip.setStyle("-fx-font-size: 13");
            tooltip.setShowDelay(Duration.millis(100)); // Set the show delay to 100 milliseconds
            tooltip.setShowDuration(Duration.INDEFINITE);
            buttonProfile.setTooltip(tooltip);
        });

        buttonProfile.setOnMouseExited(e -> {
            profileIconView.setImage(profileIcon);
            buttonProfile.setTooltip(null);
        });

        buttonProfile.setOnAction(e -> {
            ProfileScene profileScene = new ProfileScene(stage);
            profileScene.show(id);
        });

        // Button Logout
        buttonLogout.setOnMouseEntered(e -> {
            Image logoutIconHover = new Image(getClass().getResourceAsStream("/images/navbar-icon/LogoutIconHover.png"));
            logoutIconView.setImage(logoutIconHover);
            Tooltip tooltip = new Tooltip("Logout");
            tooltip.setStyle("-fx-font-size: 13");
            tooltip.setShowDelay(Duration.millis(100)); // Set the show delay to 100 milliseconds
            tooltip.setShowDuration(Duration.INDEFINITE);
            buttonLogout.setTooltip(tooltip);
        });

        buttonLogout.setOnMouseExited(e -> {
            logoutIconView.setImage(logoutIcon);
            buttonLogout.setText("");
        });

        buttonLogout.setOnAction(e -> {
            LoginScene loginScene = new LoginScene(stage);
            loginScene.show();
        });
        /* ==> BUTTON ACTION END <== */

        return navbar;
    }

    public VBox getAdminNavbar(Stage stage, int id) {
        /* ==> INSTANCE LAYOUT START <== */

        Image logoApp = new Image(getClass().getResourceAsStream("/images/LOGO.jpg"));
        ImageView logoViewApp = new ImageView(logoApp);
        logoViewApp.setFitWidth(50);
        logoViewApp.setFitHeight(50);

        Image space = new Image(getClass().getResourceAsStream("/images/navbar-icon/Admin-Space.png"));
        ImageView spaceView = new ImageView(space);
        spaceView.setFitWidth(30);
        spaceView.setFitHeight(30);

        Button buttonHome = new Button();
        Image homeIcon = new Image(getClass().getResourceAsStream("/images/navbar-icon/AdminHome.png"));
        ImageView homeIconView = new ImageView(homeIcon);
        homeIconView.setFitWidth(30);
        homeIconView.setFitHeight(30);
        buttonHome.setGraphic(homeIconView);
        buttonHome.getStyleClass().add("navbarbutton");

        Button buttonListTempat = new Button();
        Image listTempatIcon = new Image(getClass().getResourceAsStream("/images/navbar-icon/AdminTable.png"));
        ImageView listTempatIconView = new ImageView(listTempatIcon);
        listTempatIconView.setFitWidth(30);
        listTempatIconView.setFitHeight(30);
        buttonListTempat.setGraphic(listTempatIconView);
        buttonListTempat.getStyleClass().add("navbarbutton");

        Button buttonAdd = new Button();
        Image addIcon = new Image(getClass().getResourceAsStream("/images/navbar-icon/AdminAdd.png"));
        ImageView addIconView = new ImageView(addIcon);
        addIconView.setFitWidth(30);
        addIconView.setFitHeight(30);
        buttonAdd.setGraphic(addIconView);
        buttonAdd.getStyleClass().add("navbarbutton");

        Button buttonLogout = new Button();
        Image logoutIcon = new Image(getClass().getResourceAsStream("/images/navbar-icon/AdminLogOut.png"));
        ImageView logoutIconView = new ImageView(logoutIcon);
        logoutIconView.setFitWidth(30);
        logoutIconView.setFitHeight(30);
        buttonLogout.setGraphic(logoutIconView);
        buttonLogout.getStyleClass().add("navbarbutton");

        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);

        VBox navbar = new VBox(logoViewApp, spaceView, buttonHome, buttonListTempat, buttonAdd, spacer, buttonLogout);
        navbar.setPrefWidth(90);
        navbar.setPrefHeight(580);
        navbar.setAlignment(Pos.CENTER);
        navbar.setPadding(new Insets(10, 0, 10, 0));
        navbar.getStyleClass().add("admin-navbar");
        /* ==> INSTANCE LAYOUT END <== */

        /* ==> BUTTON ACTION START <== */
        // Button Home
        buttonHome.setOnMouseEntered(e -> {
            Image homeIconHover = new Image(getClass().getResourceAsStream("/images/navbar-icon/AdminHomeHover.png"));
            homeIconView.setImage(homeIconHover);
            Tooltip tooltip = new Tooltip("Home");
            tooltip.setStyle("-fx-font-size: 13");
            tooltip.setShowDelay(Duration.millis(100)); // Set the show delay to 100 milliseconds
            tooltip.setShowDuration(Duration.INDEFINITE);
            buttonHome.setTooltip(tooltip);
        });

        buttonHome.setOnMouseExited(e -> {
            homeIconView.setImage(homeIcon);
            buttonHome.setTooltip(null);
        });

        buttonHome.setOnAction(e -> {
            AdminHomeScene adminHomeScene = new AdminHomeScene(stage);
            adminHomeScene.show(id);
        });

        // Button List Table Tempat
        buttonListTempat.setOnMouseEntered(e -> {
            Image listTempatIconHover = new Image(getClass().getResourceAsStream("/images/navbar-icon/AdminTableHover.png"));
            listTempatIconView.setImage(listTempatIconHover);
            Tooltip tooltip = new Tooltip("Tabel Tempat Wisata");
            tooltip.setStyle("-fx-font-size: 13");
            tooltip.setShowDelay(Duration.millis(100)); // Set the show delay to 100 milliseconds
            tooltip.setShowDuration(Duration.INDEFINITE);
            buttonListTempat.setTooltip(tooltip);
        });

        buttonListTempat.setOnMouseExited(e -> {
            listTempatIconView.setImage(listTempatIcon);
            buttonListTempat.setTooltip(null);
        });

        buttonListTempat.setOnAction(e -> {
            TableListScene tableListScene = new TableListScene(stage);
            tableListScene.show(id);
        });

        // Button Add Tempat
        buttonAdd.setOnMouseEntered(e -> {
            Image addIconHover = new Image(getClass().getResourceAsStream("/images/navbar-icon/AdminAddHover.png"));
            addIconView.setImage(addIconHover);
            Tooltip tooltip = new Tooltip("Tambah Tempat Wisata");
            tooltip.setStyle("-fx-font-size: 13");
            tooltip.setShowDelay(Duration.millis(100)); // Set the show delay to 100 milliseconds
            tooltip.setShowDuration(Duration.INDEFINITE);
            buttonAdd.setTooltip(tooltip);
        });

        buttonAdd.setOnMouseExited(e -> {
            addIconView.setImage(addIcon);
            buttonAdd.setTooltip(null);
        });

        buttonAdd.setOnAction(e -> {
            AddTempatWisataScene addTempatScene = new AddTempatWisataScene(stage);
            addTempatScene.show(id);
        });

        // Button Logout
        buttonLogout.setOnMouseEntered(e -> {
            Image logoutIconHover = new Image(getClass().getResourceAsStream("/images/navbar-icon/AdminLogOutHover.png"));
            logoutIconView.setImage(logoutIconHover);
            Tooltip tooltip = new Tooltip("Logout");
            tooltip.setStyle("-fx-font-size: 13");
            tooltip.setShowDelay(Duration.millis(100)); // Set the show delay to 100 milliseconds
            tooltip.setShowDuration(Duration.INDEFINITE);
            buttonLogout.setTooltip(tooltip);
        });

        buttonLogout.setOnMouseExited(e -> {
            logoutIconView.setImage(logoutIcon);
            buttonLogout.setText("");
        });

        buttonLogout.setOnAction(e -> {
            LoginScene loginScene = new LoginScene(stage);
            loginScene.show();
        });
        /* ==> BUTTON ACTION END <== */

        return navbar;
    }

}
