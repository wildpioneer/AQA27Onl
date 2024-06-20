import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class CalcTest extends BaseTest {

    @Test
    public void testSum() {
        Assert.assertEquals(calculator.add(2, 3), 5, "Неверная сумма...");
        Assert.assertEquals("Test", "Test");
        Assert.assertEquals("Test", "Test", "sdfds");
    }

    @Test(enabled = false)
    public void testSum1() {
        Assert.assertEquals(calculator.add(3, 4), 7, "Неверная сумма...");
    }

    @Test(description = "Тест с описанием")
    public void testSum2() {
        Assert.assertEquals(calculator.add(3, 4), 7, "Неверная сумма...");
    }

    @Test(testName = "Test with Name")
    public void testSum3() {
        Assert.assertEquals(calculator.add(3, 4), 7, "Неверная сумма...");
    }

    @Test(timeOut = 1000)
    public void waitLongTimeTest() throws InterruptedException {
        Thread.sleep(900);
    }

    @Test(invocationCount = 4, threadPoolSize = 2)
    public void invocationCountTest1() {
        System.out.println(Thread.currentThread().getName());
        Assert.assertTrue(true);
    }

    @Test(invocationCount = 4, invocationTimeOut = 1000)
    public void invocationCountTest2() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(500);
        Assert.assertTrue(true);
    }

    // Так делать не надо
    @Test
    public void exceptionTest1() {
        try {
            List list = null;
            int size = list.size();
        } catch (NullPointerException ex) {
            Assert.assertTrue(true);
        }
    }

    //Делай так
    @Test(expectedExceptions = NullPointerException.class)
    public void exceptionTest2() {
        List list = null;
        int size = list.size();
    }

    @Test (dataProvider = "dataForSum", dataProviderClass = StaticProvider.class, threadPoolSize = 3)
    public void testDataProvider(int a, int b, int result) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Assert.assertEquals(calculator.add(a, b), result, "Неверная сумма...");
    }
}
