package cat.page;

import cat.config.Env;
import cat.config.PropertiesConfig;
import cat.service.ConnectionProvider;
import cat.steps.Hooks;
import com.google.common.base.Function;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static cat.config.PropertiesConfig.*;
import static cat.config.PropertiesConfig.DB_NAME;
import static cat.config.PropertiesConfig.ENVIRONMENT;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * Created by kaporis on 19/02/2018.
 */
public class AbstractPage {

    private static final Logger LOGGER = LogManager.getLogger(AbstractPage.class);

    protected WebDriver driver = Hooks.driver;
    protected ConnectionProvider db;
    protected Connection conn;
    protected static final Map<String, String> properties = new Env().getProperties();


    public AbstractPage() {

    }


    private WebDriver getDriver() {
        return driver;
    }

    public Connection dbConnect() throws Exception {
        if (isProductionEnvironment()) {
//          db = new ConnectionProvider(properties.get(TNS_NAME), properties.get(PropertiesConfig.DB_USER), properties.get(PropertiesConfig.DB_PASSWORD), properties.get(TNS_NAME_FILE));
            db = new ConnectionProvider(properties.get(DB_HOST), properties.get(DB_PORT), properties.get(DB_NAME), properties.get(PropertiesConfig.DB_USER), properties.get(PropertiesConfig.DB_PASSWORD));
            conn = db.connect(properties.get(TNS_NAME));
        } else {
            db = new ConnectionProvider(properties.get(DB_HOST), properties.get(DB_PORT), properties.get(DB_NAME), properties.get(PropertiesConfig.DB_USER), properties.get(PropertiesConfig.DB_PASSWORD));
            conn = db.connect();
        }

        return conn;
    }

    public void close() {
        db.close();
    }

    public boolean isProductionEnvironment() {
        String env = properties.get(CONNECTION_TYPE);
        return env.equals("CONNECTION") || env.equals("CONNECTION_POOL");
    }

    public WebElement waitForElement(By by, int timeOut) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOut);
        return webDriverWait.until(presenceOfElementBy(by));
    }

    public void waitTillClickable(WebElement webElement) {
        new WebDriverWait(driver, 30).
                until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitTillVisible(WebElement webElement) {
        new WebDriverWait(driver, 20).
                until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitTillVibiltyofElementLocated(WebElement webElement) {
        new WebDriverWait(driver, 20).
                until(ExpectedConditions.elementSelectionStateToBe(webElement, true));
    }

    public WebElement waitForElementById(String id) {
        return waitForElement(By.id(id), 10);
    }

    public WebElement waitForElementByXPath(String xpath) {
        return waitForElement(By.xpath(xpath), 10);
    }


    public boolean waitForJSandJQueryToLoad() {

        WebDriverWait wait = new WebDriverWait(driver, 30);

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) ((JavascriptExecutor) getDriver()).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) getDriver()).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };

//        return wait.until(jQueryLoad) && wait.until(jsLoad);
        return wait.until(jsLoad);
    }


    private Function<WebDriver, WebElement> presenceOfElementBy(final By id) {
        Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(id);
            }
        };
        return function;
    }


    public void found(String text) {
        found(driver.getPageSource(), text);
    }

    public void found(String pageSource, String text) {
        if (!pageSource.contains(escapeHtml(text))) {
            fail("Text: '" + text + "' not found in page '" + pageSource + "'");
        }
    }

    public void found(WebElement element) {
        if (element == null) {
            fail("Could not find element");
        }
    }

    public void notFound(WebElement element) {
        if (element == null) {
            assertTrue(Boolean.TRUE);
        }
    }

    public void found(List<String> texts) {
        for (String text : texts) {
            found(text);
        }
    }

    public void foundIsEmpty(String text) {
        if (!text.isEmpty()) {
            fail("text is present");
        }
    }

    public void foundIsEmpty(Boolean value) {
        if (!value) {
            fail("text is present");
        }
    }

    public void notFound(String text) {
        notFound(driver.getPageSource(), text);
    }

    public void notFound(String pageSource, String text) {
        assertThat(driver.getPageSource().contains(escapeHtml(text)), is(false));

    }

    private String escapeHtml(String text) {
        return text.replace("<", "&lt;").replace(">", "&gt;");
    }


    public void untilJqueryIsDone() {
        untilJqueryIsDone(20L);

    }

    public void untilPageLoadComplete() {
        untilPageLoadComplete(20L);
    }

    public void untilPageLoadComplete(Long timeoutInSeconds) { untilJqueryIsDone(20L);
        until(driver, (d) ->
        {
            Boolean isPageLoaded = ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            if (!isPageLoaded) System.out.println("Document is loading");
            return isPageLoaded;
        }, timeoutInSeconds);
    }

    public void untilJqueryIsDone(Long timeoutInSeconds) {
        until(driver, (d) ->
        {
            Boolean isJqueryCallDone = (Boolean) ((JavascriptExecutor) driver).executeScript("return window.jQuery != undefined && jQuery.active==0");
            if (!isJqueryCallDone) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("-------");
            }
            return isJqueryCallDone;
        }, timeoutInSeconds);
    }

    private static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition, Long timeoutInSeconds) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutInSeconds);
        webDriverWait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS);
        try {
            webDriverWait.until(waitCondition);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void analyzeLog() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        System.out.println(logEntries);
//        for (LogEntry entry : logEntries) {
//            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
//            //do something useful with the data
//        }
    }
}
