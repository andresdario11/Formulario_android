package com.example.pprgramacion5a.formulario;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Segunda extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargar();
    }

    public void cargar() {
        Basehelper basehelper = new Basehelper(this, "DEMO", null, 1);
        SQLiteDatabase db = basehelper.getReadableDatabase();
        if (db != null) {
            Cursor c=db.rawQuery("select * from Persona",null);
            int cantidad=c.getCount();
            int i=0;
            String[] arreglo=new String[cantidad];
            if(c.moveToFirst()){
                do {
                    String linea=c.getInt(0)+" " +c.getString(1)+" "+ c.getString(2)+" "+c.getString(3);
                    arreglo[i]=linea;
                    i++;

                }while (c.moveToNext());
            }
            ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arreglo);
            ListView lista=(ListView) findViewById(R.id.Lista);
            lista.setAdapter(adapter);
        }
    }
}

