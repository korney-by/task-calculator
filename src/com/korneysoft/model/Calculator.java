package com.korneysoft.model;

public class Calculator {

    private static final String ERR_WRONG_OPERATION = "Wrong operation symbol";

    private Calculator() {
    }


    public static int getResult(int a, int b, char operation) throws CalculatorException {
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '/':
                return a / b;
            case '*':
                return a * b;
            default:
                throw new CalculatorException(ERR_WRONG_OPERATION,String.valueOf(operation));
        }

    }
}
