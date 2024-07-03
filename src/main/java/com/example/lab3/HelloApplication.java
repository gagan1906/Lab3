package com.example.lab3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("User Input Validation");

        // Create form elements
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Label contactLabel = new Label("Contact Number:");
        TextField contactField = new TextField();
        Label postalLabel = new Label("Postal Code:");
        TextField postalField = new TextField();

        Button validateButton = new Button("Validate");

        Label resultLabel = new Label();

        // Set button action
        validateButton.setOnAction(e -> {
            String name = nameField.getText();
            String contact = contactField.getText();
            String postal = postalField.getText();
            resultLabel.setText(validateInputs(name, contact, postal));
        });

        // Layout setup
        VBox vbox = new VBox(10, nameLabel, nameField, contactLabel, contactField, postalLabel, postalField, validateButton, resultLabel);
        Scene scene = new Scene(vbox, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String validateInputs(String name, String contact, String postal) {
        if (!name.matches("[A-Z][a-zA-Z]*")) {
            return "Invalid name. Must start with an uppercase letter and contain only letters.";
        }
        if (!contact.matches("\\d{3} \\d{3} \\d{4}") && !contact.matches("\\(\\d{3}\\) \\d{3} \\d{4}")) {
            return "Invalid contact number. Acceptable formats: XXX XXX XXXX or (XXX) XXX XXXX.";
        }
        if (!postal.matches("[A-Za-z]\\d[A-Za-z] ?\\d[A-Za-z]\\d")) {
            return "Invalid postal code. Acceptable formats: A1A 1A1 or A1A-1A1 (case insensitive).";
        }
        return "All inputs are valid.";
    }
}
