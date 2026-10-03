package cat.steps;

import cat.config.Pages;
import cat.pageobject.CaseReview;
import cat.pageobject.Dashboard;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kaporis on 15/05/2018.
 */
public class CaseReviewSteps {

    public Pages pages;


    public CaseReviewSteps()  {
        this.pages = new Pages();
        PageFactory.initElements(Hooks.driver, CaseReview.class);
        PageFactory.initElements(Hooks.driver, Dashboard.class);
    }

    @Then("^the Case Review Page Opens$")
    public void caseReviewPageOpens() {
        pages.caseReviewAction().caseReviewPageOpens();
    }

    @When("^user clicks on re-assign link$")
    public void userClicksOnReAssignLink() {
        pages.caseReviewAction().userClicksOnReAssignLink();
    }

    @Then("^user see FOS drop down to re-assign the case$")
    public void userSeeFOSDropDownToReAssignTheCase() {
        pages.caseReviewAction().userSeeFOSDropDownToReAssignCase();
    }

    @When("^user selects \"([^\"]*)\" from FOS drop down$")
    public void userSelectsFromFOSDropDown(String fosUser) {
        pages.caseReviewAction().userSelectFromFOSDropDown(fosUser);
    }


    @When("^user selects destination as \"([^\"]*)\" under Case Review$")
    public void userSelectsDestinationAsUnderCaseReview(String destination) {
        // Write code here that turns the phrase above into concrete actions
        pages.caseReviewAction().userSelectsDestinationFromDropDown(destination);
    }

    @And("^CF code from dropdown as \"([^\"]*)\" under Case Review$")
    public void cfCodeFromDropdownAs(String cfCode) {
        // Write code here that turns the phrase above into concrete actions
        pages.caseReviewAction().userSelectsCFcode(cfCode);

    }

    @And("^add Comment \"([^\"]*)\" under Case Review$")
    public void addCommentUnderCaseReview(String comment) {
        // Write code here that turns the phrase above into concrete actions
        pages.caseReviewAction().userAddsComments(comment);
    }

    @And("^user clicks on submit button in Case Review$")
    public void userClicksOnSubmitButtonInCaseReview() {
        // Write code here that turns the phrase above into concrete actions
        pages.caseReviewAction().clickSubmit();
    }

    @And("^selects fos \"([^\"]*)\"$")
    public void selectsFos(String fos) {
        pages.caseReviewAction().selectFosFromDropDown(fos);
    }

    @And("^selects fos-s \"([^\"]*)\"$")
    public void selectsFoss(String foss)  {
        pages.caseReviewAction().selectFossFromDropDown(foss);
    }

    @And("^the user uploads file$")
    public void theUserUploadsFile() {
        // Write code here that turns the phrase above into concrete actions
       pages.caseReviewAction().fileUpload();
    }

    @And("^user selects \"([^\"]*)\" from FOS-S drop down$")
    public void userSelectsFromFOSSDropDown(String fossUser) {
        // Write code here that turns the phrase above into concrete actions
        pages.caseReviewAction().userSelectFromFOSSDropDown(fossUser);
    }

    @When("^the irg-m approves$")
    public void theIrgMTestDbComApproves()  {
        pages.caseReviewAction().irgmClickApprove();

    }
}
