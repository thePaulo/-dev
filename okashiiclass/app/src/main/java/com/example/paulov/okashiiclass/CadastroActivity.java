package com.example.paulov.okashiiclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    private EditText edtSenha;
    private EditText edtMail;
    private EditText edtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtMail = findViewById(R.id.edtEmailCad);
        edtNome = findViewById(R.id.edtNomeCad);
        edtSenha = findViewById(R.id.edtSenhaCad);//edtsenhacad

        Intent intent = getIntent();
        Bundle params = intent.getExtras();

        String email = params.getString("email");
        String senha = params.getString("senha");



        edtMail.setText(email);
        edtSenha.setText(senha);
    }

    public void cadastro(View view){
        Intent intent = new Intent();
        intent.putExtra("nome",edtNome.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }
}
