package cat.page;

import cat.pageobject.IRGAClose;
import cat.pageobject.IRGAClose;
import cat.pageobject.IRGmClose;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by kaporis on 05/06/2018.
 */
public class IRGACloseAction extends AbstractPage {

    public void irgAClosePageFound() {
        untilPageLoadComplete();
        untilJqueryIsDone();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(IRGAClose.selectDestinationFromIRGAClose));
    }

    public void choseDestinatioFromIRGAClose(String destinationState) {
        WebElement select = IRGAClose.selectDestinationFromIRGAClose;
        Select getValueFromDropDown = new Select(select);
        getValueFromDropDown.selectByVisibleText(destinationState);
    }

    public void addDescriptioBeforeAssignment(String description) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", IRGAClose.addDescription, description);
        IRGAClose.addDescription.sendKeys(" ");
    }

    public void changeAssignee(String assignee) {
        WebElement select = IRGAClose.selectAssignee;
        Select getValueFromDropDown = new Select(select);
        getValueFromDropDown.selectByVisibleText(assignee);
    }

    public void verifySubmitButtonEnabled() {
        waitTillClickable(IRGAClose.submitButton);

    }

    public void clickSubmitButton() {

        IRGAClose.submitButton.click();
        untilJqueryIsDone();
    }

    public void checkMOreviewers(String moReviewers) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", IRGAClose.checkMOReviewer);
    }

    public void checkCFCode() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", IRGAClose.checkCFCode);
    }

}
