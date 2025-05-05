package lesson14.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.Color;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class IdentificationPage {
    private final SelenideElement menuLang = $(".flag-indicator"),
            identificationContent = $(".identification__content"),
            identStatusNeed = $(".left-collapsed"),
            cashbox = $(".cashbox"),
            uploadMain = $("[name=main]"),
            uploadReg = $("[name=reg]"),
            uploadSelfi = $("[name=selfi]"),
            cashidentFullTabsbox = $(".ident-full-tabs"),
            identificationTabs = $(".identification__tabs"),
            identificationList = $(".identification__list");

    private final ElementsCollection identStatus = $$(".left-collapsed a"),
            formItem = $$(".ident-full__form-item label"),
            identFull = $$(".ident-full__button button"),
            in = $$(".in label"),
            redirectButton = $$(".redirect button");


    ElementsCollection selectPopup = $$(".custom-select-popup-item__text");

    public IdentificationPage changingTheLanguage(String lang) {
        menuLang.click();
        selectPopup.findBy(text(lang)).click();

        return this;
    }

    public IdentificationPage setIdentStatus() {
        identStatus.first().click();

        return this;
    }

    public IdentificationPage transfersPage(List<String> value) {
        for (String text : value) {
            identificationList.shouldHave(text(text));
        }

        return this;
    }

    public IdentificationPage setIdentificationContent(String value) {
        identificationContent.$(byText(value)).click();

        return this;
    }

    public IdentificationPage setCashidentFullTabsbox(String value) {
        cashidentFullTabsbox.$(byText(value)).click();

        return this;
    }

    public IdentificationPage setUploadMain(String values) {
        uploadMain.uploadFromClasspath(values);

        return this;
    }

    public IdentificationPage setUploadReg(String values) {
        uploadReg.uploadFromClasspath(values);

        return this;
    }

    public IdentificationPage setUploadSelfi(String values) {
        uploadSelfi.uploadFromClasspath(values);

        return this;
    }

    public IdentificationPage setIdentificationTabs(String value) {
        identificationTabs.$(byText(value)).click();

        return this;
    }

    public IdentificationPage setRedirectButton() {
        redirectButton.get(1).click();

        return this;
    }

    public IdentificationPage setIdentFull() {
        identFull.get(1).click();

        return this;
    }

    public IdentificationPage setCashbox(String value) {
        cashbox.shouldHave(text(value));

        return this;
    }

    public IdentificationPage setIdentStatusNeed(String value) {
        identStatusNeed.shouldHave(text(value));

        return this;
    }

    public IdentificationPage setFormItem(String value, String values) {
        formItem
                .filterBy(text(value))
                .first() // Возьмем первый элемент, если таких несколько
                .parent() // Поднимемся к родительскому элементу
                .find("input") // Найдем элемент input внутри родительского элемента
                .setValue(values);

        return this;
    }

    public IdentificationPage setIn(String value, String values) {
        in
                .filterBy(text(value))
                .first() // Возьмем первый элемент, если таких несколько
                .parent() // Поднимемся к родительскому элементу
                .find("input") // Найдем элемент input внутри родительского элемента
                .setValue(values);

        return this;
    }

    public IdentificationPage setExpectedColor(String value) {
        String actualColor = $(".upload__button").getCssValue("background-color");
        String actualHex = Color.fromString(actualColor).asHex();
        String expectedHex = value;
        assert actualHex.equalsIgnoreCase(expectedHex)
                : "Цвет не совпадает: ожидалось " + expectedHex + ", а было " + actualHex;

        return this;
    }

}
