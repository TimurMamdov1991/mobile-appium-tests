package ru.testing.mobile.test;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import ru.testing.mobile.TestBase;

public class Tests1 extends TestBase {

    @Tag("IOS")
    @Tag("Android")
    @Tag("Smok")
    @Test
    @DisplayName("Проверка авторизации")
    public void testClickProfile() throws InterruptedException {
        mainPage.clickMainAccount();
            mainPage.login("trades1234567@yandex.ru","Trades1234567");
    }
}
