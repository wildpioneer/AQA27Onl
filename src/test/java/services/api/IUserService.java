package services.api;

import io.restassured.response.Response;

public interface IUserService {
    Response getUsers();
}
