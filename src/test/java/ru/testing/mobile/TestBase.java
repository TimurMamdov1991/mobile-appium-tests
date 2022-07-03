package ru.testing.mobile;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebElement;
import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import ru.testing.mobile.Page.MainPage;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBase extends TestCase {

    public AppiumDriver<RemoteWebElement> driver;
    public Core core;
    public MainPage mainPage;
    protected ru.testing.mobile.Platform Platform;

    @Override
     public void setUp() throws Exception  {
        super.setUp();
        this.Platform = new Platform();
        driver = this.Platform.getDriver();

        core = new Core(driver);
        mainPage = new MainPage(driver);
     }

    @Override
    public void tearDown() throws Exception {
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh_mm_ss");
        String fileName = format.format(dateNow) + ".png";

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("target/reports/" + fileName));
        } catch (IOException | WebDriverException a) {
            a.printStackTrace();
        }

        driver.quit();
        super.tearDown();
    }
}
