package main.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import main.data.Canvas;
import main.data.ConnectionLine;
import main.data.Person;
import main.data.Storage;

import java.util.ArrayList;

public class EditConnectionController {

    @FXML
    private ChoiceBox<String> connectionType;

    @FXML
    private ComboBox<Person> firstPersonComboBox, secondPersonComboBox;

    @FXML
    private Button deleteConnectionButton, editConnectionButton;

    private ArrayList<Person> list;
    private ConnectionLine selectedLine;

    public void initialize() {
        selectedLine = Canvas.getSelectedLine();

        list = Storage.getPeopleArray();

        connectionType.setItems(FXCollections.observableArrayList(
                "Father", "Mother", "Child", "Grandparent", "Great-grandparent", "Other"));

        addPeopleToFirstComboBox();
    }

    private void addPeopleToFirstComboBox() {
        for(Person person : list) {
            firstPersonComboBox.getItems().add(person);
        }
    }

    @FXML
    public void firstPersonSelected() {
        //If first person selected more than once, reset fields
        secondPersonComboBox.getSelectionModel().clearSelection();
        secondPersonComboBox.getItems().clear();
        connectionType.setDisable(true);
        editConnectionButton.setDisable(true);

        Person selectedPerson = firstPersonComboBox.getSelectionModel().getSelectedItem();
        addPeopleToSecondComboBox(selectedPerson);

        secondPersonComboBox.setDisable(false);
    }

    private void addPeopleToSecondComboBox(Person selectedPerson) {
        ArrayList<Person> connections = selectedPerson.getConnections();

        for(Person person : list) {
            if(person != selectedPerson && (connections == null || !connections.contains(person))) {
                secondPersonComboBox.getItems().add(person);
            }
        }
    }

    @FXML
    public void secondPersonSelected() {
        //If second person selected more than once, reset fields
        connectionType.getSelectionModel().clearSelection();
        editConnectionButton.setDisable(true);

        connectionType.setDisable(false);
    }

    @FXML
    public void connectionTypeSelected() {
        editConnectionButton.setDisable(false);
    }

    @FXML
    public void editConnection() {
        // Close window
        Stage stage = (Stage) editConnectionButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void deleteConnection() {
        // Close window
        Stage stage = (Stage) deleteConnectionButton.getScene().getWindow();
        stage.close();
    }
}
