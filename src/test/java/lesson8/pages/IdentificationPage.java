package lesson8.pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.util.List;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class IdentificationPage {
    private final SelenideElement menuLang = $(".flag-indicator"),
            identStatus = $(".left-collapsed");

    ElementsCollection selectPopup = $$(".custom-select-popup-item__text");
    ElementsCollection identificationList = $$(".identification__list");

    public IdentificationPage changingTheLanguage(String lang) {
        menuLang.click();
        selectPopup.findBy(text(lang)).click();

        return this;
    }

    public IdentificationPage setIdentStatus(String value) {
        identStatus.$(byText(value)).click();

        return this;
    }

    public IdentificationPage transfersPage(List<String> value) {
        SelenideElement identificationList = $(".identification__list");

        for (String text : value) {
            identificationList.shouldHave(text(text));
        }

        return this;
    }
}
