package main.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.data.Canvas;

public class MainController {

    @FXML
    private AnchorPane canvas;

    public void showAddPersonWindow() throws Exception {
        int windowWidth = 300;
        int windowHeight = 350;

        Parent parent = FXMLLoader.load(getClass().getResource("../layouts/addPersonLayout.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Add a Person");
        stage.setScene(new Scene(parent, windowWidth, windowHeight));
        stage.setMinWidth(windowWidth + 15);
        stage.setMinHeight(windowHeight + 40);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();

        getMouseCoordinates();
    }

    private void getMouseCoordinates() {
        canvas.setOnMouseClicked(mouseEvent -> {
            Canvas.setMousePosX(mouseEvent.getX());
            Canvas.setMousePosY(mouseEvent.getY());
        });
    }

    @FXML
    public void enlargeCanvas() {
        canvas.setPrefHeight(canvas.getHeight() + 50.0);
        canvas.setPrefWidth(canvas.getWidth() + 50.0);
    }
}
