package com.example.crearbdsqlite.utilidades;

public class Utilidades {

    public static final String TABLA_PAIS="Pais";
    public static final String CAMPO_NOMBRE_PAIS="nombrePais";
    public static final  String CAMPO_POBLACION="poblacion";
    public static final String CAMPO_PIB="PIB";


    public static final String CREAR_TABLA_PAIS="CREATE TABLE "
            + TABLA_PAIS + " ("+ CAMPO_NOMBRE_PAIS+" TEXT, "
            + CAMPO_POBLACION +" INTEGER, " + CAMPO_PIB +" INTEGER);";


}
