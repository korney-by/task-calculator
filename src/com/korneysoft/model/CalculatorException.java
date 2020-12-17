package com.korneysoft.model;

public class CalculatorException extends Exception {
    private final String strNumber;

    public CalculatorException(String message, String strNumber) {
        super(message);
        this.strNumber = strNumber;
    }

    public String getDiscription(){
        return String.format("ERR: \"%s\" - %s",strNumber,getClass().getSimpleName()+": "+getMessage());
    }
}
