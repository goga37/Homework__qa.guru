package lesson10;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

        @Step("Открываем главную страницу")
        public WebSteps openMainPage() {
            open("https://github.com");

            return this;
        }

        @Step("Ищем репозиторий {repo}")
        public WebSteps searchForRepository(String repo) {
            $(".search-input").click();
            $("#query-builder-test").setValue(repo).pressEnter();

            return this;
        }

        @Step("Кликаем по ссылке репозитория")
        public WebSteps clickOnRepositoryLink() {
            $("[href='/selenide/selenide']").click();

            return this;
        }

        @Step("Открываем и проверяем таб Issues")
        public WebSteps openIssuesTab() {
            $("[data-content=Issues]").click();
            $("#repo-content-turbo-frame").shouldHave(text("New issue"));

            return this;
        }

}
