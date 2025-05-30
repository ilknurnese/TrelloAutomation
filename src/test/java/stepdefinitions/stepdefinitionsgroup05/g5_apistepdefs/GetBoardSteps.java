package stepdefinitions.stepdefinitionsgroup05.g5_apistepdefs;


import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pages.pagesGroup05.g5_apiPages.G5_GetTrelloBoardAPI;

public class GetBoardSteps {

    private String apiKey = "8876e5e53ef1bc4fb44f9d516f90ba15";
    private String apiToken = "ATTA462f54ae1db933674f360cb0ceeccbd28ded7fcd983bf6c54bb4b4d26ae5e81178C21C69";
    private Response response;
    private String id="6832a84b44d3fc3954a734e4";

    @When("I read  Trello board information")
    public void i_read_trello_board_information() {

        response= G5_GetTrelloBoardAPI.getBoard(id, apiKey,apiToken);
        response.prettyPrint();
    }













}
