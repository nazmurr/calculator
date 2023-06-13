module com.example.calculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires exp4j;


    opens com.example.calculator to javafx.fxml;
    exports com.example.calculator;
}