package cat.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by kaporis on 05/06/2018.
 */
public class IRGAClose extends PageObjectBaseClass {

    public IRGAClose(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Change IRG and MO reviewers assigned to the segment")
    public static WebElement changeAssignee;

    @FindBy(how = How.ID, using = "irg")
    public static WebElement selectAssignee;

    @FindBy(how = How.XPATH, using = "//*[@id=\"moReviewersBlock\"]/div/div/ul/li[2]/a/label/input")
    public static WebElement checkMOReviewer;

    @FindBy(how = How.ID, using = "destination")
    public static WebElement selectDestinationFromIRGAClose;

    @FindBy(how = How.XPATH, using = "//*[@id=\"cfCodeBlock\"]/div/div[1]/ul/li[2]/a/label/input")
    public static WebElement checkCFCode;

    @FindBy(how = How.ID, using = "description")
    public static WebElement addDescription;

    @FindBy(how = How.ID, using = "submitComment")
    public static WebElement submitButton;

}
