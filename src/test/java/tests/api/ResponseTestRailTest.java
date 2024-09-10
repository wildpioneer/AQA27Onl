package tests.api;

import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import io.restassured.http.Method;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.User;
import models.Users;
import org.apache.http.HttpStatus;
import org.openqa.selenium.json.TypeToken;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void getAllUsersAsArray() {
        Response response = userService.getUsers();

        User[] users = response.getBody().jsonPath().getObject("users", User[].class);

        System.out.println(users.length);
        System.out.println(users[0]);
        System.out.println(users[1]);
    }

    @Test
    public void getAllUsersAsObject() {
        Response response = userService.getUsers();

        Users users = response.getBody().as(Users.class);

        System.out.println(users);
        System.out.println(users.getUsers()[0]);
        System.out.println(users.getUsers()[1]);
    }

    @Test
    public void getAllUsersAsType() {
        Response response = userService.getUsers();

        List<User> usersList = response.getBody().jsonPath().getList("users");

        System.out.println(usersList.get(0));
        System.out.println(usersList.get(1));
    }
}
