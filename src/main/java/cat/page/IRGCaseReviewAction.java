package cat.page;

import cat.pageobject.CaseReview;
import cat.pageobject.IRGCaseReview;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by kaporis on 27/07/2018.
 */
public class IRGCaseReviewAction extends AbstractPage {


    public void theIRGCaseReviewPageOpens() {
        IRGCaseReview.reassignUnderIRGCaseReview.isDisplayed();
    }

    public void userSelectsDestinationAsUnderIRGCaseReview(String destination) {
        WebElement select = IRGCaseReview.selectDestinationUnderIRGCaseReview;
        Select getValueFromDropDown = new Select(select);
        getValueFromDropDown.selectByVisibleText(destination);
        untilJqueryIsDone();
    }

    public void cfCodeFromDropdownAsUnderIRGCaseReview(String cfCode) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", IRGCaseReview.checkCFCode);
    }

    public void addCommentUnderIRGCaseReview(String comment) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", IRGCaseReview.addCommentUnderIRGCaseReview, comment);
        IRGCaseReview.addCommentUnderIRGCaseReview.sendKeys(" ");
    }

    public void userClicksOnSubmitButtonInIRGCaseReview() {
        IRGCaseReview.submit.click();
        untilJqueryIsDone();
    }
}
