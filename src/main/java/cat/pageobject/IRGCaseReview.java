package cat.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by kaporis on 27/07/2018.
 */
public class IRGCaseReview extends PageObjectBaseClass {

    public IRGCaseReview(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Destination')]")
    public static WebElement reassignUnderIRGCaseReview;

    @FindBy(how = How.ID, using = "fos")
    public static WebElement selectFOSUSerForReAssignment;

    @FindBy(how = How.ID, using = "destination")
    public static WebElement selectDestinationUnderIRGCaseReview;

    @FindBy(how = How.XPATH, using = "//*[@id=\"cfCodeBlock\"]/div/div[1]/ul/li[2]/a/label/input")
    public static WebElement checkCFCode;

    @FindBy(how = How.ID, using = "comment")
    public static WebElement addCommentUnderIRGCaseReview;

    @FindBy(how = How.ID, using = "submitComment")
    public static WebElement submit;
}
