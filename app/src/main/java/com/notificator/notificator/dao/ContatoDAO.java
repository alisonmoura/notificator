package com.notificator.notificator.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContatoDAO extends SQLiteOpenHelper{

    public ContatoDAO(Context context) {
        super(context, "notificator", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE contato (id INTEGER PRIMARY KEY, nome VARCHAR, celular VARCHAR, foto VARCHAR, email VARCHAR, aniversario VARCHAR, endereco VARCHAR, categoria VARCHAR, mensagemAniversario VARCHAR, notificarAniversario BOOLEAN,)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
