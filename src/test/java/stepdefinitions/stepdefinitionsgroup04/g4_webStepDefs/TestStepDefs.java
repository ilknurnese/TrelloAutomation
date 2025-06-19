package stepdefinitions.stepdefinitionsgroup04.g4_webStepDefs;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;
import utilities.GWD;
import utilities.TestRailClientG4;

import java.io.IOException;

public class TestStepDefs {

    private final int runId = 5;
    private Scenario scenario;

    @Before
    public void captureScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("The user navigates to Trello Homepage")
    public void testRailCase() {
        GWD.getDriver().get(ConfigReader.getProperty("trelloURL"));
    }

    @Then("Testrail case C {int} is updated automatically")
    public void testrailCaseCIsUpdatedAs(int caseId) throws IOException {
        TestRailClientG4 client = new TestRailClientG4();
        String cucumberStatus = scenario.getStatus().name();
        int statusId;
        switch (cucumberStatus.toLowerCase()) {
            case "passed" -> statusId=1;
            case "failed" -> statusId=5;
            default -> statusId=3;
        };
        client.addResultForTestCase(runId, caseId, statusId, "Status set via step definition: " + cucumberStatus);
    }
}