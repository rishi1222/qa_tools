package cat.steps;

/**
 * Created by kaporis on 19/02/2018.
 */

import cat.config.Pages;
import cat.pageobject.Dashboard;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;


public class LoginSteps {

    private static final Logger LOGGER = LogManager.getLogger(LoginSteps.class);

    public Pages pages;

    public LoginSteps() {
        this.pages = new Pages();
        PageFactory.initElements(Hooks.driver, Dashboard.class);
    }

    @Given("the user opens the webpage")
    public void openWebPage() throws Exception {
        pages.loginPage().launchJssleuthCat();
        pages.loginPage().the_page_opens();
    }

    @Then("the use waits for page to load")
    public void waitForPageToLoad() throws Exception {
        pages.loginPage().waitForPage();
    }

    @When("user clicks on user dropDown")
    public void checksForDifferentUserIds() {
        pages.loginPage().verifyDropDown();
    }

    @And("^he checks for valid user types ([\\w-+]+(?:\\.[\\w-+]+)*@(?:[\\w-]+\\.)+[a-zA-Z]{2,7}) ((?:[a-z][a-z]*[0-9]+[a-z0-9]*))")
    public void verifyUserTypes(String users, String par) {
        pages.loginPage().verifyText(users);
    }

    @Then("the user closes browser")
    public void closeBrowser() {
        pages.loginPage().closeBrowser();
    }

    @And("^selects an actor \"([^\"]*)\"$")
    public void selectsAnActor(String actor) {
        // Write code here that turns the phrase above into concrete actions
        pages.loginPage().selectsAnActor(actor);
    }
    @When("^user selects an actor \"([^\"]*)\"$")
    public void selectsAnActor1(String actor) {
        // Write code here that turns the phrase above into concrete actions
        pages.loginPage().selectsAnActor(actor);
    }


    @Then("^user checks case \"([^\"]*)\" exits under Segment Preparation")
    public void check_if_case_exits(String caseName) {
        try {
            pages.loginPage().check_if_case_exits(caseName);
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Then("^user checks case \"([^\"]*)\" exits under IRG-M Close$")
    public void userSeesCaseExitsUnderIRGMClose(String caseName) {
        try {
            pages.loginPage().check_if_case_exits_under_IRGMClose(caseName);
        } catch (Exception e) {
            LOGGER.info(e);
        }
    }

    @Then("^user returns to dashboard page$")
    public void returnsToDashboardPage() {
        // Write code here that turns the phrase above into concrete actions
        pages.loginPage().returnsToDashboardPage();
    }

    @When("^user clicks case \"([^\"]*)\" under Segment Preparation")
    public void the_user_selects_a_case_under_Segment_Preparation(String caseName) {
        pages.loginPage().then_the_user_selects_a_case_under_segment_preparation(caseName);
    }


    @When("^user clicks case \"([^\"]*)\" under IRG-M Close$")
    public void userClicksCaseUnderIRGMClose(String caseName) {
        pages.loginPage().userClicksCaseUnderIRGMClose(caseName);
    }

    @When("^user clicks case \"([^\"]*)\" under FOS Segment Review$")
    public void userClicksCaseUnderFOSSegmentReview(String caseName) {
        pages.loginPage().userClicksCaseUnderFOSSegmentReview(caseName);
    }


    @When("^user clicks case \"([^\"]*)\" under FOS-Upgrade$")
    public void userClicksCaseUnderFOSUpgrade(String caseName)  {
        pages.loginPage().userClicksCaseUnderFosUpgrade(caseName);
    }

    @When("^user clicks case \"([^\"]*)\" under IRG-A Close$")
    public void userClicksCaseUnderIRGAClose(String caseName)  {
        pages.loginPage().userClicksCaseUnderIRGAClose(caseName);
    }

    @When("^user clicks case \"([^\"]*)\" under MO Segment Review$")
    public void userClicksCaseUnderMOSegmentReview(String caseName) {
        pages.loginPage().userClicksCaseUnderMoSegmentReview(caseName);
    }

    @When("^user clicks case \"([^\"]*)\" under Case Review$")
    public void userClicksCaseUnderCaseReview(String caseName) {
        pages.loginPage().userClicksCaseUnderCaseReview(caseName);
    }

    @When("^user clicks case \"([^\"]*)\" under IRG Case Review$")
    public void userClicksCaseUnderIRGCaseReview(String caseId)  {
        pages.loginPage().userClicksCaseUnderIRGCaseReview(caseId);

    }
}