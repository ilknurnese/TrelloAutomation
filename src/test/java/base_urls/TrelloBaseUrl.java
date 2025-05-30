package base_urls;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;


public class TrelloBaseUrl {

    public static RequestSpecification spec;



    public static void trelloApiSetUp(){

        spec = new RequestSpecBuilder().setBaseUri("https://trello.com/").build();
    }


}