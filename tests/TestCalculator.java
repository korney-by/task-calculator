import com.korneysoft.model.Calculator;
import com.korneysoft.model.CalculatorException;

import static java.lang.System.out;
import org.junit.Test;


public class TestCalculator {

    @Test
    public void allTests() {
        testCalc(1, 2, '+', 3);
        testCalc(5, 3, '-', 2);
        testCalc(3, 2, '*', 6);
        testCalc(8, 2, '/', 4);
        testCalc(8, 2, ':', 4);
    }

    private static int testCalc(int a, int b, char operation, int correctValue) {
        int result = 0;
        try {
            result = Calculator.getResult(a, b, operation);
            out.println(result == correctValue ? operation + " ok" : operation + " ERR");
        } catch (CalculatorException e) {
            System.out.println(e.getDiscription());
        }
        return result;
    }

}
