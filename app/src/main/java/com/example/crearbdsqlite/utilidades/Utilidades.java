package com.example.crearbdsqlite.utilidades;

import android.provider.BaseColumns;

public class Utilidades implements BaseColumns{

    public static final String ID = BaseColumns._ID;

    public static final String TABLA_PAIS="Pais";
    public static final String CAMPO_NOMBRE_PAIS="nombrePais";
    public static final  String CAMPO_POBLACION="poblacion";
    public static final String CAMPO_PIB="PIB";


    public static final String CREAR_TABLA_PAIS="CREATE TABLE "
            + TABLA_PAIS + " ("+ ID + " Integer primary key AUTOINCREMENT, "
            +CAMPO_NOMBRE_PAIS+" TEXT, "
            + CAMPO_POBLACION +" INTEGER, "
            + CAMPO_PIB +" INTEGER);";
}
