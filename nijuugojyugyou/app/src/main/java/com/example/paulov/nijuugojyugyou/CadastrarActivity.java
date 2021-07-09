package com.example.paulov.nijuugojyugyou;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CadastrarActivity extends AppCompatActivity {

    private EditText edtEmailCadastro;
    private EditText edtSenhaCadastro;

    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        edtEmailCadastro = findViewById(R.id.edt_mail);
        edtSenhaCadastro = findViewById(R.id.edt_senha);

        auth = FirebaseAuth.getInstance();
    }

    public void cadastrarUsuario(View view) {
        String email = edtEmailCadastro.getText().toString().trim();
        String senha = edtSenhaCadastro.getText().toString();

        auth.createUserWithEmailAndPassword(email,senha).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(CadastrarActivity.this,"Usuario cadastrado com sucesso",Toast.LENGTH_SHORT).show();
                }else{
                    String resposta = task.getException().toString();
                    Toast.makeText(CadastrarActivity.this,"Erro ao cadastrar usuário",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
