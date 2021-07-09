package com.example.paulov.okashiiclass;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtEmail;
    private EditText edtSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = findViewById(R.id.edtMail);
        edtSenha = findViewById(R.id.edtSenhaCad);
    }

    public void entrar(View view){
        String email = edtEmail.getText().toString();
        String senha = edtSenha.getText().toString();

        if(email.equals("")){
            edtEmail.setError("Este campo precisa ser preenchido");
            return;
        }
        if(senha.equals("")){
            edtSenha.setError("Este campo precisa ser preenchido");
            return;
        }
        if(email.equals("admin") && senha.equals("admin")){
            Toast.makeText(this,"logou",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Email ou senha invalidos",Toast.LENGTH_SHORT).show();
        }
    }
    public void cadastrar(View view){
        Intent intent = new Intent(this,CadastroActivity.class);
        intent.putExtra("email",edtEmail.getText().toString());
        intent.putExtra("senha",edtSenha.getText().toString());

        startActivityForResult(intent,10);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 10){
            String nome = data.getStringExtra("nome");
            Toast.makeText(this,"nome cadastrado:"+nome,Toast.LENGTH_SHORT).show();
        }

    }
}
