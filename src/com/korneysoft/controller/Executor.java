package com.korneysoft.controller;

import com.korneysoft.model.Calculator;
import com.korneysoft.model.CalculatorException;
import com.korneysoft.model.RomanNumber;

import java.util.Scanner;

public class Executor {
    private final Scanner in = new Scanner(System.in);

    public void go() {
        char c;
        do {
            goOnce(in.nextLine());
            System.out.print("Продолжить? (Y/N):");
            c = in.nextLine().charAt(0);
        } while (Character.toUpperCase(c) == 'Y');
    }

    public void goOnce(String inputStr) {
        try {
            Parser parser = new Parser(inputStr);
            int result = Calculator.getResult(parser.getValNumberA(), parser.getValNumberB(), parser.getOperation());
            if (parser.isRomanStyle()) {
                System.out.println(RomanNumber.convertToRoman(result));
            } else {
                System.out.println(result);
            }
        } catch (CalculatorException e) {
            System.out.println(e.getDiscription());
        }

    }


}
