package com.example.paulov.watashinohataraku;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }

    public void sigUp(View view) {

        mAuth.createUserWithEmailAndPassword("folano3@gmail.com","123456")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this,"ISSAI",Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this,"deu n",Toast.LENGTH_SHORT).show();
                            Log.i("qlqr",task.getException().toString());
                        }
                    }
                });
    }

    public void login(View view) {
        EditText edt = (EditText)findViewById(R.id.edt_txt);
        String nick = edt.getText().toString();
        mAuth.signInWithEmailAndPassword(nick,"123456")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"Logou",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this,"N FUNFOU",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
