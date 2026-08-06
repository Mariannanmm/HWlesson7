package org.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;
import com.codeborne.selenide.testng.TextReport;
import org.testng.annotations.Listeners;

@Listeners({TextReport.class})

public class BaseTest {
    @BeforeTest
    public void config() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1280x920";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 10000;
        Configuration.headless = false;
        Configuration.savePageSource = false;
        Configuration.screenshots = true;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
        );
    }

    @BeforeMethod
    public void login() {
        Selenide.open("https://www.demoblaze.com/");
    }

    @AfterMethod
    public void cleanWebDriver() {

    }

    @AfterTest
    public void tearDown(){

    }

}

