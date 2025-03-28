package lesson7.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String moth, String year) {
        $(".react-datepicker__month-select").$(byText(moth)).click();
        $(".react-datepicker__year-select").$(byText(year)).click();
        $("[role=listbox]").$(byText(day)).click();

    }
}
