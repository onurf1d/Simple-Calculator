module simple.calculator {
    
    requires javafx.controls;
    requires javafx.fxml;

    opens com.onur.simplecalculator to javafx.fxml;
    opens com.onur.simplecalculator.ui to javafx.fxml;

    exports com.onur.simplecalculator;
}
