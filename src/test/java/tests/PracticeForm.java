package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void fillFormTest(){
        open("/automation-practice-form");
        $("#firstName").setValue("Igor");
        $("#lastName").setValue("Bys");
        $("#userEmail").setValue("igorBys@gmail.com");
        $(".custom-control-label").click();
        $("#userNumber").setValue("8995892000");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("December")).click();
        $(".react-datepicker__year-select").$(byText("2000")).click();
        $("[role=listbox]").$(byText("18")).click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("[for=hobbies-checkbox-1]").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/1.png"));
        $("#currentAddress").setValue("7 Vesennyaya Street, Moscow");
        $("#state").scrollIntoView(true);
        $("#state").click();
        $("#react-select-3-input").pressEnter();
        $("#city").click();
        $("#react-select-4-input").pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("igorBys@gmail.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("8995892000"));
        $(".table-responsive").shouldHave(text("18 December,2000"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("1.png"));
        $(".table-responsive").shouldHave(text("7 Vesennyaya Street, Moscow"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));

    }
}
