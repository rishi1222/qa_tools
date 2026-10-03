package cat.steps;

import cat.config.Pages;
import cat.page.FoSUpgradeAction;
import cat.pageobject.Dashboard;
import cat.pageobject.FosUpgrade;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kaporis on 04/06/2018.
 */
public class FosUpgradeSteps {

    public Pages pages;

    public FosUpgradeSteps() {
        this.pages = new Pages();
        PageFactory.initElements(Hooks.driver,FosUpgrade.class);
        PageFactory.initElements(Hooks.driver, Dashboard.class);
    }

    @Then("^Fos Upgrade page opens$")
    public void fosUpgradePageOpens()  {
        pages.fosUpgradeAction().fosUpgradePageOpens();
    }

    @When("^user clicks on Change IRG and MO reviewers link in FOS Upgrade$")
    public void userClicksOnChangeIRGAndMOReviewersLinkInFOSUpgrade()  {
        pages.fosUpgradeAction().clickOnChangeIRGAAndMOReviewersLink();
    }

    @And("^user selects \"([^\"]*)\" as new assignee in FOS Upgrade$")
    public void userSelectsAsNewAssigneeInFOSUpgrade(String assignee$) {
        pages.fosUpgradeAction().changeAssignee(assignee$);
    }

    @And("^checks new MO reviewers \"([^\"]*)\" in FOS Upgrade$")
    public void checksNewMOReviewersInFOSUpgrade(String moReviewer) {
        pages.fosUpgradeAction().checkMOreviewers(moReviewer);

    }

    @And("^selects \"([^\"]*)\" as destination from FOS Upgrade$")
    public void selectsAsDestinationFromFOSUpgrade(String destinationState)  {
        pages.fosUpgradeAction().choseDestinatioFromfosUpgrade(destinationState);
    }

    @When("^user clicks case \"([^\"]*)\" in FosUpgradePage$")
    public void userClicksCaseInFosSegmentReviewPage(String caseId)  {
        pages.fosUpgradeAction().openCaseReviewUnderFosUpgrade(caseId);
    }
    @And("^adds the description \"([^\"]*)\" in FOS Upgrade$")
    public void addsTheDescriptionInFOSUpgrade(String description)  {
        pages.fosUpgradeAction().addDescriptioBeforeAssignment(description);
    }

    @Then("^the submit button is enables in FOS Upgrade$")
    public void theSubmitButtonIsEnablesInFOSUpgrade()  {
        pages.fosUpgradeAction().verifySubmitButtonEnabled();
    }

    @When("^user clicks on submit button in FOS Upgrade$")
    public void userClicksOnSubmitButtonInFOSUpgrade() {
        pages.fosUpgradeAction().clickSubmitButton();
    }
}
