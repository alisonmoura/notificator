package com.notificator.notificator.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.notificator.notificator.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{

    private String[] mPlanetTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        ButterKnife.bind(this);

        //mPlanetTitles = getResources().getStringArray(R.array.planets_array);
        //mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        //mDrawerList.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, mPlanetTitles));
        // Set the list's click listener
        // mDrawerList.setOnItemClickListener(new DrawerLayout.);

    }

    @OnClick(R.id.btn_listar_notificacoes)
    public void irParaListaNotificacoes(){
        Intent i = new Intent(MainActivity.this, ListaNotificacaoActivity.class);
        startActivity(i);}

        @OnClick(R.id.btn_listar_contatos)
        public void irParaListaContatos(){
            Intent i = new Intent(MainActivity.this, ListaContatoActivity.class);
            startActivity(i);
    }


}
