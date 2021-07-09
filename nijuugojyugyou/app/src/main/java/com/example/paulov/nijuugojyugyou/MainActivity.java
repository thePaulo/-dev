package com.example.paulov.nijuugojyugyou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

    }

    public void login(View view) {
        user=auth.getCurrentUser();
        if(user == null){
            startActivity(new Intent(this,LoginActivity.class));
        }else{
            startActivity(new Intent(this,PrincipalActivity.class));
        }

        //startActivity(new Intent(this,LoginActivity.class));
    }

    public void cadastrar(View view) {

        startActivity(new Intent(this,CadastrarActivity.class));
    }
}
