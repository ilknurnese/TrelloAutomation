package pages.pagesGroup05.g5_uiPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;

public class G5_CommonPage {

    public G5_CommonPage() {
        PageFactory.initElements( GWD.getDriver(),this);
    }


    private G5_HomePage g5HomePage;
    private G5_LoginPage g5LoginPage;
 //================AYSE===================
                                                    //BU PAGE CLASS  DEKLARE ETMEK ICIN HERKESE 2 SATIR ,YUKARDA ORNEKTE OLDUGU GIBI

//================BARIS===================


//================FARUK===================


//================MARYAM===================


//================MUSTAFA===================



    public G5_HomePage g5HomePage() {
        if (g5HomePage == null) {
            g5HomePage = new G5_HomePage();
        }
        return g5HomePage;
    }
    public G5_LoginPage g5LoginPage() {
        if (g5LoginPage == null) {
            g5LoginPage = new G5_LoginPage();
        }
        return g5LoginPage;
    }





//================AYSE===================



















//================BARIS===================



















//================FARUK===================



















//================MARYAM===================



















    //================MUSTAFA===================
































}
