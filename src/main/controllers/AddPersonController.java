package main.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class AddPersonController {
    // Constants
    private static final int FULL_NAME_MAX_LENGTH = 48;
    private static final int PERSONAL_CODE_MAX_LENGTH = 11;
    private static final int BIRTH_PLACE_MAX_LENGTH = 32;

    @FXML
    private TextField fullNameTextField;

    public void initialize() {

    }

    @FXML
    private void formatFullNameField() {
        fullNameTextField.setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getControlNewText();

            if (newText.isEmpty() || (newText.length() <= FULL_NAME_MAX_LENGTH && newText.matches("[ a-zA-Z-]+"))) {
                return change;
            }

            return null;
        }));
    }

    @FXML
    private void checkFields() {
        //checkFullNameField();
    }
}
