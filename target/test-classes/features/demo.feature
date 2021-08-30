Feature: Sistem, herhangi bir kullanıcının geçerli kimlik bilgileriyle kaydolmasına ve alisveris yapmasina izin vermelidir
@registration
  Scenario: TC_001_Kullanici trendyol' üye olabilmeli ve ürün aramasi yapabilmeli ve kasaya gidebilmeli.

  Given Kullanıcı "trendyol_url" anasayfasına gider
  Then imleci einlogen dropdown üzrine getirir
  Then einmelden dropdown'a tiklar
  Then Kullanici "Hallo/Willkommen," yazisini ekranda görmeli
  Then email text box gecerli e-mail girer
  Then password text box ına geçerli password girilir
  Then the user Männlich butonuna tiklar
  And  kullanici checkbox'a tiklar
  Then kullanici registration butonuna tiklar
  Then kullanici "Konto" yazisini görmeli
  Then kullanici searcbox'a "kinder" aramasi yapar
  Then kullanici begendigi ürünleri fav'a ekler
  Then Kullanici yas araligini secer
  Then kullanici inden waren korb butonuna tiklar
  Then araba urun sepetine tiklar
  Then Kullanici cupon kodunu text box'a girer ve Zur Kasse butonuna tiklar



