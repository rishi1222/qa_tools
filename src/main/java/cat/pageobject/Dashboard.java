package cat.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



/**
 * Created by kaporis on 12/03/2018.
 */
public class Dashboard extends PageObjectBaseClass {

   public Dashboard(WebDriver driver){
       super(driver);
   }
    @FindBy(how = How.ID, using = "overridelink")
    public static WebElement certificate;

    @FindBy(how = How.ID, using = "testUserEmail")
    public static WebElement userGroupDropDown;

    @FindBy(how = How.TAG_NAME, using = "option")
    public static WebElement selectOption;

    @FindBy(how = How.XPATH, using = "//h4[contains(text(),'Segment Preparation')]")
    public static WebElement segmentPreparation;

    @FindBy(how = How.XPATH, using = "//h4[contains(text(),'FOS Segment Review')]")
    public static WebElement fosSegmentReview;

    @FindBy(how = How.XPATH, using = "//h4[contains(text(),'IRG Segment Review')]")
    public static WebElement irgSegmntReview;

    @FindBy(how = How.XPATH, using = "//h4[contains(text(),'FOS Case Review')]")
    public static WebElement fosCaseReview;

    @FindBy(how = How.XPATH, using = "//h4[contains(text(),'IRG Case Review')]")
    public static WebElement irgCaseReview;

    @FindBy(how = How.XPATH, using = "//h4[contains(text(),'Escalated IRG Case Review')]")
    public static WebElement escalateIRGCaseReview;

    @FindBy(how = How.XPATH, using = "//h4[contains(text(),'Investigation Holding Loop')]")
    public static WebElement investigateHoldingLoop;

    @FindBy(how = How.CLASS_NAME, using = "list-group-item")
    public static WebElement linkToSegmentCreationPage;

    @FindBy(how = How.CLASS_NAME, using = "list-group-item-heading")
    public static WebElement testCaseToBeUsed;

    public static WebElement caseIdLinkToSegmentCreation(String caseID) {

//        return driver.findElement(By.cssSelector("#case-"+caseID+"]"));
        return driver.findElement(By.cssSelector("a[href="+'"'+"#/segment_prep/" +caseID+'"'+ "][id="+'"'+"case-"+caseID+'"'+"]"));
//        return driver.findElement(By.xpath("//*[@id="+'"'+"case-"+caseID+'"'+"]"));
    }

    public static WebElement caseIdLinkUnderFosUpgrade(String segCaseID,String caseID) {
        return driver.findElement(By.cssSelector("a[href="+'"'+"#/segment/" +segCaseID+'/'+caseID+'"'+ "][id="+'"'+"segment-"+caseID+'"'+"]"));
    }

    public static WebElement caseIdLinkToUnderIRGMClose(String segCaseID,String caseID) {
        return driver.findElement(By.cssSelector("a[href="+'"'+"#/segment/" +segCaseID+'/'+caseID+'"'+ "][id="+'"'+"segment-"+caseID+'"'+"]"));
    }

    public static WebElement caseIdLinkUnderFosSegmentReview(String segCaseID,String caseID) {
        return driver.findElement(By.cssSelector("a[href="+'"'+"#/segment/" +segCaseID+'/'+caseID+'"'+ "][id="+'"'+"segment-"+caseID+'"'+"]"));
    }

    public static WebElement caseIdLinkUnderMoSegmentReview(String segCaseID,String caseID) {
        return driver.findElement(By.cssSelector("a[href="+'"'+"#/segment/" +segCaseID+'/'+caseID+'"'+ "][id="+'"'+"segment-"+caseID+'"'+"]"));
    }

    public static WebElement caseIdLinkUnderCaseReview(String caseID) {
        return driver.findElement(By.cssSelector("a[href="+'"'+"#/case/" +caseID+'"'+ "][id="+'"'+"case-"+caseID+'"'+"]"));
    }


    public static WebElement caseIdLinkUnderIRGCaseReview(String caseID) {
        return driver.findElement(By.cssSelector("a[href="+'"'+"#/case/" +caseID+'"'+ "][id="+'"'+"case-"+caseID+'"'+"]"));
    }

    public static WebElement caseIdLinkUnderEscalatedFOSCaseReview(String caseID) {
        return driver.findElement(By.cssSelector("a[href*=" + caseID + "]"));
    }

    public static WebElement caseIdLinkUnderEscalatedIRGCaseReview(String caseID) {
        return driver.findElement(By.cssSelector("a[href="+'"'+"#/segment_prep/" +caseID+'"'+ "][id="+'"'+"case-"+caseID+'"'+"]"));
    }

    @FindBy(how = How.CLASS_NAME, using = "active")
    public static WebElement dashboard;

    @FindBy(how = How.ID, using = "quickSearch")
    public static WebElement quickSearch;

}
