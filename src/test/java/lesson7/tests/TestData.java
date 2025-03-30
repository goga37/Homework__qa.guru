package lesson7.tests;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class TestData {
    static final Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().option("Other", "Female", "Male"),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            day = String.valueOf(faker.number().numberBetween(1, 28)),
            month = faker.options().option(
                    "January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"),
            year = String.valueOf(faker.number().numberBetween(1900, 2005)),
            subjects = faker.options().option(
                    "Maths", "Chemistry", "English", "Physics", "Computer Science", "Economics",
                    "Arts"),
            hobbies = faker.options().option(
                    "Music", "Reading", "Sports"),
            uploadPicture = faker.options().option(
                    "1.png", "2.JPG", "3.bmp"),
            currentAddress = faker.address().streetAddress(),
            permanentAddress = faker.address().fullAddress(),
            noEmail = faker.name().firstName();

    String state = getRandomState();
    String city = getRandomCityForState(state);

    private String getRandomState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    private String getRandomCityForState(String state) {
        Map<String, String[]> stateCityMap = new HashMap<>();
        stateCityMap.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        stateCityMap.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        stateCityMap.put("Haryana", new String[]{"Karnal", "Panipat"});
        stateCityMap.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});

        return faker.options().option(stateCityMap.get(state));
    }
}