package pages.pagesGroup05.g5_uiPages;

import org.openqa.selenium.By;
import utilities.GWD;

public class G5_CardPage extends G5_CommonPage {

    // Locator: List's "Add a card" button
    private By addCardButton = By.xpath("//a[contains(@class, 'open-card-composer')]");

    // Locator: Card title input box
    private By cardTitleInput = By.xpath("//textarea[contains(@class, 'list-card-composer-textarea')]");

    // Locator: "Add Card" confirm button
    private By confirmAddCardButton = By.xpath("//input[@value='Add card']");

    // Locator: Created card (by card title text)
    public By createdCard(String cardTitle) {
        return By.xpath("//span[text()='" + cardTitle + "']");
    }

    // Actions
    public void clickAddCardButton() {
        GWD.getDriver().findElement(addCardButton).click();
    }

    public void enterCardTitle(String cardTitle) {
        GWD.getDriver().findElement(cardTitleInput).sendKeys(cardTitle);
    }

    public void clickConfirmAddCardButton() {
        GWD.getDriver().findElement(confirmAddCardButton).click();
    }

    public boolean isCardVisible(String cardTitle) {
        return  GWD.getDriver().findElements(createdCard(cardTitle)).size() > 0;
    }
}
