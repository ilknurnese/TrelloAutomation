package pages.pagesGroup04;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.GWD;
import utilities.WaitUtils;

public class BoardPage {

    WebDriver driver;

    public BoardPage() {
        this.driver = GWD.getDriver();
    }

    // === CREATE LOCATORS ===
    private final By createButton = By.xpath("//p[text()='Create']");
    private final By createBoardOption = By.xpath("//button[@data-testid='header-create-board-button']");
    private final By backgroundMenuIcon = By.xpath("(//div[@data-testid='OverflowMenuHorizontalIcon'])[1]");
    private final By backgroundImage = By.xpath("(//div[@class='hy7T0kL4IW58ix'])[1]");
    private final By boardTitleInput = By.xpath("(//input[contains(@class,'nch-textfield__input')])[1]");
    private final By visibilityDropdown = By.xpath("(//div[contains(@class,'css-1c8bys3-singleValue')])[2]");
    private final By visibilitySelectOption = By.xpath("(//select[@id='1750367860185-create-board-select-visibility'])[2]");
    private final By createBoardButton = By.xpath("//button[@data-testid='create-board-submit-button']");
    private final By boardHeaderTitle = By.xpath("//h1[@data-testid='board-name-display']");

    // === UPDATE LOCATORS ===
    private final By boardTile = By.xpath("(//div[@class='board-tile-details is-badged'])[1]");
    private final By boardTitleText = By.xpath("//h1[@data-testid='board-name-display']");
    private final By boardTitleInputField = By.xpath("//input[contains(@class,'hiRkezEUBG7ve6')]");
    private final By starIcon = By.xpath("//button[@data-testid='StarIcon']");
    private final By lockIcon = By.xpath("//button[@data-testid='OrganizationIcon']");
    private final By privateOption = By.xpath("//span[@data-testid='board-visibility-dropdown-Private']");
    private final By moreMenuButton = By.xpath("(//div[@data-testid='OverflowMenuHorizontalIcon'])[4]");
    private final By changeBackgroundButton = By.xpath("(//button[@class='S1YMKJFPn9WNGk'])[6]");
    private final By photoArea = By.className("yVUt0nJ98k_eMz");
    private final By selectBackground = By.xpath("//button[@data-testid='board-background-select-photo-22']");
    private final By closeBackground = By.xpath("//button[@data-testid='CloseIcon']");

    // === CREATE METHODS ===
    public void clickCreateButton() {
        WaitUtils.waitFor(2);
        driver.findElement(createButton).click();
    }

    public void clickCreateBoardOption() {
        WaitUtils.waitFor(2);
        driver.findElement(createBoardOption).click();
    }

    public void openBackgroundMenu() {
        WaitUtils.waitFor(1);
        driver.findElement(backgroundMenuIcon).click();
    }

    public void selectBackgroundImage() {
        WaitUtils.waitFor(1);
        driver.findElement(backgroundImage).click();
    }

    public void enterBoardTitle(String title) {
        WaitUtils.waitFor(1);
        driver.findElement(boardTitleInput).sendKeys(title);
    }

    public void openVisibilityDropdown() {
        WaitUtils.waitFor(1);
        driver.findElement(visibilityDropdown).click();
    }

    public void selectVisibilityOption() {
        WaitUtils.waitFor(1);
        driver.findElement(visibilitySelectOption).click();
    }

    public void clickCreateBoardButton() {
        WaitUtils.waitFor(2);
        driver.findElement(createBoardButton).click();
    }

    public void verifyBoardCreated(String expectedTitle) {
        WaitUtils.waitFor(3);
        String actualTitle = driver.findElement(boardHeaderTitle).getText();
        if (!actualTitle.equals(expectedTitle)) {
            throw new AssertionError("Board ismi beklenenle eşleşmiyor.\nBeklenen: " + expectedTitle + "\nGerçek: " + actualTitle);
        }
    }

    // === UPDATE METHODS ===
    public void navigateToExistingBoard() {
        WaitUtils.waitFor(3);
        driver.get("https://trello.com/u/boards");
        WaitUtils.waitFor(3);
        driver.findElement(boardTile).click();
    }

    public void updateBoardTitle(String newTitle) {
        WaitUtils.waitFor(2);
        driver.findElement(boardTitleText).click();
        WebElement inputField = driver.findElement(boardTitleInputField);
        inputField.clear();
        inputField.sendKeys(newTitle);
        inputField.sendKeys(Keys.ENTER);
    }

    public void toggleStarIcon() {
        WaitUtils.waitFor(1);
        driver.findElement(starIcon).click();
    }

    public void changeVisibilityToPrivate() {
        WaitUtils.waitFor(1);
        driver.findElement(lockIcon).click();
        WaitUtils.waitFor(1);
        driver.findElement(privateOption).click();
    }

    public void openBoardMenu() {
        WaitUtils.waitFor(2);
        driver.findElement(moreMenuButton).click();
    }

    public void changeBoardBackground() {
        WaitUtils.waitFor(2);
        driver.findElement(changeBackgroundButton).click();
        WaitUtils.waitFor(2);
        driver.findElement(photoArea).click();
        WaitUtils.waitFor(2);
        driver.findElement(selectBackground).click();
        WaitUtils.waitFor(1);
        driver.findElement(closeBackground).click();
    }

    public void verifyBoardUpdated(String expectedTitle) {
        WaitUtils.waitFor(3);
        String actualTitle = driver.findElement(boardHeaderTitle).getText();
        if (!actualTitle.equals(expectedTitle)) {
            throw new AssertionError("Güncellenen board ismi beklenenle eşleşmiyor.\nBeklenen: " + expectedTitle + "\nGerçek: " + actualTitle);
        }
    }
}
