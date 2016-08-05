package com.example.pprgramacion5a.formulario;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Basehelper extends SQLiteOpenHelper{

    String tabla="CREATE TABLE Persona(Id INTEGER PRIMARY KEY AUTOINCREMENT,Nombre Text, Apellido Text,Edad INTEGER)";

    public Basehelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
