package com.terbiyecisi.android.mydatabaseuygulamasi;

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

            while (cursor != null) {

                System.out.println("Name: " + cursor.getString(nameIx));
                System.out.println("Age: " + cursor.getInt(ageIx));

                cursor.moveToNext();

            }

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}
