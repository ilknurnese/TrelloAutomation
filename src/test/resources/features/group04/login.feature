Feature: Kullanici girisi

  @group4_login
  Scenario: Gecerli bilgilerle kullanici girisi
    Given kullanici login sayfasina gider
    When kullanici gecerli bilgilerle giris yapar
    Then kullanici basarili sekilde giris yaptigini dogrular
