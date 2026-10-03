package cat.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by kaporis on 15/05/2018.
 */
public class FosSegmentReview extends PageObjectBaseClass {

    public FosSegmentReview(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "description")
    public static WebElement selectDescriptionFromFosSegmentReview;

    public static WebElement caseReviewLinkUnderFosSegmentReview(String caseID) {
        return driver.findElement(By.cssSelector("a[href*=\"#/case/" + caseID + "\"]"));
    }

    @FindBy(how = How.ID, using = "destination")
    public static WebElement selectDestinationFromFosSegmentReview;


    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Click here to change assigned IRG and MO")
    public static WebElement changeAssignee;

    @FindBy(how = How.ID, using = "irg")
    public static WebElement selectAssignee;

    @FindBy(how = How.XPATH, using = "//*[@id=\"moReviewersBlock\"]/div/div/ul/li[2]/a/label/input")
    public static WebElement checkMOReviewer;

    @FindBy(how = How.XPATH, using = "//*[@id=\"cfCodeBlock\"]/div/div[1]/ul/li[2]/a/label/input")
    public static WebElement checkCFCode;

    @FindBy(how = How.ID, using = "description")
    public static WebElement addDescription;

    @FindBy(how = How.ID, using = "submitComment")
    public static WebElement submitButton;
    //*[@id="case-app"]/ul/li[2]/a

}
