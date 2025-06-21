package stepdefinitions.stepdefinitionsgroup04;

import io.cucumber.java.en.*;
import pages.pagesGroup04.BoardPage;
import pages.pagesGroup04.LoginPage;
import utilities.ConfigReader;
import utilities.WaitUtils;

public class UpdateBoardSteps {

    BoardPage boardPage = new BoardPage();
    LoginPage loginPage = new LoginPage();

    @Given("kullanici login olur")
    public void kullanici_login_olur() {
        loginPage.loginWithCredentials(
                ConfigReader.getProperty("email"),
                ConfigReader.getProperty("password")
        );
    }

    @When("kullanici bir board'u gunceller")
    public void kullanici_bir_boardu_gunceller() {
        boardPage.navigateToExistingBoard();
        boardPage.updateBoardTitle("Group4 Updated");
        WaitUtils.waitFor(1);
        boardPage.clickOn("Star Icon");
        boardPage.changeVisibilityToPrivate();
        WaitUtils.waitFor(2);
        boardPage.clickOn("Board Menu");
        boardPage.changeBoardBackground();
    }

    @Then("kullanici guncellenen board'u dogrular")
    public void kullanici_guncellenen_boardu_dogrular() {
        boardPage.verifyBoardUpdated("Group4 Updated");
    }
}
