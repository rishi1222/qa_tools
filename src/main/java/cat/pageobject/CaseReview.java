package cat.pageobject;

import cat.config.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by kaporis on 15/05/2018.
 */
public class CaseReview extends PageObjectBaseClass {

    public CaseReview(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Approve FO Changes')]")
    public static WebElement approveButton;

//    public CaseReview(WebDriver webdriver) {
//        super(webdriver);
//    }

    @FindBy(how = How.ID, using = "reassignLink")
    public static WebElement reassignUnderCaseReview;

    @FindBy(how = How.ID, using = "fos")
    public static WebElement selectFOSUSerForReAssignment;

    @FindBy(how = How.ID, using = "foss")
    public static WebElement selectFOSSUSerForReAssignment;

    @FindBy(how = How.ID, using = "destination")
    public static WebElement selectDestinationUnderCaseReview;

    @FindBy(how = How.XPATH, using = "//*[@id=\"cfCodeBlock\"]/div/div[1]/ul/li[2]/a/label/input")
    public static WebElement checkCFCode;

    @FindBy(how = How.ID, using = "comment")
    public static WebElement addCommentUnderCaseReview;

    @FindBy(how = How.ID, using = "submitComment")
    public static WebElement submit;

    @FindBy(how=How.ID, using="fileInput")
    public static  WebElement uploadFile;

    @FindBy(how = How.ID, using = "fos")
    public static WebElement selectFosUnderCaseReview;

    @FindBy(how = How.ID, using = "foss")
    public static WebElement selectFossUnderCaseReview;
}
