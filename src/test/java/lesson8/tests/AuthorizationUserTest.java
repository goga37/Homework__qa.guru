package lesson8.tests;

import lesson8.pages.AuthorizationUserPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AuthorizationUserTest extends TestBase {

    AuthorizationUserPage authorizationUserPage = new AuthorizationUserPage();
    @Tags({
            @Tag("S4"),
            @Tag("SMOK")
    })
    @ParameterizedTest(name ="Авторизация через {0}")
    @CsvSource(value = {
            "Телефон, 9781999651, 1234qwer",
            "Счет, 17495588, 1234qwer",
            "Логин, VX79781999651C, 1234qwer"
    })
    void authorizationUserMethod(String type, String identifier, String password) {
        authorizationUserPage.authorizationUser(type, identifier, password);
    }
}
