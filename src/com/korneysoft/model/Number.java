package com.korneysoft.model;

public abstract class Number {
    private static final String ERR_INPUT_OUT_OF_RANGE = "Out of range. Input value must be between 1 and 10 inclusive";
    public abstract int getValue() throws CalculatorException;

    protected void checkValue(int value) throws CalculatorException {
        if (value<1 || value>10 ) {
            throw new CalculatorException(ERR_INPUT_OUT_OF_RANGE,Integer.toString(value));
        }
    }

}
