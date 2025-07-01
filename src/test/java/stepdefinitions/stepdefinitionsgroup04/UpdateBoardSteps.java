package stepdefinitions.stepdefinitionsgroup04;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.pagesGroup04.BoardPage;
import pages.pagesGroup04.LoginPage;
import utilities.ConfigReader;
import utilities.WaitUtils;

public class UpdateBoardSteps {

    BoardPage boardPage = new BoardPage();
    LoginPage loginPage = new LoginPage();

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


    @Given("kullanıcı {string} isimli boardda üye ekleme ekranına gelir")
    public void kullanıcıIsimliBoarddaÜyeEklemeEkranınaGelir(String boardName) {
        boardPage.goToBoardsPage();
        boardPage.clickOnText(boardName);
        boardPage.clickOn("Share Button");
    }

    @When("kullanıcı {string} üyesini {string} verisini girerek ekler")
    public void kullanıcıÜyesiniVerisiniGirerekEkler(String member, String type) {
        boardPage.enterMemberData(member);
        boardPage.clickOn("Share button on share screen");
    }

    @Then("Kullanıcı {string} isimli üyenin eklendiğini doğrular")
    public void kullanıcıIsimliÜyeninEklendiğiniDoğrular(String member) {
        WaitUtils.waitFor(2);
        Assert.assertTrue("İsim listede görüntülenemedi",boardPage.checkMemberOnList(member));
        boardPage.clickOn("Close Share Button");
    }

    @When("kullanıcı eklenen {string} isimli üyeyi üye listesinden siler")
    public void kullanıcıEklenenIsimliÜyeyiÜyeListesindenSiler(String arg0) {
        boardPage.clickOn("Member Permission Dropdown");
        boardPage.clickOn("Remove From Board");
        boardPage.clickOn("Remove Button");
    }

    @Then("kullanıcı {string} isimli üyenin silindiğini doğrular")
    public void kullanıcıIsimliÜyeninSilindiğiniDoğrular(String member) {
        WaitUtils.waitFor(2);
        Assert.assertFalse("İsim listede görünüyor",boardPage.checkMemberOnList(member));
    }
}
