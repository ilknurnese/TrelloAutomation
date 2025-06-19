package stepdefinitions.stepdefinitionsgroup04;

import io.cucumber.java.en.*;
import pages.pagesGroup04.BoardPage;
import pages.pagesGroup04.LoginPage;
import utilities.ConfigReader;

public class CreateBoardSteps {

    BoardPage boardPage = new BoardPage();
    LoginPage loginPage = new LoginPage();

    @Given("kullanici login olur")
    public void kullanici_login_olur() {
        loginPage.loginWithCredentials(
                ConfigReader.getProperty("email"),
                ConfigReader.getProperty("password")
        );
    }

    @When("kullanici yeni bir board olusturur")
    public void kullanici_yeni_bir_board_olusturur() {
        boardPage.clickCreateButton();
        boardPage.clickCreateBoardOption();
        boardPage.openBackgroundMenu();
        boardPage.selectBackgroundImage();
        boardPage.enterBoardTitle("Group4");
        boardPage.openVisibilityDropdown();
        boardPage.selectVisibilityOption();
        boardPage.clickCreateBoardButton();
    }

    @Then("kullanici olusturulan board'u dogrular")
    public void kullanici_olusturulan_boardu_dogrular() {
        boardPage.verifyBoardCreated("Group4");
    }
}
