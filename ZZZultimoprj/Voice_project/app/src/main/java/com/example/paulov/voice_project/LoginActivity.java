package com.example.paulov.voice_project;

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
    private FirebaseAuth mAuth;
    private EditText mail;
    private EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        mail = findViewById(R.id.edt_mail);
        senha = findViewById(R.id.edt_senha);

    }

    public void login(View view) {

        String login = mail.getText().toString();
        String pass = senha.getText().toString();

        mAuth.signInWithEmailAndPassword(login,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        }else{
                            Toast.makeText(LoginActivity.this,"Usuario nao encontrado",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void signup(View view) {
        String login = mail.getText().toString();
        String pass = senha.getText().toString();

        mAuth.createUserWithEmailAndPassword(login,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this,"Usuario registrado com sucesso",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(LoginActivity.this,"Ocorreu um erro ao criar a sua conta",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void skip(View view) {

        startActivity(new Intent(LoginActivity.this,MainActivity.class));
    }
}
