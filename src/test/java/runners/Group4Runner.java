package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/group4-reports/report.html",
                "json:target/group4-reports/report.json"
        },
        features = "src/test/resources/features/group04",
        glue = {"stepdefinitions.stepdefinitionsgroup04"},
        tags = "@group4_login",
        dryRun = false,
        monochrome = true
)
public class Group4Runner {
}
