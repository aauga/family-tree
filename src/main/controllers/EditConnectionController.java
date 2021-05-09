package main.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import main.data.Canvas;
import main.data.ConnectionLine;
import main.data.Person;
import main.data.Storage;

public class EditConnectionController {

    @FXML
    private Label firstPersonLabel, secondPersonLabel;

    @FXML
    private ChoiceBox<String> connectionType;

    @FXML
    private Button deleteConnectionButton, editConnectionButton;

    private ConnectionLine selectedLine;
    private Person firstPerson, secondPerson;

    public void initialize() {
        connectionType.setItems(FXCollections.observableArrayList(
                "Father", "Mother", "Child", "Grandparent", "Great-grandparent", "Other"));

        selectedLine = Canvas.getSelectedLine();

        firstPerson = selectedLine.getFirstPerson();
        secondPerson = selectedLine.getSecondPerson();
        String connection = selectedLine.getConnectionType();

        firstPersonLabel.setText(firstPerson.toString());
        secondPersonLabel.setText(secondPerson.toString());
        connectionType.getSelectionModel().select(connection);
    }

    @FXML
    public void editConnection() {
        String connection = connectionType.getValue();
        selectedLine.setConnectionType(connection);

        // Close window
        Stage stage = (Stage) editConnectionButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void deleteConnection() {
        firstPerson.removeConnection(secondPerson);
        secondPerson.removeConnection(firstPerson);

        Canvas.removeLine(selectedLine.getLine());
        Storage.removeLine(selectedLine);

        // Close window
        Stage stage = (Stage) deleteConnectionButton.getScene().getWindow();
        stage.close();
    }
}
