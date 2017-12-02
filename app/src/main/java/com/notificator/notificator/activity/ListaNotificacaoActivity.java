package com.notificator.notificator.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.notificator.notificator.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListaNotificacaoActivity extends AppCompatActivity{

    List<String> notificacoes = new ArrayList<>();

    @Bind(R.id.lista_notificacoes)
    ListView listaNotificacoes;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_notificacao);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        notificacoes.add("Notificação de casamento");
        notificacoes.add("Notificação de aniversário");
        notificacoes.add("Notificação de Natal");
        notificacoes.add("Notificação de Natal");
        notificacoes.add("Notificação de Natal");
        notificacoes.add("Notificação de Natal");
        notificacoes.add("Notificação de Natal");
        notificacoes.add("Notificação de Natal");
        notificacoes.add("Notificação de Natal");
        notificacoes.add("Notificação de Natal");
        notificacoes.add("Notificação de Natal");
        notificacoes.add("Notificação de Natal");
        notificacoes.add("Notificação de Natal");
        notificacoes.add("Notificação de Natal");
        notificacoes.add("Notificação de Natal");
        notificacoes.add("Notificação de Natal");
        notificacoes.add("Notificação de Natal");
        notificacoes.add("Notificação de Natal");
        notificacoes.add("Notificação de Natal");
        notificacoes.add("Notificação de Natal");
        notificacoes.add("Notificação de Natal");
        notificacoes.add("Notificação de Natal");
        notificacoes.add("Notificação de Natal");
        notificacoes.add("Notificação de Natal");
        notificacoes.add("Notificação de Natal");
        notificacoes.add("Notificação de Natal");
        notificacoes.add("Notificação de Natal");
        notificacoes.add("Notificação de Natal");
        notificacoes.add("Notificação de Natal");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, notificacoes);
        listaNotificacoes.setAdapter(adapter);

    }

    @OnClick(R.id.floating_btn_nova_notificacao)
    public void novaNotificacao(){
        Intent i = new Intent(ListaNotificacaoActivity.this, CadastroNotificacaoActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
