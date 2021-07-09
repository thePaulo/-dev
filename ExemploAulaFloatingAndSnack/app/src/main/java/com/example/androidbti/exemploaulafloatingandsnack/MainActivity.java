package com.example.androidbti.exemploaulafloatingandsnack;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Clicou no FAB!", Toast.LENGTH_SHORT).show();
                //Snackbar.make(findViewById(R.id.coordinator),"Clicou no FAB",Snackbar.LENGTH_LONG).show();
                final Snackbar snackbar= Snackbar.make(findViewById(R.id.coordinator),"Clicou no FAB",Snackbar.LENGTH_LONG);
                snackbar.setAction("Fechar", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snackbar.dismiss();
                    }
                });
                snackbar.show();
            }
        });
    }
}
