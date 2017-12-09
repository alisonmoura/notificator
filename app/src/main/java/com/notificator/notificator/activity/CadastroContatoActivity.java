package com.notificator.notificator.activity;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

import com.notificator.notificator.R;
import com.notificator.notificator.model.Contato;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

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

    Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date;

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

        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        aniversario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(CadastroContatoActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    private void updateLabel() {
        String myFormat = "dd/MM/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        aniversario.setText(sdf.format(myCalendar.getTime()));
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
