package lesson14.tests;

import lesson14.pages.AuthorizationUserPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AuthorizationUserTest extends TestBase {

    AuthorizationUserPage authorizationUserPage = new AuthorizationUserPage();
    @Tags({
            @Tag("S4"),
            @Tag("SMOK")
    })
    @DisplayName("Проверка авторизации")
    @ParameterizedTest(name ="Авторизация через {0}")
    @CsvSource(value = {
            "Телефон, 9781999651, 1234qwer",
            "Счет, 17495588, 1234qwer",
            "Логин, VX79781999651C, 1234qwer"
    })
    void authorizationUserMethod(String type, String identifier, String password) {
        step("Открываем главную страницу БЕТСИТИ и авторизуемся", () -> {
            authorizationUserPage.authorizationUser(type, identifier, password);
        });
    }
}
