package cat.steps;

import cat.config.Pages;
import cat.pageobject.IRGAClose;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kaporis on 05/06/2018.
 */
public class IRGACloseSteps {

    public Pages pages;

    public IRGACloseSteps() {
        this.pages = new Pages();
        PageFactory.initElements(Hooks.driver, IRGAClose.class);
    }

    @Then("^IRG-A Close page opens$")
    public void irgAClosePageOpens() {
        pages.irgaCloseAction().irgAClosePageFound();

    }

    @When("^user clicks on Change IRG and MO reviewers link in IRG-A Close$")
    public void userClicksOnChangeIRGAndMOReviewersLinkInIRGAClose() {
        pages.irgmCloseAction().clickOnChangeIRGAAndMOReviewersLink();
    }

    @And("^user selects \"([^\"]*)\" as new assignee in IRG-A Close$")
    public void userSelectsAsNewAssigneeInIRGAClose(String assignee) {
        pages.irgaCloseAction().changeAssignee(assignee);
    }

    @And("^checks new MO reviewers \"([^\"]*)\" in IRG-A Close$")
    public void checksNewMOReviewersInIRGAClose(String moReviewer) {
        pages.irgaCloseAction().checkMOreviewers(moReviewer);
    }

    @And("^selects \"([^\"]*)\" as destination from IRG-A Close$")
    public void selectsAsDestinationFromIRGAClose(String destinationState) {
        pages.irgaCloseAction().choseDestinatioFromIRGAClose(destinationState);
    }

    @And("^select CFcode under IRG-A Close$")
    public void selectCFcodeUnderIRGAClose() {
        pages.irgaCloseAction().checkCFCode();
    }

    @And("^adds the description \"([^\"]*)\" in IRG-A Close$")
    public void addsTheDescriptionInIRGAClose(String description) throws Throwable {
        pages.irgaCloseAction().addDescriptioBeforeAssignment(description);
    }

    @Then("^the submit button is enables in IRG-A Close$")
    public void theSubmitButtonIsEnablesInIRGAClose() {
        pages.irgaCloseAction().verifySubmitButtonEnabled();
    }

    @When("^user clicks on submit button in IRG-A Close$")
    public void userClicksOnSubmitButtonInIRGAClose() {
        pages.irgmCloseAction().clickSubmitButton();
    }
}
