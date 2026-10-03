package cat.page;


import cat.pageobject.CaseSegmentation;
import cat.pageobject.IRGmClose;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import java.io.IOException;


/**
 * Created by kaporis on 18/04/2018.
 */
public class IRGMCloseAction extends AbstractPage {

    public void irgMClosePageFound() {
        untilPageLoadComplete();
        untilJqueryIsDone();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(IRGmClose.selectDestinationFromIRGMClose));
    }

    public void clickOnChangeIRGAAndMOReviewersLink() {
        IRGmClose.changeAssignee.click();
        untilJqueryIsDone();
    }

    public void choseDestinatioFromIRGMClose(String destinationState) {
        WebElement select = IRGmClose.selectDestinationFromIRGMClose;
        Select getValueFromDropDown = new Select(select);
        getValueFromDropDown.selectByVisibleText(destinationState);
    }

    public void addDescriptioBeforeAssignment(String description) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", IRGmClose.addDescription, description);
        IRGmClose.addDescription.sendKeys(" ");
    }

    public void changeAssignee(String assignee) {
        WebElement select = IRGmClose.selectAssignee;
        Select getValueFromDropDown = new Select(select);
        getValueFromDropDown.selectByVisibleText(assignee);
    }

    public void verifySubmitButtonEnabled() {
        waitTillClickable(IRGmClose.submitButton);

    }

    public void clickSubmitButton() {
        IRGmClose.submitButton.click();
        untilJqueryIsDone();
    }

    public void checkMOreviewers(String moReviewers) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", IRGmClose.checkMOReviewer);
    }

    public void checkCFCode() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", IRGmClose.checkCFCode);
    }


}


