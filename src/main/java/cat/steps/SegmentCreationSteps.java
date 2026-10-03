package cat.steps;

import cat.config.Pages;
import cat.pageobject.CaseReview;
import cat.pageobject.CaseSegmentation;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kaporis on 27/02/2018.
 */
public class SegmentCreationSteps {

    private static final Logger LOGGER = LogManager.getLogger(SegmentCreationSteps.class);

    public Pages pages;

    public SegmentCreationSteps() {
        this.pages = new Pages();
        PageFactory.initElements(Hooks.driver, CaseSegmentation.class);
    }


    @Then("^segment creation page opens")
    public void segment_creation_page_opens() {
        pages.segmentCreationPage().segment_creation_page_opens();
    }

    @When("^user checks all trades in a case$")
    public void userChecksAllTradesInACase() {
        // Write code here that turns the phrase above into concrete actions
        pages.segmentCreationPage().userChecksAllTradesInACase();
    }

    @Then("^Create Segment Button is enabled$")
    public void createSegmentButtonIsEnabled() {
        // Write code here that turns the phrase above into concrete actions
        pages.segmentCreationPage().createSegmentButtonIsEnabled();
    }

    @When("^user click on Create Segment$")
    public void userClickOnCreateSegment() {
        // Write code here that turns the phrase above into concrete actions
        pages.segmentCreationPage().userClickOnCreateSegment();
    }

    @Then("^Create Segment Pop screen comes up$")
    public void createSegmentPopScreenComesUp() {
        // Write code here that turns the phrase above into concrete actions
        pages.segmentCreationPage().createSegmentPopScreenComesUp();
    }

    @When("^user selects destination as \"([^\"]*)\"$")
    public void userSelectsDestinationAs(String destination) {
        // Write code here that turns the phrase above into concrete actions
        pages.segmentCreationPage().userSelectsDestinationAs(destination);
    }

    @And("^IRG assignee as \"([^\"]*)\"$")
    public void irgAssigneeAs(String irgAssignee) {
        // Write code here that turns the phrase above into concrete actions
        pages.segmentCreationPage().irgAssigneeAs(irgAssignee);
    }

    @And("^add Comment \"([^\"]*)\"$")
    public void addComment(String comment) {
        // Write code here that turns the phrase above into concrete actions
        pages.segmentCreationPage().addComment(comment);
    }

    @Then("^save new segment button gets enabled$")
    public void saveNewSegmentButtonGetsEnabled() {
        // Write code here that turns the phrase above into concrete actions
        pages.segmentCreationPage().saveNewSegmentButtonGetsEnabled();
    }

    @When("^user click save new segment button$")
    public void userClickSaveNewSegmentButton() {
        // Write code here that turns the phrase above into concrete actions
        pages.segmentCreationPage().userClickSaveNewSegmentButton();
    }

    @Then("^user sees submit segment button$")
    public void userSeesSubmitSegmentButton() {
        // Write code here that turns the phrase above into concrete actions
        pages.segmentCreationPage().userSeesSubmitSegmentButton();
    }

    @When("^user clicks on submit segment button$")
    public void userClicksOnSubmitSegmentButton() {
        // Write code here that turns the phrase above into concrete actions

        pages.segmentCreationPage().userClicksOnSubmitSegmentButton();
    }


    @And("^CFcode from dropDown \"([^\"]*)\"$")
    public void cfcodeFromDropDown(String cfCode) {
        pages.segmentCreationPage().cfcodeFromDropDown(cfCode);
    }

    @And("^MO reviewers as \"([^\"]*)\"$")
    public void moReviewersAs(String MOReviewer) {
        // Write code here that turns the phrase above into concrete actions
        pages.segmentCreationPage().selectMOReviewer(MOReviewer);
    }


    @And("^disable Email Notification$")
    public void diableEmailNotification() {
        // Write code here that turns the phrase above into concrete actions
        pages.segmentCreationPage().disableEmailNotification();
    }
}
