package com.korneysoft.model;

public class ArabicNumber extends Number {
    public static final String ERR_NO_ARABIC_NUMBER = "The number isn't arabic";
    private static final String ERR_ARABIC_EMPTY = "Arabic number is empty";

    private final String asArabic;

    public ArabicNumber(String stringNumber) {
        asArabic = stringNumber;
    }

    @Override
    public int getValue() throws CalculatorException {
        int result;
        if (asArabic == null || asArabic.length() == 0) {
            throw new CalculatorException(ERR_ARABIC_EMPTY, asArabic);
        } else {
            try {
                result = Integer.parseInt(asArabic);
            } catch (NumberFormatException e) {
                throw new CalculatorException(ERR_NO_ARABIC_NUMBER, asArabic);
            }
        }
        checkValue(result);
        return result;
    }

    public static String readNumber(String string, int startPosition) throws CalculatorException {
        return readNumber(string, startPosition, -1);
    }

    public static String readNumber(String string, int startPosition, int endPosition) throws CalculatorException {
        StringBuilder result = new StringBuilder();

        for (int i = startPosition; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i))) {
                result.append(string.charAt(i));
            } else {
                break;
            }
        }

        if (result.length() == 0 || (endPosition >= 0 & result.length() < endPosition - startPosition)) {
            throw new CalculatorException(ERR_NO_ARABIC_NUMBER, string);
        }
        return result.toString();
    }
}
