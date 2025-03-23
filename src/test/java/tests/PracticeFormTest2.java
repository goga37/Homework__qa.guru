package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

public class PracticeFormTest2 {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        practiceFormPage.openPage()
                .setFirsName("Igor")
                .setLastName("bys")
                .setEmail("igorBys@gmail.com")
                .setGender("Other")
                .setUserNumber("8995892000")
                .setDateOfBirth("18", "December", "2000")
                .setSubjects("Math")
                .setHobbies("Music")
                .setUploadPicture("1.png")
                .setCurrentAddress("7 Vesennyaya Street, Moscow")
                .setState("Haryana")
                .setCity("Panipat")
                .setSubmit()
                .isResultWindowDisplayed("Thanks for submitting the form")
                .checkResult("Student Name", "Igor Bys")
                .checkResult("Student Email", "igorBys@gmail.com")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "8995892000")
                .checkResult("Date of Birth", "18 December,2000")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "1.png")
                .checkResult("Address", "7 Vesennyaya Street, Moscow")
                .checkResult("State and City", "Haryana Panipat");
    }
    @Test
    void testFillingOnlyRequiredFields() {
        practiceFormPage.openPage()
                .setFirsName("Igor")
                .setLastName("bys")
                .setGender("Other")
                .setUserNumber("8995892000")
                .setSubmit()
                .isResultWindowDisplayed("Thanks for submitting the form")
                .checkResult("Student Name", "Igor Bys")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "8995892000");
    }
@Test
void testMissingRequiredField() {
    practiceFormPage.openPage()
            .setFirsName("Igor")
            .setLastName("bys")
            .setEmail("igorBys@gmail.com")
            .setGender("Other")
            .setDateOfBirth("18", "December", "2000")
            .setSubjects("Math")
            .setHobbies("Music")
            .setUploadPicture("1.png")
            .setCurrentAddress("7 Vesennyaya Street, Moscow")
            .setState("Haryana")
            .setCity("Panipat")
            .setSubmit()
            .shouldNotSeeModal();
}
}