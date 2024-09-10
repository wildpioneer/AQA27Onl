package tests.api;

import baseEntities.BaseApiTest;
import io.restassured.response.Response;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class CrudProjectTest extends BaseApiTest {
    private Project actualProject;

    @Test
    public void addProjectTest() {
        Project expectedProject = new Project();
        expectedProject.setName("Test Project");
        expectedProject.setAnnouncement("Test Announcement");
        expectedProject.setShowAnnouncement(true);
        expectedProject.setSuiteMode(2);

        actualProject = projectService.addProject(expectedProject);

        Assert.assertEquals(actualProject, expectedProject);
    }

    @Test (dependsOnMethods = "addProjectTest")
    public void readProjectTest() {
        Project project = projectService.getProject(actualProject.getId());

        System.out.println(project);
        Assert.assertEquals(project, actualProject);
    }

    @Test
    public void readProjectTest1() {
        Response response = projectService.getGeneralProject(255);

        response
                .then()
                .assertThat()
                .statusCode(400)
                .body("error", is("Field :project_id is not a valid or accessible project."));
    }

    @Test
    public void updateProjectTest() {

    }

    @Test
    public void deleteProjectTest() {

    }
}
