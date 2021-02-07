package ru.netology.data;

import lombok.Value;

public class DataHelper {
  private DataHelper() {}

  @Value
  public static class AuthInfo {
    private String login;
    private String password;
  }

  public static AuthInfo getAuthInfo() {
    return new AuthInfo("vasya", "qwerty123");
  }

  public static AuthInfo getOtherAuthInfo(AuthInfo original) {
    return new AuthInfo("petya", "123qwerty");
  }

  @Value
  public static class VerificationCode {
    private String code;
  }

  public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
    return new VerificationCode("12345");
  }

  @Value
  public static class TransferInfo {
    private String money;
    private String numberCard;
  }
  public static TransferInfo getTransferInfo01() {
    return new TransferInfo("200", "5559000000000001");
  }
  public static TransferInfo getTransferInfo02() {
    return new TransferInfo("200", "5559000000000002");
  }

}


