package lesson7.tests;

import org.junit.jupiter.api.Test;
import lesson7.pages.TextBoxFormPage;

import static lesson7.tests.TestData.*;

public class TextBoxTests extends TestBase {
    TestData td = new TestData();
    TextBoxFormPage textBoxFormPage = new TextBoxFormPage();


    @Test
    void fillFormTest() {
        textBoxFormPage.openPage()
                .closeBanners()
                .setUserName(td.firstName)
                .setEmail(td.email)
                .setCurrentAddress(td.currentAddress)
                .setPermanentAddress(td.permanentAddress)
                .setSubmit()
                .checkResult(td.firstName,
                        td.email,
                        td.currentAddress,
                        td.permanentAddress);

    }

    @Test
    void sendInvalidEmailTest() {
        textBoxFormPage.openPage()
                .setUserName(td.firstName)
                .setEmail(td.noEmail)
                .setCurrentAddress(td.currentAddress)
                .setPermanentAddress(td.permanentAddress)
                .setSubmit()
                .checkNoResult();

    }
}
