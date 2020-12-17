package com.korneysoft.model;

import java.util.HashMap;
import java.util.Map;

public class RomanNumber extends Number {
    private static final String ERR_NO_ROMAN_DIGIT = "The digit isn't roman";
    public static final String ERR_NO_ROMAN_NUMBER = "The number isn't roman";
    private static final String ERR_ROMAN_EMPTY = "Roman number is empty";
    private static final String ERR_CANT_TO_ROMAN_NUMBER = "This number can't represented at roman style";

    private static final String[] arrRomanDigitSort = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    private static final String RomanDigitsRepeat3 = "I,X,C,M,";
    // RomanDigitsRepeat3 - Symbols what can repeat 3 times in the Roman nubmer
    // other symbols can't repeat

    private final StringBuilder lastPosition = new StringBuilder(2);

    private static final Map<String, Integer> romanDigits;

    static {
        romanDigits = new HashMap<>();
        romanDigits.put(arrRomanDigitSort[0], 1); // I
        romanDigits.put(arrRomanDigitSort[1], 4); // IV
        romanDigits.put(arrRomanDigitSort[2], 5); // V
        romanDigits.put(arrRomanDigitSort[3], 9); // IX
        romanDigits.put(arrRomanDigitSort[4], 10);// X
        romanDigits.put(arrRomanDigitSort[5], 40);// XL
        romanDigits.put(arrRomanDigitSort[6], 50);// L
        romanDigits.put(arrRomanDigitSort[7], 90);// XC
        romanDigits.put(arrRomanDigitSort[8], 100);// C
        romanDigits.put(arrRomanDigitSort[9], 400);// CD
        romanDigits.put(arrRomanDigitSort[10], 500);// D
        romanDigits.put(arrRomanDigitSort[11], 900);// CM
        romanDigits.put(arrRomanDigitSort[12], 1000);// M
    }


    private final String asRoman;

    public String getAsRoman() {
        return asRoman;
    }


    public RomanNumber(String stringRomanNumber) {
        asRoman = stringRomanNumber.toUpperCase();
    }


    private String getLastDigits(StringBuilder sb, int countDigit) {
        if (sb.length() >= countDigit) {
            return sb.substring(sb.length() - countDigit, sb.length());
        }
        return "";
    }

    private int takeLastPosition(StringBuilder sb) throws CalculatorException {
        int result = 0;
        String strTemp = null;

        //for begin check 2 last digit, if not found then one last digit
        for (int i = 2; i >= 1; i--) {
            strTemp = getLastDigits(sb, i);
            if (strTemp.length() > 0 && romanDigits.containsKey(strTemp)) {
                result = romanDigits.get(strTemp);
                break;
            }
        }
        lastPosition.setLength(0);
        // if not found -> exception
        if (result == 0) {
            throw new CalculatorException(ERR_NO_ROMAN_DIGIT, strTemp);
        }

        // delete finding digit
        sb.delete(sb.length() - strTemp.length(), sb.length());
        lastPosition.append(strTemp);
        return result;
    }

    private int getMaxCountPosition(String s) {
        if (RomanDigitsRepeat3.contains(s + ",")) {
            return 3;
        } else {
            return 1;
        }
    }


    @Override
    public int getValue() throws CalculatorException {
        StringBuilder sbRomanNumber = new StringBuilder(asRoman);
        String strLastPositionOld = "";
        int countLastPosition = 1;
        int maxCountPosition = 0;
        int result = 0;
        int lastPositionValue = 0;
        int currentPositionValue;

        if (asRoman.length() == 0) {
            throw new CalculatorException(ERR_ROMAN_EMPTY, asRoman);
        }

        while (sbRomanNumber.length() > 0) {
            currentPositionValue = takeLastPosition(sbRomanNumber);
            // counts repeats for current Position
            if (strLastPositionOld.equals(lastPosition.toString())) {
                countLastPosition++;
            } else {
                countLastPosition = 1;
                strLastPositionOld = lastPosition.toString();
                maxCountPosition = getMaxCountPosition(lastPosition.toString());
            }

            if (currentPositionValue < lastPositionValue || // wrong order roman digits
                    countLastPosition > maxCountPosition) {
                throw new CalculatorException(ERR_NO_ROMAN_NUMBER, asRoman);
            }
            lastPositionValue = currentPositionValue;

            result += currentPositionValue;
        }
        checkValue(result);
        return result;
    }

    public static boolean isRomanStyle(String string) throws CalculatorException {
        if (string.length() == 0) {
            throw new CalculatorException(ERR_ROMAN_EMPTY, string);
        } else {
            return romanDigits.containsKey(string.substring(0, 1));
        }
    }
    public static String readNumber(String string, int startPosition) throws CalculatorException {
            return readNumber(string,startPosition,-1);
    }

    public static String readNumber(String string, int startPosition,int endPosition) throws CalculatorException {

        StringBuilder result = new StringBuilder();
        for (int i = startPosition; i < string.length(); i++) {
            if (romanDigits.containsKey(string.substring(i, i + 1))) {
                result.append(string.charAt(i));
            } else {
                break;
            }
        }

        if (result.length() == 0 ||(endPosition >= 0 & result.length() < (endPosition - startPosition))) {
            throw new CalculatorException(ERR_NO_ROMAN_NUMBER, string);
        }
        return result.toString();
    }


    public static String convertToRoman(int value) throws CalculatorException {
        // Return "value" as Roman style
        if (value <= 0 || value > 4000) {
            throw new CalculatorException(ERR_CANT_TO_ROMAN_NUMBER, Integer.toString(value));
        }

        StringBuilder result = new StringBuilder();
        int valueRomanDigit;

        for (int i = arrRomanDigitSort.length - 1; (i >= 0 && value > 0); i--) {
            valueRomanDigit = romanDigits.get(arrRomanDigitSort[i]);
            while (valueRomanDigit <= value) {
                result.append(arrRomanDigitSort[i]);
                value -= valueRomanDigit;
            }
        }
        return result.toString();
    }


}
