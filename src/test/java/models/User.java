package models;

import lombok.Data;

import java.util.Objects;

@Data
public class User {
    private String username;
    private String password;
}
