import org.testng.Assert;
import org.testng.annotations.Test;

public class ObjectsTest {

    @Test
    public void assertObjectsTest() {
        Volvo car1 = new Volvo(1, "XC60", 1800);
        Volvo car2 = new Volvo(2, "XC60", 1800);

        Assert.assertEquals(car1, car2);
    }
}
