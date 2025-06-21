Feature: Kullanici board silme islemini gerceklestirir

  @group4_delete
  Scenario: Kullanici bir board'u siler
    Given kullanici login olarak silme islemi icin hazirlik yapar
    When kullanici bir board'u kapatir ve siler
    Then kullanici board'un silindigini dogrular
