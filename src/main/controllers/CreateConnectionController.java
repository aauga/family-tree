package main.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class CreateConnectionController {

    @FXML
    private ChoiceBox<String> connectionType;

    public void initialize() {
        connectionType.setItems(FXCollections.observableArrayList(
                "Father", "Mother", "Child", "Grandparent", "Great-grandparent", "Other"));
    }
}
