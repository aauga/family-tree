package main.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class CreateConnectionController {

    @FXML
    private ChoiceBox connectionType;

    public void initialize() {
        connectionType.getItems().add("Father");
        connectionType.getItems().add("Mother");
        connectionType.getItems().add("Child");
        connectionType.getItems().add("Grandparent");
        connectionType.getItems().add("Great-Grandparent");
        connectionType.getItems().add("Other");
    }
}
