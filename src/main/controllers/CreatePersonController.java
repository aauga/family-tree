package main.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import main.data.Canvas;
import main.data.Person;
import main.data.Storage;
import main.data.Node;

import java.util.ArrayList;
import java.util.Calendar;

public class CreatePersonController {
    // Constants
    private static final int NAME_MAX_LENGTH = 16;
    private static final int PERSONAL_CODE_LENGTH = 11;
    private static final int BIRTH_YEAR_MAX_LENGTH = 4;
    private static final int BIRTH_PLACE_MAX_LENGTH = 32;

    @FXML
    private TextField firstNameTextField, lastNameTextField, personalCodeTextField, birthYearTextField, birthPlaceTextField;

    @FXML
    private Label personalCodeErrorLabel;

    @FXML
    private Button addPersonButton;

    @FXML
    private void formatFirstNameTextField() {
        firstNameTextField.setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getControlNewText();

            if (newText.isEmpty() || (newText.length() <= NAME_MAX_LENGTH && newText.matches("[ a-zA-Z-]+"))) {
                return change;
            }

            return null;
        }));
    }

    @FXML
    private void formatLastNameTextField() {
        lastNameTextField.setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getControlNewText();

            if (newText.isEmpty() || (newText.length() <= NAME_MAX_LENGTH && newText.matches("[ a-zA-Z-]+"))) {
                return change;
            }

            return null;
        }));
    }

    @FXML
    private void formatPersonalCodeTextField() {
        personalCodeTextField.setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getControlNewText();

            if(newText.isEmpty() || (newText.length() <= PERSONAL_CODE_LENGTH && newText.matches("[0-9]+"))) {
                return change;
            }

            return null;
        }));
    }

    @FXML
    private void formatBirthYearTextField() {
        birthYearTextField.setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getControlNewText();

            if(newText.isEmpty() || (newText.length() <= BIRTH_YEAR_MAX_LENGTH && newText.matches("[0-9]+"))) {
                return change;
            }

            return null;
        }));
    }

    private void checkIfBirthYearValid() {
        String birthYearStr = birthYearTextField.getText();

        if(!birthYearStr.isEmpty()) {
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            int birthYear = Integer.parseInt(birthYearStr);

            if (birthYear > currentYear) {
                birthYearTextField.setText(String.valueOf(currentYear));
            }
        }
    }

    @FXML
    private void formatBirthPlaceTextField() {
        birthPlaceTextField.setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getControlNewText();

            if(newText.isEmpty() || (newText.length() <= BIRTH_PLACE_MAX_LENGTH && newText.matches("[ a-zA-Z-]+"))) {
                return change;
            }

            return null;
        }));
    }

    private boolean textFieldsEmpty() {
        return firstNameTextField.getText().isEmpty()
                || lastNameTextField.getText().isEmpty()
                || personalCodeTextField.getText().isEmpty()
                || birthYearTextField.getText().isEmpty()
                || birthPlaceTextField.getText().isEmpty();
    }

    private boolean personalCodeExists(String personalCode) {
        ArrayList<Person> people = Storage.getPeopleArray();

        for (Person person : people) {
            if (personalCode.equals(person.getPersonalCode())) {
                return true;
            }
        }

        return false;
    }

    private boolean personalCodeValid() {
        String personalCode = personalCodeTextField.getText();

        if(personalCode.length() == PERSONAL_CODE_LENGTH) {
            if(!personalCodeExists(personalCode)) {
                personalCodeErrorLabel.setVisible(false);
                return true;
            }
            else {
                personalCodeErrorLabel.setText("Already exists!");
                personalCodeErrorLabel.setVisible(true);
            }
        }
        else if(!personalCode.isEmpty()){
            personalCodeErrorLabel.setText("Too short!");
            personalCodeErrorLabel.setVisible(true);
        }

        return false;
    }

    // Function enables the "Add Person" button if all fields are filled in correctly and disables it if not.
    @FXML
    private void checkFields() {
        checkIfBirthYearValid();
        addPersonButton.setDisable(!personalCodeValid() || textFieldsEmpty());
    }

    @FXML
    private void addPersonToStorage() {
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String personalCode = personalCodeTextField.getText();
        int birthYear = Integer.parseInt(birthYearTextField.getText());
        String birthPlace = birthPlaceTextField.getText();

        Person person = new Person(firstName, lastName, personalCode, birthYear, birthPlace);
        Storage.addPerson(person);

        Node node = new Node(person, Canvas.getMousePosX(), Canvas.getMousePosY());
        Storage.addNode(node);
        Canvas.addToCanvas(node);

        // Close window
        Stage stage = (Stage) addPersonButton.getScene().getWindow();
        stage.close();
    }
}
