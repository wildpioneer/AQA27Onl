package baseEntities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import services.DataBaseService;

public class BaseDBTest {
    protected DataBaseService dbService;

    @BeforeTest
    public void setDBConnection() {
        dbService = new DataBaseService();
    }

    @AfterTest
    public void closeDBConnection() {
        dbService.closeConnection();
    }
}
