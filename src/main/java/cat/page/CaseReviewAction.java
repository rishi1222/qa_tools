package cat.page;

import cat.pageobject.CaseReview;
import cat.pageobject.FosSegmentReview;
import cat.pageobject.IRGmClose;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

/**
 * Created by kaporis on 15/05/2018.
 */
public class CaseReviewAction extends AbstractPage {


    public void caseReviewPageOpens() {

        untilPageLoadComplete();
        untilJqueryIsDone();
//        WebDriverWait wait = new WebDriverWait(driver, 20);
//        wait.until(ExpectedConditions.visibilityOf(CaseReview.reassignUnderCaseReview));
    }

    public void userClicksOnReAssignLink() {
        CaseReview.reassignUnderCaseReview.click();
    }

    public void userSeeFOSDropDownToReAssignCase() {
        waitTillClickable(CaseReview.selectFOSUSerForReAssignment);
    }

    public void userSelectFromFOSDropDown(String fosUser) {
        WebElement select = CaseReview.selectFOSUSerForReAssignment;
        Select getValueFromDropDown = new Select(select);
        getValueFromDropDown.selectByVisibleText(fosUser);
        untilJqueryIsDone();
    }

    public void userSelectFromFOSSDropDown(String fossUser) {
        WebElement select = CaseReview.selectFOSSUSerForReAssignment;
        Select getValueFromDropDown = new Select(select);
        getValueFromDropDown.selectByVisibleText(fossUser);
        untilJqueryIsDone();
    }


    public void userSelectsDestinationFromDropDown(String destination) {
        WebElement select = CaseReview.selectDestinationUnderCaseReview;
        Select getValueFromDropDown = new Select(select);
        getValueFromDropDown.selectByVisibleText(destination);
        untilJqueryIsDone();
    }

    public void userSelectsCFcode(String cfCode) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", CaseReview.checkCFCode);
    }

    public void userAddsComments(String comment) {
        CaseReview.addCommentUnderCaseReview.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", CaseReview.addCommentUnderCaseReview, comment);
        CaseReview.addCommentUnderCaseReview.sendKeys(" ");
        CaseReview.addCommentUnderCaseReview.sendKeys(Keys.TAB);
    }

    public void clickSubmit() {
        CaseReview.submit.click();
        untilJqueryIsDone();
    }

    public void fileUpload()  {
//        CaseReview.uploadFile.click();
        CaseReview.uploadFile.sendKeys("c:\\Test_File\\Epic_Test.txt");
    }


    public void selectFosFromDropDown(String fos) {
        WebElement select = CaseReview.selectFosUnderCaseReview;
        Select getValueFromDropDown = new Select(select);
        getValueFromDropDown.selectByVisibleText(fos);
        untilJqueryIsDone();
    }


    public void selectFossFromDropDown(String foss) {
        WebElement select = CaseReview.selectFossUnderCaseReview;
        Select getValueFromDropDown = new Select(select);
        getValueFromDropDown.selectByVisibleText(foss);
        untilJqueryIsDone();
    }

    public void irgmClickApprove() {
        CaseReview.approveButton.click();
    }
}
