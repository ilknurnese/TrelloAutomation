package stepdefinitions.stepdefinitionsgroup04;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.pagesGroup04.LoginPage;
import utilities.ConfigReader;
import utilities.GWD;
import org.openqa.selenium.By;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("kullanici login sayfasina gider")
    public void kullanici_login_sayfasina_gider() {
        GWD.getDriver().get(ConfigReader.get("trelloURL"));
    }

    @When("kullanici gecerli bilgilerle giris yapar")
    public void kullanici_gecerli_bilgilerle_giris_yapar() {
        String email = ConfigReader.get("group4_email");
        String password = ConfigReader.get("group4_password");
        loginPage.loginWithCredentials(email, password);
    }

    @Then("kullanici basarili sekilde giris yaptigini dogrular")
    public void kullanici_basarili_sekilde_giris_yaptigini_dogrular() {

        boolean isLoginSuccessful = GWD.getDriver().findElement(By.cssSelector("button[data-testid='header-member-menu-button']")).isDisplayed();
        Assert.assertTrue("Login başarılı olmadı!", isLoginSuccessful);
    }
}
