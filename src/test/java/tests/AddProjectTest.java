package tests;

import baseEntities.BaseTest;
import com.github.javafaker.Faker;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProjectTest extends BaseTest {

    @Test
    public void addProjectTest1() {
        Faker faker = new Faker();
        String projectName = faker.name().firstName();
        String projectAnnouncement = "TestDescription";
    }

    @Test
    public void addProjectTest2() {
        Project project = new Project();
        project.setName("asdasd");

        projectStep.addProject(project);
    }

    @Test
    public void addProjectTest3() {
        Project project = new Project();
        project.setName("asdasd");

        projectStep.addProject(project);
    }

    @Test
    public void addProjectTest4() {
        Project project = new Project();
        project.setName("asdasd");

        projectStep.addProject(project);
    }

    @Test
    public void addProjectTest5() {
        Project project = new Project();
        project.setName("asdasd");

        projectStep.addProject(project);
    }

    @Test
    public void addProjectTest6() {
        Project project = new Project();
        project.setName("asdasd");

        projectStep.addProject(project);
    }
}
