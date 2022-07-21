# Yazlab2 2. Proje


#Rota Planlama Problemi


# Özet

Yazılım Labaratuvarı 2 dersi 1. projesi kapsamıda çok katmanlı bir mobil uygulama geliştirmemiz istenmiştir.Bu proje ile birlikte gerçek dünya ihtiyaçlarını karşılayacak bazı yetenekler kazandırılacaktır.Bunların başlıcaları algoritma çözümleme,araştırma ve mobil yazılım konularıdır.Bunun dışında bir mobil uygulamasının kütüphaneleri,alt yapısının öğrenilmesi ve uygulanması ,veri tabanlarının kullanılması ve veri tabanı tasarımı konuları da büyük önem teşkil etmektedir.

# Giriş

Projede bizden istenilen Kocaeli’nin ilcelerinden Kocaeli Universitesine gelen servis aracları icin yolcu ve rota planlaması yapmamızdır. Yolculardan talep alınarak isletilen bu sistemde yolcular i¸cin dinamik olarak rota planlamaları yapılacaktır. Belirli arac ve durak sayısı bilgilerinin, duraklardaki yolcu sayısı bilgisi ile birlestirilerek en optimum rotaların olusturulması hedeflenmektedir. Bunu yaparken aracların kiralama maliyeti ve yakıt tuketiminin de hesaplanarak yol-maliyet optimizasyonu da yapılması beklenmektedir.

# Yöntem

Program Java programlama dilinde geliştirilmiştir.Geliştirme ortamı olarak Android Studio kullanılmıştır.Veri tabanı yönetimi sistemi için SQLite kullandık.Projemize başlarken öncelikle yol haritamızı çıkardık.Projenin isterlerini analiz edip bu isterler üzerine
araştırmalar yaptık.Bu araştırmalarımızda öncelikle kullanacağımız dile karar verdik.Öncelikle kotlinle yazmayı düşündük.Bu konuda javada karar verdik.Sonra database’e karar verdik.Öncelikle firebase kullanmayı düşündük.Ama Sqlite da karar kıldık.Database de kullandığımız tablolar

## Users
username ve password u alarak kullanıcı giriş tutulur.Bu sayede hangi kullanıcının girdiği kontrol edilir


## Araclar
(name ve kullanici_sayisi).Araçlar ve araçların taşıyabileceği kişi adeti tutulur.Bu sayede araçlara binebilecek kişilerin adetine göre yolcu alımı yapılabilir.

## Duraklar
(name,bekleyen_Sayisi,Lat,Long)Duraklardaki kiş adetleri duraklara gelebilecek otobüsler için hazır tutulur.


# Classlar

## AdminAraclarActivity:
Admin için araçların girilmesini tutar

### AdminDuraklarActivity:
Admin için durakların girilmesini tutar AdminMapActivity:Adminin mapini gösterir

### AdminSecimActivity:
Admin için duraklar ve araçlar sayfasına yönlendirme yapar. DBHelper:Database işlemelerinin yapıldığı classdır.

## LoginActivity:
Kullanıcı girişinin yapıldığı classdır.

## RegisterActivity:
Yeni bir kullanıcı eklenebilecek classdır RotaCalActivity:Rota çizdirmesi gereken classdır

## UserActivity:
User için map ve durak seçimine yönlendirme yapan classdır. 

## UserDuraklarActivity:
Durak seçimi yapılan classdır

## UserMapActivity:
Kullanıcı mapinin gösterildiği classdır. 

# Deneysel Sonuçlar:
![image](https://user-images.githubusercontent.com/58952369/180178890-12ca1348-8cac-4166-8f8b-de835fd67cc4.png)

![image](https://user-images.githubusercontent.com/58952369/180178919-4e2594c9-15e0-4119-9b2d-33211069de30.png)

![image](https://user-images.githubusercontent.com/58952369/180178964-9c01c617-f256-411e-8492-5e0dc02afbb3.png)

![image](https://user-images.githubusercontent.com/58952369/180178984-e3e6a056-bf37-40a9-bc5f-0f225305da49.png)




# VI. KAYNAKÇA 

https://www.youtube.com/ https://stackoverflow.com/

https://www.geeksforgeeks.org 

https://developers.google.com/maps/documentation/javascript/ 

www.w3schools.com/

https://www.sqlite.org
