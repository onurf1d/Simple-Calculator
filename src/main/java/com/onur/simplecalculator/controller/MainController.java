package com.onur.simplecalculator.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import com.onur.simplecalculator.logic.MixedLogic;
import java.math.BigDecimal;

public class MainController {

    private final String UNDEFINED_MESSAGE = "Undefined";

    @FXML
    private TextField operationText;

    @FXML
    void clickedNumberButton(ActionEvent event) {
        Button button = (Button) event.getSource();
        String number = button.getText();

        if(operationText.getText().equals(UNDEFINED_MESSAGE)) {
            operationText.clear();
        }

        operationText.appendText(number);
    }

    @FXML
    void clickedOperationButton(ActionEvent event) {
        Button button = (Button) event.getSource();

        String currentText = operationText.getText();

        if(currentText == null || currentText.trim().isEmpty() || currentText.equals(UNDEFINED_MESSAGE)) {
            return;
        }

        String operator = " " + button.getText() + " ";

        if(!isOperator()) {
            button.getStyleClass().add("operator");
            operationText.appendText(operator);
        }
        else {
            button.getStyleClass().add("operator");

            operationText.deleteText(operationText.getLength() - 2, operationText.getLength());
            operationText.appendText(button.getText() + " ");
        }
    }

    @FXML
    void clickedPointButton(ActionEvent event) {
        Button button = (Button) event.getSource();

        if(operationText.getLength() == 0 || isOperator()) {
            String point = "0.";
            operationText.appendText(point);
        }
        else if(!isDuplicatePoint()) {
            String point = button.getText();
            operationText.appendText(point);
        }
    }

    @FXML
    void clickedClearButton(ActionEvent event) {
        Button button = (Button) event.getSource();

        operationText.clear();
    }

    @FXML
    void clickedEqualsButton(ActionEvent event) {
        Button button = (Button) event.getSource();
        try {
            MixedLogic ml = new MixedLogic();
            BigDecimal result = ml.calculate(operationText.getText());
            operationText.clear();
            operationText.setText(String.valueOf(result));
        } catch (ArithmeticException e) {
            operationText.setText(UNDEFINED_MESSAGE);
        }
    }

    @FXML
    void clickedEraseButton(ActionEvent event) {
        Button button = (Button) event.getSource();

        if(operationText.getText().endsWith(" ")) {
            operationText.deleteText(operationText.getLength() - 3, operationText.getLength());
        }
        else if(operationText.getText().equals(UNDEFINED_MESSAGE)) {
            operationText.clear();
        }
        else {
            if(!operationText.getText().isEmpty()) {
                operationText.deleteText(operationText.getLength() - 1, operationText.getLength());
            }
        }
    }

    private boolean isOperator() {
        String currentText = operationText.getText();
        String trimmedText = currentText.trim();
        String lastMeaningfulChar = trimmedText.substring(trimmedText.length() - 1);

        String[] operatorArray = {"+", "-", "x", "/", "%"};

        boolean isOperator = false;

        for(String s: operatorArray) {          //boşluk dışındaki son karakterin operatör olup olmadığını kontrol ediyor
            if (lastMeaningfulChar.equals(s)) {
                return true;
            }
        }
        return isOperator;
    }

    private boolean isDuplicatePoint() {
        String currentText = operationText.getText();
        String[] parts = currentText.split(" ");

        String lastOperand = parts[parts.length - 1];

        if(lastOperand.contains(".")) {
            return true;
        }
        return false;
    }
}
