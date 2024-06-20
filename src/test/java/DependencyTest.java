import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTest {

    @Test
    public void stepb() {
        System.out.println("stepb");
    }

    @Test (dependsOnMethods = "stepb")
    public void stepa2() {
        System.out.println("stepa2");
    }

    @Test (dependsOnMethods = "stepa2")
    public void stepa11() {
        System.out.println("stepa11");
        Assert.assertTrue(false);
    }

    @Test (dependsOnMethods = "stepa11", alwaysRun = true)
    public void stepa12() {
        System.out.println("stepa12");
    }

    @Test (dependsOnMethods = "stepa12")
    public void stepd() {
        System.out.println("stepd");
    }

    @Test (dependsOnMethods = {"stepd", "stepa11"})
    public void stepc() {
        System.out.println("stepc");
    }
}
