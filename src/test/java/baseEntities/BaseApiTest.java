package baseEntities;

import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;
import services.api.ProjectService;
import services.api.UserService;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected ProjectService projectService;
    protected UserService userService;


    @BeforeTest
    public void setupApiClient() {
        // Setup RestAssured
        RestAssured.baseURI = ReadProperties.getUri();

        // Update default request specification
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password());

        projectService = new ProjectService();
        userService = new UserService();
    }
}
