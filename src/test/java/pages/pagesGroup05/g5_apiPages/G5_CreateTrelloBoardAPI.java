package pages.pagesGroup05.g5_apiPages;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class G5_CreateTrelloBoardAPI {

    /*
    curl --request POST \
  --url 'https://api.trello.com/1/boards/?name={name}&key=APIKey&token=APIToken'
     */
    public static <String> Response createBoard(String name, String key, String token) {
        RestAssured.baseURI = "https://api.trello.com";

        return given()
                .queryParam("name", name)
                .queryParam("key", key)
                .queryParam("token", token)
                .header("Content-Type", "application/json")
                .when()
                .post("/1/boards/")

                .then().log().all()
                .extract()
                .response();
        /*
        Bu, POST isteğini yapar ve dönen yanıtı (status code, body, headers, vb.) Response nesnesi olarak alır.

            Sonra bu yanıtla şunu yapabilirsiniz:
        response.getStatusCode();       // 200
        response.jsonPath().getString("id");  // Oluşturulan board'un ID’si
        response.prettyPrint();         // JSON yanıtı konsola yazdırır

         */
    }

/*

    @Given("The user create a board named {string}")
    public void the_user_create_a_board_named(String boardName) {
        RestAssured.baseURI = "https://api.trello.com/1";

//        Response response =
                given()
                .queryParam("name", boardName)
                .queryParam("key", "8876e5e53ef1bc4fb44f9d516f90ba15")
                .queryParam("token",  "ATTA462f54ae1db933674f360cb0ceeccbd28ded7fcd983bf6c54bb4b4d26ae5e81178C21C69")
                .header("Content-Type", "application/json")
                .when()
                .post("/boards/")
                .then()
//                .assertThat().statusCode(201)
                .body("name", equalTo(boardName)).log().all();
//                .extract().response();

//        String boardId = response.path("id");
//        System.out.println("Board created with ID: " + boardId);

    }
 */

















}
