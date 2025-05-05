package lesson14.tests;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class TestData {
    static final Faker faker = new Faker(new Locale("ru"));
    private static final Random random = new Random();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().option("Other", "Female", "Male"),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            seria = String.valueOf(faker.number().numberBetween(1000, 9999)),
            numberPas = String.valueOf(faker.number().numberBetween(100000, 999999)),
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

    String patronymic = getPatronymic(firstName);  // Генерация отчества на основе имени

    // Метод для генерации отчества
    public static String getPatronymic(String firstName) {
        String patronymic = "";
        if (firstName.endsWith("а") || firstName.endsWith("я")) {
            patronymic = firstName.substring(0, firstName.length() - 1) + "вна"; // Пример для женского имени
        } else {
            patronymic = firstName + "ович";  // Пример для мужского имени
        }
        return patronymic;
    }

    String snils = generateSnils();

    // Метод генерации СНИЛС
    private static String generateSnils() {
        Random random = new Random();
        int[] numbers = new int[9];
        for (int i = 0; i < 9; i++) {
            numbers[i] = random.nextInt(10);
        }

        // Вычисление контрольной суммы
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += numbers[i] * (9 - i);
        }

        int control;
        if (sum < 100) {
            control = sum;
        } else if (sum == 100 || sum == 101) {
            control = 0;
        } else {
            control = sum % 101;
            if (control == 100) {
                control = 0;
            }
        }

        // Форматируем в строку: XXX-XXX-XXX YY
        return String.format("%03d-%03d-%03d %02d",
                numbers[0] * 100 + numbers[1] * 10 + numbers[2],
                numbers[3] * 100 + numbers[4] * 10 + numbers[5],
                numbers[6] * 100 + numbers[7] * 10 + numbers[8],
                control);
    }

    String inn = generateIndividualInn();


    public static String generateIndividualInn() {
        String base = randomDigits(10); // первые 10 цифр
        int check1 = calculateChecksum(base, new int[]{7, 2, 4, 10, 3, 5, 9, 4, 6, 8});
        int check2 = calculateChecksum(base + check1, new int[]{3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8});
        return base + check1 + check2;
    }

    private static int calculateChecksum(String digits, int[] weights) {
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += Character.getNumericValue(digits.charAt(i)) * weights[i];
        }
        return (sum % 11) % 10;
    }

    private static String randomDigits(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}