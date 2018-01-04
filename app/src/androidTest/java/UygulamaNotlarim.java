/**
Created by Ali GEÇER on 30.12.2017
 http://android.terbiyecisi.com/ornek-uygulamalar/my-database-uygulamasi/

 Veritabanı ve tablo oluşturma;
 Tabloya veri ekleme;
 Cursor oluşturma;
 Cursor u tablo içerisinde While döngüsü ile gezdirme;
 Tablo içerisindeki verileri Logcat ekranına yazdırma;
 SQL komutları ile çekilecek verileri filtreleme;
 SQL komutları ile verileri silme ve güncelleme;
 Öncelikle boş bir aktivite oluşturuyorum. Bu oluşturduğum yeni uygulamaya My Database adını verdim.

 Uygulama oluşturulup build işlemi tamamlandığında MainActivity.java dosyasının içeriği şu şekildedir.

 package com.example.android.mydatabase;

 import android.database.sqlite.SQLiteDatabase;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;

 public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

}
}
 Adım 1: Veritabanını oluşturma.
 onCreate metodu içerisine yeni database imi oluşturacak ya da mevcut ise açacak olan şu kodu yazıyorum.

 SQLiteDatabase myDatabase = this.openOrCreateDatabase("Musicians", MODE_PRIVATE, null);
 Bu kod uygulamamız içerisinde bize Musicians adında yeni bir database oluşturur. Bunu bir excel dosyası oluşturmak olarak düşünebilirim. Yukarıdaki bu kod ile excel dosyamızı yaratmış oldum. Bu excel dosyamın adına Musicians adını verdim, bu ismi oluşturmak istediğim uygulamaya göre istediğim bir isim ile değiştirebilirim.

 MainActivity.java dosyasının son hali şu şekildedir.

 package com.example.android.mydatabase;

 import android.database.sqlite.SQLiteDatabase;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;

 public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

SQLiteDatabase myDatabase = this.openOrCreateDatabase("Musicians", MODE_PRIVATE, null);

}
}
 Adım 2: Veritabanımız içerisinde tablo ve tablo içerisinde sütun oluşturma.
 Şimdi az önce oluşturduğum excel dosyası içerisine bir muzisyenler adında bir sheet & sayfa oluşturup, bu sheet içersinde isimleri name ve age olan 2 sütun yaratacağım. onCreate metodu içeriside aşağıdaki kod ile bu işlemi yapıyorum.

 myDatabase.execSQL("CREATE TABLE IF NOT EXISTS muzisyenler(name VARCHAR, age INT(2))");
 Bu kod ile Musicians databaseim içerisine muzisyenler adında bir sheet yani yeni sayfa oluşturdum ve bu sayfada 2 adet sütun tanımladım. Bu sütunların birinin adı name, diğeri ise age.
 name sütununun tipi VARCHAR, age sütununun tipi iseen fazla 2 basamaklı INT olduğunu belirttim.

 MainActivity.java dosyasının son hali şu şekildedir.

 package com.example.android.mydatabaseuygulamasi;

 import android.database.sqlite.SQLiteDatabase;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;

 public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

SQLiteDatabase myDatabase = this.openOrCreateDatabase("Musicians", MODE_PRIVATE, null);

myDatabase.execSQL("CREATE TABLE IF NOT EXISTS muzisyenler (name VARCHAR, age INT(2))");

}
}
 Adım 3: Veritabımıza veri ekleme.
 Şu ana kadar elimizde bir database ve bu database içerisinde bulunan bir tablomuz mevcut. Geldik bu tablomuz içerisinde yer alan sütunlar için data yani veri eklemeye.

 myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('James', 50)");
 Bu kod ile muzisyenler tablomun içerisinde yer alan name ve age sütununa sırasıyla James ve 50 değerlerini ekledim.

 MainActivity.java dosyasının son hali şu şekildedir.

 package com.example.android.mydatabaseuygulamasi;

 import android.database.sqlite.SQLiteDatabase;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;

 public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

SQLiteDatabase myDatabase = this.openOrCreateDatabase("Musicians", MODE_PRIVATE, null);
myDatabase.execSQL("CREATE TABLE IF NOT EXISTS muzisyenler (name VARCHAR, age INT(2))");
myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('James', 50)");

}
}
 Adım 4: try, catch sınıfı ile hata ayıklama.
 Android Studio içerisinde veritabanı işlemleri yaparken SQLite kodlarını elle manuel olarak yazmak zorunda olduğumuz için ve bu kodlar ile ilgili bir hata denetimi şu anda kullanmakta olduğumuz Android Studio versiyonunda yapılamadığı için; veritabanı işlemleri yaparken yazdığımız kodlarda hata denetimi yaparken try and catch sınıflarını kullanacağız.
 try, catch, finally ile ilgili yazıma burayı tıklayarak ulaşabilirsiniz.

 onCreate metodu içerisinde şu şablonu kullanarak try, catch bloğumu oluşturuyorum.

 try {

 } catch (Exception e) {

 e.printStackTrace();

 }
 Şimdi ise veritabanı işlemleri için yazdığım tüm kodları try bloğuna taşıyorum.

 try {

 SQLiteDatabase myDatabase = this.openOrCreateDatabase("Musicians", MODE_PRIVATE, null);
 myDatabase.execSQL("CREATE TABLE IF NOT EXISTS muzisyenler (name VARCHAR, age INT(2))");
 myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('James', 50)");

 } catch (Exception e) {

 e.printStackTrace();

 }
 MainActivity.java dosyasının son hali şu şekildedir.

 package com.example.android.mydatabaseuygulamasi;

 import android.database.sqlite.SQLiteDatabase;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;

 public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

try {

SQLiteDatabase myDatabase = this.openOrCreateDatabase("Musicians", MODE_PRIVATE, null);
myDatabase.execSQL("CREATE TABLE IF NOT EXISTS muzisyenler (name VARCHAR, age INT(2))");
myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('James', 50)");

} catch (Exception e) {

e.printStackTrace();

}
}
}
 Bu hali ile programımızı çalıştırabiliriz. Ekrana hiçbir şey gelmeyecektir. Ancak arka planda bizim database imiz, tablomuz ve sütunlarımız yaratılıp, bu sütunlara verilerimiz eklenmiş olacaktır.

 Veritabanından veri çekme.
 Eğer yukarıdaki işlemler ile verilerimizi düzgün bir şekilde veritabanımıza ekleyebildiysek, şimdi o verileri nasıl çekeceğimizi ve kullanacağımıza geçelim.

 Adım 5: Veri ekleyen kod satırını pasif etme.
 Öncelikle daha önce 18. satırda bulunan aşağıdaki kod satırının;

 myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('James', 50)");
 satır başına // koyarak pasif hale getiriyorum ki programı her çalıştırdığımda veritabanına tekrar tekrar aynı veri kayıt edilmesin. Bu kod satırını pasif hale getirmeden önce uygulamamız en az 1 kere çalıştırılmış olmalı.

 MainActivity.java dosyasının son hali şu şekildedir.

 package com.example.android.mydatabaseuygulamasi;

 import android.database.sqlite.SQLiteDatabase;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;

 public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

try {

SQLiteDatabase myDatabase = this.openOrCreateDatabase("Musicians", MODE_PRIVATE, null);
myDatabase.execSQL("CREATE TABLE IF NOT EXISTS muzisyenler (name VARCHAR, age INT(2))");
//myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('James', 50)");

} catch (Exception e) {

e.printStackTrace();

}
}
}
 Adım 6: Cursor oluşturma.
 Verileri toplamak için Cursor adında bir obje kullanacağız. Cursor dediğimiz şeyi bir işaretçi gibi düşünebiliriz. Örneğin mouse umuzun imleci gibi. Bu Cursor umuzu alıcaz ve oluşturduğumuz tablo içerisinde satır satır gezdireceğiz.
 1. satır, 2. satır, 3.satır... tek tek bu verilerin üzerinde gezdireceğim ve okutacağım ve böylece verilerime ulaşabileceğim.

 onCreate metodu içerisinde aşağıdaki ile Cursor umuzu yaratalım.

 Cursor cursor = myDatabase.rawQuery("SELECT * FROM muzisyenler", null);
 Bu kod ile Cursor objesinden cursor adında bir Cursor türetip, bu cursor a veritabanım içerisindeki muzisyenler tablosuna gidip tüm satırları gezecek olan cursor nesnemi yaratmış oldum.

 MainActivity.java dosyasının son hali şu şekildedir.

 package com.example.android.mydatabaseuygulamasi;

 import android.database.Cursor;
 import android.database.sqlite.SQLiteDatabase;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;

 public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

try {

SQLiteDatabase myDatabase = this.openOrCreateDatabase("Musicians", MODE_PRIVATE, null);
myDatabase.execSQL("CREATE TABLE IF NOT EXISTS muzisyenler (name VARCHAR, age INT(2))");
//myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('James', 50)");

Cursor cursor = myDatabase.rawQuery("SELECT * FROM muzisyenler", null);

} catch (Exception e) {

e.printStackTrace();

}
}
}
 Adım 7: Sütun ya da kolon index i oluşturma.
 Bir önceki adımda cursor umuzu oluşturmuştuk, şimdi ise bizim tablomuz içerisinde yer alan name ve age sütunlarımız için birer kolon&sütun index i oluşturmamız gerekiyor. Bu indexleri aşağıdaki şu kodlar ile oluşturuyorum.

 int nameIx = cursor.getColumnIndex("name");
 int ageIx = cursor.getColumnIndex("age");
 Bu kodlar ile olarak tablom içerisinde yer alan name sutunu için nameIx ve age sütunu için ise ageIx indexlerini oluşturmuş oluyorum. Burada dikkat etmemiz gereken şey getColumnIndex(); içerisindeki isimler ile daha önce oluşturduğumuz tablo içerisindeki sütun isimlerinin aynı olmasıdır.

 MainActivity.java dosyasının son hali şu şekildedir.

 package com.example.android.mydatabaseuygulamasi;

 import android.database.Cursor;
 import android.database.sqlite.SQLiteDatabase;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;

 public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

try {

SQLiteDatabase myDatabase = this.openOrCreateDatabase("Musicians", MODE_PRIVATE, null);
myDatabase.execSQL("CREATE TABLE IF NOT EXISTS muzisyenler (name VARCHAR, age INT(2))");
//myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('James', 50)");

Cursor cursor = myDatabase.rawQuery("SELECT * FROM muzisyenler", null);
int nameIx = cursor.getColumnIndex("name");
int ageIx = cursor.getColumnIndex("age");

} catch (Exception e) {

e.printStackTrace();

}
}
}
 Adım 8: While döngüsü ile cursor u satır satır gezdirip verileri okutma.
 Önceki adımlarda cursor umuzu ve kolon index lerimizi oluşturmuştuk. Cursor umuzu tablomuzun her kolonunu satır satır gezip verileri okuması için while döngüsü içerisine sokacağız.
 Ancak cursor umuzu while döngüsüne sokmadan önce aşağıdaki kod ile tablomuzun başlangıç noktasına taşımamız ve oradan başlayarak while döngüsüne başlatmalıyız.
 Cursor umuzu tablomuzun başlagıç noktasına şu kod ile taşıyoruz.

 cursor.moveToFirst();
 Şimdi tablomuzun ilk satır ve sütununa taşıdığımız cursor umuzu while döngüsüne sokarak tabloda yer alan tüm verileri toplamasını ve devamında android studio log ekranına bu verileri yazdırmasını aşağıdaki kod ile sağlayacağız.

 while (cursor != null){

 System.out.println("Name: " + cursor.getString(nameIx));
 System.out.println("Age: " + cursor.getInt(ageIx));

 cursor.moveToNext();

 }
 Bu while döngüsünü biraz açmak gerekirse; anlam olarak şunu ifade etmektedir.
 while (cursor != null) // cursor umuz boş değilken bunu yap demektir. Değer olduğu sürece yani cursor boş bir satıra gelmediği sürece blok içerisindeki işlemleri yap demektir.

 System.out.println("Name: " + cursor.getString(nameIx)); // bu kod ise şu işlemi yapmaktadır. "Name: " yaz, cursor.getString(nameIx) // cursor un gezip veri okuduğu nameIx içerisindeki string ile birleştir ve android studio log ekranına yazdır.

 cursor.moveToNext(); // cursor u bir sonraki satıra ya da kayıt üzerine taşı ve while döngüsü kontrol ifadesi ile devam et.

 Adım 8 içerisinde yazdığımız kodlardan sonra MainActivity.java dosyasının son hali şu şekildedir.

 package com.example.android.mydatabaseuygulamasi;

 import android.database.Cursor;
 import android.database.sqlite.SQLiteDatabase;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;

 public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

try {

SQLiteDatabase myDatabase = this.openOrCreateDatabase("Musicians", MODE_PRIVATE, null);
myDatabase.execSQL("CREATE TABLE IF NOT EXISTS muzisyenler (name VARCHAR, age INT(2))");
//myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('James', 50)");

Cursor cursor = myDatabase.rawQuery("SELECT * FROM muzisyenler", null);
int nameIx = cursor.getColumnIndex("name");
int ageIx = cursor.getColumnIndex("age");

cursor.moveToFirst();

while (cursor != null){

System.out.println("Name: " + cursor.getString(nameIx));
System.out.println("Age: " + cursor.getInt(ageIx));

cursor.moveToNext();

}

} catch (Exception e) {

e.printStackTrace();

}
}
}
 Adım 9: Uygulamanın çalıştırılması ve android studio log ekranında verilerin takibi.
 Buraya kadar yaptıklarımızla artık uygulamamızı tekrar çalıştırabiliriz. Şu ana kadar tablomuzda pasif halde beklettiğimiz 19. satır nedeniyle sadece bit kayıt mevcut, eğer siz bu 19. satır ı daha önce pasif hale getirmeden birden çok kez build ederek çalıştırmış isek, Logcat ekranında o kadar sayıda aynı kayıttan göreceksinizdir. Biz programı hazırlarken sadece 1 kere veri ekleme kodunu aktif bıraktığımız için aşağıdaki resimde göründüğü üzere log ekranımda sadece 1 kayıt ve o kayıt a ait yaş bilgisi dönmekte.



 Logcat ekranına yazdırarak takip ettiğiniz verileri kolay olarak bulmanız için arama kutusuna I/System.out: yazarsanız çıktıları daha kolay bulabilirsiniz.

 Adım 10: SQL komutları ile veri filtreleme.
 Şu an için tablomuzda sadece 1 isim ve 1 yaş verisi var. SQL Filtre işlemlerinde geniş bir çalışma için daha fazla veriye ihtiyacımız var. Bu nedenle daha önce pasif hale getirdiğimiz ve tablomuza veri eklemeye yarayan 19. satırdaki kodumuzu aktif hale getirip, aynı kodu birkaç defa kopya yapıştır yapıp her bir kod satırı içerisindeki name ve yaş bilgisini farklı isim ve yaş ile oluşturalım. Ben veri çoğaltma için şu kodları kullandım.

 myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Ali', 10)");
 myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Veli', 5)");
 myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Deli', 11)");
 myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Ayşe', 2)");
 myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Fatma', 20)");
 myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Hayriye', 30)");
 myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Zeki', 22)");
 myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Metin', 65)");
 myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Çetin', 17)");
 myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Cihan', 7)");
 myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Görkem', 40)");
 Bu kodları ekleyerek programımızı bir kere daha çalıştırıyoruz ve bu verilerinde tablomuza eklenmesini sağlıyoruz.

 MainActivity.java dosyasının son hali şu şekildedir.

 package com.example.android.mydatabaseuygulamasi;

 import android.database.Cursor;
 import android.database.sqlite.SQLiteDatabase;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;

 public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

try {

SQLiteDatabase myDatabase = this.openOrCreateDatabase("Musicians", MODE_PRIVATE, null);
myDatabase.execSQL("CREATE TABLE IF NOT EXISTS muzisyenler (name VARCHAR, age INT(2))");
myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Ali', 10)");
myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Veli', 5)");
myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Deli', 11)");
myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Ayşe', 2)");
myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Fatma', 20)");
myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Hayriye', 30)");
myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Zeki', 22)");
myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Metin', 65)");
myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Çetin', 17)");
myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Cihan', 7)");
myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Görkem', 40)");

Cursor cursor = myDatabase.rawQuery("SELECT * FROM muzisyenler", null);
int nameIx = cursor.getColumnIndex("name");
int ageIx = cursor.getColumnIndex("age");

cursor.moveToFirst();

while (cursor != null){

System.out.println("Name: " + cursor.getString(nameIx));
System.out.println("Age: " + cursor.getInt(ageIx));

cursor.moveToNext();

}

} catch (Exception e) {

e.printStackTrace();

}
}
}
 Adım 11: Veri eklediğimiz komutları tekrar pasif ediyoruz.
 Programımız her çalıştığında tekrar tekrar tablomuza aynı verilerin eklenmemesi için 10.adımda yaptığımız ve veri eklememize yarayan tüm kodları  başlarına // işareti koyarak yeniden pasif hale getiriyoruz.

 //            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Ali', 10)");
 //            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Veli', 5)");
 //            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Deli', 11)");
 //            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Ayşe', 2)");
 //            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Fatma', 20)");
 //            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Hayriye', 30)");
 //            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Zeki', 22)");
 //            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Metin', 65)");
 //            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Çetin', 17)");
 //            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Cihan', 7)");
 //            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Görkem', 40)");
 Adım 12: Verileri SQL komutları ile filtreleme (opsiyonel).
 Artık tablomuzda yaklaşık olarak 15 adet kayıt var ve şimdi bu 15 kayıdın tamamını değilde, çıktı olarak sadece istediğimiz özelliklere sahip kayıtları çıktı olarak yazdıracağız. Filtre ederken kullanacağımız SQL filtre komutlarını oluşturduğumuz cursor içerisindeki SQL komutunu modifiye ederek yapacağız

 Filtre 1: Bu filtre tablomuzdaki age değeri 50 den büyük olan kayıtları çekecektir.

 Cursor cursor = myDatabase.rawQuery("SELECT * FROM muzisyenler WHERE age > 50", null);
 Filtre 2:Bu filtre tablomuzdaki age değeri 50 den küçük olan kayıtları çekecektir.

 Cursor cursor = myDatabase.rawQuery("SELECT * FROM muzisyenler WHERE age < 50", null);
 Filtre 3:Bu filtre de birden fazla kriter ile tablomuzdaki age değeri 50 den küçük ve adı Ali olan kayıtları çekecektir. Burada dikkat etmemiz gereken VARCHAR tipindeki veri değerine sahip değeri çekerken filtre kriterimizi ' ' arasına yazmaktır.

 Cursor cursor = myDatabase.rawQuery("SELECT * FROM muzisyenler WHERE age < 50 AND name = 'Ali'", null);
 Filtre 4: Bu filtre name değeri içinde a harfi geçen tüm kayıtları çekecektir.

 Cursor cursor = myDatabase.rawQuery("SELECT * FROM muzisyenler WHERE name LIKE '%a%'", null);
 Filtre 5: Bu filtre name değeri R harfi ile başlayan tüm kayıtları çekecektir.

 Cursor cursor = myDatabase.rawQuery("SELECT * FROM muzisyenler WHERE name LIKE 'R%'", null);
 Filtre 6: Bu filtre name değeri k harfi ile biten tüm kayıtları çekecektir.

 Cursor cursor = myDatabase.rawQuery("SELECT * FROM muzisyenler WHERE name LIKE '%k'", null);
 Adım 13: SQL komutları ile Verileri silme (opsiyonel).
 Şimdi de tablomuzdan bizim belirlediğimiz kriter e sahip olan bir kaydın silinmesi için kullandığımız kodlara bakalım. Kodun yazılacağı yer değişken olup biz oluşturduğumuz Cursor üzerine yazarak denememizi yapacağız. Mevcut tablomuzda Ali adında bir kayıt var ve biz bu kaydı aşağıdaki kodu kullanarak tablomuzdan silebiliriz.

 myDatabase.execSQL("DELETE FROM muzisyenler WHERE name = 'Ali'");
 MainActivity.java dosyasının son hali şu şekildedir.

 package com.example.android.mydatabaseuygulamasi;

 import android.database.Cursor;
 import android.database.sqlite.SQLiteDatabase;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;

 public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

try {

SQLiteDatabase myDatabase = this.openOrCreateDatabase("Musicians", MODE_PRIVATE, null);
myDatabase.execSQL("CREATE TABLE IF NOT EXISTS muzisyenler (name VARCHAR, age INT(2))");
//            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Ali', 10)");
//            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Veli', 5)");
//            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Deli', 11)");
//            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Ayşe', 2)");
//            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Fatma', 20)");
//            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Hayriye', 30)");
//            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Zeki', 22)");
//            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Metin', 65)");
//            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Çetin', 17)");
//            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Cihan', 7)");
//            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Görkem', 40)");

myDatabase.execSQL("DELETE FROM muzisyenler WHERE name = 'Ali'");

Cursor cursor = myDatabase.rawQuery("SELECT * FROM muzisyenler", null);
int nameIx = cursor.getColumnIndex("name");
int ageIx = cursor.getColumnIndex("age");

cursor.moveToFirst();

while (cursor != null){

System.out.println("Name: " + cursor.getString(nameIx));
System.out.println("Age: " + cursor.getInt(ageIx));

cursor.moveToNext();

}

} catch (Exception e) {

e.printStackTrace();

}
}
}
 Bu hali ile programımızı çalıştırdığımızda artık çıktılar içerisinde Ali adında bir kayıt olmadığını görebiliriz.

 Adım 14: SQL komutları ile Veri güncelleme (opsiyonel).
 Şimdide tablomuzda bulunan bir verilerden istediğimiz bir kritere sahip olan veri için aşağıdaki kod ile güncellemesini yapalım.

 myDatabase.execSQL("UPDATE muzisyenler SET age = 55 WHERE name = 'Veli'");
 Bu SQL komutu ile de name değeri Veli olan kayıtlar bulunacak ve bu kayıtlara ait age değeri 55 e set edilecektir.

 MainActivity.java dosyasının son hali şu şekildedir.

 package com.example.android.mydatabaseuygulamasi;

 import android.database.Cursor;
 import android.database.sqlite.SQLiteDatabase;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;

 public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

try {

SQLiteDatabase myDatabase = this.openOrCreateDatabase("Musicians", MODE_PRIVATE, null);
myDatabase.execSQL("CREATE TABLE IF NOT EXISTS muzisyenler (name VARCHAR, age INT(2))");
//            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Ali', 10)");
//            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Veli', 5)");
//            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Deli', 11)");
//            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Ayşe', 2)");
//            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Fatma', 20)");
//            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Hayriye', 30)");
//            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Zeki', 22)");
//            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Metin', 65)");
//            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Çetin', 17)");
//            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Cihan', 7)");
//            myDatabase.execSQL("INSERT INTO muzisyenler (name, age) VALUES ('Görkem', 40)");

myDatabase.execSQL("DELETE FROM muzisyenler WHERE name = 'Ali'");
myDatabase.execSQL("UPDATE muzisyenler SET age = 55 WHERE name = 'Veli'");

Cursor cursor = myDatabase.rawQuery("SELECT * FROM muzisyenler", null);
int nameIx = cursor.getColumnIndex("name");
int ageIx = cursor.getColumnIndex("age");

cursor.moveToFirst();

while (cursor != null){

System.out.println("Name: " + cursor.getString(nameIx));
System.out.println("Age: " + cursor.getInt(ageIx));

cursor.moveToNext();

}

} catch (Exception e) {

e.printStackTrace();

}
}
}
 Tavsiyeler: Eğer sadece veritabanına dayalı bir uygulama yapmayı planlıyorsanız Google a SQLite yazarak arama yapmanızı ve SQLite a ait kullanabileceğiniz diğer komut ve kodları incelemenizi öneririm.

 Bu yaptığımız uygulamayı buraya tıklayarak github.com üzerindeki hesabımızdan indirip bilgisayarınızda çalıştırabilirsiniz.

 */