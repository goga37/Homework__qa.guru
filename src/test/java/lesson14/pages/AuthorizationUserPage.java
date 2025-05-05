package lesson14.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthorizationUserPage {
    private final SelenideElement authSignIn = $("#authSignIn"),
            auth = $(".auth"),
            loginInput = $("[name=login]"),
            passInput = $("[name=pass]"),
            loginBtnSignIn = $("#loginBtnSignIn");

    public AuthorizationUserPage authorizationUser(String authorizationMethod, String login, String pass) {
        open(Configuration.baseUrl);
        $(".push-confirm").$(byText("Позже")).click();
        $(".cookie-modal").$(byText("Принять")).click();
        authSignIn.click();
        auth.$(byText(authorizationMethod)).click();
        loginInput.setValue(login);
        passInput.setValue(pass);
        loginBtnSignIn.click();
        authSignIn.shouldNot(appear);
        return this;
    }
}
