package stepdefinitions.stepdefinitionsgroup04;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.pagesGroup04.BoardPage;
import pages.pagesGroup04.LoginPage;
import utilities.ConfigReader;
import utilities.GWD;
import static org.junit.Assert.*;

public class CreateBoardSteps {

    LoginPage loginPage = new LoginPage();
    BoardPage boardPage = new BoardPage();

    @Given("kullanici Trello anasayfasina login olur")
    public void kullanici_trello_anasayfasina_login_olur() {
        GWD.getDriver().get(ConfigReader.get("trelloURL"));
        loginPage.loginWithCredentials(
                ConfigReader.get("group4_email"),
                ConfigReader.get("group4_password")
        );
    }

    @When("kullanici yeni bir board olusturur")
    public void kullanici_yeni_bir_board_olusturur() {
        boardPage.clickCreateButton();
        boardPage.selectCreateBoard();
        boardPage.selectBoardBackground();
        boardPage.enterBoardTitle("Group4 Test Board");
        boardPage.openVisibilityOptions();
        boardPage.clickStartFreeTrial();
        boardPage.clickFinalCreateButton();
    }

    @Then("kullanici board'un basariyla olustugunu dogrular")
    public void kullanici_board_olustugunu_dogrular() {
        assertTrue("Board olusturulamadi!", boardPage.verifyBoardCreated());
    }
}
