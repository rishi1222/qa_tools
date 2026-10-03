package cat.page;

import cat.pageobject.FosSegmentReview;
import cat.pageobject.MoSegmentReview;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by kaporis on 15/06/2018.
 */
public class MoSegmentReviewAction extends AbstractPage {

    public void moSegmentReviewPageFound() {
        untilPageLoadComplete();
        untilJqueryIsDone();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(MoSegmentReview.selectDescriptionFromMoSegmentReview));

    }

    public void openCaseReviewUnderFosSegmentReveiw(String caseId) {
        FosSegmentReview.caseReviewLinkUnderFosSegmentReview(caseId).click();
        untilPageLoadComplete();
        untilJqueryIsDone();
    }

    public void userSelectDestinationUnderMoSegmentReviewPage(String destination) {

        waitTillClickable(MoSegmentReview.selectDestinationFromMoSegmentReview);
        Select getValuesInDropDown = new Select(MoSegmentReview.selectDestinationFromMoSegmentReview);
        getValuesInDropDown.selectByVisibleText(destination);
    }

    public void addCommentUnderMoSegmentReviewPage(String comment) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", MoSegmentReview.selectDescriptionFromMoSegmentReview, comment);
        MoSegmentReview.selectDescriptionFromMoSegmentReview.sendKeys(" ");
    }

    public void clickOnChangeIRGAAndMOReviewersLink() {
        FosSegmentReview.changeAssignee.click();
    }

    public void changeAssignee(String assignee) {
        WebElement select = MoSegmentReview.selectAssignee;
        Select getValueFromDropDown = new Select(select);
        getValueFromDropDown.selectByVisibleText(assignee);
    }

    public void checkMOreviewers(String moReviewer) {
        System.out.println("Calling javascript function");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", MoSegmentReview.checkMOReviewer);
    }

    public void checkCFCode() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", MoSegmentReview.checkCFCode);
    }

    public void verifySubmitButtonEnabled() {
        waitTillClickable(FosSegmentReview.submitButton);
    }

    public void clickSubmitButton() {
        MoSegmentReview.submitButton.click();
        untilJqueryIsDone();
    }


}
