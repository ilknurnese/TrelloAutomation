package pages.pagesGroup05.g5_uiPages;

import enums.UserCredentials;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigReader;
import utilities.GWD;
import utilities.WaitUtils;

import static base_urls.TrelloBaseUrl.trelloApiSetUp;

public class HHHHHHHooks11111 extends G5_CommonPage {

    /*
   Hooks is used to run before and after each SCENARIO or SCENARIO OUTLINE
    */
    @Before
    public void before() {
        GWD.getDriver().manage().deleteAllCookies();
    }

    @After
    public void tearDownScenario(Scenario scenario) {
//        System.out.println("After Method");
        if (scenario.isFailed()) {//capturing the screenshot when a sceraio fails and attaching it to the report
            final byte[] failedScreenshot = ((TakesScreenshot) GWD.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(failedScreenshot, "image/png", "failed_scenario" + scenario.getName() + "");
//            GWD.closeDriver();
        }
    }

    //    This Before hooks ONLY RUNS for @smoke_test TAGGED SCENARIOS
//    @Before(value = "@smoke_tests")
    @Before("@medunna_UserName_Email")
    public void beforeApi() {// this method will run before TC03_Api
        trelloApiSetUp();
    }


    @Before
    public void loginBeforeScenario() {

        GWD.getDriver().get(ConfigReader.getProperty("trelloURL"));
        g5HomePage().loginButton.click();
        WaitUtils.waitForVisibility(g5LoginPage().inputMailBox, 20);
        // Enum'dan kullanıcı seçiyoruz
        UserCredentials user = UserCredentials.user_mustafa;

        // E-posta girip devam et
        g5LoginPage().inputMailBox.sendKeys(user.getEmail());
        g5LoginPage().continueButton.click();

        WaitUtils.waitForVisibility(g5LoginPage().passwordBox, 3);

        // Şifre girip login ol
        g5LoginPage().passwordBox.sendKeys(user.getPassword());
        g5LoginPage().logInButton.click();
    }


    //    @After
//    public void tearDown() {
//        GWD.getDriver().quit();
//    }
//    @After
//    public void tearDown() {
//        if (GWD.getDriver() != null) {
//            GWD.getDriver().quit(); // close() değil quit() kullan
//        }

    }


