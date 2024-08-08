package models;

import java.util.Objects;

public class User {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder {
        private User newUser;

        public Builder() {
            this.newUser = new User();
        }

        public Builder setUsername(String username) {
            newUser.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            newUser.password = password;
            return this;
        }

        public User build() {
            return newUser;
        }
    }
}
