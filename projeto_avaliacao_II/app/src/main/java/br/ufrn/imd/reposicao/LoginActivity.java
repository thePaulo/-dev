package br.ufrn.imd.reposicao;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {

    private EditText edtEmail;
    private EditText edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


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
            Intent intent = new Intent(getApplicationContext(),NotesActivity.class);
            startActivity(intent);
            finish();

        }else{
            Toast.makeText(this,"Email ou senha invalidos",Toast.LENGTH_SHORT).show();
        }
    }

    void cadastrar(View view){
        Toast.makeText(this,"to aki pra fazer nd n",Toast.LENGTH_SHORT).show();
    }
}
