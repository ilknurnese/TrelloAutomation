package stepdefinitions.stepdefinitionsgroup04;

import io.cucumber.java.en.*;
import pages.pagesGroup04.BoardPage;
import pages.pagesGroup04.LoginPage;
import utilities.ConfigReader;
import utilities.WaitUtils;

public class CreateBoardSteps {

    BoardPage boardPage = new BoardPage();
    LoginPage loginPage = new LoginPage();

    @Given("kullanici login olur")
    public void kullanici_login_olur() {
        loginPage.loginWithCredentials(
                ConfigReader.getProperty("group4_email"),
                ConfigReader.getProperty("group4_password")
        );
    }

    @When("kullanici yeni bir board olusturur")
    public void kullanici_yeni_bir_board_olusturur() {
        WaitUtils.waitFor(2);
        boardPage.clickOn("Create Button");
        WaitUtils.waitFor(2);
        boardPage.clickOn("Create Board Option");
        WaitUtils.waitFor(1);
        boardPage.clickOn("Background Menu");
        WaitUtils.waitFor(1);
        boardPage.clickOn("Background Image");
        WaitUtils.waitFor(1);
        boardPage.enterBoardTitle("Group4");
        WaitUtils.waitFor(1);
        boardPage.clickOn("Visibility Dropdown");
        WaitUtils.waitFor(1);
        boardPage.clickOn("Visibility Option");
        WaitUtils.waitFor(1);
        boardPage.clickOn("Create Board button");
    }


    @Then("kullanici olusturulan board'u dogrular")
    public void kullanici_olusturulan_boardu_dogrular() {
        boardPage.verifyBoardCreated("Group4");
    }

    @When("kullanici {string} isimli yeni bir board olusturur")
    public void kullaniciIsimliYeniBirBoardOlusturur(String boardName) {
        WaitUtils.waitFor(3);
        boardPage.clickOn("Create Button");
        WaitUtils.waitFor(2);
        boardPage.clickOn("Create Board Option");
        WaitUtils.waitFor(1);
        boardPage.clickOn("Background Menu");
        WaitUtils.waitFor(1);
        boardPage.clickOn("Background Image");
        WaitUtils.waitFor(1);
        boardPage.clickOn("Background Cross Button");
        WaitUtils.waitFor(1);
        boardPage.enterBoardTitle(boardName);
        WaitUtils.waitFor(1);
        boardPage.clickOn("Create Board button");
    }

    @Then("kullanici olusturulan {string} isimli board'u dogrular")
    public void kullaniciOlusturulanIsimliBoardUDogrular(String boardName) {
        boardPage.verifyBoardCreated(boardName);
    }
}
