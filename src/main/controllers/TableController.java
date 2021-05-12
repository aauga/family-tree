package main.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.data.ConnectionLine;
import main.data.Person;
import main.data.Storage;

import java.util.ArrayList;

public class TableController {

    @FXML
    private TableView<Person> peopleTableView;

    @FXML
    private TableView<ConnectionLine> connectionsTableView;

    public void initialize() {
        initializePeopleTable();
        initializeConnectionTable();
        populatePeopleTable();
        populateConnectionTable();
    }

    private void initializePeopleTable() {
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
    }

    private void initializeConnectionTable() {
        TableColumn<ConnectionLine, String> connectionTypeCol = new TableColumn<>("Connection");
        connectionTypeCol.setCellValueFactory(new PropertyValueFactory<>("connectionType"));

        TableColumn<ConnectionLine, String> firstPersonData = new TableColumn<>("First Person");
        firstPersonData.setCellValueFactory(new PropertyValueFactory<>("firstPerson"));

        TableColumn<ConnectionLine, String> secondPersonData = new TableColumn<>("Second Person");
        secondPersonData.setCellValueFactory(new PropertyValueFactory<>("secondPerson"));

        connectionsTableView.getColumns().add(firstPersonData);
        connectionsTableView.getColumns().add(connectionTypeCol);
        connectionsTableView.getColumns().add(secondPersonData);
    }

    private void populatePeopleTable() {
        ArrayList<Person> list = Storage.getPeopleArray();

        for(Person person : list) {
            peopleTableView.getItems().add(person);
        }
    }

    private void populateConnectionTable() {
        ArrayList<ConnectionLine> list = Storage.getConnectionLineArray();

        for(ConnectionLine connection : list) {
            connectionsTableView.getItems().add(connection);
        }
    }
}
