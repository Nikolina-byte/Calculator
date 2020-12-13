package edu.ib;

import java.net.URL;
import java.sql.SQLOutput;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class JavaFXCalculatorController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnInverse;

    @FXML
    private Button btnPow;

    @FXML
    private Button btnSqrt;

    @FXML
    private Button btnDivide;

    @FXML
    private Button btnSeven;

    @FXML
    private Button btnFour;

    @FXML
    private Button btnEight;

    @FXML
    private Button btnFive;

    @FXML
    private Button btnOne;

    @FXML
    private Button btnTwo;

    @FXML
    private Button btnNine;

    @FXML
    private Button btnSix;

    @FXML
    private Button btnThree;

    @FXML
    private Button btnMultiplied;

    @FXML
    private Button btnMinus;

    @FXML
    private Button btnPlus;

    @FXML
    private Button btnPlusMinus;

    @FXML
    private Button btnZero;

    @FXML
    private Button btnComma;

    @FXML
    private Button btnEquals;

    @FXML
    private Button btnPercent;

    @FXML
    private Button btnClearLast;

    @FXML
    private Button btnClearAll;

    @FXML
    private Button btnBack;

    @FXML
    private TextArea textAreaHistory;

    @FXML
    private TextField textEquation;

    @FXML
    private TextField textScore;

    @FXML
    private Button btnClearHistory;


    StringBuilder calculatorHistory = new StringBuilder();
    Boolean zmienna = false;
    String number;
    String operation;
    String results;

    boolean clickRownaOne = false;
    private String number1;
    private String number2;
    private String operator = "";
    private boolean start = true;

    Calculator calculator = new Calculator();

    @FXML
    void onClickNumber(ActionEvent event) {
        if (start) {
            textScore.setText("");
            System.out.println("set1");
            start = false;
        }

        if (zmienna) {
            textScore.setText("");
            System.out.println("set2");
            zmienna = false;
            System.out.println("Konrad dasdda");
        }

        String value = ((Button)event.getSource()).getText();
        number = textScore.getText() + value;
        textScore.setText(number);
        System.out.println("set3");

        //wyłączanie kropek
        if((".").equals(value)){
            btnComma.setDisable(true);
            System.out.println("debug kropka");
        }

        System.out.println(calculatorHistory);


    }

    @FXML
    void onClickOperator(ActionEvent event) {
        zmienna = true;
        String value = ((Button)event.getSource()).getText();
        operator = value;
        System.out.println("operatorclick: " + operator);
        number1 = (textScore.getText());
        textEquation.setText(number1 + operator);
        System.out.println("set4");
        btnComma.setDisable(false);
    }

    @FXML
    void onClickEquals(ActionEvent event) {
        btnComma.setDisable(false);
        String wartosc = textEquation.getText();
        textEquation.setText(wartosc + textScore.getText()+"=");
        System.out.println("set5");
        System.out.println(textEquation.getText());

        if(!operator.isEmpty()){
            if(clickRownaOne) {
                textEquation.setText(number1 + operator + number + "=");
            }
            Double calculateResult = calculator.calculate(Double.parseDouble(number1), Double.parseDouble(number), operator);
            results = Converter.getStringCalculateValue(calculateResult);
            textScore.setText(results);
            number1 = results;
            System.out.println("sadsdas adas ad sa d");
        }
        else {
            textEquation.setText(number + "=");
        }

        clear();
    }

    void clear(){
        calculatorHistory=calculatorHistory.append(textEquation.getText() + textScore.getText());
        number1 = textScore.getText();
        clickRownaOne=true;
        textAreaHistory.setText(String.valueOf(calculatorHistory) + "\n" + textAreaHistory.getText());
        calculatorHistory.delete(0, calculatorHistory.length());
        start = true;
    }

    @FXML
    void onClickClearAll(ActionEvent event) {
        textScore.setText("");
        textEquation.setText("");
        operator = "";
        number = "";
        number1 = "";
    }

    @FXML
    void onClickClearHistory(ActionEvent event) {
        textAreaHistory.setText("");
    }

    @FXML
    void onClickClearLast(ActionEvent event) {
        textScore.setText("");
    }

    @FXML
    void onClickBack(ActionEvent event) {
        String value = textScore.getText();
        textScore.setText(value.substring(0, value.length()-1));
        if (textScore.getText().isEmpty())
            textScore.setText("0");
    }

    @FXML
    void initialize() {
        assert btnInverse != null : "fx:id=\"btnInverse\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnPow != null : "fx:id=\"btnPow\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnSqrt != null : "fx:id=\"btnSqrt\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnDivide != null : "fx:id=\"btnDivide\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnSeven != null : "fx:id=\"btnSeven\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnFour != null : "fx:id=\"btnFour\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnEight != null : "fx:id=\"btnEight\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnFive != null : "fx:id=\"btnFive\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnOne != null : "fx:id=\"btnOne\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnTwo != null : "fx:id=\"btnTwo\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnNine != null : "fx:id=\"btnNine\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnSix != null : "fx:id=\"btnSix\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnThree != null : "fx:id=\"btnThree\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnMultiplied != null : "fx:id=\"btnMultiplied\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnMinus != null : "fx:id=\"btnMinus\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnPlus != null : "fx:id=\"btnPlus\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnPlusMinus != null : "fx:id=\"btnPlusMinus\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnZero != null : "fx:id=\"btnZero\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnComma != null : "fx:id=\"btnComma\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnEquals != null : "fx:id=\"btnEquals\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnPercent != null : "fx:id=\"btnPercent\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnClearLast != null : "fx:id=\"btnClearLast\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnClearAll != null : "fx:id=\"btnClearAll\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'calculator.fxml'.";
        assert textAreaHistory != null : "fx:id=\"textAreaHistory\" was not injected: check your FXML file 'calculator.fxml'.";
        assert textEquation != null : "fx:id=\"textEquation\" was not injected: check your FXML file 'calculator.fxml'.";
        assert textScore != null : "fx:id=\"textScore\" was not injected: check your FXML file 'calculator.fxml'.";
        assert btnClearHistory != null : "fx:id=\"btnClearHistory\" was not injected: check your FXML file 'calculator.fxml'.";
        this.calculatorHistory.delete(0,calculatorHistory.length());

        this.calculator = new Calculator();
    }
}
