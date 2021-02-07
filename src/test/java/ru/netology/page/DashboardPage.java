package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
  private SelenideElement heading = $("[data-test-id=dashboard]");
  private ElementsCollection cardsButton = $$("[data-test-id=action-deposit]");
  private SelenideElement reloadButton = $("[data-test-id=action-reload]");
  private ElementsCollection cardsInfo = $$(".list__item");

  public DashboardPage() {
    heading.shouldBe(visible);
  }

  public TransferPage clickTransfer(int numberCard) {
    cardsButton.get(numberCard).click();
    return new TransferPage();
  }

  public void clickReload() {
    reloadButton.click();
  }

  public void checkBalance(int numberCard, String newBalance) {
    cardsInfo.get(numberCard).shouldHave(text(newBalance));
  }

  public String getBalance(int numberCard) {
    String cardInfo = cardsInfo.get(numberCard).getText();
    final Pattern pattern = Pattern.compile(": (-?\\d+.?\\d+)");
    final Matcher matcher = pattern.matcher(cardInfo);
    matcher.find();
    return matcher.group(1);
  }
}
