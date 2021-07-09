package com.example.paulov.jyunanajyugyou;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void next(View view) {
        //invoke explicito
        //Intent intent = new Intent(this,EmailActivity.class);

        //invoke implicito
        Intent intent = new Intent("br.ufrn.imd.intent.action.EMAIL");
        startActivity(intent);
    }

    public void config(View view) {
        Intent intent = new Intent(Settings.ACTION_SETTINGS);
        startActivity(intent);
    }
}
