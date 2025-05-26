package pages.pagesGroup05.g5_uiPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class G5_HomePage extends G5_CommonPage {



    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement loginButton;

    @FindBy(id = "account-menu")
    public WebElement accountIcon;

    @FindBy(xpath = "//span[text()='Register']")
    public WebElement registerLink;

    @FindBy(id = "firstPassword")
    public WebElement firstPassword;

    @FindBy(xpath = "//input[@id='secondPassword']")
    public WebElement secondPassword;

    @FindBy(xpath = "//li[@style='background-color: rgb(153, 255, 0);']")
    public List<WebElement> bar4;



}
