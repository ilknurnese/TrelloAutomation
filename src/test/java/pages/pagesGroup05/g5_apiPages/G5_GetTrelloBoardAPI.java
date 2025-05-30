package pages.pagesGroup05.g5_apiPages;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class G5_GetTrelloBoardAPI {


    public static <String> Response getBoard(String id, String key, String token) {
        RestAssured.baseURI = "https://api.trello.com";

        return given()
                .pathParam("boardId", id)
                .queryParam("key", key)
                .queryParam("token", token)
                .header("Content-Type", "application/json")
                .when()
                .get("/1/boards/{boardId}")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }


}
