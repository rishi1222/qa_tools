package cat.steps;


import cat.config.Pages;
import cat.pageobject.*;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;


/**
 * Created by kaporis on 19/02/2018.
 */
public class Hooks {

    public static WebDriver driver;

    @Before("@web")
/**
 * Delete all cookies at the start of each scenario to avoid
 * shared state between tests
 */
    public void openBrowser() throws IOException {

        String driverPath = "C:\\Users\\kaporis\\Project\\selenium";

        System.out.println("Called openBrowser");
        System.out.println(System.getProperty("browser"));
        System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "sandbox; default-src 'self';");



                ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("disable-infobars");
        options.addArguments("--enable-javascript");
//        driver = new RemoteWebDriver(
//                new URL("http://127.0.0.1:4444/wd/hub"),
//                options
//        );

//        driver = new RemoteWebDriver(
//                new URL("http://localhost:4444/wd/hub"),
//                options
//        );


                driver = new RemoteWebDriver(
                new URL("http://10.202.17.126:4444/wd/hub"),
                options
        );



//        options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

//        LoggingPreferences logPrefs = new LoggingPreferences();
//        logPrefs.enable(LogType.BROWSER, Level.ALL);

        //Internet Explorer

//        Runtime.getRuntime().exec("regedit.exe /s #ProtectMode.reg".replace("#", System.getProperty("user.dir") + "/src/test/resources/"));
//        System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
//        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
//        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//        capabilities.setCapability("requireWindowFocus", true);
//        capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
//        driver = new RemoteWebDriver(
//                new URL("http://127.0.0.1:4444/wd/hub"),
//                capabilities
//        );


    }




    @After("@web")
/**
 * Embed a screenshot in test report if test is marked as failed
 */
    public void embedScreenshot(Scenario scenario) {
        System.out.println("Called embeddedBrowser");
        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
        driver.close();
        driver.quit();
    }

}
