Feature: Kullanici girisi

  @group4_login
  Scenario: C1122 - Gecerli bilgilerle kullanici girisi
    Given kullanici login sayfasina gider
    When kullanici gecerli bilgilerle giris yapar
    Then kullanici basarili sekilde giris yaptigini dogrular
    Then Testrail case C 1122 is updated automatically on login page