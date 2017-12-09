package com.notificator.notificator.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.notificator.notificator.model.Contato;

import java.util.ArrayList;
import java.util.List;

public class ContatoDAO extends SQLiteOpenHelper{

    public ContatoDAO(Context context) {
        super(context, "notificator", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE contato (id INTEGER PRIMARY KEY, nome VARCHAR, celular VARCHAR, foto VARCHAR, email VARCHAR, aniversario DATE, endereco VARCHAR, categoria VARCHAR, mensagemAniversario VARCHAR, notificarAniversario BOOLEAN)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public List<Contato> buscarTodos(){

        List<Contato> todos = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM contato";

        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{

                Contato contato = new Contato();
                contato.setId(cursor.getInt(0));
                contato.setNome(cursor.getString(1));
                contato.setCelular(cursor.getString(2));
                contato.setFoto(cursor.getString(3));
                contato.setEmail(cursor.getString(4));
                //contato.setAniversario(cursor.getString(5));
                contato.setEndereco(cursor.getString(6));
                contato.setCategoria(cursor.getString(7));
                contato.setMensagemAniversario(cursor.getString(8));
                //contato.setNotificarAniversario(cursor.getInt(9));

                todos.add(contato);

            }while(cursor.moveToNext());
        }

        return todos;

    }
}
