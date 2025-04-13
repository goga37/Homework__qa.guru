package lesson10;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AnnotationTest {
    private static final String REPOSITORY = "selenide/selenide";

    WebSteps webSteps = new WebSteps();

    @Test
    public void testAnnotatedStep() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        webSteps.openMainPage()
                .searchForRepository(REPOSITORY)
                .clickOnRepositoryLink()
                .openIssuesTab();

    }
}