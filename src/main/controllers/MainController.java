package main.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.data.Canvas;

import java.io.IOException;

public class MainController {

    @FXML
    private AnchorPane canvas;

    public void initialize() {
        Canvas.setCanvas(canvas);
    }

    @FXML
    public void showCreatePersonWindow() {
        canvas.setOnMouseClicked(mouseEvent -> {
            Canvas.setMousePosX(mouseEvent.getX());
            Canvas.setMousePosY(mouseEvent.getY());

            Parent parent = null;
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../layouts/createPerson.fxml"));

            try {
                parent = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            stage.setTitle("Add a Person");
            stage.setScene(new Scene(parent, 300, 350));
            stage.setResizable(false);

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        });
    }

    @FXML
    public void showCreateConnectionWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../layouts/createConnection.fxml"));
        Parent parent = loader.load();
        Stage stage = new Stage();

        stage.setTitle("Create a Connection");
        stage.setScene(new Scene(parent, 300, 300));
        stage.setResizable(false);

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    public void enlargeCanvas() {
        canvas.setPrefHeight(canvas.getHeight() + 50.0);
        canvas.setPrefWidth(canvas.getWidth() + 50.0);
    }
}
