package com.notificator.notificator.activity;

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

public class ListaNotificacao extends AppCompatActivity{

    List<String> notificacoes = new ArrayList<>();

    @Bind(R.id.lista_notificacoes)
    ListView listaNotificacoes;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_notificacao);
        ButterKnife.bind(this);

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


}
