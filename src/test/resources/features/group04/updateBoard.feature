Feature: Kullanici mevcut board'u gunceller

  @group4_update
  Scenario: Kullanici mevcut board'u gunceller (kisa test)
    Given kullanici login olur
    When kullanici bir board'u gunceller
    Then kullanici guncellenen board'u dogrular
