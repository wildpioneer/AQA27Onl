package tests.api;

import baseEntities.BaseApiTest;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ResponseTestRailTest extends BaseApiTest {
    String name;

    @Test
    public void getAllProjectsTest() {
        String endpoint = "/index.php?/api/v2/get_projects";

        given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("limit", is(250))
                .body("size", is(0));
    }

    @Test
    public void getSingleValueTest() {
        int project_id = 1;
        String endpoint = "index.php?/api/v2/get_project/" + project_id;

        name = given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().getString("name");

        System.out.println(name);
    }

    @Test
    public void getResponseValueTest() {
        int project_id = 1;
        String endpoint = "index.php?/api/v2/get_project/" + project_id;

        Response response = given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        Assert.assertEquals(response.getBody().jsonPath().getString("name"), "wp_test_01");
    }

    @Test
    public void paramTest() {
        int project_id = 1;
        String endpoint = "/index.php?/api/v2/get_project/{project_id}";

        name = given()
                .pathParam("project_id", project_id)
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().getString("name");

        System.out.println(name);
    }

}
