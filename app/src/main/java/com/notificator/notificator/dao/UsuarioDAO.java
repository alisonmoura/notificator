package com.notificator.notificator.dao;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuarioDAO extends SQLiteOpenHelper {


    public UsuarioDAO(Context context) {
        super(context, "notificator", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String Sql = "CREATE TABLE usuario (id INTEGER PRIMARY KEY, nome VARCHAR, email VARCHAR, foto VARCHAR)";
       db.execSQL(Sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
