package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:src/test/resources/htmlReporter/Rapor.html",
                "json:src/test/resources/htmlReporter/Rapor.json",
                "junit:src/test/resources/htmlReporter/Rapor.xml"

        },
        monochrome = true,
        features = "src/test/resources/features",
        glue = {"stepdefinitions","hooks"},
        tags = "@g5_uiboardstests",
        dryRun = false

)
public class Runner {
}