package com.notificator.notificator.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.notificator.notificator.model.Contato;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        String sql = "SELECT * FROM contato ORDER BY id DESC";

        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToFirst()){
            do{
                Contato contato = new Contato();
                contato.setId(cursor.getInt(0));
                contato.setNome(cursor.getString(1));
                contato.setCelular(cursor.getString(2));
                contato.setFoto(cursor.getString(3));
                contato.setEmail(cursor.getString(4));

                //Conversão de data
                String dataAniversarioStr = cursor.getString(5);
                if(dataAniversarioStr != null){
                    DateFormat formatter = new SimpleDateFormat("yyyy-MMM-d");
                    try {
                        Date dataAniversario = formatter.parse(dataAniversarioStr);
                        contato.setAniversario(dataAniversario);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

                contato.setEndereco(cursor.getString(6));
                contato.setCategoria(cursor.getString(7));
                contato.setMensagemAniversario(cursor.getString(8));
                contato.setNotificarAniversario(cursor.getInt(9) > 0);

                todos.add(contato);

            }while(cursor.moveToNext());
        }

        return todos;

    }

    public void salvar(Contato contato){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", contato.getNome());
        values.put("celular", contato.getCelular());
        values.put("foto", contato.getFoto());
        values.put("email", contato.getEmail());

        if(contato.getAniversario() != null){
            //Conversão de data
            String ano = Integer.toString(contato.getAniversario().getYear());
            String mes = Integer.toString(contato.getAniversario().getMonth());
            String dia = Integer.toString(contato.getAniversario().getDate());
            String dataAniversario = ano + "-" + mes + "-" + dia;

            values.put("aniversario", dataAniversario);
        }

        values.put("endereco", contato.getEndereco());
        values.put("categoria", contato.getCategoria());
        values.put("mensagemAniversario", contato.getMensagemAniversario());
        values.put("notificarAniversario", contato.getNotificarAniversario());

        // Verifica se tem id, se tiver ele tem que fazer update do contato
        if(contato.getId() != null && contato.getId() > 0){
            db.update("contato", values, "id = ?",  new String[]{contato.getId().toString()});
        }else{
            db.insert("contato", null, values);
        }

        db.close();

    }

    public void remover(Contato contato){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("contato", "id = ?", new String[]{contato.getId().toString()});
        db.close();
    }
}
