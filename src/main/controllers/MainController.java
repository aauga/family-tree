package main.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {

    public void showAddPersonWindow() throws Exception {
        int windowWidth = 250;
        int windowHeight = 350;

        Parent parent = FXMLLoader.load(getClass().getResource("../layouts/addPersonLayout.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Add a Person");
        stage.setScene(new Scene(parent, windowWidth, windowHeight));
        stage.setMinWidth(windowWidth + 15);
        stage.setMinHeight(windowHeight + 40);
        stage.show();
    }
}
