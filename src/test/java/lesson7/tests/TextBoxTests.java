package lesson7.tests;

import org.junit.jupiter.api.Test;
import lesson7.pages.TextBoxFormPage;

import static lesson7.tests.TestData.*;

public class TextBoxTests extends TestBase {

    TextBoxFormPage textBoxFormPage = new TextBoxFormPage();


    @Test
    void fillFormTest() {
        textBoxFormPage.openPage()
                .closeBanners()
                .setUserName(firstName)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .setSubmit()
                .checkResult(firstName,
                        email,
                        currentAddress,
                        permanentAddress);

    }

    @Test
    void sendInvalidEmailTest() {
        textBoxFormPage.openPage()
                .setUserName(firstName)
                .setEmail(noEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .setSubmit()
                .checkNoResult();

    }
}
