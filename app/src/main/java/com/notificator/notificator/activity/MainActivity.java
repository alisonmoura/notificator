package com.notificator.notificator.activity;

import android.content.Intent;
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
        Intent i = new Intent(MainActivity.this, CadastroNotificacaoActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.btn_contatos)
    public void irParaContato(){
        Intent a =  new Intent(MainActivity.this, CadastroContatoActivity.class);
        startActivity(a);
    }


}
