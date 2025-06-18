package pages.pagesGroup04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.GWD;
import utilities.WaitUtils;

public class BoardPage {

    WebDriver driver;

    public BoardPage() {
        this.driver = GWD.getDriver();
    }

    private By createButton = By.xpath("//p[text()='Create']");
    private By createBoardOption = By.xpath("(//*[@class='kgXqyT2weJmrQm'])[2]");
    private By boardTitleInput = By.cssSelector("[data-testid='create-board-title-input']");
    private By visibilityDropdown = By.xpath("//button[@data-testid='visibility-select']");
    private By startFreeTrialButton = By.xpath("//button[@data-testid='start-trial-submit-button']");
    private By finalCreateBoardButton = By.xpath("//button[@data-testid='create-board-submit-button']");
    private By boardHeaderTitle = By.xpath("//h1[@data-testid='board-name-display']");

    public void clickCreateButton() {
        WaitUtils.waitFor(2);
        driver.findElement(createButton).click();
    }

    public void selectCreateBoardOption() {
        WaitUtils.waitFor(2);
        driver.findElement(createBoardOption).click();
    }

    public void chooseBoardBackground() {
        // Bu adım opsiyonel olabilir, sadece bekletiyoruz
        WaitUtils.waitFor(1);
    }

    public void enterBoardTitle(String title) {
        driver.findElement(boardTitleInput).sendKeys(title);
    }

    public void selectVisibilityOption() {
        driver.findElement(visibilityDropdown).click();
        WaitUtils.waitFor(1);
    }

    public void clickStartFreeTrialButton() {
        driver.findElement(startFreeTrialButton).click();
        WaitUtils.waitFor(2);
    }

    public void clickCreateBoardButton() {
        driver.findElement(finalCreateBoardButton).click();
        WaitUtils.waitFor(3); // Oluşması zaman alabilir
    }

    public void verifyBoardCreated(String expectedTitle) {
        String actualTitle = driver.findElement(boardHeaderTitle).getText();
        if (!actualTitle.equals(expectedTitle)) {
            throw new AssertionError("Beklenen board başlığı bulunamadı: " + expectedTitle);
        }
    }
}
