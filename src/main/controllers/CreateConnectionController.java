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

public class CreateConnectionController {

    @FXML
    private ChoiceBox<String> connectionType;

    @FXML
    private ComboBox<Person> firstPersonComboBox, secondPersonComboBox;

    @FXML
    private Button createConnectionButton;

    private ArrayList<Person> list;

    public void initialize() {
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
        createConnectionButton.setDisable(true);

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
        createConnectionButton.setDisable(true);

        connectionType.setDisable(false);
    }

    @FXML
    public void connectionTypeSelected() {
        createConnectionButton.setDisable(false);
    }

    @FXML
    public void createConnection() {
        Person firstPerson = firstPersonComboBox.getSelectionModel().getSelectedItem();
        Person secondPerson = secondPersonComboBox.getSelectionModel().getSelectedItem();

        firstPerson.addConnection(secondPerson);
        secondPerson.addConnection(firstPerson);

        ConnectionLine connectionLine = new ConnectionLine(firstPerson, secondPerson);
        Storage.addLine(connectionLine);
        Canvas.addLine(connectionLine);

        // Close window
        Stage stage = (Stage) createConnectionButton.getScene().getWindow();
        stage.close();
    }
}
