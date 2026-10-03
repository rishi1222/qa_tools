package cat.steps;

import cat.config.Pages;
import cat.pageobject.Dashboard;
import cat.pageobject.FosSegmentReview;
import cat.pageobject.MoSegmentReview;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kaporis on 15/06/2018.
 */
public class MoSegmentReviewSteps {
    public Pages pages;

    public MoSegmentReviewSteps() {
        this.pages = new Pages();
        PageFactory.initElements(Hooks.driver, MoSegmentReview.class);
        PageFactory.initElements(Hooks.driver, FosSegmentReview.class);
    }

    @Then("^the MO Segment Review Page opens$")
    public void theMoSegmentReviewPageopens() {
        pages.moSegmentReviewAction().moSegmentReviewPageFound();
    }


    @When("^user clicks on Change IRG and MO reviewers link in MoSegmentReview$")
    public void userClicksOnChangeIRGAndMOReviewersLinkInMoSegmentReview() {
        pages.moSegmentReviewAction().clickOnChangeIRGAAndMOReviewersLink();
    }

    @And("^user selects \"([^\"]*)\" as new assignee in MoSegmentReview$")
    public void userSelectsAsNewAssigneeInMoSegmentReview(String assignee$) {
        pages.moSegmentReviewAction().changeAssignee(assignee$);
    }

    @And("^checks new MO reviewers \"([^\"]*)\" in MoSegmentReview$")
    public void checksNewMOReviewersInMoSegmentReview(String moReviewer) {
        pages.moSegmentReviewAction().checkMOreviewers(moReviewer);
    }

    @And("^select CFcode under MoSegmentReview$")
    public void selectCFcodeUnderMoSegmentReview() {
        pages.moSegmentReviewAction().checkCFCode();
    }

    @When("^user selects destination as \"([^\"]*)\" under MoSegmentReviewPage$")
    public void userSelectsDestinationAsUnderMoSegmentReviewPage(String destination) {
        pages.moSegmentReviewAction().userSelectDestinationUnderMoSegmentReviewPage(destination);
    }

    @And("^add Comment \"([^\"]*)\" under MoSegmentReviewPage$")
    public void addCommentUnderMoSegmentReviewPage(String comment) {
        pages.moSegmentReviewAction().addCommentUnderMoSegmentReviewPage(comment);
    }

    @Then("^the submit button is enables in MoSegmentReviewPage$")
    public void theSubmitButtonIsEnablesInMoSegmentReview() {

        pages.moSegmentReviewAction().verifySubmitButtonEnabled();
    }

    @When("^user clicks on submit button in MoSegmentReviewPage$")
    public void userClicksOnSubmitButtonInMoSegmentReview() {

        pages.moSegmentReviewAction().clickSubmitButton();
    }
}
