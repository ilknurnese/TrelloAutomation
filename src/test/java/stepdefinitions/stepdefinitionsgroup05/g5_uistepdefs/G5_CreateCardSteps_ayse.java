package stepdefinitions.stepdefinitionsgroup05.g5_uistepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class G5_CreateCardSteps_ayse {

    WebDriver driver;


    @Given("The user is logged into the application with valid credentials")
    public void the_user_is_logged_in() {
        // Implement login steps here if not using session cookies
        // Or assume login is already handled in the test setup
    }

    @Given("The user has access to a board that contains at least one list")
    public void the_user_has_access_to_board() {
        // Already assumed by navigating to the board page
    }

    @Given("The user has permission to create cards on the board")
    public void the_user_has_permission() {
        // Already assumed by user role
    }

    @Given("The user navigates to {string}")
    public void the_user_navigates_to(String boardUrl) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(boardUrl);

    }

    @When("The user clicks on the {string} option under an existing list")
    public void the_user_clicks_on_add_a_card(String option) {
      //  cardPage.clickAddCardButton();
    }

    @When("The user enters a valid card title {string}")
    public void the_user_enters_a_valid_card_title(String cardTitle) {
      //  cardPage.enterCardTitle(cardTitle);
    }

    @When("The user clicks the {string} button")
    public void the_user_clicks_the_add_card_button(String button) {
      //  cardPage.clickConfirmAddCardButton();
    }

    @Then("The new card titled {string} should be visible under the selected list")
    public void the_new_card_should_be_visible(String cardTitle) {
      //  Assert.assertTrue("Card was not found!", cardPage.isCardVisible(cardTitle));
        driver.quit();
    }
}
