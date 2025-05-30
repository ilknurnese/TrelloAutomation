package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.GWD;
import utilities.GWD;

import static base_urls.TrelloBaseUrl.trelloApiSetUp;

public class Hooks {

    /*
   Hooks is used to run before and after each SCENARIO or SCENARIO OUTLINE
    */
    @Before
    public void before() {
         GWD.getDriver().manage().deleteAllCookies();
     }
    @After
    public void tearDownScenario(Scenario scenario){
//        System.out.println("After Method");
        if (scenario.isFailed()){//capturing the screenshot when a sceraio fails and attaching it to the report
            final byte[] failedScreenshot = ((TakesScreenshot) GWD.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(failedScreenshot,"image/png","failed_scenario"+scenario.getName()+"");
//            GWD.closeDriver();
        }
    }
    //    This Before hooks ONLY RUNS for @smoke_test TAGGED SCENARIOS
//    @Before(value = "@smoke_tests")
    @Before("@medunna_UserName_Email")
    public void beforeApi(){// this method will run before TC03_Api
        trelloApiSetUp();
    }






}
