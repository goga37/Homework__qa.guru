package lesson14.tests;


import lesson14.pages.AuthorizationUserPage;
import lesson14.pages.IdentificationPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static io.qameta.allure.Allure.step;

public class IdentificationTest extends TestBase {

    IdentificationPage identificationPage = new IdentificationPage();
    AuthorizationUserPage authorizationUserPage = new AuthorizationUserPage();
    TestData td = new TestData();

    @BeforeEach
    void authorizationUserMethod() {
        authorizationUserPage.authorizationUser("Телефон", "9681462678", "1234qwer");
    }

    @Tags({
            @Tag("S4"),
            @Tag("SMOKS")
    })
    @DisplayName("Проверка способов полной идентификации через Сбер и Т-Банк")
    @ParameterizedTest(name = "Идентификации с помощью {0}")
    @CsvSource(value = {
            "Сбер, Ожидаем данные от Сбера",
            "Т-Банк, Ожидаем данные от Т-банка"
    })
    void testIdentificationFlowSber(String type, String identifier) {
        step("Переходим на экран идентификации", () -> {
            identificationPage.setIdentStatus();
        });
        step("Выбираем способ полной идентификации", () -> {
            identificationPage.setIdentificationContent(type);
        });
        step("Переходим на выбранный способ идентификации", () -> {
            identificationPage.setRedirectButton();
        });
        step("Проверка текста плашки после перехода на выбранный способ идентификации", () -> {
            identificationPage.setIdentStatusNeed(identifier);
        });
    }

    @Tags({
            @Tag("S4"),
            @Tag("SMOKS")
    })
    @DisplayName("Проверка способа полной идентификации через Госуслуги (По паспорту РФ)")
    @Test
    void testIdentificationFlowGos() {
        step("Переходим на экран идентификации", () -> {
            identificationPage.setIdentStatus();
        });
        step("Выбираем способ полной идентификации", () -> {
            identificationPage.setIdentificationContent("Госуслуги");
        });
        step("Вводим Фамилию", () -> {
            identificationPage.setFormItem("Фамилия",td.lastName);
        });
        step("Вводим Имя", () -> {
            identificationPage.setFormItem("Имя",td.firstName);
        });
        step("Вводим Отчество", () -> {
            identificationPage.setFormItem("Имя",td.firstName);
        });
        step("Вводим Отчество", () -> {
            identificationPage.setFormItem("Отчество",td.patronymic);
        });
        step("Вводим Серию", () -> {
            identificationPage.setFormItem("Серия",td.seria);
        });
        step("Вводим Номер паспорта", () -> {
            identificationPage.setFormItem("Серия",td.numberPas);
        });
        step("Отправляем на проверку", () -> {
            identificationPage.setIdentFull();
        });
        step("Проверка текста плашки после перехода на выбранный способ идентификации", () -> {
            identificationPage.setIdentStatusNeed("Ожидаем данные от Госуслуг");
        });
    }

    @Tags({
            @Tag("S4"),
            @Tag("SMOKS")
    })
    @DisplayName("Проверка способа полной идентификации через Госуслуги (По номеру СНИЛС)")
    @Test
    void testIdentificationFlowSnils() {
        step("Переходим на экран идентификации", () -> {
            identificationPage.setIdentStatus();
        });
        step("Выбираем способ полной идентификации", () -> {
            identificationPage.setIdentificationContent("Госуслуги");
        });
        step("Выбираем таб По номеру СНИЛС", () -> {
            identificationPage.setCashidentFullTabsbox("По номеру СНИЛС");
        });
        step("Вводим СНИЛС", () -> {
            identificationPage.setFormItem("СНИЛС",td.snils);
        });
        step("Отправляем на проверку", () -> {
            identificationPage.setIdentFull();
        });
        step("Проверка текста плашки после перехода на выбранный способ идентификации", () -> {
            identificationPage.setIdentStatusNeed("Ожидаем данные от Госуслуг");
        });
    }

    @Tags({
            @Tag("S4"),
            @Tag("SMOKS")
    })
    @DisplayName("Проверка способа лично ППС")
    @Test
    void testIdentificationFlowPps() {
        step("Переходим на экран идентификации", () -> {
            identificationPage.setIdentStatus();
        });
        step("Выбираем способ полной идентификации", () -> {
            identificationPage.setIdentificationContent("Пункт приема ставок");
        });
        step("Проверка перехода на экран с адресами ППС", () -> {
            identificationPage.setCashbox("Адреса пунктов приема ставок");
        });
    }

    @Tags({
            @Tag("S4"),
            @Tag("SMOKS")
    })
    @DisplayName("Проверка способа упрощенной идентификации через Госуслуги")
    @Test
    void testIdentificationFlowSimplifiedPps() {
        step("Переходим на экран идентификации", () -> {
            identificationPage.setIdentStatus();
        });
        step("Выбираем таб Упрощенная", () -> {
            identificationPage.setIdentificationTabs("Упрощенная");
        });
        step("Выбираем способ упрощенной идентификации", () -> {
            identificationPage.setIdentificationContent("Госуслуги");
        });
        step("Переходим на выбранный способ идентификации", () -> {
            identificationPage.setRedirectButton();
        });
        step("Проверка текста плашки после перехода на выбранный способ идентификации", () -> {
            identificationPage.setIdentStatusNeed("Ожидаем данные от Госуслуг");
        });
    }

    @Tags({
            @Tag("S4"),
            @Tag("SMOKS")
    })
    @DisplayName("Проверка способа упрощенной идентификации через Загрузку документов")
    @Test
    void testIdentificationFlowSimplifiedDoc() {
        step("Переходим на экран идентификации", () -> {
            identificationPage.setIdentStatus();
        });
        step("Выбираем таб Упрощенная", () -> {
            identificationPage.setIdentificationTabs("Упрощенная");
        });
        step("Выбираем способ упрощенной идентификации", () -> {
            identificationPage.setIdentificationContent("Загрузить документы");
        });
        step("Загружаем Главный разворот паспорта", () -> {
            identificationPage.setUploadMain(td.uploadPicture);
        });
        step("Загружаем Разворот паспорта с регистрацией", () -> {
            identificationPage.setUploadReg(td.uploadPicture);
        });
        step("Загружаем Фото с главным разворотом", () -> {
            identificationPage.setUploadSelfi(td.uploadPicture);
        });
        step("Загружаем Фото с главным разворотом", () -> {
            identificationPage.setIn("ИНН",td.inn);
        });
        step("Проверяем, что кнопка отправить стала активна", () -> {
            identificationPage.setExpectedColor("#3ca059");
        });
    }
}