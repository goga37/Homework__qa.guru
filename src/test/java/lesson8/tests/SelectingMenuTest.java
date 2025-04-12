package lesson8.tests;
import lesson8.pages.SelectingMenuPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SelectingMenuTest extends TestBase {

    SelectingMenuPage selectingMenuPage = new SelectingMenuPage();


    @Tag("S4")
    @DisplayName("Проверка выбора пункта в меню")
    @ValueSource(strings = {
            "Линия",
            "Быстрые игры",
            "Результаты",
            "Информация",
            "Промо",
    })

    @ParameterizedTest( name = "Выбор пункта {0} в меню")
    void selectingMenuTest(String SearchMenu) {
        selectingMenuPage.openPage();
        selectingMenuPage.setMenu(SearchMenu);
        selectingMenuPage.shouldNotBanner();

    }
}
