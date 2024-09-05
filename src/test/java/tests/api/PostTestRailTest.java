package tests.api;

import baseEntities.BaseApiTest;
import com.google.gson.Gson;
import io.restassured.mapper.ObjectMapperType;
import models.Project;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostTestRailTest extends BaseApiTest {

    @Test
    public void addProjectUsingStringTest() {
        String endpoint = "/index.php?/api/v2/add_project";

        Project expectedProject = new Project();
        expectedProject.setName("WP_Project_01");
        expectedProject.setAnnouncement("This is a test announcement.");
        expectedProject.setShowAnnouncement(true);
        expectedProject.setSuiteMode(2);

        given()
                .body(String.format("{\n" +
                                        "    \"name\": \"%s\",\n" +
                                        "    \"announcement\": \"%s\",\n" +
                                        "    \"show_announcement\": %b,\n" +
                                        "    \"suite_mode\": %d\n" +
                                        "}",
                        expectedProject.getName(),
                        expectedProject.getAnnouncement(),
                        expectedProject.isShowAnnouncement(),
                        expectedProject.getSuiteMode()))
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test
    public void addProjectUsingMapTest() {
        String endpoint = "/index.php?/api/v2/add_project";

        Project expectedProject = new Project();
        expectedProject.setName("WP_Project_02");
        expectedProject.setAnnouncement("This is a test announcement.");
        expectedProject.setShowAnnouncement(false);
        expectedProject.setSuiteMode(3);

        Map<String, Object> jsonAsMap = new HashMap<String, Object>();
        jsonAsMap.put("name", expectedProject.getName());
        jsonAsMap.put("suite_mode", expectedProject.getSuiteMode());

        given()
                .body(jsonAsMap)
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test
    public void addProjectUsingObjectTest() throws FileNotFoundException {
        String endpoint = "/index.php?/api/v2/add_project";

        Project expectedProject = new Project();
        expectedProject.setName("WP_Project_05");
        expectedProject.setAnnouncement("This is a test announcement.");
        expectedProject.setShowAnnouncement(true);
        expectedProject.setSuiteMode(1);

        given()
                .body(expectedProject)
                .log().body()
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test
    public void addProjectUsingFileTest() throws FileNotFoundException {
        String endpoint = "/index.php?/api/v2/add_project";

        given()
                .body(PostTestRailTest.class.getClassLoader().getResourceAsStream("tmp.json"))
                .log().body()
                .when()
                .post(endpoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }
}
