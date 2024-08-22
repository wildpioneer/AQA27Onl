package tests;

import org.testng.annotations.Test;
import stepsDefs.FirstStepDefs;

public class SampleTest {

    @Test
    public void test() {
        new FirstStepDefs().startBrowser();
    }
}
