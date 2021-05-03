package main.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import main.data.Person;
import main.data.Storage;

import java.util.ArrayList;

public class CreateConnectionController {

    @FXML
    private ChoiceBox<String> connectionType;

    @FXML
    private ComboBox<Person> firstPersonComboBox, secondPersonComboBox;

    public void initialize() {
        connectionType.setItems(FXCollections.observableArrayList(
                "Father", "Mother", "Child", "Grandparent", "Great-grandparent", "Other"));

        addPeopleToFirstComboBox();
    }

    private void addPeopleToFirstComboBox() {
        ArrayList<Person> list = Storage.getPeopleArray();

        for(Person person : list) {
            firstPersonComboBox.getItems().add(person);
        }
    }
}
