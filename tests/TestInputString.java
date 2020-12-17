import com.korneysoft.controller.Executor;
import com.korneysoft.controller.Parser;
import com.korneysoft.model.Calculator;
import com.korneysoft.model.CalculatorException;
import org.junit.Test;

public class TestInputString {
    Executor executor = new Executor();

    @Test
    public void allTests() {
        oneTest(" V +VIII  ");
        oneTest("V + V ");
        oneTest("VX +II");
        //oneTest("IIII +II");
        //oneTest("1F0 +7");
        oneTest("3f +7");
    }

    public void oneTest(String inputString) {
        executor.goOnce(inputString);

    }
}
