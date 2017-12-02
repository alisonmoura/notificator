package com.notificator.notificator.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.notificator.notificator.R;
import com.notificator.notificator.adapter.ContatoAdapter;
import com.notificator.notificator.model.Contato;

import java.util.ArrayList;
import java.util.Date;
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

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        List<Contato> contatos = gerarContatos();

        ContatoAdapter adapter = new ContatoAdapter(this, contatos);
        listaContato.setAdapter(adapter);

        listaContato.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Contato contatoClicado = (Contato) listaContato.getAdapter().getItem(position);
                Intent i = new Intent(ListaContatoActivity.this, CadastroContatoActivity.class);
                if(contatoClicado != null){
                    i.putExtra("CONTATO", contatoClicado);
                }
                startActivity(i);
            }
        });
    }

    private List gerarContatos(){
        Contato mona = new Contato();
        mona.setNome("Mona");
        mona.setAniversario(new Date());
        mona.setCategoria("Amigos");
        mona.setCelular("999999999");
        mona.setEmail("mona@gmail.com");
        mona.setEndereco("Rua Neve na Bahia");
        mona.setMensagemAniversario("Feliz aniversário");
        mona.setNotificarAniversario(true);

        Contato jao = new Contato();
        jao.setNome("Jão da Silva");
        jao.setAniversario(new Date());
        jao.setCategoria("Amigos");
        jao.setCelular("999999999");
        jao.setEmail("jao@gmail.com");
        jao.setEndereco("Rua Neve na Bahia");
        jao.setMensagemAniversario("Feliz aniversário");
        jao.setNotificarAniversario(true);

        Contato maria = new Contato();
        maria.setNome("Maria da Silva");
        maria.setAniversario(new Date());
        maria.setCategoria("Amigos");
        maria.setCelular("999999999");
        maria.setEmail("maria@gmail.com");
        maria.setEndereco("Rua Neve na Bahia");
        maria.setMensagemAniversario("Feliz aniversário");
        maria.setNotificarAniversario(true);

        List<Contato> contatos = new ArrayList<>();
        contatos.add(mona);
        contatos.add(jao);
        contatos.add(maria);

        return contatos;

    }

    @OnClick(R.id.floating_btn_novo_contato)
    public void novoContato(){
        Intent i = new Intent(ListaContatoActivity.this, CadastroContatoActivity.class);
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
