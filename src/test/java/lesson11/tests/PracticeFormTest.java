package lesson11.tests;

import lesson7.pages.PracticeFormPage;
import org.junit.jupiter.api.Test;

public class PracticeFormTest extends TestBase {
    TestData td = new TestData();

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void fillFormTest() {
        practiceFormPage.openPage()
                .closeBanners()
                .setFirsName(td.firstName)
                .setLastName(td.lastName)
                .setEmail(td.email)
                .setGender(td.gender)
                .setUserNumber(td.userNumber)
                .setDateOfBirth(td.day, td.month, td.year)
                .setSubjects(td.subjects)
                .setHobbies(td.hobbies)
                .setUploadPicture(td.uploadPicture)
                .setCurrentAddress(td.currentAddress)
                .setState(td.state)
                .setCity(td.city)
                .setSubmit()
                .isResultWindowDisplayed("Thanks for submitting the form")
                .checkResult("Student Name", td.firstName + " " + td.lastName)
                .checkResult("Student Email", td.email)
                .checkResult("Gender", td.gender)
                .checkResult("Mobile", td.userNumber)
                .checkResult("Date of Birth", td.day + " " + td.month + "," + td.year)
                .checkResult("Subjects", td.subjects)
                .checkResult("Hobbies", td.hobbies)
                .checkResult("Picture", td.uploadPicture)
                .checkResult("Address", td.currentAddress)
                .checkResult("State and City", td.state + " " + td.city);
    }

    @Test
    void testFillingOnlyRequiredFields() {
        practiceFormPage.openPage()
                .closeBanners()
                .setFirsName(td.firstName)
                .setLastName(td.lastName)
                .setGender(td.gender)
                .setUserNumber(td.userNumber)
                .setSubmit()
                .isResultWindowDisplayed("Thanks for submitting the form")
                .checkResult("Student Name", td.firstName + " " + td.lastName)
                .checkResult("Gender", td.gender)
                .checkResult("Mobile", td.userNumber);
    }

    @Test
    void testMissingRequiredField() {
        practiceFormPage.openPage()
                .closeBanners()
                .setFirsName(td.firstName)
                .setLastName(td.lastName)
                .setEmail(td.email)
                .setGender(td.gender)
                .setDateOfBirth(td.day, td.month, td.year)
                .setSubjects(td.subjects)
                .setHobbies(td.hobbies)
                .setUploadPicture(td.uploadPicture)
                .setCurrentAddress(td.currentAddress)
                .setState(td.state)
                .setCity(td.city)
                .setSubmit()
                .shouldNotSeeModal();
    }
}