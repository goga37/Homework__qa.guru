package lesson8.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import lesson7.pages.PracticeFormPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelectingMenuPage {
    private final SelenideElement
            menu = $(".menu"),
            slideActive = $(".slide slide_active");

    public SelectingMenuPage setMenu(String value) {
        menu.$(byText(value)).click();

        return this;
    }

    public SelectingMenuPage shouldNotBanner() {
        slideActive.shouldNot(appear);

        return this;
    }

    public SelectingMenuPage openPage() {
        open(Configuration.baseUrl);
        $(".push-confirm").$(byText("Позже")).click();
        $(".cookie-modal").$(byText("Принять")).click();

        return this;
    }
}
