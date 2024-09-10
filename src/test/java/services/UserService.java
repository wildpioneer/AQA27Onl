package services;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class UserService implements IUserService {
    @Override
    public Response getUsers() {
         return given()
                .when()
                .get(Endpoints.GET_USERS)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
    }
}
