package tests;


import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

import com.codeborne.selenide.Condition;
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

public class LambdaTest {

  private static final String REPOSITORY = "eroshenkoam/allure-example";
  static final int ISSUE = 80;

  @Test
  @Owner("Olesya Predeina")
  @Feature("Страница репозитория")
  @Story("Элементы на странице репозитория")
  @Severity(SeverityLevel.NORMAL)
  @DisplayName("Тест: Шаги с помощью лямбда-выражений (name, () -> {})")
  @Link(name = "GitHub", url = "https://github.com")

  public void testIssueSearch() {
    SelenideLogger.addListener("allure", new AllureSelenide());

    step("Открываем главную страницу", () -> {
    open("https://github.com");
    });
    step("Ищем репозиторий" + REPOSITORY, () -> {
    $(".header-search-input").click();
    $(".header-search-input").sendKeys(REPOSITORY);
    $(".header-search-input").submit();
    });
    step("Кликаем по ссылке репозитория" + REPOSITORY, () -> {
    $(linkText(REPOSITORY)).click();
    });
    step("Открываем таб Issues", () -> {
    $("#issues-tab").click();
    });
    step("Проверяем наличие Issue с номером" + ISSUE, () -> {
    $(withText("#" + ISSUE)).should(Condition.exist);
    });

  }
}

