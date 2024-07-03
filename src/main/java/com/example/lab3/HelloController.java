// HelloController.java
package com.example.lab3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField contactField;

    @FXML
    private TextField postalField;

    @FXML
    private Label resultLabel;

    @FXML
    private void validateInputs() {
        String name = nameField.getText();
        String contactNumber = contactField.getText();
        String postalCode = postalField.getText();

        boolean isValid = true;

        if (!isValidUsername(name)) {
            resultLabel.setText("Invalid username. First character must be uppercase and subsequent characters must be letters.");
            isValid = false;
        }

        if (!isValidContactNumber(contactNumber)) {
            resultLabel.setText("Invalid contact number. Must be exactly 10 digits long and in the format XXX XXX XXXX or (XXX) XXX XXXX.");
            isValid = false;
        }

        if (!isValidPostalCode(postalCode)) {
            resultLabel.setText("Invalid postal code. Must be in the format P6R 2V8 or P6r-2V8 or p6r 2v8 or p6r-2v8.");
            isValid = false;
        }

        if (isValid) {
            resultLabel.setText("All fields are valid!");
        }
    }

    private boolean isValidUsername(String username) {
        if (username.length() == 0) return false;
        if (!Character.isUpperCase(username.charAt(0))) return false;
        for (int i = 1; i < username.length(); i++) {
            if (!Character.isLetter(username.charAt(i))) return false;
        }
        return true;
    }

    private boolean isValidContactNumber(String contactNumber) {
        contactNumber = contactNumber.replaceAll("\\D", "");
        if (contactNumber.length() != 10) return false;
        return true;
    }

    private boolean isValidPostalCode(String postalCode) {
        postalCode = postalCode.replaceAll("\\s|-", "");
        if (postalCode.length() != 6) return false;
        if (!Character.isLetter(postalCode.charAt(0))) return false;
        if (!Character.isDigit(postalCode.charAt(1))) return false;
        if (!Character.isLetter(postalCode.charAt(2))) return false;
        if (!Character.isDigit(postalCode.charAt(3))) return false;
        if (!Character.isLetter(postalCode.charAt(4))) return false;
        if (!Character.isDigit(postalCode.charAt(5))) return false;
        return true;
    }
}