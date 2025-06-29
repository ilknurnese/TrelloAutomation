package pages.pagesGroup04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.GWD;
import utilities.WaitUtils;

public class LoginPage {

    WebDriver driver;

    public LoginPage() {
        this.driver = GWD.getDriver();
    }

    private final By loginLinkOnHomePage = By.xpath("//a[text()='Log in']");
    private final By emailInput = By.id("username");
    private final By continueBtn = By.className("css-178ag6o"); // "Devam Et" butonu
    private final By passwordInput = By.id("password");
    private final By loginBtn = By.id("login-submit"); // Doğru locator
    public By memberButton = By.xpath("//button[@data-testid='header-member-menu-button']");


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
