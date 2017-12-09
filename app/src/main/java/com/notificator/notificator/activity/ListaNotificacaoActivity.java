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
import com.notificator.notificator.adapter.NotificacaoAdapter;
import com.notificator.notificator.model.Notificacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListaNotificacaoActivity extends AppCompatActivity{

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

        List<Notificacao> notificacoes = getNotificacoes();

        NotificacaoAdapter adapter = new NotificacaoAdapter(this, notificacoes);
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

    private List<Notificacao> getNotificacoes(){

        List<Notificacao> notificacoes = new ArrayList<>();

        Notificacao natal = new Notificacao();
        natal.setNomeNotificacao("Notificação de Natal");
        natal.setData(new Date());
        natal.setLocalEvento("High Tech");
        natal.setMensagemNoticacao("Feliz Natal");

        Notificacao anoNovo = new Notificacao();
        anoNovo.setNomeNotificacao("Notificação de Ano Novo");
        anoNovo.setData(new Date());
        anoNovo.setLocalEvento("High Tech");
        anoNovo.setMensagemNoticacao("Feliz Ano Novo");

        notificacoes.add(natal);
        notificacoes.add(anoNovo);

        return notificacoes;
    }
}
