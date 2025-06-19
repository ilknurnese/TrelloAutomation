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

    private final By createButton = By.xpath("//p[text()='Create']");
    private final By createBoardOption = By.xpath("//button[@data-testid='header-create-board-button']");
    private final By backgroundMenuIcon = By.xpath("(//div[@data-testid='OverflowMenuHorizontalIcon'])[1]");
    private final By backgroundImage = By.xpath("(//div[@class='hy7T0kL4IW58ix'])[1]");
    private final By boardTitleInput = By.xpath("(//input[contains(@class,'nch-textfield__input')])[1]");
    private final By visibilityDropdown = By.xpath("(//div[contains(@class,'css-1c8bys3-singleValue')])[2]");
    private final By visibilitySelectOption = By.xpath("(//select[@id='1750367860185-create-board-select-visibility'])[2]");
    private final By createBoardButton = By.xpath("//button[@data-testid='create-board-submit-button']");
    private final By boardHeaderTitle = By.xpath("//h1[@data-testid='board-name-display']");

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
}
