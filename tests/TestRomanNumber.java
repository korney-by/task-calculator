import com.korneysoft.model.RomanNumber;
import com.korneysoft.model.CalculatorException;
import org.junit.Test;


public class TestRomanNumber {

    @Test
    public void goTestToRoman(){
        goTestConvertToRoman("I", 1);
        goTestConvertToRoman("II", 2);
        goTestConvertToRoman("III", 3);
        goTestConvertToRoman("IV", 4);
        goTestConvertToRoman("V", 5);
        goTestConvertToRoman("VI", 6);
        goTestConvertToRoman("VII", 7);
        goTestConvertToRoman("VIII", 8);
        goTestConvertToRoman("IX", 9);
        goTestConvertToRoman("X", 10);
        goTestConvertToRoman("XIX", 19);
        goTestConvertToRoman("XXX", 30);
        goTestConvertToRoman("XXXVIII", 38);
        goTestConvertToRoman("MMMDCCCXCIV", 3894);
        goTestConvertToRoman("MMMCMXCIX", 3999);
        goTestConvertToRoman("MMMM", 4000);
        goTestConvertToRoman("", 5000);
        goTestConvertToRoman("", 0);
        goTestConvertToRoman("", -10);

    }

    private void goTestConvertToRoman(String strRomanNumber, int valueRomanNumber) {
        String calcRomanNumber;
        try {
            calcRomanNumber = RomanNumber.convertToRoman(valueRomanNumber);
            System.out.println(valueRomanNumber + ": " +
                    (strRomanNumber.equals(calcRomanNumber)? calcRomanNumber + " - ok" : strRomanNumber + " != " + calcRomanNumber));
        } catch (CalculatorException e) {
            System.out.println(e.getDiscription());
        }
    }

    @Test
    public void goTestFromRoman(){
        goTestRomanNumber("I", 1);
        goTestRomanNumber("II", 2);
        goTestRomanNumber("III", 3);
        goTestRomanNumber("IV", 4);
        goTestRomanNumber("V", 5);
        goTestRomanNumber("VI", 6);
        goTestRomanNumber("VII", 7);
        goTestRomanNumber("VIII", 8);
        goTestRomanNumber("IX", 9);
        goTestRomanNumber("X", 10);
        goTestRomanNumber("XIX", 19);
        goTestRomanNumber("IIIIII", 6);
        goTestRomanNumber("XXXVIII", 38);
        goTestRomanNumber("MXXXVIII", 1038);
        goTestRomanNumber("MMMDCCCXCIV", 3894);
        goTestRomanNumber("MMMCMXCIX", 3999);
        goTestRomanNumber("MMMM", 4000);
        goTestRomanNumber("XXVXIII", 1);
        goTestRomanNumber("IIIX", 1);
        goTestRomanNumber("RK", 1);
        goTestRomanNumber("", 1);


    }


    private void goTestRomanNumber(String strRomanNumber, int valueRomanNumber) {
        RomanNumber romanNumber = new RomanNumber(strRomanNumber);
        int calcValueRomanNumber;
        try {
            calcValueRomanNumber=romanNumber.getValue();
            System.out.println(romanNumber.getAsRoman() + ": " +
                    (calcValueRomanNumber == valueRomanNumber ? valueRomanNumber + " - ok" : calcValueRomanNumber + " != " + valueRomanNumber));
        } catch (CalculatorException e) {
            System.out.println(e.getDiscription());
        }
    }

}
