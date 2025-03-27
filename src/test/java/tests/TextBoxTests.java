package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.TextBoxFormPage;

public class TextBoxTests {

    TextBoxFormPage textBoxFormPage = new TextBoxFormPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        textBoxFormPage.openPage()
                .setUserName("Igor")
                .setEmail("csdc@bk.ru")
                .setCurrentAddress("strit 12")
                .setPermanentAddress("home 47")
                .setSubmit()
                .checkResult("Igor",
                        "csdc@bk.ru",
                        "strit 12",
                        "home 47");

    }

    @Test
    void sendInvalidEmailTest() {
        textBoxFormPage.openPage()
                .setUserName("Igor")
                .setEmail("csdc")
                .setCurrentAddress("strit 12")
                .setPermanentAddress("home 47")
                .setSubmit()
                .checkNoResult();

    }
}
