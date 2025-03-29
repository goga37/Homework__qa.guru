package lesson7.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxFormPage {
    private final SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submit = $("#submit"),
            nameKey = $("#output #name"),
            emailKey = $("#output #email"),
            currentAddressKey = $("#output #currentAddress"),
            permanentAddressKey = $("#output #permanentAddress");

    public TextBoxFormPage openPage() {
        open("/text-box");

        return this;
    }


    public TextBoxFormPage closeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public TextBoxFormPage setUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public TextBoxFormPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public TextBoxFormPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxFormPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public TextBoxFormPage setSubmit() {
        submit.scrollIntoView(true);
        submit.click();

        return this;
    }

    public TextBoxFormPage checkResult(String name, String email, String currentAddress, String permanentAddress) {
        nameKey.shouldHave(text(name));
        emailKey.shouldHave(text(email));
        currentAddressKey.shouldHave(text(currentAddress));
        permanentAddressKey.shouldHave(text(permanentAddress));

        return this;
    }

    public TextBoxFormPage checkNoResult() {
        $("#output").$(By.id("name")).shouldNot(Condition.exist);
        $("#output").$(By.id("email")).shouldNot(Condition.exist);
        $("#output").$(By.id("currentAddress")).shouldNot(Condition.exist);
        $("#output").$(By.id("permanentAddress")).shouldNot(Condition.exist);
        return this;
    }
}
