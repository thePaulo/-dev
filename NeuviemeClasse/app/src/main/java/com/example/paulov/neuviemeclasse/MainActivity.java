package com.example.paulov.neuviemeclasse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void open(View view){
        MyDialogFragment dialog = new MyDialogFragment();
        dialog.show(getSupportFragmentManager(),"dialog_tag");


    }
    public void openSimple(View view){
        SimpleDialogFragment simpleDialogFragment = new SimpleDialogFragment();
        simpleDialogFragment.show(getSupportFragmentManager(),"simple_Dialog");
    }

    public void openRadio(View view){
        RadioDialogFragment radioDialogFragment = new RadioDialogFragment();
        radioDialogFragment.show(getSupportFragmentManager(),"Radio_Dialog");
    }

    public void openMutiple(View view) {
        MultipleDialogFragment multiple = new MultipleDialogFragment();
        multiple.show(getSupportFragmentManager(),"dialogMultiple");
    }

    public void openEditDialog(View view){
        MyEditDialog.show(getSupportFragmentManager(), new MyEditDialog.OnTextListener() {
            @Override
            public void onSetText(String texto) {
                Toast.makeText(MainActivity.this,"Texto passado: "+texto,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
