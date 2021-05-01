package main.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.data.Canvas;

import java.io.IOException;

public class MainController {

    @FXML
    private AnchorPane canvas;

    public void initialize() {
        Canvas.setCanvas(canvas);
    }

    public void showAddPersonWindow() {
        int windowWidth = 300;
        int windowHeight = 350;

        canvas.setOnMouseClicked(mouseEvent -> {
            Canvas.setMousePosX(mouseEvent.getX());
            Canvas.setMousePosY(mouseEvent.getY());

            Parent parent = null;

            try {
                parent = FXMLLoader.load(getClass().getResource("../layouts/addPersonLayout.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Stage stage = new Stage();
            stage.setTitle("Add a Person");
            stage.setScene(new Scene(parent, windowWidth, windowHeight));
            stage.setMinWidth(windowWidth + 15);
            stage.setMinHeight(windowHeight + 40);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        });
    }

    @FXML
    public void enlargeCanvas() {
        canvas.setPrefHeight(canvas.getHeight() + 50.0);
        canvas.setPrefWidth(canvas.getWidth() + 50.0);
    }
}
