package cat.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import cat.steps.Hooks;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kaporis on 12/03/2018.
 */
public abstract class PageObjectBaseClass  {

    protected static WebDriver driver;

    public PageObjectBaseClass(WebDriver driver) {
        this.driver = driver;

    }

    protected WebDriver getWebDriver(){
        return driver;
    }

}
