package tests.api;

import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SimpleTestRailTest {

    @Test
    public void getAllUsersStepByStepTest() {
        // Setup RestAssured
        RestAssured.baseURI = ReadProperties.getUri();

        // Setup endpoint
        String endpoint = "/index.php?/api/v2/get_users";

        // Setup request object
        RequestSpecification request = given();

        // Add header parameter
        request.header(HTTP.CONTENT_TYPE, ContentType.JSON);

        // Add auth
        request.auth().preemptive().basic(ReadProperties.username(), ReadProperties.password());

        // Set response and execute request
        Response response = request.request(Method.GET, endpoint);

        // Validate response
        // Get and check status code
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

        // Get Response Body
        System.out.println(response.getBody().prettyPrint());
    }

    @Test
    public void getAllUsersShortTest() {
        // Setup RestAssured
        RestAssured.baseURI = ReadProperties.getUri();

        // Setup endpoint
        String endpoint = "/index.php?/api/v2/get_users";

        // Setup request object
        given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password())
                .when()
                .request(Method.GET, endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }
}
