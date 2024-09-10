package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Users {
    private int offset;
    private int limit;
    private int size;

    private User[] users;
}
