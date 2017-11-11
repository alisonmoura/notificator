package com.notificator.notificator.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.notificator.notificator.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_notificacoes)
    public void irParaNotificacao(){
        System.out.println("Clicou no botão");
        TextView textoInicial = (TextView)findViewById(R.id.text_view_mensagem_inicial);
        textoInicial.setText("Clicou no botão de notificações");
    }


}
