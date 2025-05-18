package stepdefinitions.stepdefinitionsgroup01;

import io.cucumber.java.en.Given;
import utilities.ConfigReader;
import utilities.GWD;

public class MyStepdefs {

    @Given("The user navigates to Google")
    public void test() {

        GWD.getDriver().get(ConfigReader.getProperty("googleURL"));

    }
}
