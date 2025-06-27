Feature: Kullanici board islemlerini gerceklestirir

  @group4_create
  Scenario: Kullanici yeni bir board olusturur
    Given kullanici login olur
    When kullanici yeni bir board olusturur
    Then kullanici olusturulan board'u dogrular

  @group4_update
  Scenario: Kullanici mevcut board'u gunceller
    Given kullanici login olur
    When kullanici bir board'u gunceller
    Then kullanici guncellenen board'u dogrular

  @group4_delete
  Scenario: Kullanici bir board'u siler
    Given kullanici login olarak silme islemi icin hazirlik yapar
    When kullanici bir board'u kapatir ve siler
    Then kullanici board'un silindigini dogrular