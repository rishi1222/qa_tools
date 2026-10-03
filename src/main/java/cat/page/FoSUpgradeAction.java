package cat.page;

import cat.pageobject.CaseSegmentation;
import cat.pageobject.FosUpgrade;
import cat.pageobject.IRGmClose;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by kaporis on 04/06/2018.
 */
public class FoSUpgradeAction extends AbstractPage {

    public void fosUpgradePageOpens() {
        untilPageLoadComplete();
        untilJqueryIsDone();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(FosUpgrade.selectDestinationFromFosUpgrade));
    }

    public void clickOnChangeIRGAAndMOReviewersLink() {
        untilJqueryIsDone();
        FosUpgrade.changeAssignee.click();
        untilJqueryIsDone();
    }

    public void changeAssignee(String assignee) {
        WebElement select = FosUpgrade.selectAssignee;
        Select getValueFromDropDown = new Select(select);
        getValueFromDropDown.selectByVisibleText(assignee);
        untilJqueryIsDone();
    }

    public void checkMOreviewers(String moReviewer) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", FosUpgrade.checkMOReviewer);
        untilJqueryIsDone();
    }

    public void choseDestinatioFromfosUpgrade(String destinationState) {

        WebElement select = FosUpgrade.selectDestinationFromFosUpgrade;
        Select getValueFromDropDown = new Select(select);
        getValueFromDropDown.selectByVisibleText(destinationState);
        untilJqueryIsDone();
    }


    public void openCaseReviewUnderFosUpgrade(String caseId) {
        FosUpgrade.caseReviewLinkUnderFosUpgrade(caseId).click();
        untilPageLoadComplete();
        untilJqueryIsDone();
    }


    public void addDescriptioBeforeAssignment(String description) {
        FosUpgrade.addDescription.sendKeys(" ");
        ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", FosUpgrade.addDescription, description);
        FosUpgrade.addDescription.sendKeys(Keys.TAB);

    }

    public void verifySubmitButtonEnabled() {
        waitTillClickable(FosUpgrade.submitButton);
    }


    public void clickSubmitButton() {
        ((JavascriptExecutor) driver).executeScript("if(document.createEvent)" +
                "{ var evObj = document.createEvent('MouseEvents'); " +
                "evObj.initEvent('click', true, false); " +
                "arguments[0].dispatchEvent(evObj); } " +
                "else if(document.createEventObject) " +
                "{ arguments[0].fireEvent('onclick');} ", FosUpgrade.submitButton);
//        FosUpgrade.submitButton.click();
        untilJqueryIsDone();
    }
}
