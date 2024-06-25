package com.example.sqliteogrenmeprojesi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
                val veritabani=this.openOrCreateDatabase("Urunler", Context.MODE_PRIVATE,null)
                veritabani.execSQL("CREATE TABLE IF NOT EXISTS urunler(id INTEGER PRIMARY KEY, isim VARCHAR,fiyat INT)")
               // veritabani.execSQL("INSERT INTO urunler(isim,fiyat) VALUES ('Kazak',100)")
              //  veritabani.execSQL("INSERT INTO urunler(isim,fiyat) VALUES ('Pantalon',120)")
              //  veritabani.execSQL("INSERT INTO urunler(isim,fiyat) VALUES ('Şapka',40)")
               val cursor =veritabani.rawQuery("SELECT * FROM urunler",null)
             //    val cursor =veritabani.rawQuery("SELECT * FROM urunler WHERE isim='Pantalon'",null)
           // val cursor =veritabani.rawQuery("DELETE FROM urunler WHERE id=3",null)
         //   val cursor =veritabani.rawQuery("UPDATE  urunler SET isim='Kazakk' WHERE id=5",null)
                val IdColumnIndex=cursor.getColumnIndex("id")
                val isimColumnIndex=cursor.getColumnIndex("isim")
                val fiyatColumnIndex=cursor.getColumnIndex("fiyat")
            while(cursor.moveToNext()){

                println("ID : ${cursor.getInt(IdColumnIndex)}")
                println("Isim : ${cursor.getString(isimColumnIndex)}")
                println("Fiyat : ${cursor.getInt(fiyatColumnIndex)}")
            }
            cursor.close()



        }catch (e:Exception){e.printStackTrace()}




    }
}