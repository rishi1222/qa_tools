package cat.steps;

import cat.config.Pages;
import cat.pageobject.Dashboard;
import cat.pageobject.FosSegmentReview;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kaporis on 15/05/2018.
 */
public class FosSegmentReviewSteps {

    public Pages pages;

    public FosSegmentReviewSteps()  {
        this.pages = new Pages();
        PageFactory.initElements(Hooks.driver,FosSegmentReview.class);
        PageFactory.initElements(Hooks.driver, Dashboard.class);
    }

    @Then("^the FOS Segment Review Page opens$")
    public void theFosSegmentReviewPageopens() {
        pages.fosSegmentReviewAction().fosSegmentReviewPageFound();
    }

    @When("^user clicks case \"([^\"]*)\" in FosSegmentReviewPage$")
    public void userClicksCaseInFosSegmentReviewPage(String caseId)  {
        pages.fosSegmentReviewAction().openCaseReviewUnderFosSegmentReveiw(caseId);
    }


    @When("^user clicks on Change IRG and MO reviewers link in FOSSegmentReview$")
    public void userClicksOnChangeIRGAndMOReviewersLinkInFOSUpgrade()  {
        pages.fosSegmentReviewAction().clickOnChangeIRGAAndMOReviewersLink();
    }

    @And("^user selects \"([^\"]*)\" as new assignee in FOSSegmentReview$")
    public void userSelectsAsNewAssigneeInFOSUpgrade(String assignee$) {
        pages.fosSegmentReviewAction().changeAssignee(assignee$);
    }

    @And("^checks new MO reviewers \"([^\"]*)\" in FOSSegmentReview$")
    public void checksNewMOReviewersInFOSUpgrade(String moReviewer) {
        pages.fosSegmentReviewAction().checkMOreviewers(moReviewer);

    }

    @And("^select CFcode under FOSSegmentReview$")
    public void selectCFcodeUnderIRGAClose() {
        pages.fosSegmentReviewAction().checkCFCode();
    }

    @When("^user selects destination as \"([^\"]*)\" under FosSegmentReviewPage$")
    public void userSelectsDestinationAsUnderFosSegmentReviewPage(String destination)  {
       pages.fosSegmentReviewAction().userSelectDestinationUnderFosSegmentReviewPage(destination);
    }

    @And("^add Comment \"([^\"]*)\" under FosSegmentReviewPage$")
    public void addCommentUnderFosSegmentReviewPage(String comment) {
        pages.fosSegmentReviewAction().addCommentUnderFosSegmentReviewPage(comment);
    }

    @Then("^the submit button is enables in FosSegmentReviewPage$")
    public void theSubmitButtonIsEnablesInFOSUpgrade()  {

        pages.fosSegmentReviewAction().verifySubmitButtonEnabled();
    }

    @When("^user clicks on submit button in FosSegmentReviewPage$")
    public void userClicksOnSubmitButtonInFOSUpgrade() {

        pages.fosSegmentReviewAction().clickSubmitButton();
    }
}
