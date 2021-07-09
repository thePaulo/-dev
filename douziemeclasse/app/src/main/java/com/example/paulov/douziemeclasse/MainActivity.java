package com.example.paulov.douziemeclasse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.my_toolbar1);
        setSupportActionBar(toolbar);
    }

    public void next(View view){
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
}
