Feature: Board Üye işlemleri

  @BoardMemberTest
  Scenario: Board Oluşturma ve Üye işlemleri yapma
    Given kullanici login sayfasina gider
    When kullanici gecerli bilgilerle giris yapar
    Then kullanici basarili sekilde giris yaptigini dogrular
    When kullanici "Üye İşlemleri" isimli yeni bir board olusturur
    Then kullanici olusturulan "Üye İşlemleri" isimli board'u dogrular
#    When kullanici bir board'u kapatir ve siler
#    Then kullanici board'un silindigini dogrular

