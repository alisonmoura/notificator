package com.notificator.notificator.activity;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;

import com.notificator.notificator.R;
import com.notificator.notificator.model.Contato;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CadastroContatoActivity extends AppCompatActivity {

    @Bind(R.id.cadastro_contato_nome)
    EditText nome;
    @Bind(R.id.cadastro_contato_celular)
    EditText celular;
    @Bind(R.id.cadastro_contato_foto)
    EditText foto;
    @Bind(R.id.cadastro_contato_email)
    EditText email;
    @Bind(R.id.cadastro_contato_aniversario)
    EditText aniversario;
    @Bind(R.id.cadastro_contato_endereco)
    EditText endereco;
    @Bind(R.id.cadastro_contato_categoria)
    EditText categoria;
    @Bind(R.id.cadastro_contato_msgniver)
    EditText msgniver;
    @Bind(R.id.cadastro_contato_notificar)
    CheckBox notificar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState  ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_contato_layout);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Contato contato = new Contato();
        if(getIntent() != null && getIntent().hasExtra("CONTATO")){
            contato = (Contato) getIntent().getSerializableExtra("CONTATO");
            nome.setText(contato.getNome());
            celular.setText(contato.getCelular());
            foto.setText(contato.getFoto());
            email.setText(contato.getEmail());
            aniversario.setText(Long.toString(contato.getAniversario().getTime()));
            endereco.setText(contato.getEndereco());
            categoria.setText(contato.getCategoria());
            msgniver.setText(contato.getMensagemAniversario());
            notificar.setChecked(contato.getNotificarAniversario());
        }

    }

    @OnClick(R.id.btn_cancelar)
    public void cancelar(){
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
