package com.example.crearbdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarPais extends AppCompatActivity {

    EditText etNombrePais, etPoblacion, etPib;
    Button btnAnadir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_pais);

        etNombrePais=findViewById(R.id.etNombrePais);
        etPoblacion=findViewById(R.id.etPoblacion);
        etPib=findViewById(R.id.etPib);
        btnAnadir=findViewById(R.id.btnAnadir);

    }

    public void onClick(View v){
        switch (v.getId()){

            case R.id.btnAnadir:
                anadirPais();
                break;


        }
    }


    private void anadirPais(){
        ConexionSQLiteHelper conexion= new ConexionSQLiteHelper(this,"bd_Paises",null,1);
        //indicamos que vamos a abrir la base de datos para escribir...
        SQLiteDatabase db = conexion.getWritableDatabase();
        //Para poder escribir se hace pareido a como utilizamos una tabla hash, es decir, clave dato.
        ContentValues valores= new ContentValues();
        valores.put("NombrePais",this.etNombrePais.getText().toString());
        valores.put("Poblacion",Integer.parseInt(this.etPoblacion.getText().toString()));
        valores.put("PIB",Integer.parseInt(this.etPib.getText().toString()));

        Long idResultado = db.insert("Pais","NombrePais",valores);
        Toast.makeText(getApplicationContext(),"Nacion: "+ idResultado,Toast.LENGTH_LONG).show();

        db.close();
        limpiarCampos();

    }

    private void limpiarCampos(){
        etNombrePais.setText("");
        etPoblacion.setText("");
        etPib.setText("");
    }

}