package lesson7.tests;

import org.junit.jupiter.api.Test;
import lesson7.pages.PracticeFormPage;

import static lesson7.tests.TestData.*;

public class PracticeFormTest extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void fillFormTest() {
        practiceFormPage.openPage()
                .closeBanners()
                .setFirsName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(day, month, year)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setUploadPicture(uploadPicture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .setSubmit()
                .isResultWindowDisplayed("Thanks for submitting the form")
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", uploadPicture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void testFillingOnlyRequiredFields() {
        practiceFormPage.openPage()
                .closeBanners()
                .setFirsName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setSubmit()
                .isResultWindowDisplayed("Thanks for submitting the form")
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber);
    }

    @Test
    void testMissingRequiredField() {
        practiceFormPage.openPage()
                .closeBanners()
                .setFirsName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setDateOfBirth(day, month, year)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setUploadPicture(uploadPicture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .setSubmit()
                .shouldNotSeeModal();
    }
}