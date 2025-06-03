package pages.pagesGroup05.g5_uiPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ConfigReader;
import utilities.GWD;

import java.util.List;

public class G5_TestBoard extends G5_CommonPage {

//================AYSE===================



















//================BARIS===================



















//================FARUK===================



















//================MARYAM===================



















 //================MUSTAFA===================
    @FindBy(xpath ="//a[text()='Log in']")
    public WebElement loginButton;

    @FindBy(xpath ="//button[@data-testid='create-board-tile']")
    public WebElement createBoardButton;

   @FindBy(xpath ="(//span[@data-testid='CheckIcon'])[1]")
   public WebElement checkIcon;

    @FindBy(xpath ="(//h2[normalize-space()='Create board'])[1]")
    public WebElement createBoardText;

    @FindBy(xpath ="//div[@data-testid='create-board-select-visibility-select--control']")
    public WebElement visibilityDropdown;

//    @FindBy(xpath ="//*[contains(text(),'Board members and Trello Workspace')]")
//    public WebElement privateVisibilityDropdown;

    @FindBy(xpath ="//span[@class='xkFHuqSrHKJuI9']")
    public WebElement privateVisibilityDropdown;


    @FindBy(xpath ="//*[@data-testid='create-board-title-input']")
    public WebElement boardNameBox;

    @FindBy(xpath ="//*[@data-testid='create-board-submit-button']")
    public WebElement createBoardSubmit;

    @FindBy(xpath ="//*[text()='Group-5 Test Board']")
    public WebElement actualBoardName;

    @FindBy(xpath ="//button[@title='Custom image']")
    public List<WebElement> boardCustomImages;

    @FindBy(xpath ="//img[@role='presentation']")
    public WebElement smallBoardSampleImage;

    @FindBy(xpath ="//span[@data-testid='OverflowMenuHorizontalIcon']")
    public WebElement treeDotIcon;

























}
