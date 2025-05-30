package pages.pagesGroup05.g5_uiPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class G5_LoginPage extends G5_CommonPage {



    //================AYSE===================



















//================BARIS===================



















//================FARUK===================



















//================MARYAM===================



















    //================MUSTAFA===================
    @FindBy(xpath = "//input[@id='username']")
    public WebElement inputMailBox;

    @FindBy(id ="login-submit")
    public WebElement continueButton;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordBox;

    @FindBy(id ="login-submit")
    public WebElement logInButton;


















}
