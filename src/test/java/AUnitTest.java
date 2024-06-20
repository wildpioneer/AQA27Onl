import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AUnitTest extends BaseTest {

    @BeforeMethod
    public void preCondition() {
        System.out.println("AUnitTest Precondition...");
        System.out.println(Thread.currentThread().getName());
    }

    @Test
    public void positiveLoginTest() {
        System.out.println("First Unit Test...");
        System.out.println(Thread.currentThread().getName());
    }

    @Test
    public void test1() {
        System.out.println("Second Unit Test...");
        System.out.println(Thread.currentThread().getName());
    }

    @Test
    public void test10() {
        System.out.println("Second Unit Test...");
        System.out.println(Thread.currentThread().getName());
    }

    @Test
    public void test7() {
        System.out.println("Second Unit Test...");
        System.out.println(Thread.currentThread().getName());
    }
}
