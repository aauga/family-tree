package main.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.data.Person;
import main.data.Storage;

import java.util.ArrayList;

public class TableController {

    @FXML
    private TableView<Person> peopleTableView;

    public void initialize() {
        TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Person, String> personalCodeCol = new TableColumn<>("Personal Code");
        personalCodeCol.setCellValueFactory(new PropertyValueFactory<>("personalCode"));

        TableColumn<Person, Integer> birthYearCol = new TableColumn<>("Birth Year");
        birthYearCol.setCellValueFactory(new PropertyValueFactory<>("birthYear"));

        TableColumn<Person, String> birthPlaceCol = new TableColumn<>("Birthplace");
        birthPlaceCol.setCellValueFactory(new PropertyValueFactory<>("birthPlace"));

        personalCodeCol.setMinWidth(100);

        peopleTableView.getColumns().add(firstNameCol);
        peopleTableView.getColumns().add(lastNameCol);
        peopleTableView.getColumns().add(personalCodeCol);
        peopleTableView.getColumns().add(birthYearCol);
        peopleTableView.getColumns().add(birthPlaceCol);

        addElementsToTable();
    }

    private void addElementsToTable() {
        ArrayList<Person> list = Storage.getPeopleArray();

        for(Person person : list) {
            peopleTableView.getItems().add(person);
        }
    }
}
