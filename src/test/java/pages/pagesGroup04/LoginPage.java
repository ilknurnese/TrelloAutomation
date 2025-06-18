package pages.pagesGroup04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.GWD;
import utilities.WaitUtils;

public class LoginPage {

    WebDriver driver;

    public LoginPage() {
        this.driver = GWD.getDriver();
    }

    private By loginLinkOnHomePage = By.xpath("//a[text()='Log in']");


    private By emailInput = By.id("username");
    private By continueBtn = By.className("css-178ag6o");


    private By passwordInput = By.id("password");
    private By loginBtn = By.id("login-submit");


    public void clickLoginLinkOnHomePage() {
        driver.findElement(loginLinkOnHomePage).click();
    }

    public void enterEmailAndContinue(String email) {
        WaitUtils.waitFor(2); // Şartlı bekleme ile iyileştirilebilir
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(continueBtn).click();
    }

    public void enterPasswordAndLogin(String password) {
        WaitUtils.waitFor(2);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginBtn).click();
    }


    public void loginWithCredentials(String email, String password) {
        clickLoginLinkOnHomePage();
        enterEmailAndContinue(email);
        enterPasswordAndLogin(password);
    }
}
