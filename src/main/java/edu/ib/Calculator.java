package edu.ib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Calculator {

    public double calculate(double number1, double number2, String operator) {
        double calculateValue =number1;

        switch (operator) {
            case "+":
                calculateValue = number1 + number2;
                break;
            case "-":
                calculateValue = number1 - number2;
                break;
            case "*":
                calculateValue = number1 * number2;
                break;
            case "/":
                if (number2 == 0)
                    calculateValue = 0;
                calculateValue = number1 / number2;
                break;
            case "%":
                calculateValue = number1 / 100.0;
                break;
            case "x^2":
                calculateValue = Math.pow(number1, 2);
                break;
            case "sqrt(x)":
                calculateValue = Math.sqrt(number1);
                break;
            case "+/-":
                calculateValue = number1 * (-1);
                break;
        }

        return calculateValue;
    }
}
