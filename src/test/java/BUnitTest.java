import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BUnitTest extends BaseTest {

    @Test
    public void positiveLoginTest() {
        System.out.println("BUnitTest: First Unit Test...");
        System.out.println(Thread.currentThread().getName());
    }

    @Test
    public void test1() {
        System.out.println("BUnitTest: Second Unit Test...");
        System.out.println(Thread.currentThread().getName());
    }
}
