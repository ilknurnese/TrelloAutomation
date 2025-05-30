package stepdefinitions.stepdefinitionsgroup05.g5_uistepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.pagesGroup05.g5_uiPages.G5_CommonPage;
import utilities.ConfigReader;
import utilities.GWD;

public class G5_CreateBoardSteps extends G5_CommonPage {

    @Given("The user is directed to the home page")
    public void the_user_is_directed_to_the_home_page() {

        GWD.getDriver().get(ConfigReader.getProperty("trelloURL"));


    }
    @When("Home page titles such as {string} appear")
    public void home_page_titles_such_as_appear(String string) {

        GWD.getDriver().getTitle().contains("Capture, organize, and tackle your to-dos from anywhere | Trello");

    }










}
