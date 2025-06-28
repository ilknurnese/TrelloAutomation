package stepdefinitions.stepdefinitionsgroup04;

import io.cucumber.java.en.*;
import pages.pagesGroup04.BoardPage;
import pages.pagesGroup04.LoginPage;
import utilities.ConfigReader;

public class DeleteBoardSteps {

    BoardPage boardPage = new BoardPage();
    LoginPage loginPage = new LoginPage();

    @Given("kullanici login olarak silme islemi icin hazirlik yapar")
    public void kullanici_login_olarak_silme_islemi_icin_hazirlik_yapar() {
        loginPage.loginWithCredentials(
                ConfigReader.getProperty("email"),
                ConfigReader.getProperty("password")
        );
    }

    @When("kullanici bir board'u kapatir ve siler")
    public void kullanici_bir_boardu_kapatir_ve_siler() {
        boardPage.closeBoard();
        boardPage.openClosedBoards();
        boardPage.deleteClosedBoard();
    }

    @When("kullanici bir {string} isimli board'u kapatir ve siler")
    public void kullanici_isimli_boardu_kapatir_ve_siler(String boardName) {
        boardPage.closeBoard();
        boardPage.openClosedBoards();
        boardPage.deleteClosedBoard();
    }

    @Then("kullanici board'un silindigini dogrular")
    public void kullanici_boardun_silindigini_dogrular() {
        boardPage.verifyBoardDeleted("Group4 Updated"); // ya da dinamik title
    }
}
