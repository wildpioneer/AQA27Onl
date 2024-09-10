package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private String name;
    private int id;
    private String email;

    @SerializedName("is_active")
    @JsonProperty("is_active")
    private boolean isActive;

    private String parent;
}
