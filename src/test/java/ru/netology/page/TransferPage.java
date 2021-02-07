package ru.netology.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement moneyField = $("[data-test-id=amount] input");
    private SelenideElement cardField = $("[data-test-id=from] input");
    private SelenideElement confirmButton = $("[data-test-id=action-transfer]");

    public DashboardPage validTransfer(DataHelper.TransferInfo info) {
        moneyField.setValue(info.getMoney());
        cardField.setValue(info.getNumberCard());
        confirmButton.click();
        return Selenide.page(DashboardPage.class);
    }
}
