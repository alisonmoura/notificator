package com.notificator.notificator.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.notificator.notificator.R;
import com.notificator.notificator.adapter.ContatoAdapter;
import com.notificator.notificator.dao.ContatoDAO;
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

    ContatoDAO dao;
    ContatoAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_contatos);
        ButterKnife.bind(this);

        dao = new ContatoDAO(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Contato> contatos = dao.buscarTodos();

        adapter = new ContatoAdapter(this, contatos);
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

        listaContato.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view,
                                           final int position, long id) {
                AlertDialog alert = new AlertDialog.Builder(ListaContatoActivity.this)
                        .setTitle("Deletar contato")
                        .setMessage("Deseja deletar este contato?")
                        .setNegativeButton("Não", null)
                        .setPositiveButton("Sim", new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface,
                                                        int i) {
                                        dao.remover(adapter.getItem(position));
                                        adapter.remove(adapter.getItem(position));
                                        Toast.makeText(ListaContatoActivity.this, "Contato removido com sucesso", Toast.LENGTH_LONG).show();
                                        adapter.notifyDataSetChanged();
                                    }
                                }).show();
                return true;
            }
        });
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
