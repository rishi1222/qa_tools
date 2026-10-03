package cat.page;

import cat.pageobject.CaseSegmentation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;


/**
 * Created by kaporis on 27/02/2018.
 */
public class SegmentCreationPage extends AbstractPage {

    String parentWindowHandler = null; // Store your parent window
    String subWindowHandler = null;

    private static final Logger LOGGER = LogManager.getLogger(SegmentCreationPage.class);


    public void segment_creation_page_opens() {
        untilPageLoadComplete();
        untilJqueryIsDone();
        found(CaseSegmentation.selectAllCheckBox);
    }

    public void userChecksAllTradesInACase() {
        CaseSegmentation.selectAllCheckBox.click();
        untilJqueryIsDone();
    }

    public void createSegmentButtonIsEnabled() {
        CaseSegmentation.createSegmentButton.isEnabled();
    }

    public void userClickOnCreateSegment() {
        CaseSegmentation.createSegmentButton.click();
        untilJqueryIsDone();
    }

    public void createSegmentPopScreenComesUp() {
        parentWindowHandler = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler);
        untilJqueryIsDone();
    }

    public void userSelectsDestinationAs(String destination) {

        waitTillClickable(CaseSegmentation.destination);
        Select getValuesInDropDown = new Select(CaseSegmentation.destination);
        getValuesInDropDown.selectByVisibleText(destination);
    }

    public void irgAssigneeAs(String irgAssignee) {
        Select getValuesInDropDown = new Select(CaseSegmentation.irgAssignee);
        getValuesInDropDown.selectByVisibleText(irgAssignee);
    }

    public void addComment(String comment) {

        ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", CaseSegmentation.comment, comment);
        CaseSegmentation.comment.sendKeys(" ");
    }

    public void saveNewSegmentButtonGetsEnabled() {
        untilJqueryIsDone();
        Assert.assertTrue(CaseSegmentation.saveSegment.isEnabled());
    }

    public void userClickSaveNewSegmentButton() {
        CaseSegmentation.saveSegment.click();
    }

    public void userSeesSubmitSegmentButton() {
        Assert.assertTrue(CaseSegmentation.submitSegment.isEnabled());
    }

    public void userClicksOnSubmitSegmentButton() {
        ((JavascriptExecutor) driver).executeScript("if(document.createEvent)" +
                "{ var evObj = document.createEvent('MouseEvents'); " +
                "evObj.initEvent('click', true, false); " +
                "arguments[0].dispatchEvent(evObj); } " +
                "else if(document.createEventObject) " +
                "{ arguments[0].fireEvent('onclick');} ", CaseSegmentation.submitSegment);

        //analyzeLog();
//        CaseSegmentation.submitSegment.click();
    }

    public void cfcodeFromDropDown(String cfCode) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", CaseSegmentation.checkCFCode);
    }

    public void selectMOReviewer(String moReviewer) {
        //driver.findElement(By.xpath("//*[@id=\"moReviewersBlock\"]/div[2]/button")).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", CaseSegmentation.checkMOReviewer);

    }

    public void disableEmailNotification(){
        untilJqueryIsDone();
        CaseSegmentation.sendEmailNotication.click();
        untilJqueryIsDone();
    }

}
