package pages.pagesGroup05.g5_uiPages;

import org.openqa.selenium.support.PageFactory;
import utilities.GWD;

public class G5_CommonPage {

    public G5_CommonPage() {
        PageFactory.initElements( GWD.getDriver(),this);
    }

    private G5_HomePage homePage;



    public G5_HomePage homePage() {
        if (homePage == null) {
            homePage = new G5_HomePage();
        }
        return homePage;
    }



}
