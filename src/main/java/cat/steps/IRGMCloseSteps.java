package cat.steps;

import cat.config.Pages;
import cat.pageobject.Dashboard;
import cat.pageobject.IRGmClose;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kaporis on 18/04/2018.
 */
public class IRGMCloseSteps {

    public Pages pages;

    public IRGMCloseSteps()  {
        this.pages = new Pages();
        PageFactory.initElements(Hooks.driver, IRGmClose.class);
        PageFactory.initElements(Hooks.driver, Dashboard.class);
    }

    @Then("^IRG-M Close page opens$")
    public void irgMClosePageOpens() {
        pages.irgmCloseAction().irgMClosePageFound();
    }

    @When("^user clicks on Change IRG and MO reviewers link$")
    public void userClicksOnChangeIRGAndMOReviewersLink() {
        pages.irgmCloseAction().clickOnChangeIRGAAndMOReviewersLink();

    }

    @And("^user selects \"([^\"]*)\" as new assignee$")
    public void userSelectsAsNewAssignee(String assignee$) {
        pages.irgmCloseAction().changeAssignee(assignee$);
    }

    @And("^checks new MO reviewers \"([^\"]*)\"$")
    public void checksNewMOReviewers(String moReviewer) {
        pages.irgmCloseAction().checkMOreviewers(moReviewer);
    }

    @And("^selects \"([^\"]*)\" as destination$")
    public void selectsAsDesination(String destinationState) {
        pages.irgmCloseAction().choseDestinatioFromIRGMClose(destinationState);
    }


    @And("^select CFcode under IRG-M Close$")
    public void selectCFcodeUnderIRGMClose() {
        pages.irgmCloseAction().checkCFCode();
    }


    @And("^adds the description \"([^\"]*)\"$")
    public void addsTheDescription(String description) {
        pages.irgmCloseAction().addDescriptioBeforeAssignment(description);
    }

    @Then("^the submit button is enables$")
    public void theSubmitButtonIsEnables() {
        pages.irgmCloseAction().verifySubmitButtonEnabled();

    }

    @When("^user clicks on submit button$")
    public void userClicksOnSubmitButton() {
        pages.irgmCloseAction().clickSubmitButton();
    }

    @And("^select ClientDriven-Cancellation under IRG-M Close$")
    public void selectClientDrivenCancellationUnderIRGMClose()  {
        // This option is available automatically
    }
}
