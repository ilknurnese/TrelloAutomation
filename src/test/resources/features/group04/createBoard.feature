Feature: Kullanici yeni bir board olusturur

  @group4_create @SmokeTest @RegressionTest
  Scenario: Kullanici yeni bir board olusturur (kisa test)
    Given kullanici login olur
    When kullanici yeni bir board olusturur
    Then kullanici olusturulan board'u dogrular
