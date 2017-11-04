package com.notificator.notificator.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.notificator.notificator.R;

/**
 * Created by marcelpaulino on 04/11/17.
 */

public class MainNotificacao extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_notificacao);
    }
}
