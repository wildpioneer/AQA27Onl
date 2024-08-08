package utils;

import configuration.ReadProperties;
import models.User;

public class Director {

    public static User getAdmin() {
        return new User.Builder()
                .setUsername(ReadProperties.username())
                .setPassword(ReadProperties.password())
                .build();
    }

    public static User getUserWithIncorrectUsername() {
        return
                new User.Builder()
                        .setUsername("sdsdsd")
                        .setPassword(ReadProperties.password())
                        .build();
    }

    public static User getUserWithIncorrectPassword() {
        return new User.Builder()
                .setUsername(ReadProperties.username())
                .setPassword("sdsdsd")
                .build();
    }
}
