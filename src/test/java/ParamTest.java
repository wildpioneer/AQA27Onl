import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamTest {

    @Parameters({"login", "psw"})
    @Test
    public void paramTest(@Optional("def_user") String loginName, @Optional("99999") String pswValue) {
        System.out.println("Login is: " + loginName);
        System.out.println("Password is: " + pswValue);
    }
}
