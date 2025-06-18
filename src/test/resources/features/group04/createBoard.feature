Feature: Kullanici yeni bir board olusturur

  @group4_create
  Scenario: Gecerli bilgilerle yeni board olusturma
    Given kullanici Trello anasayfasina login olur
    When kullanici yeni bir board olusturur
    Then kullanici board'un basariyla olustugunu dogrular
