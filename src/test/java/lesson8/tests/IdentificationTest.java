package lesson8.tests;

import lesson8.pages.AuthorizationUserPage;
import lesson8.pages.IdentificationPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class IdentificationTest extends TestBase {

    IdentificationPage identificationPage = new IdentificationPage();
    AuthorizationUserPage authorizationUserPage = new AuthorizationUserPage();

    @BeforeEach
    void authorizationUserMethod() {
        authorizationUserPage.authorizationUser("Телефон", "9781999651", "1234qwer");
    }

    static Stream<Arguments> testIdentification() {
        return Stream.of(
                Arguments.of(Language.ru, "Пройдите идентификацию", List.of("Полная",
                        "Статус идентификации:",
                        "Не идентифицирован",
                        "Статус идентификации:",
                        "Чтобы начать играть, по законодательству РФ, Вам необходимо пройти идентификацию. Подтвердите, что вы - реальный человек старше 18 лет.",
                        "Вы получите:",
                        "Лимит на одну операцию:",
                        "595 000 ₽",
                        "Лимит вывода на эл. кошельки:",
                        "в месяц",
                        "без ограничений",
                        "Госуслуги",
                        "Потребуется паспорт РФ или СНИЛС",
                        "Сбер",
                        "С картой Сбера",
                        "Т-Банк",
                        "С картой Т‑Банка",
                        "Лично",
                        "Пункт приема ставок",
                        "Потребуется документ, удостоверяющий личность"
                        )),
                Arguments.of(Language.en, "Please verify your identification", List.of("Full",
                        "Identification status:",
                        "Not identified",
                        "To start playing, according to the legislation of the Russian Federation, you need to pass identification. Confirm that you are a real person over 18 years old.",
                        "You will get:",
                        "Limit per a transaction:",
                        "595,000 ₽",
                        "Withdrawal limit to electronic wallets:",
                        "per month",
                        "no limits",
                        "Online",
                        "Gosuslugi",
                        "You will need a Russian passport or SNILS",
                        "With a Sber bank card",
                        "With a Sber bank card",
                        "T-bank",
                        "With a T-bank card",
                        "In person",
                        "Betting shop",
                        "An identification document will be required"
                        )));
    }
    @Tags({
            @Tag("S4"),
            @Tag("SMOK")
    })
    @MethodSource
    @DisplayName("Проверка отображения способов полной идентификации и их переводов")
    @ParameterizedTest(name = "[{index}] Язык: {0}, Ожидаемый заголовок: {1}")
    void testIdentification(Language language, String value, List<String> expectedTexts) {
        identificationPage.changingTheLanguage(language.name());
        identificationPage.setIdentStatus(value);
        identificationPage.transfersPage(expectedTexts);
    }
}

