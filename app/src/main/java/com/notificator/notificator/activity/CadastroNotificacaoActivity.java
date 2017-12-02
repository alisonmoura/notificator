package com.notificator.notificator.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
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

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @OnClick(R.id.btn_salvar)
    public void irParaNotificar(){
        TextView textoNotificar = (TextView)findViewById(R.id.txt_de_envio);
        textoNotificar.setText("Clicou no botão Salvar");
    }

    @OnClick(R.id.btnCancelar)
    public void cancelar(){
        this.finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
