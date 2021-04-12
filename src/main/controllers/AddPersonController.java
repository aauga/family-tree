package main.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.util.Calendar;

public class AddPersonController {
    // Constants
    private static final int FULL_NAME_MAX_LENGTH = 48;
    private static final int PERSONAL_CODE_MAX_LENGTH = 11;
    private static final int BIRTH_YEAR_MAX_LENGTH = 4;
    private static final int BIRTH_PLACE_MAX_LENGTH = 32;

    @FXML
    private TextField fullNameTextField, personalCodeTextField, birthYearTextField, birthPlaceTextField;

    @FXML
    private Button addPersonButton;

    public void initialize() {

    }

    @FXML
    private void formatFullNameTextField() {
        fullNameTextField.setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getControlNewText();

            if (newText.isEmpty() || (newText.length() <= FULL_NAME_MAX_LENGTH && newText.matches("[ a-zA-Z-]+"))) {
                return change;
            }

            return null;
        }));
    }

    @FXML
    private void formatPersonalCodeTextField() {
        personalCodeTextField.setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getControlNewText();

            if(newText.isEmpty() || (newText.length() <= PERSONAL_CODE_MAX_LENGTH && newText.matches("[0-9]+"))) {
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

    @FXML
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
        return !fullNameTextField.getText().isEmpty() && !personalCodeTextField.getText().isEmpty() && !birthYearTextField.getText().isEmpty() && !birthPlaceTextField.getText().isEmpty();
    }

    @FXML
    private void checkControls() {
        checkIfBirthYearValid();

        if(textFieldsEmpty()) {
            addPersonButton.setDisable(false);
        }
    }
}
