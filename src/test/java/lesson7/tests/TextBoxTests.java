package lesson7.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import lesson7.pages.TextBoxFormPage;

public class TextBoxTests extends TestBase {

    TextBoxFormPage textBoxFormPage = new TextBoxFormPage();


    @Test
    void fillFormTest() {
        textBoxFormPage.openPage()
                .CloseBanners()
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
