package lesson14.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lesson13.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://betcity.ru";
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browser_version", "127.0");
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = System.getProperty("remoteUrl");
        SelenideLogger.addListener("allure", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        lesson13.helpers.Attach.screenshotAs("Last screenshot");
        lesson13.helpers.Attach.pageSource();
        lesson13.helpers.Attach.browserConsoleLogs();
        Attach.addVideo();
    }

}
