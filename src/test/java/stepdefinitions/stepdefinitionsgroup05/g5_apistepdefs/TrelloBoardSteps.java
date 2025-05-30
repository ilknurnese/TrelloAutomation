package stepdefinitions.stepdefinitionsgroup05.g5_apistepdefs;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pages.pagesGroup05.g5_apiPages.G5_CreateTrelloBoardAPI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TrelloBoardSteps {
    private String apiKey = "8876e5e53ef1bc4fb44f9d516f90ba15";
    private String apiToken = "ATTA462f54ae1db933674f360cb0ceeccbd28ded7fcd983bf6c54bb4b4d26ae5e81178C21C69";
    private Response response;


    @Given("I have valid API credentials")
    public void i_have_valid_api_credentials() {
        System.out.println("1");
    }


    @When("I create a new Trello board named {string}")
    public void i_create_a_new_trello_board_named(String boardName) {

        response= G5_CreateTrelloBoardAPI.createBoard(boardName,apiKey,apiToken);

    }


    @Then("the board should be created successfully")
    public void the_board_should_be_created_successfully() {
        assertEquals(200, response.getStatusCode());
        assertNotNull(response.jsonPath().getString("id"));
    }













}
