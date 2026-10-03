package cat.steps;

import cat.config.Pages;
import cat.pageobject.ExecuteSqlQueries;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;

/**
 * Created by kaporis on 14/03/2018.
 */
public class ResetCaseStateSteps {

    public Pages pages;
    private static final Logger LOGGER = LogManager.getLogger(ResetCaseStateSteps.class);

    public ResetCaseStateSteps() {
        this.pages = new Pages();
        PageFactory.initElements(Hooks.driver, ExecuteSqlQueries.class);
    }


    @Given("^a list of cases to be used as \"([^\"]*)\"$")
    public void aListOfCasesToBeUsedAs(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        LOGGER.info("Setting Initial state of TestData");
        pages.resetCaseState().setValueofCaseId(arg0);
    }

    @When("^user resets their state$")
    public void userResetsTheirState(DataTable testCases) {
        // Write code here that turns the phrase above into concrete actions
        List<List<String>> tableNames = testCases.raw();
        pages.resetCaseState().setStateofGivenCaseId(tableNames);
    }

    @When("^user refreshes the dataBase$")
    public void userRefreshesTheDataBase(DataTable testCases) {
        // Write code here that turns the phrase above into concrete actions
        List<List<String>> tableNames = testCases.raw();
        pages.resetCaseState().refreshTheDatabase(tableNames);
    }

    @Then("^user is able to use the testdata again$")
    public void userIsAbleToUseTheTestdataAgain() {

    }

    @And("^sets the state of \"([^\"]*)\" to Segment Preparation State$")
    public void setsTheStateOfCaseToSegmentPreparationState(String caseId) {
        pages.resetCaseState().setsTheStateOfCaseToSegmentPreparationState(caseId);
    }


    @And("^user checks case \"([^\"]*)\" case state changed to \"([^\"]*)\" and segment state changed to \"([^\"]*)\"$")
    public void userChecksCaseCaseStateChangedToAndSegmentStateChangedTo(String caseId, String caseStatus, String segmentStatus) {
        pages.resetCaseState().checkCaseAndSegmentStatus(caseId, caseStatus, segmentStatus);
    }
}
