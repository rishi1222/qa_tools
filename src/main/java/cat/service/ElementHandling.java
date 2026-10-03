package cat.service;

import org.openqa.selenium.WebElement;

/**
 * Created by kaporis on 18/04/2018.
 */
public class ElementHandling {

    public static boolean retryingFindClick(WebElement webElement) {
        boolean result = false;
        int attempts = 0;
        while (attempts < 2) {
            try {
                webElement.click();
                result = true;
                break;
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }
}
