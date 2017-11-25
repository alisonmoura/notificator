package com.notificator.notificator.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.notificator.notificator.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListaContatoActivity extends AppCompatActivity{

    @Bind(R.id.lista_contatos)
    ListView listaContato;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_contatos);
        ButterKnife.bind(this);
        List<String> contatos = new ArrayList<>();
        contatos.add("Mona");
        contatos.add("Joao");
        contatos.add("mama");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contatos);
        listaContato.setAdapter(arrayAdapter);
    }

    @OnClick(R.id.floating_btn_novo_contato)
    public void novoContato(){
        Intent i = new Intent(ListaContatoActivity.this, CadastroContatoActivity.class);
        startActivity(i);
    }


}
