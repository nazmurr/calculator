package com.example.calculator;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class CalculatorController {
    @FXML
    private Label calcDisplay;

    @FXML
    protected void onButtonClick(Event event) {
        String input = ((Button) event.getSource()).getText();
        //System.out.println(input);
        String displayText = calcDisplay.getText();
        if (displayText.equals("0") || displayText.equals("Invalid Input")) {
            calcDisplay.setText(input);
        } else {
            calcDisplay.setText(displayText + input);
        }
    }

    @FXML
    protected void onClearButtonClick() {
        calcDisplay.setText("0");
    }

    @FXML
    protected void onCalculateButtonClick() {
        try {
            String displayText = calcDisplay.getText();
            displayText = displayText.replace('×', '*');
            displayText = displayText.replace('÷', '/');
            //System.out.println(displayText);
            Expression e = new ExpressionBuilder(displayText).build();
            double result = e.evaluate();
            //System.out.println(result);
            calcDisplay.setText(String.valueOf(result));
        } catch (Exception e) {
            //System.out.println(e.getMessage());
            calcDisplay.setText("Invalid Input");
        }

    }
}
