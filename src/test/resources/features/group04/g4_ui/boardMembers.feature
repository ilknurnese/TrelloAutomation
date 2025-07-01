Feature: Board Üye işlemleri

  @BoardMemberTest
  Scenario: Board Oluşturma ve Üye işlemleri yapma
#    Kullanıcı giriş yapar
    Given kullanici login sayfasina gider
    When kullanici gecerli bilgilerle giris yapar
    Then kullanici basarili sekilde giris yaptigini dogrular
#    Kullanıcı board oluşturur
    When kullanici "Üye İşlemleri" isimli yeni bir board olusturur
    Then kullanici olusturulan "Üye İşlemleri" isimli board'u dogrular
#    Kullanıcı isim ile üye ekler
    Given kullanıcı "Üye İşlemleri" isimli boardda üye ekleme ekranına gelir
    When kullanıcı "Zuhal Şeker" üyesini "isim" verisini girerek ekler
    Then Kullanıcı "Zuhal Şeker" isimli üyenin eklendiğini doğrular
    Then Testrail case C 185 is updated automatically
#    Kullanıcı isim ile üye siler
    Given kullanıcı "Üye İşlemleri" isimli boardda üye ekleme ekranına gelir
    When kullanıcı eklenen "Zuhal Şeker" isimli üyeyi üye listesinden siler
    Then kullanıcı "Zuhal Şeker" isimli üyenin silindiğini doğrular
    Then Testrail case C 187 is updated automatically
#    Kullanıcı mail ile üye ekler
    Given kullanıcı "Üye İşlemleri" isimli boardda üye ekleme ekranına gelir
    When kullanıcı "aliveli@abc.com" üyesini "mail" verisini girerek ekler
    Then Kullanıcı "aliveli" isimli üyenin eklendiğini doğrular
    Then Testrail case C 184 is updated automatically
#    Kullanıcı oluşturduğu board u siler
    When kullanici "Üye İşlemleri" isimli board'u kapatir ve siler
    Then kullanici "Üye İşlemleri" isimli board'un silindigini dogrular

