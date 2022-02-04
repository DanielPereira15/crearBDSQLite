package com.example.crearbdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper conexion = new ConexionSQLiteHelper(this,"bd_paises",null,2);
    }


    public void onClick(View v){
        Intent intent =null;


        switch (v.getId()){
            case R.id.btnCrearPais:
                intent=new Intent(this,RegistrarPais.class);
                break;

            case R.id.btnBuscar:
                intent= new Intent(this,BuscarPais.class);
                break;
        }

        startActivity(intent);
    }
}