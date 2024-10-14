package steps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

public class WebSteps {

  @Step("Открываем главную страницу Github")
  public WebSteps openMainPage() {
    open("https://github.com");

    return this;
  }

  @Step("Ищем репозиторий {repository}")
  public WebSteps searchForRepository(String repository) {
    $(".header-search-input").click();
    $(".header-search-input").sendKeys(repository);
    $(".header-search-input").submit();

    return this;
  }

  @Step("Кликаем по ссылке репозитория {repository}")
  public WebSteps clickOnRepositoryLink(String repository) {
    $(linkText(repository)).click();

    return this;
  }

  @Step("Открываем таб Issues")
  public WebSteps openIssuesTab() {
    $("#issues-tab").click();

    return this;
  }

  @Step("Проверяем наличие Issue с номером {issue}")
  public WebSteps souldSeeIssueWithNumber(int issue) {
    $(withText("#" + issue)).should(Condition.exist);

    return this;
  }

}
