package cat.page;

import cat.pageobject.CaseReview;
import cat.pageobject.CaseSegmentation;
import cat.pageobject.Dashboard;
import cat.pageobject.ExecuteSqlQueries;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static cat.config.PropertiesConfig.*;


/**
 * Created by kaporis on 19/02/2018.
 */
public class LoginPage extends AbstractPage {

    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class);

    public String script = " var http = new XMLHttpRequest();" +
            " http.open(\"GET\", arguments[0], \"true\");" +
            " http.setRequestHeader(arguments[1],arguments[2]);" +
            " http.send(null);";

    public void launchJssleuthCat() throws Exception {
        launchJS();
    }

    public void the_page_opens() {
        untilPageLoadComplete();
        untilJqueryIsDone();
        Object s = ((JavascriptExecutor)driver).executeScript("return document.embeds ;");
        System.out.println(s);
    }

    public void logoff() {
        WebElement logoffLink = driver.findElement(By.linkText("Log out"));
        if (logoffLink != null) {
            logoffLink.click();
        }
    }

    public void launchJS() throws InterruptedException {
        LOGGER.info("LoginPage.launchDA : " + properties.get(ENVIRONMENT));
        String homePage = properties.get(HOME_PAGE);
        LOGGER.info("Access website using Home Page URL: " + homePage);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(homePage);
        ((JavascriptExecutor)driver).executeScript(script,homePage,"Ct-Remote-User","rishi.kapoor@db.com");
        untilJqueryIsDone();
        untilPageLoadComplete();
    }

    public void waitForPage() throws InterruptedException {
        Dashboard.certificate.click();
        LOGGER.info("Click action performed unauthorised certificate");
    }

    public void verifyDropDown() {
        waitTillClickable(Dashboard.userGroupDropDown);
    }

    public void verifyText(String users) {
        Select getValuesInDropDown = new Select(Dashboard.userGroupDropDown);
        getValuesInDropDown.selectByVisibleText(users);
        checkApplicationState(users);
        untilJqueryIsDone();
        LOGGER.info("Assert all User Option Within Select Exits ");
    }

    private void checkApplicationState(String users) {
        if (users.contains("MO")) {
            notFound(Dashboard.segmentPreparation);
        }
    }

    public void closeBrowser() {
        driver.quit();
    }

    public void returnsToDashboardPage() {
//        untilPageLoadComplete();
        untilJqueryIsDone();
//        driver.findElement(By.xpath("//*[contains(text(),'Dashboard')]")).click();
        found(Dashboard.dashboard);
    }

    public void selectsAnActor(String actor) {
        Select getValuesInDropDown = new Select(Dashboard.userGroupDropDown);
        getValuesInDropDown.selectByVisibleText(actor);
        untilPageLoadComplete();
        untilJqueryIsDone();
        waitTillClickable(Dashboard.userGroupDropDown);
    }


    public void then_the_user_selects_a_case_under_segment_preparation(String caseName) {
        Dashboard.quickSearch.sendKeys(caseName);
        waitTillClickable(Dashboard.caseIdLinkToSegmentCreation(caseName));
        if (Dashboard.caseIdLinkToSegmentCreation(caseName).isEnabled()) {
            Dashboard.caseIdLinkToSegmentCreation(caseName).click();
        }
        untilJqueryIsDone();
    }

    public void userClicksCaseUnderFosUpgrade(String caseName) {
        Connection conn = null;
        String caseNameWithSegment = null;
        try {
            if (conn == null) {
                conn = dbConnect();
            }
            caseNameWithSegment = ExecuteSqlQueries.getCaseNameWithSegmentId(caseName, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        close();
        if (Dashboard.caseIdLinkUnderFosUpgrade(caseName,caseNameWithSegment).isEnabled()) {
            Dashboard.caseIdLinkUnderFosUpgrade(caseName,caseNameWithSegment).click();
        }
        untilJqueryIsDone();
    }


    public void check_if_case_exits_under_IRGMClose(String caseName) throws Exception {

        Connection conn = null;
        String caseNameWithSegment = null;
        try {
            if (conn == null) {
                conn = dbConnect();
            }
            caseNameWithSegment = ExecuteSqlQueries.getCaseNameWithSegmentId(caseName, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        waitTillClickable(Dashboard.caseIdLinkToUnderIRGMClose(caseName,caseNameWithSegment));
    }

    public void userClicksCaseUnderIRGMClose(String caseName) {

        Connection conn = null;
        String caseNameWithSegment = null;
        try {
            if (conn == null) {
                conn = dbConnect();
            }
            caseNameWithSegment = ExecuteSqlQueries.getCaseNameWithSegmentId(caseName, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        close();
        if (Dashboard.caseIdLinkToUnderIRGMClose(caseName,caseNameWithSegment).isEnabled()) {
            Dashboard.caseIdLinkToUnderIRGMClose(caseName,caseNameWithSegment).click();
        }
        untilJqueryIsDone();
    }

    public void userClicksCaseUnderFOSSegmentReview(String caseName) {
//        Connection conn = null;
        String caseNameWithSegment = null;
        try (Connection conn = dbConnect()) {
//            if (conn == null) {
//                conn = dbConnect();
//            }
            caseNameWithSegment = ExecuteSqlQueries.getCaseNameWithSegmentId(caseName, conn);
            System.out.println("Case with segment number : "+ caseNameWithSegment);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //close();
        if (Dashboard.caseIdLinkUnderFosSegmentReview(caseName,caseNameWithSegment).isEnabled()) {
            Dashboard.caseIdLinkUnderFosSegmentReview(caseName,caseNameWithSegment).click();
        }
        untilPageLoadComplete();
        untilJqueryIsDone();
    }

    public void userClicksCaseUnderMoSegmentReview(String caseName) {
        Connection conn = null;
        String caseNameWithSegment = null;
        try {
            if (conn == null) {
                conn = dbConnect();
            }
            caseNameWithSegment = ExecuteSqlQueries.getCaseNameWithSegmentId(caseName, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        close();
        if (Dashboard.caseIdLinkUnderMoSegmentReview(caseName,caseNameWithSegment).isEnabled()) {
            Dashboard.caseIdLinkUnderMoSegmentReview(caseName,caseNameWithSegment).click();
        }
        untilJqueryIsDone();
    }

    public void userClicksCaseUnderCaseReview(String caseName){
        untilPageLoadComplete();
        untilJqueryIsDone();
        if (Dashboard.caseIdLinkUnderCaseReview(caseName).isEnabled()) {
            Dashboard.caseIdLinkUnderCaseReview(caseName).click();

        }
        untilJqueryIsDone();
    }

    public void userClicksCaseUnderIRGCaseReview(String caseName) {
        if (Dashboard.caseIdLinkUnderIRGCaseReview(caseName).isEnabled()) {
            Dashboard.caseIdLinkUnderIRGCaseReview(caseName).click();
        }
        untilJqueryIsDone();
    }

    public void userClicksCaseUnderEscalatedFOSCaseReview(String caseName) {
        if (Dashboard.caseIdLinkUnderEscalatedFOSCaseReview(caseName).isEnabled()) {
            Dashboard.caseIdLinkUnderEscalatedFOSCaseReview(caseName).click();
        }
        untilJqueryIsDone();
    }

    public void userClicksCaseUnderEscalatedIRGCaseReview(String caseName) {
        if (Dashboard.caseIdLinkUnderEscalatedIRGCaseReview(caseName).isEnabled()) {
            Dashboard.caseIdLinkUnderEscalatedIRGCaseReview(caseName).click();
        }
        untilJqueryIsDone();
    }


    public void check_if_case_exits(String caseName) throws Exception {
        waitTillClickable(Dashboard.caseIdLinkToSegmentCreation(caseName));
    }


    public void userClicksCaseUnderIRGAClose(String caseName) {

        Connection conn = null;
        String caseNameWithSegment = null;
        try {
            if (conn == null) {
                conn = dbConnect();
            }
            caseNameWithSegment = ExecuteSqlQueries.getCaseNameWithSegmentId(caseName, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        close();
        if (Dashboard.caseIdLinkToUnderIRGMClose(caseName,caseNameWithSegment).isEnabled()) {
            waitTillClickable(Dashboard.caseIdLinkToUnderIRGMClose(caseName,caseNameWithSegment));
            Dashboard.caseIdLinkToUnderIRGMClose(caseName,caseNameWithSegment).click();
        }
        untilJqueryIsDone();
    }
}

