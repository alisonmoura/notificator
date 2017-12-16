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
import android.widget.Toast;

import com.notificator.notificator.R;
import com.notificator.notificator.dao.ContatoDAO;
import com.notificator.notificator.model.Contato;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

    Integer id;
    ContatoDAO dao;
    Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState  ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_contato_layout);
        ButterKnife.bind(this);

        dao = new ContatoDAO(this);

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

            if(contato.getAniversario() != null){
                String myFormat = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                aniversario.setText(sdf.format(contato.getAniversario().getTime()));
            }
            endereco.setText(contato.getEndereco());
            categoria.setText(contato.getCategoria());
            msgniver.setText(contato.getMensagemAniversario());
            notificar.setChecked(contato.getNotificarAniversario());
            id = contato.getId();
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
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        aniversario.setText(sdf.format(myCalendar.getTime()));
    }

    @OnClick(R.id.cadastro_contato_btn_salvar)
    public void salvar(){

        Contato contato = new Contato();
        contato.setNome(nome.getText().toString());
        contato.setEmail(email.getText().toString());
        contato.setCelular(celular.getText().toString());
        contato.setEndereco(endereco.getText().toString());
        contato.setFoto(foto.getText().toString());
        contato.setCategoria(categoria.getText().toString());
        contato.setMensagemAniversario(msgniver.getText().toString());
        contato.setId(id);

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf.parse(aniversario.getText().toString());
            dao.salvar(contato);
            Toast.makeText(CadastroContatoActivity.this, "Contato cadastrado com sucesso", Toast.LENGTH_SHORT).show();
            finish();
        }catch(Exception e){
            System.out.println(e.getMessage());
            Toast.makeText(CadastroContatoActivity.this, "Data de aniversário inválida", Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.cadastro_contato_btn_cancelar)
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
