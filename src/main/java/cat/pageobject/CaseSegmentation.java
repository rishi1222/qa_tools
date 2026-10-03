package cat.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by kaporis on 13/03/2018.
 */
public class CaseSegmentation extends PageObjectBaseClass {

    public CaseSegmentation(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "createSegment")
    public static WebElement createSegmentButton;

    @FindBy(how = How.ID, using = "datatable")
    public static WebElement checkBoxTable;

    @FindBy(how = How.ID, using = "selectAllTrades")
    public static WebElement selectAllCheckBox;

    @FindBy(how = How.ID, using = "proposeTo")
    public static WebElement destination;

    @FindBy(how = How.ID, using = "irgAssignee")
    public static WebElement irgAssignee;

    @FindBy(how = How.ID, using = "comment")
    public static WebElement comment;

    @FindBy(how = How.ID, using = "saveNewSegment")
    public static WebElement saveSegment;

    @FindBy(how = How.ID, using = "submitSegments")
    public static WebElement submitSegment;


    @FindBy(how = How.XPATH, using = "//*[@id=\"cfCodeBlock\"]/div/div[1]/ul/li[2]/a/label/input")
    public static WebElement checkCFCode;

    @FindBy(how = How.XPATH, using = "//*[@id=\"moReviewersBlock\"]/div[2]/div/ul/li[2]/a/label/input")
    public static WebElement checkMOReviewer;

    @FindBy(how = How.ID, using = "segmentDialog")
    public static WebElement modalSegmentDialog;

    @FindBy(how =How.XPATH, using = "//span[contains(text(),'Send email notification to')]")
    public static WebElement sendEmailNotication;

}
