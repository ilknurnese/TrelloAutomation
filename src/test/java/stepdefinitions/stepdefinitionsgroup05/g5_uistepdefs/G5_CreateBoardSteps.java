package stepdefinitions.stepdefinitionsgroup05.g5_uistepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.pagesGroup05.g5_uiPages.G5_CommonPage;
import pages.pagesGroup05.g5_uiPages.G5_TestBoard;
import utilities.ConfigReader;
import utilities.GWD;
import utilities.JSUtils;
import utilities.WaitUtils;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class G5_CreateBoardSteps extends G5_CommonPage {

    @Given("The user is directed to the home page")
    public void the_user_is_directed_to_the_home_page() {

        GWD.getDriver().get(ConfigReader.getProperty("trelloURL"));


    }
    @When("Home page titles such as {string} appear")
    public void home_page_titles_such_as_appear(String string) {

        GWD.getDriver().getTitle().contains("Capture, organize, and tackle your to-dos from anywhere | Trello");

    }


    @When("user Clicks the Create button on the home page")
    public void user_clicks_the_create_button_on_the_home_page() {

        WaitUtils.waitForClickablility(g5TestBoard().createBoardButton,30);
//        WaitUtils.waitFor(5);
         g5TestBoard().createBoardButton.click();
    }
    @When("the user verify that {string}, {string}, {string} titles are visible.")
    public void the_user_verify_that_titles_are_visible(String  textBackGround, String textBoardTitle, String textVisibility) {

        Assert.assertEquals("Background",textBackGround);
        Assert.assertEquals("Board title",textBoardTitle);
        Assert.assertEquals("Visibility",textVisibility);

    }

    @When("the user verify that Background, Board Title, Visibility titles are visible")
    public void the_user_verify_that_background_board_title_visibility_titles_are_visible(DataTable titles) {

        List<String> relevantTitles=titles.asList();

        Assert.assertEquals("Background",relevantTitles.get(0));
        Assert.assertEquals("Board title",relevantTitles.get(1));
        Assert.assertEquals("Visibility",relevantTitles.get(2));

        }


     @Then("the user verify that Background, Visibility and Board Title should be selected. The Create button is clicked")
     public void the_user_verify_that_background_visibility_and_board_title_should_be_selected_the_create_button_is_clicked() {

         List<WebElement> backgroundImages = g5TestBoard().boardCustomImages;
         WaitUtils.waitFor(5);

         g5TestBoard().boardCustomImages.get(1).click();
         g5TestBoard().boardNameBox.sendKeys("Group-5 Test Board");
         g5TestBoard().visibilityDropdown.click();
         WaitUtils.waitForClickablility(g5TestBoard().privateVisibilityDropdown,10);
         JSUtils.JSclickWithTimeout(g5TestBoard().privateVisibilityDropdown);

//         Actions actions = new Actions(GWD.getDriver());
//         actions.moveToElement(g5TestBoard().privateVisibilityDropdown).click().build().perform();

         WaitUtils.waitForClickablility(g5TestBoard().createBoardSubmit,30);
//         WaitUtils.waitFor(20);
         JSUtils.JSclickWithTimeout(g5TestBoard().createBoardSubmit);





//         for (int i = 0; i < backgroundImages.size(); i++) {
//             //Click on the checkbox 2 if it is NOT already selected
//             if (!g5TestBoard().boardCustomImages.get(i).isSelected()) {
//
//                 g5TestBoard().boardCustomImages.get(i).click();
//                 WaitUtils.waitFor(2);
////                 assertTrue(g5TestBoard().boardCustomImages.get(i).isSelected());
//
//                 assertTrue(g5TestBoard().checkIcon.getAttribute("aria-hidden").contains("true"));
//
//
//             }
//              g5TestBoard().createBoardText.isDisplayed();

     }

    @Then("the user verify that the created board appears on the home page")
    public void the_user_verify_that_the_created_board_appears_on_the_home_page() {
//          WaitUtils.waitForVisibility(g5TestBoard().actualBoardName,10);
          WaitUtils.waitFor(5);
          Assert.assertEquals(g5TestBoard().actualBoardName.getText(), ConfigReader.getProperty("expectedBoardName"));
     }

//    @And("The user close application")
//    public void theUserCloseApplication() {
//        GWD.getDriver().close();
//     }

    @Then("The user verify that Under the Background heading there are sample images and a ... button to view more images and above the Background heading there is a small board example.")
    public void the_user_verify_that_under_the_background_heading_there_are_sample_images_and_a_button_to_view_more_images_and_above_the_background_heading_there_is_a_small_board_example() {
           WaitUtils.waitFor(10);
//        WaitUtils.waitForClickablility(g5TestBoard().createBoardButton,7);
//        g5TestBoard().createBoardButton.click();

//        List<WebElement> backgroundImages = g5TestBoard().boardCustomImages;
//        WaitUtils.waitFor(5);
        for (int i = 0; i <g5TestBoard().boardCustomImages.size(); i++) {

             Assert.assertTrue(g5TestBoard().boardCustomImages.get(i).isDisplayed());
            Assert.assertTrue(g5TestBoard().boardCustomImages.get(i).isEnabled());

             }

            Assert.assertTrue(g5TestBoard().smallBoardSampleImage.isDisplayed());
            WaitUtils.waitForClickablility(g5TestBoard().treeDotIcon,2);
            Assert.assertTrue(g5TestBoard().treeDotIcon.isEnabled());
            Assert.assertTrue(g5TestBoard().treeDotIcon.isDisplayed());

    }



}
