package tests;

import com.github.javafaker.Faker;
import models.Project;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoggerTest {
    private Logger logger = LogManager.getLogger(LoggerTest.class);

    @Test
    public void logLevelsTest() {
        logger.trace("Trace Message: ...");
        logger.debug("Debug Message: ...");
        logger.info("Info Message: ...");
        logger.warn("Warn Message: ...");
        logger.error("Error Message: ...");
        logger.fatal("Fatal Message: ...");
    }

    @Test
    public void logMessageTest() {
        Faker faker = new Faker();

        Project project = new Project();
        project.setName(faker.company().name());
        project.setAnnouncement(faker.book().title());

        logger.info(project.toString());

        if (false) {
            logger.error("Error message...");
        } else {
            logger.fatal("Fatal message...");
        }

        Assert.assertTrue(false, "Failed result....");
    }
}
