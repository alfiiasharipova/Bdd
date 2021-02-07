package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

class MoneyTransferTest {

  @Test
  void shouldTransferMoneyFromSecondCard() {
    val loginPage = open("http://localhost:9999", LoginPage.class);
    val authInfo = DataHelper.getAuthInfo();
    val verificationPage = loginPage.validLogin(authInfo);
    val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
    val dashboardPage = verificationPage.validVerify(verificationCode);
    val transferInfo = DataHelper.getTransferInfo02();
    int currentBalance = Integer.parseInt(dashboardPage.getBalance(0));
    val transferPage = dashboardPage.clickTransfer(0);
    transferPage.validTransfer(transferInfo);
    int newAmount = Integer.parseInt(transferInfo.getMoney());
    int newBalance =currentBalance+newAmount;
    dashboardPage.checkBalance(0, String.valueOf(newBalance));
  }

  @Test
  void shouldTransferMoneyFromFirstCard() {
    val loginPage = open("http://localhost:9999", LoginPage.class);
    val authInfo = DataHelper.getAuthInfo();
    val verificationPage = loginPage.validLogin(authInfo);
    val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
    val dashboardPage = verificationPage.validVerify(verificationCode);
    val transferInfo = DataHelper.getTransferInfo01();
    int currentBalance = Integer.parseInt(dashboardPage.getBalance(1));
    val transferPage = dashboardPage.clickTransfer(1);
    transferPage.validTransfer(transferInfo);
    int newAmount = Integer.parseInt(transferInfo.getMoney());
    int newBalance =currentBalance+newAmount;
    dashboardPage.checkBalance(1, String.valueOf(newBalance));
  }
}

