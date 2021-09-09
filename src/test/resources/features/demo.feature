Feature: Sistem, herhangi bir kullanıcının geçerli kimlik bilgileriyle kaydolmasına ve alisveris yapmasina izin vermelidir
@registration
  Scenario: TC_001_Kullanici trendyol' üye olabilmeli ve ürün aramasi yapabilmeli ve kasaya gidebilmeli.

  Given Kullanıcı "trendyol_url" anasayfasına gider
  Then Imleci einlogen dropdown üzrine getirir
  Then Einmelden dropdown'a tiklar
  Then Kullanici "Hallo/Willkommen," yazisini ekranda görmeli
  Then E-mail text box'na gecerli e-mail girer
  Then Password text box'ına geçerli password girilir
  Then Kullanici Männlich butonuna tiklar
  And  Kullanici checkbox'a tiklar
  Then Kullanici registration butonuna tiklar
  Then Kullanici "Konto" yazisini görmeli
  Then Kullanici searcbox'a "kinder" aramasi yapar
  #Then Kullanici begendigi ürünleri fav'a ekler
  Then Kullanici begendigi ürüne tiklar
  Then Kullanici yas araligini secer
  Then Kullanici inden waren korb butonuna tiklar
  Then Urun sepetine tiklar
  Then Kullanici cupon kodunu text box'a girer ve Zur Kasse butonuna tiklar



