package com.example.paulov.nijuugojyugyou;

import android.content.Intent;
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

public class LoginActivity extends AppCompatActivity {
    private EditText emailLogin;
    private EditText senhaLogin;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailLogin = findViewById(R.id.edt_mail_login);
        senhaLogin = findViewById(R.id.edt_senha_login);

        auth = FirebaseAuth.getInstance();
    }

    public void entrar(View view) {
        String email = emailLogin.getText().toString().trim();
        String senha = senhaLogin.getText().toString();

        auth.signInWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(LoginActivity.this,"Usuario logado com sucesso",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,PrincipalActivity.class));
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this,"Erro ao entrar",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
