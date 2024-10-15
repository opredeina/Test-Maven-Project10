package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.WebSteps;


public class StepAnnotatedTest {

  private static final String REPOSITORY = "eroshenkoam/allure-example";
  private static final int ISSUE = 80;


  @Test
  @Feature("Страница репозитория")
  @Story("Элементы на странице репозитория")
  @DisplayName("Тест: Шаги с аннотацией @Step")
  @Link(name = "GitHub", url = "https://github.com")

  public void testAnnotatedSteps() {
    SelenideLogger.addListener("allure", new AllureSelenide());
    WebSteps steps = new WebSteps();

    steps.openMainPage()
        .searchForRepository(REPOSITORY)
        .clickOnRepositoryLink(REPOSITORY)
        .openIssuesTab()
        .souldSeeIssueWithNumber(ISSUE);
  }

}
