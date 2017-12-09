package com.notificator.notificator.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by marcelpaulino on 09/12/2017.
 */

public class NotificacaoDAO extends SQLiteOpenHelper {

    public NotificacaoDAO(Context context) { super(context, "notificar", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE notificacao (id INTEGER PRIMARY KEY, nomeNotificacao VARCHAR, mensagemNotificacao VARCHAR, data DATA, localEvento VARCHAR, listaContatos VARCHAR,)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
