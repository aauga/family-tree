package main.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import main.util.CanvasUtil;
import main.data.ConnectionLine;
import main.data.Person;
import main.data.Storage;
import main.util.TableUtil;
import main.util.dataFilteringUtil.ConnectionFilter;
import main.util.dataFilteringUtil.FilterFirstname;
import main.util.dataFilteringUtil.FilterLastname;
import main.util.dataFilteringUtil.PersonFilter;

import java.util.ArrayList;

public class TableController {

    private ArrayList<Person> peopleList;
    private ArrayList<ConnectionLine> connectionList;

    @FXML
    private TableView<Person> peopleTableView;

    @FXML
    private TableView<ConnectionLine> connectionsTableView;

    @FXML
    private RadioButton firstNameRadioButton, lastNameRadioButton, connectionRadioButton;

    @FXML
    private TextField criteriaTextField;

    @FXML
    private ChoiceBox<String> connectionChoiceBox;

    @FXML
    private AnchorPane peopleAnchorPane, connectionAnchorPane;

    public void initialize() {
        TableUtil.setPeopleTable(peopleAnchorPane);
        TableUtil.setConnectionTable(connectionAnchorPane);

        peopleList = Storage.getPeopleArray();
        connectionList = Storage.getConnectionLineArray();

        initializePeopleTable();
        initializeConnectionTable();

        populateConnectionChoiceBox();

        populatePeopleTable(peopleList);
        populateConnectionTable(connectionList);
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

    private void populateConnectionChoiceBox() {
        connectionChoiceBox.setItems(FXCollections.observableArrayList(
                "Father", "Mother", "Child", "Grandparent", "Great-grandparent", "Other"));
    }

    private void populatePeopleTable(ArrayList<Person> list) {
        peopleTableView.getItems().clear();

        for(Person person : list) {
            peopleTableView.getItems().add(person);
        }
    }

    private void populateConnectionTable(ArrayList<ConnectionLine> list) {
        connectionsTableView.getItems().clear();

        for(ConnectionLine connection : list) {
            connectionsTableView.getItems().add(connection);
        }
    }

    @FXML
    public void handleCriteriaTextField() {
        String criteria = criteriaTextField.getText();
        ArrayList<Person> filteredPeopleList = new ArrayList<>();
        ArrayList<ConnectionLine> filteredConnectionList = new ArrayList<>();

        if(firstNameRadioButton.isSelected()) {
            PersonFilter firstNameCriteria = new FilterFirstname();
            filteredPeopleList = firstNameCriteria.filterPeople(peopleList, criteria);
            filteredConnectionList = PersonFilter.filterConnections(filteredPeopleList);
        }
        else if(lastNameRadioButton.isSelected()) {
            PersonFilter lastNameCriteria = new FilterLastname();
            filteredPeopleList = lastNameCriteria.filterPeople(peopleList, criteria);
            filteredConnectionList = PersonFilter.filterConnections(filteredPeopleList);
        }
        else if(connectionRadioButton.isSelected()) {
            String value = connectionChoiceBox.getValue();
            filteredConnectionList = ConnectionFilter.filterConnections(connectionList, value);
            filteredPeopleList = ConnectionFilter.filterPeople(filteredConnectionList);
        }

        populatePeopleTable(filteredPeopleList);
        populateConnectionTable(filteredConnectionList);

        CanvasUtil.updateWithFilteredData(filteredPeopleList, filteredConnectionList);
    }

    @FXML
    public void handleNameRadioButton() {
        connectionChoiceBox.setDisable(true);
        criteriaTextField.setDisable(false);

        connectionChoiceBox.getSelectionModel().clearSelection();

        handleCriteriaTextField();
    }

    @FXML
    public void handleConnectionRadioButton() {
        criteriaTextField.setDisable(true);
        connectionChoiceBox.setDisable(false);

        criteriaTextField.clear();
        connectionChoiceBox.getSelectionModel().clearSelection();

        handleCriteriaTextField();
    }
}
