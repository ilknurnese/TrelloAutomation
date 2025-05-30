package stepdefinitions.stepdefinitionsgroup05.g5_uistepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.pagesGroup05.g5_uiPages.G5_CommonPage;
import utilities.ConfigReader;
import utilities.GWD;

public class G5_CreateCardSteps extends G5_CommonPage {

//   HomePage homePage=new HomePage();

    @Given("the user navigates to the Trello login page")
    public void the_user_navigates_to_the_trello_login_page() {

        GWD.getDriver().get(ConfigReader.getProperty("googleURL"));

    }

    @When("the user click the login button")
    public void the_user_click_the_login_button() {
        homePage().loginButton.click();
    }

    @When("the user logs in with email {string} and password {string}")
    public void the_user_logs_in_with_email_and_password(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user clicks on {string}")
    public void the_user_clicks_on(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user enters board name {string}")
    public void the_user_enters_board_name(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user confirms board creation")
    public void the_user_confirms_board_creation() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the board {string} should be visible on the dashboard")
    public void the_board_should_be_visible_on_the_dashboard(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
