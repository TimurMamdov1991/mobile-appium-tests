package ru.testing.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.URL;

public class Platform {

    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";
    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";

    public AppiumDriver getDriver() throws Exception{
        URL URl = new URL(APPIUM_URL);
        if (this.isAndroid()) {
            return new AndroidDriver<RemoteWebElement>(URl, this.getCapabilitiesAndroid());
        } else if (this.isIOS()) {
            return new IOSDriver<RemoteWebElement>(URl, this.getCapabilitiesIos());
        } else {
            throw new Exception("Cannot detect type of the Driver. Platform value " + this.getPlatformVar());
        }
    }

   public boolean isAndroid(){
       return isPlatform(PLATFORM_ANDROID);
   }

    public boolean isIOS(){
        return isPlatform(PLATFORM_IOS);
    }

    private DesiredCapabilities getCapabilitiesAndroid(){
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","11,0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("app","A:\\app-releaseSB.apk");
        capabilities.setCapability("appPackage","ru.mobile.sbereducation");
        capabilities.setCapability("appActivity","ru.edutoria.app.main.ui.MainActivity");
        return capabilities;
    }

    private DesiredCapabilities getCapabilitiesIos(){
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","IOS");
        capabilities.setCapability("deviceName","IPhone 8");
        capabilities.setCapability("platformVersion","11,3");
        capabilities.setCapability("app","A:\\app-releaseSB.app");
        return capabilities;
    }

    private boolean isPlatform(String my_platform){
        String platform = this.getPlatformVar();
        return my_platform.equals(platform);
    }

    private String getPlatformVar(){
        return System.getenv("PLATFORM");
    }
}
