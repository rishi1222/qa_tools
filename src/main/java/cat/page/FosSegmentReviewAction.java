package cat.page;


import cat.pageobject.FosSegmentReview;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by kaporis on 15/05/2018.
 */
public class FosSegmentReviewAction extends AbstractPage {

    public void fosSegmentReviewPageFound() {
        untilPageLoadComplete();
        untilJqueryIsDone();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(FosSegmentReview.selectDescriptionFromFosSegmentReview));

    }

    public void openCaseReviewUnderFosSegmentReveiw(String caseId) {
        FosSegmentReview.caseReviewLinkUnderFosSegmentReview(caseId).click();
        untilPageLoadComplete();
        untilJqueryIsDone();
    }

    public void userSelectDestinationUnderFosSegmentReviewPage(String destination) {

        waitTillClickable(FosSegmentReview.selectDestinationFromFosSegmentReview);
        Select getValuesInDropDown = new Select(FosSegmentReview.selectDestinationFromFosSegmentReview);
        getValuesInDropDown.selectByVisibleText(destination);
    }

    public void addCommentUnderFosSegmentReviewPage(String comment) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", FosSegmentReview.selectDescriptionFromFosSegmentReview, comment);
        FosSegmentReview.selectDescriptionFromFosSegmentReview.sendKeys(" ");
    }

    public void clickOnChangeIRGAAndMOReviewersLink() {
        FosSegmentReview.changeAssignee.click();
    }

    public void changeAssignee(String assignee) {
        WebElement select = FosSegmentReview.selectAssignee;
        Select getValueFromDropDown = new Select(select);
        getValueFromDropDown.selectByVisibleText(assignee);
    }

    public void checkMOreviewers(String moReviewer) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", FosSegmentReview.checkMOReviewer);
    }

    public void checkCFCode() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", FosSegmentReview.checkCFCode);
    }

    public void verifySubmitButtonEnabled() {
        waitTillClickable(FosSegmentReview.submitButton);
    }

    public void clickSubmitButton() {
        FosSegmentReview.submitButton.click();
        untilJqueryIsDone();
    }
}
