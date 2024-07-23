package tests;

import org.testng.annotations.Test;

public class ParamTest {

    @Test
    public void testParam() {
        System.out.println(System.getProperty("user.dir"));
        String username = System.getProperty("username");
        System.out.println(username);
    }
}
