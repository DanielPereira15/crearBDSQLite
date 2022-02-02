package com.example.crearbdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crearbdsqlite.utilidades.Utilidades;

public class BuscarPais extends AppCompatActivity {
    EditText etNombrePaisBuscar, etPoblacionBuscar, etPibBuscar;

    ConexionSQLiteHelper conexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_pais);
        conexion= new ConexionSQLiteHelper(this,"bd_Paises",null,1);//conseguimos la base de datos y la abrimos para escribir

        etNombrePaisBuscar=findViewById(R.id.etNombrePaisBuscar);
        etPoblacionBuscar=findViewById(R.id.etPoblacionBuscar);
        etPibBuscar=findViewById(R.id.etPibBuscar);
    }

    public void onClick(View v){
        switch (v.getId()){

            case R.id.btnBuscarB:
                buscar();
                break;
        }
    }

    private void buscar(){
        //indicamos que vamos a abrir la base de datos para leerla...
        SQLiteDatabase db = conexion.getReadableDatabase();
        //Para poder escribir se hace pareido a como utilizamos una tabla hash, es decir, clave(nombre igual que la columana de la tabla) dato.
        String[]parametrosBusqueda = {this.etNombrePaisBuscar.getText().toString().trim()};
        String[]campos={Utilidades.CAMPO_POBLACION,Utilidades.CAMPO_PIB};
       try{
           Cursor cursor = db.query(Utilidades.TABLA_PAIS,campos,Utilidades.CAMPO_NOMBRE_PAIS+"=?",parametrosBusqueda,
                   null,null,null);   //cursor es un puntero que apunta a lo que devuelve select

            cursor.moveToFirst();
            etPoblacionBuscar.setText(""+cursor.getInt(0));
            etPibBuscar.setText(""+cursor.getInt(1));

            cursor.close();



       }catch (Exception e){
           Toast.makeText(getApplicationContext(),"El pais no existe...",Toast.LENGTH_LONG).show();
           limpiar();
           e.getMessage();
       }
    }
    public void limpiar(){
        etPoblacionBuscar.setText("");
        etPibBuscar.setText("");
    }
}