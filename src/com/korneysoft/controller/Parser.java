package com.korneysoft.controller;

import com.korneysoft.model.ArabicNumber;
import com.korneysoft.model.CalculatorException;
import com.korneysoft.model.Number;
import com.korneysoft.model.RomanNumber;

public class Parser {
    private static final String ERR_WRONG_INPUT = "Wrong input data";


    private final String inputString;
    private char operation;
    private int valNumberA;
    private String strNumberA;
    private int valNumberB;
    private String strNumberB;
    private boolean RomanStyle;

    public boolean isRomanStyle() {
        return RomanStyle;
    }

    public Parser(String inputString) {
        this.inputString = clearString(inputString);
        try {
            parse();
        } catch (CalculatorException e) {
            System.out.println(e.getDiscription());
            System.exit(1);
        }
    }


    private void parse() throws CalculatorException {
        // парсим входную строку
        Number numberA, numberB;
        readStyle();
        if (RomanStyle) {
            try {
                strNumberA = RomanNumber.readNumber(inputString, 0);
                strNumberB = RomanNumber.readNumber(inputString, strNumberA.length() + 1,inputString.length());
            } catch (CalculatorException e) {
                if (e.getMessage().equals(RomanNumber.ERR_NO_ROMAN_NUMBER)) {
                    throw new CalculatorException(ERR_WRONG_INPUT, inputString);
                }
            }
            numberA = new RomanNumber(strNumberA);
            numberB = new RomanNumber(strNumberB);
        } else {
            try {
                strNumberA = ArabicNumber.readNumber(inputString, 0);
                strNumberB = ArabicNumber.readNumber(inputString, strNumberA.length() + 1,inputString.length());
            }catch (CalculatorException e){
                if (e.getMessage().equals(ArabicNumber.ERR_NO_ARABIC_NUMBER)) {
                    throw new CalculatorException(ERR_WRONG_INPUT, inputString);
                }
            }
            numberA = new ArabicNumber(strNumberA);
            numberB = new ArabicNumber(strNumberB);
        }
        operation = inputString.charAt(strNumberA.length());


        try {
            valNumberA = numberA.getValue();
            valNumberB = numberB.getValue();
        } catch (CalculatorException e) {
            System.out.println(e.getDiscription());
            System.exit(1);
        }
    }


    private void readStyle() {
        try {
            RomanStyle = RomanNumber.isRomanStyle(inputString);
        } catch (CalculatorException e) {
            System.out.println(e.getDiscription());
        }
    }

    private String clearString(String string) {
        // удаляем се пробелы  и другие не чистаемые символы.
        return string.replaceAll("\\s", "");
    }

    public char getOperation() {
        return operation;
    }

    public int getValNumberA() {
        return valNumberA;
    }

    public int getValNumberB() {
        return valNumberB;
    }

}
