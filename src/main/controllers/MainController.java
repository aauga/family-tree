package main.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.stage.Stage;
import main.data.Person;

public class MainController {
    @FXML
    private TreeTableView<Person> treeTable;

    public void initialize() {
        TreeTableColumn<Person, String> lastNameColumn = new TreeTableColumn<>("Last Name");
        TreeTableColumn<Person, String> firstNameColumn = new TreeTableColumn<>("First Name");
        TreeTableColumn<Person, String> personalCodeColumn = new TreeTableColumn<>("Personal Code");
        TreeTableColumn<Person, Integer> birthYearColumn = new TreeTableColumn<>("Year of Birth");
        TreeTableColumn<Person, String> birthPlaceColumn = new TreeTableColumn<>("Place of Birth");

        lastNameColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("lastName"));
        lastNameColumn.setMinWidth(100);

        firstNameColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("firstName"));
        firstNameColumn.setMinWidth(100);

        personalCodeColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("personalCode"));
        personalCodeColumn.setMinWidth(100);

        birthYearColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("birthYear"));
        birthYearColumn.setMinWidth(100);

        birthPlaceColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>("birthPlace"));
        birthPlaceColumn.setMinWidth(120);

        treeTable.getColumns().add(lastNameColumn);
        treeTable.getColumns().add(firstNameColumn);
        treeTable.getColumns().add(personalCodeColumn);
        treeTable.getColumns().add(birthYearColumn);
        treeTable.getColumns().add(birthPlaceColumn);
    }

    public void showAddPersonWindow() throws Exception {
        int windowWidth = 250;
        int windowHeight = 350;

        Parent parent = FXMLLoader.load(getClass().getResource("../layouts/addPersonLayout.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Add a Person");
        stage.setScene(new Scene(parent, windowWidth, windowHeight));
        stage.setMinWidth(windowWidth + 15);
        stage.setMinHeight(windowHeight + 40);
        stage.show();
    }
}
