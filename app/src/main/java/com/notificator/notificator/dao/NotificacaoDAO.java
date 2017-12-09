package com.notificator.notificator.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.notificator.notificator.model.Contato;
import com.notificator.notificator.model.Notificacao;

import java.util.ArrayList;
import java.util.List;

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

    public List<Contato> buscarTodos(){

        List<Contato> todos = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM notificacao";

        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{

                Notificacao notificacao = new Notificacao();
                notificacao.setId(cursor.getInt(0));
                notificacao.setNomeNotificacao(cursor.getString(1));
                notificacao.setMensagemNoticacao(cursor.getString(2));
                //notificacao.setData(cursor.getString(3));
                notificacao.setLocalEvento(cursor.getString(4));
                notificacao.setListaContatos(cursor.getString(6));

                todos.add(notificacao);

            }while(cursor.moveToNext());
        }

        return todos;

    }

}
