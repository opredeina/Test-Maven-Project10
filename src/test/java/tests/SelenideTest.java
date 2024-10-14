package tests;


import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
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


public class SelenideTest {

  @Test
  @Owner("Olesya Predeina")
  @Feature("Страница репозитория")
  @Story("Элементы на странице репозитория")
  @Severity(SeverityLevel.NORMAL)
  @DisplayName("Тест: Selenide с Listener")
  @Link(name = "GitHub", url = "https://github.com")

  public void testIssueSearch() {
    SelenideLogger.addListener("allure", new AllureSelenide());

    open("https://github.com");

    $(".header-search-input").click();
    $(".header-search-input").sendKeys("eroshenkoam/allure-example");
    $(".header-search-input").submit();

    $(linkText("eroshenkoam/allure-example")).click();
    $("#issues-tab").click();
    $(withText("#80")).should(Condition.exist);

  }
}
