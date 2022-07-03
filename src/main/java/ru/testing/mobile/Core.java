package ru.testing.mobile;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;


public class Core {
    protected AppiumDriver<RemoteWebElement> driver;

    public Core(AppiumDriver<RemoteWebElement> driver) {
        this.driver = driver;
    }


    public WebElement waitForElementPresent(String locator, String error_massage, long timeoutInSecond){
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSecond);
        wait.withMessage(error_massage + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    public WebElement waitForElementPresent(String locator, String error_massage){
        return waitForElementPresent(locator,error_massage,10);
    }

    public WebElement waitForElementAndClick(String locator, String error_massage, long timeoutInSecond){
        WebElement element = waitForElementPresent(locator, error_massage, timeoutInSecond);
        element.click();
        return element;
    }

    public WebElement waitForElementAndClick(String locator, String error_massage){
        WebElement element = waitForElementPresent(locator, error_massage, 60);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(String locator, String value, String error_massage, long timeoutInSecond){
        WebElement element = waitForElementPresent(locator, error_massage, timeoutInSecond);
        element.sendKeys(value);
        return element;
    }

    public WebElement waitForElementAndSendKeys(String locator, String value, String error_massage){
        WebElement element = waitForElementPresent(locator, error_massage, 60);
        element.sendKeys(value);
        return element;
    }

    public WebElement waitForElementAndClear(String locator, String error_massage){
        WebElement element = waitForElementPresent(locator, error_massage, 60);
        element.clear();
        return element;
    }

    private By getLocatorByString(String locator_with_type){
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"),2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];

        if (by_type.equals("xpath")){
            return By.xpath(locator);
        } else if (by_type.equals("id")){
            return By.id(locator);
        } else {
            throw new IllegalArgumentException("Cannot get typ of Locator. Locator: " + locator_with_type);
        }
    }
}

