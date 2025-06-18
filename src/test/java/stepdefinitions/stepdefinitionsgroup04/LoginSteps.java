package stepdefinitions.stepdefinitionsgroup04;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.pagesGroup04.LoginPage;
import utilities.ConfigReader;
import utilities.GWD;
import org.openqa.selenium.By;
import utilities.TestRailClientG4;

import java.io.IOException;

import static utilities.WaitUtils.waitForPageToLoad;
import static utilities.WaitUtils.waitForVisibility;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();
    WebDriver driver = GWD.getDriver();
    private final int runId = 1;
    private Scenario scenario;

    @Before
    public void captureScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("kullanici login sayfasina gider")
    public void kullanici_login_sayfasina_gider() {
        driver.get(ConfigReader.get("trelloURL"));
    }

    @When("kullanici gecerli bilgilerle giris yapar")
    public void kullanici_gecerli_bilgilerle_giris_yapar() {
        String email = ConfigReader.get("group4_email");
        String password = ConfigReader.get("group4_password");
        loginPage.loginWithCredentials(email, password);
    }

    @Then("kullanici basarili sekilde giris yaptigini dogrular")
    public void kullanici_basarili_sekilde_giris_yaptigini_dogrular() {
        waitForVisibility(loginPage.memberButton,5);
        boolean isLoginSuccessful = driver.findElement(loginPage.memberButton).isDisplayed();
        Assert.assertTrue("Login başarılı olmadı!", isLoginSuccessful);
    }

    @Then("Testrail case C {int} is updated automatically on login page")
    public void testrailCaseCIsUpdatedAs(int caseId) throws IOException {
        TestRailClientG4 client = new TestRailClientG4();
        String cucumberStatus = scenario.getStatus().name();
        int statusId;
        switch (cucumberStatus.toLowerCase()) {
            case "passed" -> statusId=1;
            case "failed" -> statusId=5;
            default -> statusId=3;
        };
        client.addResultForTestCase(runId, caseId, statusId, "Status set via step definition: " + cucumberStatus);
    }
}
