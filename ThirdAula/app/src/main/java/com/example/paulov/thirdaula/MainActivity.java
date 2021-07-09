package com.example.paulov.thirdaula;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView view = findViewById(R.id.textID);
        view.setText("WATASHI NO APPU DESU");
    }

    public void next(View view){
        Intent it = new Intent(this,ActivityDois.class);
        startActivity(it);
    }
}
