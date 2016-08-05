package com.example.pprgramacion5a.formulario;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ET_Nombre, ET_Apellido, ET_Edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ET_Nombre = (EditText) findViewById(R.id.ET_Nombre);
        ET_Apellido = (EditText) findViewById(R.id.ET_Apellido);
        ET_Edad = (EditText) findViewById(R.id.ET_Edad);

    }

    public void guardar(View v) {
        String nombre = ET_Nombre.getText().toString();
        String apellido = ET_Apellido.getText().toString();
        int edad = Integer.parseInt(ET_Edad.getText().toString());

        Basehelper basehelper = new Basehelper(this, "DEMO", null, 1);
        SQLiteDatabase db = basehelper.getWritableDatabase();
        if (db != null) {
            ContentValues registronuevo = new ContentValues();
            registronuevo.put("Nombre", nombre);
            registronuevo.put("Apellido", apellido);
            registronuevo.put("Edad", edad);
            long i = db.insert("Persona", null, registronuevo);
            if (i > 0) {
                Toast.makeText(this, "Registro Insertado", Toast.LENGTH_SHORT).show();

            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.action_settings){
            return true;
        }
        if(id==R.id.action_listar){
            startActivity(new Intent(this,Segunda.class));
        }

        return super.onOptionsItemSelected(item);
    }
}