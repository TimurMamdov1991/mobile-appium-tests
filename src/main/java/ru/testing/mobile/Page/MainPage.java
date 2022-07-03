package ru.testing.mobile.Page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import ru.testing.mobile.Core;


public class MainPage extends Core {

    public MainPage(AppiumDriver<RemoteWebElement> driver) {
        super(driver);
    }

    private static final String
            COME = "xpath://android.view.View[@text='Войти']",
            PASSWORD = "xpath://android.widget.EditText[@index='3']",
            EMAIL = "xpath://android.widget.EditText[@index='2']",
            ACCOUNT="xpath://android.view.View[@text='У меня есть аккаунт']",
            CREATEACCOUNT ="xpath://android.view.View[@text='Создать аккаунт']",
            SKIP = "xpath://android.view.View[@text='Пропустить']";

    public void clickMainAccount() {
        this.waitForElementAndClick(ACCOUNT,"no click");
    }

     public void clickCreateAccount() {
      this.waitForElementAndClick(CREATEACCOUNT,"no click");
    }

    public void clickSkip() {
        this.waitForElementAndClick(SKIP,"no click");
    }

    public void login(String email, String pass){
        this.waitForElementAndSendKeys(EMAIL,email,"");
        this.waitForElementAndSendKeys(PASSWORD,pass,"");
        this.waitForElementAndClick(COME,"no click");
    }
}
