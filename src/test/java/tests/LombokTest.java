package tests;

import lombok.val;
import models.Project;
import models.ProjectBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LombokTest {

    @Test
    public void simpleTest() {
        Project project = new Project();
        project.setId(10);
        project.setName("Test");
        project.setProjectType(3);

        System.out.println(project.toString());
    }

    @Test
    public void equalsAndHashCodeTest() {
        Project actualProject = new Project();
        actualProject.setId(4);
        actualProject.setName("Test");
        actualProject.setProjectType(3);

        Project expectedProject = new Project();
        expectedProject.setName("Test");
        expectedProject.setProjectType(3);

        System.out.println(actualProject);
        System.out.println(expectedProject);

        Assert.assertTrue(actualProject.equals(expectedProject));
    }

    @Test
    public void builderTest() {
        ProjectBuilder actualProject = ProjectBuilder.builder()
                .id(10)
                .name("Test")
                .projectType(3)
                .build();

        ProjectBuilder expectedProject = ProjectBuilder.builder()
                .id(10)
                .name("Test")
                .projectType(3)
                .build();

        System.out.println(actualProject);
        System.out.println(expectedProject);

        Assert.assertTrue(actualProject.equals(expectedProject));
    }

    @Test
    public void valTest() {
        List<String> list1 = new ArrayList<String>();

        val list2 = new ArrayList<String>(); // Transfer to final variables
        val list3 = new ArrayList<Integer>();

        list2.add("Test Value");

        System.out.println(list2.get(0));
    }

    @Test
    public void varTest() {
        List<String> list1 = new ArrayList<String>();

        var list2 = new ArrayList<String>(); // Transfer to not final variables

        list2.add("Test Value");

        System.out.println(list2.get(0));
    }
}
