package com.notificator.notificator.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.notificator.notificator.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CadastroNotificacaoActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_notificacao);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_salvar)
    public void irParaNotificar(){
        TextView textoNotificar = (TextView)findViewById(R.id.txt_de_envio);
        textoNotificar.setText("Clicou no botão Salvar");
    }
}
