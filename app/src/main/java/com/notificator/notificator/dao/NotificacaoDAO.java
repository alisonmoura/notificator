package com.notificator.notificator.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NotificacaoDAO extends SQLiteOpenHelper {

    public NotificacaoDAO(Context context) { super(context, "notificator", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE notificacao (id INTEGER PRIMARY KEY, nomeNotificacao VARCHAR, mensagemNotificacao VARCHAR, data DATETIME, localEvento VARCHAR, listaContatos VARCHAR,)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
