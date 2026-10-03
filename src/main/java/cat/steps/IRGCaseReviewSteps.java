package cat.steps;

import cat.config.Pages;
import cat.pageobject.Dashboard;
import cat.pageobject.IRGCaseReview;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kaporis on 27/07/2018.
 */
public class IRGCaseReviewSteps {

    public Pages pages;

    public IRGCaseReviewSteps() {
        this.pages = new Pages();
        PageFactory.initElements(Hooks.driver, IRGCaseReview.class);
        PageFactory.initElements(Hooks.driver, Dashboard.class);
    }


    @Then("^the IRG Case Review Page Opens$")
    public void theIRGCaseReviewPageOpens() {
        pages.irgCaseReviewAction().theIRGCaseReviewPageOpens();
    }

    @When("^user selects destination as \"([^\"]*)\" under IRG Case Review$")
    public void userSelectsDestinationAsUnderIRGCaseReview(String destination) {
        pages.irgCaseReviewAction().userSelectsDestinationAsUnderIRGCaseReview(destination);
    }

    @And("^CF code from dropdown as \"([^\"]*)\" under IRG Case Review$")
    public void cfCodeFromDropdownAsUnderIRGCaseReview(String cfCode) {
        pages.irgCaseReviewAction().cfCodeFromDropdownAsUnderIRGCaseReview(cfCode);
    }

    @And("^add Comment \"([^\"]*)\" under IRG Case Review$")
    public void addCommentUnderIRGCaseReview(String comment) {
        pages.irgCaseReviewAction().addCommentUnderIRGCaseReview(comment);
    }

    @And("^user clicks on submit button in IRG Case Review$")
    public void userClicksOnSubmitButtonInIRGCaseReview() {
        pages.irgCaseReviewAction().userClicksOnSubmitButtonInIRGCaseReview();
    }
}
