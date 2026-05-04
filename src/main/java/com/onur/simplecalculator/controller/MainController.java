package com.onur.simplecalculator.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import com.onur.simplecalculator.logic.MixedLogic;

public class MainController {

    @FXML
    private TextField operationText;

    @FXML
    void clickedNumberButton(ActionEvent event) {
        Button button = (Button) event.getSource();

        String number =  button.getText();
        operationText.appendText(number);
    }

    @FXML
    void clickedOperationButton(ActionEvent event) {
        Button button = (Button) event.getSource();

        button.getStyleClass().add("operator");

        String operator = " " + button.getText() + " ";
        operationText.appendText(operator);
    }

    @FXML
    void clickedPointButton(ActionEvent event) {
        Button button = (Button) event.getSource();

        if(operationText.getLength() == 0) {
            String point = "0.";
            operationText.appendText(point);
        }
        else {
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

        MixedLogic ml = new MixedLogic();
        double result = ml.calculate(operationText.getText());
        operationText.clear();
        operationText.setText(String.valueOf(result));
    }

    @FXML
    void clickedPercentButton(ActionEvent event) {
        Button button = (Button) event.getSource();

        String percentage = " % ";
        operationText.appendText(percentage);
    }

    @FXML
    void clickedEraseButton(ActionEvent event) {
        Button button = (Button) event.getSource();

        operationText.deleteText(operationText.getLength() - 1, operationText.getLength());
    }
}
